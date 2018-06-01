package mym3app.hci.univie.ac.at.dialyapp;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

import static android.graphics.Typeface.BOLD;
import static android.view.ViewGroup.*;

public class Highlights extends AppCompatActivity {

    public static final String ENTRY_NUM = "entry_edit_num";

    CardView entry1_v;
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

    CardView entry2_v;
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

    CardView entry3_v;
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

    LinearLayout entry_wrapper;

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

        entry_wrapper = (LinearLayout) findViewById(R.id.entry_wrapper);

        Drawable em1_h = getResources().getDrawable(R.drawable.em1_h, null);
        Drawable em2_h = getResources().getDrawable(R.drawable.em2_h, null);
        Drawable em3_h = getResources().getDrawable(R.drawable.em3_h, null);
        Drawable em4_h = getResources().getDrawable(R.drawable.em4_h, null);
        Drawable em5_h = getResources().getDrawable(R.drawable.em5_h, null);

        Drawable img1 = getResources().getDrawable(R.drawable.img1, null);
        Drawable img2 = getResources().getDrawable(R.drawable.img2, null);
        Drawable img3 = getResources().getDrawable(R.drawable.img3, null);
        Drawable img4 = getResources().getDrawable(R.drawable.img4, null);
        Drawable img5 = getResources().getDrawable(R.drawable.img5, null);
        Drawable img6 = getResources().getDrawable(R.drawable.img6, null);

        Drawable ic_work = getResources().getDrawable(R.drawable.ic_work, null);
        Drawable ic_friends = getResources().getDrawable(R.drawable.ic_people, null);
        Drawable ic_food = getResources().getDrawable(R.drawable.ic_food, null);
        Drawable ic_shopping = getResources().getDrawable(R.drawable.ic_store, null);
        Drawable ic_health = getResources().getDrawable(R.drawable.ic_bike, null);
        Drawable ic_custom = getResources().getDrawable(R.drawable.ic_edit_black_24dp, null);

        ColorDrawable colorAccent = new ColorDrawable(ContextCompat.getColor(this, R.color.colorAccent));

        //////////
        //DP-GRÖßEN
        final int dp2 = dpAsPixels(2);
        final int dp3 = dpAsPixels(3);
        final int dp6 = dpAsPixels(6);
        final int dp8 = dpAsPixels(8);
        final int dp10 = dpAsPixels(10);
        final int dp12 = dpAsPixels(12);
        final int dp16 = dpAsPixels(16);
        final int dp26 = dpAsPixels(26);
        final int dp30 = dpAsPixels(30);
        final int dp150 = dpAsPixels(150);


        //////////
        //GESPEICHERTE EINTRÄGE LADEN
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

        Entry entry = new Entry();

        final int num_entries = entries.size();

