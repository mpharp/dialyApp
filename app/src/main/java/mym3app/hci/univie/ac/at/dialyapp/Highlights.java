package mym3app.hci.univie.ac.at.dialyapp;

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
    ImageView entry1_work;
    ImageView entry1_friends;
    ImageView entry1_food;
    ImageView entry1_shopping;
    ImageView entry1_health;
    ImageView entry1_custom;
    TextView entry1_date;

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



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highlights);

        entry1_emo = (ImageView) findViewById(R.id.entry1_emo);
        entry1_title = (TextView) findViewById(R.id.entry1_title);
        entry1_img = (ImageView) findViewById(R.id.entry1_img);
        entry1_work = (ImageView) findViewById(R.id.entry1_work);
        entry1_friends = (ImageView) findViewById(R.id.entry1_friends);
        entry1_food = (ImageView) findViewById(R.id.entry1_food);
        entry1_shopping = (ImageView) findViewById(R.id.entry1_shopping);
        entry1_health = (ImageView) findViewById(R.id.entry1_health);
        entry1_custom = (ImageView) findViewById(R.id.entry1_custom);
        entry1_date = (TextView) findViewById(R.id.entry1_date);

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

        Entry entry1 = entries.get(0);

        switch (entry1.getEmotion()) {
            case 1:
                entry1_emo.setImageDrawable(getResources().getDrawable(R.drawable.em1_h));
                break;
            case 2:
                entry1_emo.setImageDrawable(getResources().getDrawable(R.drawable.em2_h));
                break;
            case 3:
                entry1_emo.setImageDrawable(getResources().getDrawable(R.drawable.em3_h));
                break;
            case 4:
                entry1_emo.setImageDrawable(getResources().getDrawable(R.drawable.em4_h));
                break;
            case 5:
                entry1_emo.setImageDrawable(getResources().getDrawable(R.drawable.em5_h));
                break;
            default:
        }

        String entries_str = "";
        for (Entry entry : entries) {
            entries_str += entry.toString();
        }

        entry1_title.setText(entries.get(entries.size()-1).toString());

        switch (entry1.getMedia()) {
            case 1:
                entry1_img.setImageDrawable(getResources().getDrawable(R.drawable.img1));
                break;
            case 2:
                entry1_img.setImageDrawable(getResources().getDrawable(R.drawable.img2));
                break;
            case 3:
                entry1_img.setImageDrawable(getResources().getDrawable(R.drawable.img3));
                break;
            case 4:
                entry1_img.setImageDrawable(getResources().getDrawable(R.drawable.img4));
                break;
            case 5:
                entry1_img.setImageDrawable(getResources().getDrawable(R.drawable.img5));
                break;
            case 6:
                entry1_img.setImageDrawable(getResources().getDrawable(R.drawable.img6));
                break;
            default:
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

        entry1_date.setText(entry1.getDate() + entries.size());

        System.out.println(entries.toString());


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
