package mym3app.hci.univie.ac.at.dialyapp;

/**
 * Created by johannes on 12.05.18.
 */

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Entry {

    public String title;
    public String date;
    public boolean[] category;
    public String location;
    public int emotion;
    public String text;

    public String[] getMedia() {
        return media;
    }

    public String[] media = null;
    //public String[] alarms = null; // Kann man später implementieren

    public Entry() {}

    public Entry(String title, String date, boolean[] category, String location, int emotion,
                 String text, String[] media) {

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

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public boolean[] getCategory() {
        return category;
    }

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
        String str = "title: " + this.title + "\ndate: " + this.date + "\ncategory:" +
                category.toString() + "\nlocation: " + this.location + "\nemotion:" +
                Integer.toString(this.emotion) + "\ntext: " + this.text;
        return str;
    }
}
