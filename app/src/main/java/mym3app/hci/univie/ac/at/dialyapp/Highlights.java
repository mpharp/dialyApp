package mym3app.hci.univie.ac.at.dialyapp;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

public class Highlights extends AppCompatActivity {

    ImageView entry1_emo;
    TextView entry1_title;
    ImageView entry1_img;
    View entry1_div;
    ImageView entry1_work;
    ImageView entry1_friends;
    ImageView entry1_food;
    ImageView entry1_shopping;
    ImageView entry1_health;
    ImageView entry1_custom;
    TextView entry1_date;

    ImageView entry2_emo;
    TextView entry2_title;
    ImageView entry2_img;
    View entry2_div;
    ImageView entry2_work;
    ImageView entry2_friends;
    ImageView entry2_food;
    ImageView entry2_shopping;
    ImageView entry2_health;
    ImageView entry2_custom;
    TextView entry2_date;

    ImageView entry3_emo;
    TextView entry3_title;
    ImageView entry3_img;
    View entry3_div;
    ImageView entry3_work;
    ImageView entry3_friends;
    ImageView entry3_food;
    ImageView entry3_shopping;
    ImageView entry3_health;
    ImageView entry3_custom;
    TextView entry3_date;

    /*
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_map:
                    //mTextMessage.setText("Karte");
                    return true;
                case R.id.navigation_list:
                    //mTextMessage.setText("Liste");
                    return true;
                case R.id.navigation_calendar:
                    //mTextMessage.setText("Kalender");
                    return true;
            }
            return false;
        }
    };
    */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highlights);

        entry1_emo = (ImageView) findViewById(R.id.entry1_emo);
        entry1_title = (TextView) findViewById(R.id.entry1_title);
        entry1_img = (ImageView) findViewById(R.id.entry1_img);
        entry1_div = (View) findViewById(R.id.entry1_div);
        entry1_work = (ImageView) findViewById(R.id.entry1_work);
        entry1_friends = (ImageView) findViewById(R.id.entry1_friends);
        entry1_food = (ImageView) findViewById(R.id.entry1_food);
        entry1_shopping = (ImageView) findViewById(R.id.entry1_shopping);
        entry1_health = (ImageView) findViewById(R.id.entry1_health);
        entry1_custom = (ImageView) findViewById(R.id.entry1_custom);
        entry1_date = (TextView) findViewById(R.id.entry1_date);

        entry2_emo = (ImageView) findViewById(R.id.entry2_emo);
        entry2_title = (TextView) findViewById(R.id.entry2_title);
        entry2_img = (ImageView) findViewById(R.id.entry2_img);
        entry2_div = (View) findViewById(R.id.entry2_div);
        entry2_work = (ImageView) findViewById(R.id.entry2_work);
        entry2_friends = (ImageView) findViewById(R.id.entry2_friends);
        entry2_food = (ImageView) findViewById(R.id.entry2_food);
        entry2_shopping = (ImageView) findViewById(R.id.entry2_shopping);
        entry2_health = (ImageView) findViewById(R.id.entry2_health);
        entry2_custom = (ImageView) findViewById(R.id.entry2_custom);
        entry2_date = (TextView) findViewById(R.id.entry2_date);


        entry3_emo = (ImageView) findViewById(R.id.entry3_emo);
        entry3_title = (TextView) findViewById(R.id.entry3_title);
        entry3_img = (ImageView) findViewById(R.id.entry3_img);
        entry3_div = (View) findViewById(R.id.entry3_div);
        entry3_work = (ImageView) findViewById(R.id.entry3_work);
        entry3_friends = (ImageView) findViewById(R.id.entry3_friends);
        entry3_food = (ImageView) findViewById(R.id.entry3_food);
        entry3_shopping = (ImageView) findViewById(R.id.entry3_shopping);
        entry3_health = (ImageView) findViewById(R.id.entry3_health);
        entry3_custom = (ImageView) findViewById(R.id.entry3_custom);
        entry3_date = (TextView) findViewById(R.id.entry3_date);

        String[] fileList = fileList();
        ArrayList<Entry> entries = new ArrayList<Entry>();
        for(String f : fileList) {
            if(f.startsWith("entry")) {
                try {
                    entries.add(new Entry(openFileInput(f)));
                } catch (FileNotFoundException e) { //wird nie passieren
                    e.printStackTrace();
                }
            }
        }

        Entry entry1 = new Entry();
        Entry entry2 = new Entry();
        Entry entry3 = new Entry();

        int num_entries = entries.size();

        switch (num_entries) {
            default:
            case 3:
                entry3 = entries.get(num_entries-3);
            case 2:
                entry2 = entries.get(num_entries-2);
            case 1:
                entry1 = entries.get(num_entries-1);
            case 0:
                break;
        }


        Drawable em1_h = getResources().getDrawable(R.drawable.em1_h, null);
        Drawable em2_h = getResources().getDrawable(R.drawable.em2_h, null);
        Drawable em3_h = getResources().getDrawable(R.drawable.em3_h, null);
        Drawable em4_h = getResources().getDrawable(R.drawable.em4_h, null);
        Drawable em5_h = getResources().getDrawable(R.drawable.em5_h, null);

        ////
        //Einträge aus Dateien auslesen & anzeigen

        //Letzter Entry
        if (num_entries > 0) {
            switch (entry1.getEmotion()) {
                case 1:
                    entry1_emo.setImageDrawable(em1_h);
                    break;
                case 2:
                    entry1_emo.setImageDrawable(em2_h);
                    break;
                case 3:
                    entry1_emo.setImageDrawable(em3_h);
                    break;
                case 4:
                    entry1_emo.setImageDrawable(em4_h);
                    break;
                case 5:
                    entry1_emo.setImageDrawable(em5_h);
                    break;
                default:
            }

            entry1_title.setText(entry1.getTitle());

            switch (entry1.getMedia()) {
                case 1:
                    entry1_img.setImageDrawable(getResources().getDrawable(R.drawable.img1, null));
                    break;
                case 2:
                    entry1_img.setImageDrawable(getResources().getDrawable(R.drawable.img2, null));
                    break;
                case 3:
                    entry1_img.setImageDrawable(getResources().getDrawable(R.drawable.img3, null));
                    break;
                case 4:
                    entry1_img.setImageDrawable(getResources().getDrawable(R.drawable.img4, null));
                    break;
                case 5:
                    entry1_img.setImageDrawable(getResources().getDrawable(R.drawable.img5, null));
                    break;
                case 6:
                    entry1_img.setImageDrawable(getResources().getDrawable(R.drawable.img6, null));
                    break;
                default:
                    entry1_img.setVisibility(View.GONE);
                    entry1_div.setVisibility(View.GONE);
            }

            String[] cat_str_arr = entry1.getCategory().split(" ");
            Boolean[] cat_bool_arr = new Boolean[cat_str_arr.length];
            for (int i = 0; i < cat_str_arr.length; i++) {
                cat_bool_arr[i] = Boolean.parseBoolean(cat_str_arr[i]);
                if (!(cat_bool_arr[i])) {
                    switch (i) {
                        case 0:
                            entry1_work.setVisibility(View.GONE);
                            break;
                        case 1:
                            entry1_friends.setVisibility(View.GONE);
                            break;
                        case 2:
                            entry1_food.setVisibility(View.GONE);
                            break;
                        case 3:
                            entry1_shopping.setVisibility(View.GONE);
                            break;
                        case 4:
                            entry1_health.setVisibility(View.GONE);
                            break;
                        case 5:
                            entry1_custom.setVisibility(View.GONE);
                            break;
                        default:
                    }
                }
            }

            entry1_date.setText(entry1.getDate());
        }



        //Ab zwei Einträgen
        if (num_entries > 1) {
            switch (entry2.getEmotion()) {
                case 1:
                    entry2_emo.setImageDrawable(em1_h);
                    break;
                case 2:
                    entry2_emo.setImageDrawable(em2_h);
                    break;
                case 3:
                    entry2_emo.setImageDrawable(em3_h);
                    break;
                case 4:
                    entry2_emo.setImageDrawable(em4_h);
                    break;
                case 5:
                    entry2_emo.setImageDrawable(em5_h);
                    break;
                default:
            }

            entry2_title.setText(entry2.getTitle());

            switch (entry2.getMedia()) {
                case 1:
                    entry2_img.setImageDrawable(getResources().getDrawable(R.drawable.img1, null));
                    break;
                case 2:
                    entry2_img.setImageDrawable(getResources().getDrawable(R.drawable.img2, null));
                    break;
                case 3:
                    entry2_img.setImageDrawable(getResources().getDrawable(R.drawable.img3, null));
                    break;
                case 4:
                    entry2_img.setImageDrawable(getResources().getDrawable(R.drawable.img4, null));
                    break;
                case 5:
                    entry2_img.setImageDrawable(getResources().getDrawable(R.drawable.img5, null));
                    break;
                case 6:
                    entry2_img.setImageDrawable(getResources().getDrawable(R.drawable.img6, null));
                    break;
                default:
                    entry2_img.setVisibility(View.GONE);
                    entry2_div.setVisibility(View.GONE);
            }

            String[] cat_str_arr = entry2.getCategory().split(" ");
            Boolean[] cat_bool_arr = new Boolean[cat_str_arr.length];
            for (int i = 0; i < cat_str_arr.length; i++) {
                cat_bool_arr[i] = Boolean.parseBoolean(cat_str_arr[i]);
                if (!(cat_bool_arr[i])) {
                    switch (i) {
                        case 0:
                            entry2_work.setVisibility(View.GONE);
                            break;
                        case 1:
                            entry2_friends.setVisibility(View.GONE);
                            break;
                        case 2:
                            entry2_food.setVisibility(View.GONE);
                            break;
                        case 3:
                            entry2_shopping.setVisibility(View.GONE);
                            break;
                        case 4:
                            entry2_health.setVisibility(View.GONE);
                            break;
                        case 5:
                            entry2_custom.setVisibility(View.GONE);
                            break;
                        default:
                    }
                }
            }

            entry2_date.setText(entry2.getDate());
        }


        // Ab 3 Einträgen
        if (entries.size() > 2) {
            switch (entry3.getEmotion()) {
                case 1:
                    entry3_emo.setImageDrawable(getResources().getDrawable(R.drawable.em1_h, null));
                    break;
                case 2:
                    entry3_emo.setImageDrawable(getResources().getDrawable(R.drawable.em2_h, null));
                    break;
                case 3:
                    entry3_emo.setImageDrawable(getResources().getDrawable(R.drawable.em3_h, null));
                    break;
                case 4:
                    entry3_emo.setImageDrawable(getResources().getDrawable(R.drawable.em4_h, null));
                    break;
                case 5:
                    entry3_emo.setImageDrawable(getResources().getDrawable(R.drawable.em5_h, null));
                    break;
                default:
            }

            entry3_title.setText(entry3.getTitle());

            switch (entry3.getMedia()) {
                case 1:
                    entry3_img.setImageDrawable(getResources().getDrawable(R.drawable.img1, null));
                    break;
                case 2:
                    entry3_img.setImageDrawable(getResources().getDrawable(R.drawable.img2, null));
                    break;
                case 3:
                    entry3_img.setImageDrawable(getResources().getDrawable(R.drawable.img3, null));
                    break;
                case 4:
                    entry3_img.setImageDrawable(getResources().getDrawable(R.drawable.img4, null));
                    break;
                case 5:
                    entry3_img.setImageDrawable(getResources().getDrawable(R.drawable.img5, null));
                    break;
                case 6:
                    entry3_img.setImageDrawable(getResources().getDrawable(R.drawable.img6, null));
                    break;
                default:
                    entry3_img.setVisibility(View.GONE);
                    entry3_div.setVisibility(View.GONE);
            }

            String[] cat_str_arr = entry3.getCategory().split(" ");
            Boolean[] cat_bool_arr = new Boolean[cat_str_arr.length];
            for (int i = 0; i < cat_str_arr.length; i++) {
                cat_bool_arr[i] = Boolean.parseBoolean(cat_str_arr[i]);
                if (!(cat_bool_arr[i])) {
                    switch (i) {
                        case 0:
                            entry3_work.setVisibility(View.GONE);
                            break;
                        case 1:
                            entry3_friends.setVisibility(View.GONE);
                            break;
                        case 2:
                            entry3_food.setVisibility(View.GONE);
                            break;
                        case 3:
                            entry3_shopping.setVisibility(View.GONE);
                            break;
                        case 4:
                            entry3_health.setVisibility(View.GONE);
                            break;
                        case 5:
                            entry3_custom.setVisibility(View.GONE);
                            break;
                        default:
                    }
                }
            }

            entry3_date.setText(entry3.getDate());
        }

        System.out.println(entries.toString());

        /*
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        */
    }

}
