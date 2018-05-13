package mym3app.hci.univie.ac.at.dialyapp;

/**
 * Created by johannes on 12.05.18.
 */

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Entry {

    public String title;
    public String date;
    public boolean[] category;
    public String location;
    public int emotion;
    public String text;
    public int media; //int of example images
    //public String[] alarms = null; // Kann man später implementieren

    public Entry() {}

    public Entry(String title, String date, boolean[] category, String location, int emotion,
                 String text, int media) {

        this.title = title;
        this.date = date;
        this.category = category;
        this.location = location;
        this.emotion = emotion;
        this.text = text;
        this.media = media;

    }

    public Entry(FileInputStream fileInStream) throws FileNotFoundException { //pass openFileInput(name) here
        Gson gson = new Gson();

        Entry newEntry =  gson.fromJson(new JsonReader(new InputStreamReader(fileInStream)), this.getClass());

        this.title = newEntry.getTitle();
        this.date = newEntry.getDate();
        this.category = newEntry.getCategory();
        this.location = newEntry.getLocation();
        this.emotion = newEntry.getEmotion();
        this.text = newEntry.getText();
        this.media = newEntry.getMedia();
    }

    public void saveToFile(File filesDir) {

        String filename = "entry" + this.date + this.title;
        File file = new File(filesDir, filename);
        FileWriter writer = null;
        try {
            writer = new FileWriter(file);
            Gson gson = new Gson();
            gson.toJson(this, writer);
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getMedia() {
        return media;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public boolean[] getCategory() {
        return category;
    }

    /*
    public boolean[] getCategoryBool() {
        String[] stringBools = this.category.substring(1,category.length()-1).split(",");
        // boolean[] bools = Arrays.stream(stringBools).map(Boolean::parseBoolean).toArray(Boolean[]::new); nur mit java 8 :(
        boolean[] bools = new boolean[stringBools.length];
        for(int i = 0; i < bools.length; i++) {
            bools[i] = Boolean.parseBoolean(stringBools[i].trim());
        }
        return bools;
    }*/

    public String getLocation() {
        return location;
    }

    public int getEmotion() {
        return emotion;
    }

    public String getText() {
        return text;
    }

    public String toString() {
        String cat_str = "";
        for (int i = 0; i < this.category.length; i++){
            if (this.category[i]) cat_str += "true ";
            else cat_str += "false ";
        }

        String str = "title: " + this.title + "\ndate: " + this.date + "\ncategory:" +
                cat_str + "\nlocation: " + this.location + "\nemotion:" +
                Integer.toString(this.emotion) + "\ntext: " + this.text;
        return str;
    }
}
