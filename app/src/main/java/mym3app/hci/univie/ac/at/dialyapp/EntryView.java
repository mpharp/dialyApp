package mym3app.hci.univie.ac.at.dialyapp;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

public class EntryView extends AppCompatActivity {

    public static final String ENTRY_NUM = "entry_edit_num";
    public static final String EDIT = "entry_edit";


    ImageView entry_emo;
    TextView entry_title;
    ImageView entry_img;
    View entry_div;
    ImageView entry_work;
    ImageView entry_friends;
    ImageView entry_food;
    ImageView entry_shopping;
    ImageView entry_health;
    ImageView entry_custom;
    TextView entry_date;
    TextView entry_txt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Intent intent = getIntent();
        final int entry_num = intent.getIntExtra(Highlights.ENTRY_NUM, 1);

        /*
         *
         * json auslesen und variablen beschreiben
         * */


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        entry_emo = (ImageView) findViewById(R.id.entry_emo);
        entry_title = (TextView) findViewById(R.id.entry_title);
        entry_img = (ImageView) findViewById(R.id.entry_img);
        entry_div = (View) findViewById(R.id.entry_div1);
        entry_work = (ImageView) findViewById(R.id.entry_work);
        entry_friends = (ImageView) findViewById(R.id.entry_friends);
        entry_food = (ImageView) findViewById(R.id.entry_food);
        entry_shopping = (ImageView) findViewById(R.id.entry_shopping);
        entry_health = (ImageView) findViewById(R.id.entry_health);
        entry_custom = (ImageView) findViewById(R.id.entry_custom);
        entry_date = (TextView) findViewById(R.id.entry_date);
        entry_txt = (TextView) findViewById(R.id.entry_txt);

        String[] fileList = fileList();
        ArrayList<Entry> entries = new ArrayList<Entry>();
        for(String f : fileList) {
            if(f.startsWith("entry.")) {
                try {
                    entries.add(new Entry(openFileInput(f)));
                } catch (FileNotFoundException e) { //wird nie passieren
                    e.printStackTrace();
                }
            }
        }

        Collections.sort(entries, Entry.comp);

        final Entry entry = entries.get(entry_num);

        Drawable em1 = getResources().getDrawable(R.drawable.em1_h, null);
        Drawable em2 = getResources().getDrawable(R.drawable.em2_h, null);
        Drawable em3 = getResources().getDrawable(R.drawable.em3_h, null);
        Drawable em4 = getResources().getDrawable(R.drawable.em4_h, null);
        Drawable em5 = getResources().getDrawable(R.drawable.em5_h, null);


        switch (entry.getEmotion()) {
            case 1:
                entry_emo.setImageDrawable(em1);
                break;
            case 2:
                entry_emo.setImageDrawable(em2);
                break;
            case 3:
                entry_emo.setImageDrawable(em3);
                break;
            case 4:
                entry_emo.setImageDrawable(em4);
                break;
            case 5:
                entry_emo.setImageDrawable(em5);
                break;
            default:
        }

        entry_title.setText(entry.getTitle());

        switch (entry.getMedia()) {
            case 1:
                entry_img.setImageDrawable(getResources().getDrawable(R.drawable.img1, null));
                break;
            case 2:
                entry_img.setImageDrawable(getResources().getDrawable(R.drawable.img2, null));
                break;
            case 3:
                entry_img.setImageDrawable(getResources().getDrawable(R.drawable.img3, null));
                break;
            case 4:
                entry_img.setImageDrawable(getResources().getDrawable(R.drawable.img4, null));
                break;
            case 5:
                entry_img.setImageDrawable(getResources().getDrawable(R.drawable.img5, null));
                break;
            case 6:
                entry_img.setImageDrawable(getResources().getDrawable(R.drawable.img6, null));
                break;
            default:
                entry_img.setVisibility(View.GONE);
                entry_div.setVisibility(View.GONE);
        }

        String[] cat_str_arr = entry.getCategory().split(" ");
        Boolean[] cat_bool_arr = new Boolean[cat_str_arr.length];
        for (int i = 0; i < cat_str_arr.length; i++) {
            cat_bool_arr[i] = Boolean.parseBoolean(cat_str_arr[i]);
            if (!(cat_bool_arr[i])) {
                switch (i) {
                    case 0:
                        entry_work.setVisibility(View.GONE);
                        break;
                    case 1:
                        entry_friends.setVisibility(View.GONE);
                        break;
                    case 2:
                        entry_food.setVisibility(View.GONE);
                        break;
                    case 3:
                        entry_shopping.setVisibility(View.GONE);
                        break;
                    case 4:
                        entry_health.setVisibility(View.GONE);
                        break;
                    case 5:
                        entry_custom.setVisibility(View.GONE);
                        break;
                    default:
                }
            }
        }

        entry_date.setText(entry.getDate());

        entry_txt.setText(entry.getText());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Intent intent = new Intent (EntryView.this, NewEntry_1.class);
                intent.putExtra(ENTRY_NUM, entry_num);
                intent.putExtra(EDIT, true);
                startActivity(intent);*/
                Snackbar.make(view, "Feature noch nicht implementiert.", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
