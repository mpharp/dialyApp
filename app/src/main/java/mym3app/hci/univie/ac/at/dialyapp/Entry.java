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
import java.util.Comparator;

public class Entry {

    public String title;
    public String date;
    public String cat_str;
    public String location;
    public int emotion;
    public String text;
    public int media; //int of example images
    public int priority;
    //public String[] alarms = null; // Kann man später implementieren

    public Entry() {}

    public Entry(String title, String date, String cat_str, String location, int emotion,
                 String text, int media, int priority) {

        this.title = title;
        this.date = date;
        this.cat_str = cat_str;
        this.location = location;
        this.emotion = emotion;
        this.text = text;
        this.media = media;
        this.priority = priority;

    }

    public Entry(FileInputStream fileInStream) throws FileNotFoundException { //pass openFileInput(name) here
        Gson gson = new Gson();

        Entry newEntry =  gson.fromJson(new JsonReader(new InputStreamReader(fileInStream)), this.getClass());

        this.title = newEntry.getTitle();
        this.date = newEntry.getDate();
        this.cat_str = newEntry.getCategory();
        this.location = newEntry.getLocation();
        this.emotion = newEntry.getEmotion();
        this.text = newEntry.getText();
        this.media = newEntry.getMedia();
        this.priority = newEntry.getPriority();
    }

    public void saveToFile(File filesDir) {

        String filename = "entry." + this.priority + "." + this.date + "." + this.title;
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

    public static Comparator<Entry> comp = new Comparator<Entry>() {

        public int compare(Entry e1, Entry e2) {
            int prio1 = e1.getPriority();
            int prio2 = e2.getPriority();

            return prio2 - prio1;
        }};

    public int getMedia() {
        return media;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getCategory() {
        return cat_str;
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

    public int getPriority() { return priority; }

    public String toString() {
        String str = "title: " + this.title + "\ndate: " + this.date + "\ncategory:" +
                this.cat_str + "\nlocation: " + this.location + "\nemotion:" +
                Integer.toString(this.emotion) + "\ntext: " + this.text + "\nmedia:" + this.media + "\npriority:" + this.priority;
        return str;
    }
}