        //////////
        //EINTRÄGE ERSTELLEN
        for (int i = 1; i <= num_entries; i++) {
            entry = entries.get(num_entries - i);
            int emotion = entry.getEmotion();
            String title = entry.getTitle();
            int img = entry.getMedia();
            String categories = entry.getCategory();
            String date = entry.getDate();

            //CARDVIEW ENTRY
            CardView entry_cv = new CardView(this);

            LayoutParams params_entry_cv = new LayoutParams(
                    LayoutParams.MATCH_PARENT,
                    LayoutParams.WRAP_CONTENT
            );
            params_entry_cv.setMargins(dp16,dp16,dp16,dp16);
            entry_cv.setLayoutParams(params_entry_cv);

            entry_cv.setRadius(dp8);

            entry_cv.setCardElevation(dp8);

            entry_wrapper.addView(entry_cv);

                //LINEARLAYOUT CONTENT

                LinearLayout entry_content = new LinearLayout(this);

                LayoutParams params_entry_content = new LayoutParams(
                        LayoutParams.WRAP_CONTENT,
                        LayoutParams.WRAP_CONTENT
                );
                params_entry_content.gravity = Gravity.CENTER_VERTICAL;
                entry_content.setLayoutParams(params_entry_content);

                entry_content.setOrientation(LinearLayout.VERTICAL);

                entry_cv.addView(entry_content);

                    //LINEARLAYOUT HEADER
                    LinearLayout entry_header = new LinearLayout(this);

                    LayoutParams params_entry_header = new LayoutParams(
                            LayoutParams.MATCH_PARENT,
                            LayoutParams.WRAP_CONTENT
                    );
                    entry_header.setLayoutParams(params_entry_header);
                    entry_header.setPadding(dp16,dp16,dp16,dp2);

                    entry_header.setOrientation(LinearLayout.HORIZONTAL);

                    entry_content.addView(entry_header);

                        //IMAGEVIEW ICON EMOTION
                        ImageView entry_emotion = new ImageView(this);

                        LayoutParams params_entry_emotion = new LayoutParams(
                                dp30,
                                dp30
                        );
                        params_entry_emotion.setMarginEnd(dp16);
                        entry_emotion.setLayoutParams(params_entry_emotion);

                        switch (emotion) {
                            case 1:
                                entry_emotion.setImageDrawable(em1_h);
                                break;
                            case 2:
                                entry_emotion.setImageDrawable(em2_h);
                                break;
                            case 3:
                                entry_emotion.setImageDrawable(em3_h);
                                break;
                            case 4:
                                entry_emotion.setImageDrawable(em4_h);
                                break;
                            case 5:
                                entry_emotion.setImageDrawable(em5_h);
                                break;
                            default:
                        }

                        entry_header.addView(entry_emotion);

                        //TEXTVIEW TITEL
                        TextView entry_title = new TextView(this);

                        LayoutParams params_entry_title = new LayoutParams(
                                LayoutParams.MATCH_PARENT,
                                LayoutParams.WRAP_CONTENT
                        );
                        params_entry_title.gravity = Gravity.CENTER;
                        entry_title.setLayoutParams(params_entry_title);

                        entry_title.setText(title);
                        entry_title.setTextColor(Color.BLACK);
                        entry_title.setTextSize(20);
                        entry_title.setTypeface(null, BOLD);

                        entry_header.addView(entry_title);


                    //SPACER 1 ERSTELLEN & EINFÜGEN
                    View spc1 = new View(this);
                    LayoutParams p_spc1 = new LayoutParams(
                            LayoutParams.MATCH_PARENT,
                            dp3
                    );
                    p_spc1.setMargins(dp16,dp12,dp16,0);
                    spc1.setLayoutParams(p_spc1);
                    spc1.setBackground(colorAccent);
                    entry_content.addView(spc1);

                    //SPACER 2 ERSTELLEN
                    View spc2 = new View(this);
                    LayoutParams p_spc2 = new LayoutParams(
                            LayoutParams.MATCH_PARENT,
                            dp2
                    );
                    p_spc2.setMargins(dp16,dp12,dp16,0);
                    spc2.setLayoutParams(p_spc2);
                    spc2.setBackground(colorAccent);


                    //IMAGEVIEW BILD
                    ImageView entry_img = new ImageView(this);

                    LayoutParams params_entry_img = new LayoutParams(
                            LayoutParams.MATCH_PARENT,
                            dp150
                    );
                    params_entry_img.setMargins(0,dp12,0,0);
                    entry_img.setLayoutParams(params_entry_img);

                    switch (img) {
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
                            spc2.setVisibility(View.GONE);
                    }

                    entry_content.addView(entry_img);

                    //SPACER2 EINFÜGEN
                    entry_content.addView(spc2);


                    //FOOTER
                    LinearLayout entry_footer = new LinearLayout(this);
                    LayoutParams params_entry_footer = new LayoutParams(
                            LayoutParams.MATCH_PARENT,
                            LayoutParams.WRAP_CONTENT
                    );
                    params_entry_footer.setMargins(dp16,dp6,dp8,dp6);
                    entry_footer.setLayoutParams(params_entry_footer);
                    entry_footer.setOrientation(LinearLayout.HORIZONTAL);
                    entry_content.addView(entry_footer);

                        //CATEGORIES
                        LinearLayout entry_categories = new LinearLayout(this);
                        LayoutParams params_entry_categories = new LayoutParams(
                                0,
                                LayoutParams.WRAP_CONTENT
                        );
                        params_entry_categories.gravity = Gravity.BOTTOM;
                        params_entry_categories.weight = 4;
                        entry_categories.setLayoutParams(params_entry_footer);
                        entry_categories.setOrientation(LinearLayout.HORIZONTAL);
                        entry_footer.addView(entry_categories);

                            //WORK
                            ImageView work = new ImageView(this);

                            LayoutParams params_work = new LayoutParams(
                                    0,
                                    LayoutParams.WRAP_CONTENT
                            );
                            params_work.weight = 1;
                            work.setLayoutParams(params_work);
                            work.setImageDrawable(ic_work);
                            entry_categories.addView(work);

                            //FRIENDS
                            ImageView friends = new ImageView(this);

                            LayoutParams params_friends = new LayoutParams(
                                    0,
                                    LayoutParams.WRAP_CONTENT
                            );
                            params_friends.weight = 1;
                            friends.setLayoutParams(params_friends);
                            friends.setImageDrawable(ic_friends);
                            entry_categories.addView(friends);

                            //FOOD
                            ImageView food = new ImageView(this);

                            LayoutParams params_food = new LayoutParams(
                                    0,
                                    LayoutParams.WRAP_CONTENT
                            );
                            params_food.weight = 1;
                            food.setLayoutParams(params_food);
                            food.setImageDrawable(ic_food);
                            entry_categories.addView(food);

                            //SHOPPING
                            ImageView shopping = new ImageView(this);

                            LayoutParams params_shopping = new LayoutParams(
                                    0,
                                    LayoutParams.WRAP_CONTENT
                            );
                            params_shopping.weight = 1;
                            shopping.setLayoutParams(params_shopping);
                            shopping.setImageDrawable(ic_shopping);
                            entry_categories.addView(shopping);

                            //HEALTH
                            ImageView health = new ImageView(this);

                            LayoutParams params_health = new LayoutParams(
                                    0,
                                    LayoutParams.WRAP_CONTENT
                            );
                            params_health.weight = 1;
                            health.setLayoutParams(params_health);
                            health.setImageDrawable(ic_health);
                            entry_categories.addView(health);

                            //CUSTOM
                            ImageView custom = new ImageView(this);

                            LayoutParams params_custom = new LayoutParams(
                                    0,
                                    LayoutParams.WRAP_CONTENT
                            );
                            params_custom.weight = 1;
                            custom.setLayoutParams(params_custom);
                            custom.setImageDrawable(ic_custom);
                            entry_categories.addView(custom);


                            //KATEGORIEN EINBLENDEN/AUSBLENDEN
                            String[] cat_str_arr = categories.split(" ");
                            Boolean[] cat_bool_arr = new Boolean[cat_str_arr.length];
                            for (int k = 0; k < cat_str_arr.length; k++) {
                                cat_bool_arr[k] = Boolean.parseBoolean(cat_str_arr[k]);
                                if (!(cat_bool_arr[k])) {
                                    switch (k) {
                                        case 0:
                                            work.setVisibility(View.GONE);
                                            break;
                                        case 1:
                                            friends.setVisibility(View.GONE);
                                            break;
                                        case 2:
                                            food.setVisibility(View.GONE);
                                            break;
                                        case 3:
                                            shopping.setVisibility(View.GONE);
                                            break;
                                        case 4:
                                            health.setVisibility(View.GONE);
                                            break;
                                        case 5:
                                            custom.setVisibility(View.GONE);
                                            break;
                                        default:
                                    }
                                }
                            }

                        //DATUM
                        TextView entry_date = new TextView(this);
                        LayoutParams params_entry_date = new LayoutParams(
                                0,
                                LayoutParams.WRAP_CONTENT
                        );
                        params_entry_date.gravity = Gravity.BOTTOM;
                        params_entry_date.weight = 2;
                        params_entry_date.setMargins(dp10,0,0,dp8);
                        entry_date.setLayoutParams(params_entry_date);

                        entry_date.setText(date);
                        entry_date.setTextSize(14);
                        entry_date.setTextColor(Color.parseColor("#757575"));
                        entry_date.setTextAlignment(LinearLayout.TEXT_ALIGNMENT_TEXT_END);
                        entry_categories.addView(entry_date);

                        //ONCLICK LISTENER
                        final int num = i;
                        entry_cv.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent intent = new Intent(Highlights.this, EntryView.class);
                                intent.putExtra(ENTRY_NUM, num_entries - num);
                                startActivity(intent);
                            }
                        });
        }

        ////
        //Einträge aus Dateien auslesen & anzeigen
        /*
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


        entry1_v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Highlights.this, EntryView.class);
                intent.putExtra(ENTRY_NUM, 1);
                startActivity(intent);
            }
        });

        entry2_v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Highlights.this, EntryView.class);
                intent.putExtra(ENTRY_NUM, 2);
                startActivity(intent);
            }
        });

        entry3_v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Highlights.this, EntryView.class);
                intent.putExtra(ENTRY_NUM, 3);
                startActivity(intent);
            }
        });

        */

        System.out.println(entries.toString());

        /*
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        */
    }

    public int dpAsPixels(int sizeInDp) {
        float scale = getResources().getDisplayMetrics().density;
        return (int) (sizeInDp*scale + 0.5f);
    }

}
