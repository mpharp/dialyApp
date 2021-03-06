package mym3app.hci.univie.ac.at.dialyapp;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

public class NewEntry_2 extends AppCompatActivity {

    public static final String TITLE = "title";
    public static final String DATE = "date";
    public static final String CATEGORY = "category";
    public static final String LOCATION = "location";
    public static final String EMOTION = "emotion";
    public static final String TEXT = "text";
    public static final String IMG_CHOICE = "image_choice";
    public static final String PRIORITY = "priority";

    public static final String ENTRY_ID = "entry_edit_id";
    public static final String EDIT = "entry_edit";

    TextView title_set;

    LinearLayout emo1;
    ImageView emo1d;
    TextView emo1t;

    LinearLayout emo2;
    ImageView emo2d;
    TextView emo2t;

    LinearLayout emo3;
    ImageView emo3d;
    TextView emo3t;

    LinearLayout emo4;
    ImageView emo4d;
    TextView emo4t;

    LinearLayout emo5;
    ImageView emo5d;
    TextView emo5t;

    LinearLayout add_img;

    EditText new_entry_txt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_entry_2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        final Drawable upArrow = getResources().getDrawable(R.drawable.ic_arrow_back_white);
        toolbar.setNavigationIcon(upArrow);
        setSupportActionBar(toolbar);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimary));

        Intent intent = getIntent();

        //Zum Befüllen der final int Arrays mit einem Startwert
        final int[] empty_int_arr = new int[1];
        empty_int_arr[0] = 0;

        //Unterscheidung, woher die Activity geöffnet wurde
        final String new_entry_title = intent.hasExtra("img_choice") ? intent.getStringExtra(ImageSelect.TITLE) : intent.getStringExtra(NewEntry_1.TITLE);
        final String new_entry_date = intent.hasExtra("img_choice") ? intent.getStringExtra(ImageSelect.DATE) : intent.getStringExtra(NewEntry_1.DATE);
        final String cat_str = intent.hasExtra("img_choice") ? intent.getStringExtra(ImageSelect.CATEGORY) : intent.getStringExtra(NewEntry_1.CATEGORY);
        final String new_entry_location = intent.hasExtra("img_choice") ? intent.getStringExtra(ImageSelect.LOCATION) : intent.getStringExtra(NewEntry_1.LOCATION);
        final int[] new_entry_emotion = intent.hasExtra("img_choice") ? intent.getIntArrayExtra(ImageSelect.EMOTION) : empty_int_arr;
        final int[] new_entry_img = intent.hasExtra("img_choice") ? intent.getIntArrayExtra(ImageSelect.IMG_CHOICE) : empty_int_arr;
        final boolean img_change = intent.hasExtra("img_choice");
        final String new_entry_txt_backup = intent.hasExtra("img_choice") ? intent.getStringExtra(ImageSelect.TEXT) : "";
        final int new_entry_priority = intent.hasExtra("img_choice") ? intent.getIntExtra(ImageSelect.PRIORITY, 0) : intent.getIntExtra(NewEntry_1.PRIORITY, 0);
        final int entry_edit_id = intent.hasExtra(EDIT) ? intent.getIntExtra(ENTRY_ID, 1001) : 1001;
        final boolean entry_edit = intent.hasExtra(EDIT) ? intent.getBooleanExtra(EDIT, Boolean.FALSE) : Boolean.FALSE;

        //Titel setzen
        title_set = (TextView) findViewById(R.id.title_set);
        title_set.setText(new_entry_title);

        //Drawable Resources laden
        final Drawable em1 = getResources().getDrawable(R.drawable.em1);
        final Drawable em2 = getResources().getDrawable(R.drawable.em2);
        final Drawable em3 = getResources().getDrawable(R.drawable.em3);
        final Drawable em4 = getResources().getDrawable(R.drawable.em4);
        final Drawable em5 = getResources().getDrawable(R.drawable.em5);

        final Drawable em1_g = getResources().getDrawable(R.drawable.em1_g);
        final Drawable em2_g = getResources().getDrawable(R.drawable.em2_g);
        final Drawable em3_g = getResources().getDrawable(R.drawable.em3_g);
        final Drawable em4_g = getResources().getDrawable(R.drawable.em4_g);
        final Drawable em5_g = getResources().getDrawable(R.drawable.em5_g);



        ////
        //Layouts für EMOTIONS erfassen
        final int[] emo_int = new int[1];
        emo_int[0] = 0;

        emo1 = (LinearLayout) findViewById(R.id.emo1);
        emo1d = (ImageView) findViewById(R.id.emo1d);
        emo1t = (TextView) findViewById(R.id.emo1t);

        emo2 = (LinearLayout) findViewById(R.id.emo2);
        emo2d = (ImageView) findViewById(R.id.emo2d);
        emo2t = (TextView) findViewById(R.id.emo2t);

        emo3 = (LinearLayout) findViewById(R.id.emo3);
        emo3d = (ImageView) findViewById(R.id.emo3d);
        emo3t = (TextView) findViewById(R.id.emo3t);

        emo4 = (LinearLayout) findViewById(R.id.emo4);
        emo4d = (ImageView) findViewById(R.id.emo4d);
        emo4t = (TextView) findViewById(R.id.emo4t);

        emo5 = (LinearLayout) findViewById(R.id.emo5);
        emo5d = (ImageView) findViewById(R.id.emo5d);
        emo5t = (TextView) findViewById(R.id.emo5t);

        new_entry_txt = (EditText) findViewById(R.id.new_entry_txt);


        ////
        //EMOTIONS Auswählen optisch darstellen
        emo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                emo_int[0] = 1;
                emo1t.setTextColor(Color.parseColor("#333333"));
                emo1d.setImageDrawable(em1);
                emo2t.setTextColor(Color.parseColor("#80333333"));
                emo2d.setImageDrawable(em2_g);
                emo3t.setTextColor(Color.parseColor("#80333333"));
                emo3d.setImageDrawable(em3_g);
                emo4t.setTextColor(Color.parseColor("#80333333"));
                emo4d.setImageDrawable(em4_g);
                emo5t.setTextColor(Color.parseColor("#80333333"));
                emo5d.setImageDrawable(em5_g);
            }
        });
        emo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                emo_int[0] = 2;
                emo1t.setTextColor(Color.parseColor("#80333333"));
                emo1d.setImageDrawable(em1_g);
                emo2t.setTextColor(Color.parseColor("#333333"));
                emo2d.setImageDrawable(em2);
                emo3t.setTextColor(Color.parseColor("#80333333"));
                emo3d.setImageDrawable(em3_g);
                emo4t.setTextColor(Color.parseColor("#80333333"));
                emo4d.setImageDrawable(em4_g);
                emo5t.setTextColor(Color.parseColor("#80333333"));
                emo5d.setImageDrawable(em5_g);
            }
        });
        emo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                emo_int[0] = 3;
                emo1t.setTextColor(Color.parseColor("#80333333"));
                emo1d.setImageDrawable(em1_g);
                emo2t.setTextColor(Color.parseColor("#80333333"));
                emo2d.setImageDrawable(em2_g);
                emo3t.setTextColor(Color.parseColor("#333333"));
                emo3d.setImageDrawable(em3);
                emo4t.setTextColor(Color.parseColor("#80333333"));
                emo4d.setImageDrawable(em4_g);
                emo5t.setTextColor(Color.parseColor("#80333333"));
                emo5d.setImageDrawable(em5_g);
            }
        });
        emo4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                emo_int[0] = 4;
                emo1t.setTextColor(Color.parseColor("#80333333"));
                emo1d.setImageDrawable(em1_g);
                emo2t.setTextColor(Color.parseColor("#80333333"));
                emo2d.setImageDrawable(em2_g);
                emo3t.setTextColor(Color.parseColor("#80333333"));
                emo3d.setImageDrawable(em3_g);
                emo4t.setTextColor(Color.parseColor("#333333"));
                emo4d.setImageDrawable(em4);
                emo5t.setTextColor(Color.parseColor("#80333333"));
                emo5d.setImageDrawable(em5_g);
            }
        });
        emo5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                emo_int[0] = 5;
                emo1t.setTextColor(Color.parseColor("#80333333"));
                emo1d.setImageDrawable(em1_g);
                emo2t.setTextColor(Color.parseColor("#80333333"));
                emo2d.setImageDrawable(em2_g);
                emo3t.setTextColor(Color.parseColor("#80333333"));
                emo3d.setImageDrawable(em3_g);
                emo4t.setTextColor(Color.parseColor("#80333333"));
                emo4d.setImageDrawable(em4_g);
                emo5t.setTextColor(Color.parseColor("#333333"));
                emo5d.setImageDrawable(em5);
            }
        });


        Entry entry = new Entry();

        ////
        //Daten aus ImageSelect-Dialog wieder einfügen
        switch (entry_edit ? entry.getEmotion() : new_entry_emotion[0]) {
            case 1:
                emo1.performClick();
                break;
            case 2:
                emo2.performClick();
                break;
            case 3:
                emo3.performClick();
                break;
            case 4:
                emo4.performClick();
                break;
            case 5:
                emo5.performClick();
                break;
            default:
        }


        if (!(new_entry_txt_backup.equals(""))) {
            new_entry_txt.setText(new_entry_txt_backup, TextView.BufferType.EDITABLE);
        }

        //Falls Edit
        if (entry_edit && !img_change) {
            String[] fileList = fileList();
            final String[] fpath = new String[1];
            fpath[0] = "";
            for(String f : fileList) {
                if(f.startsWith("entry." + entry_edit_id)) {
                    fpath[0] = f;
                }
            }

            Entry ent_edit = new Entry();
            try {
                ent_edit = new Entry(openFileInput(fpath[0]), this);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            title_set.setText(ent_edit.getTitle());

            int emo = ent_edit.getEmotion();
            switch (emo) {
                case 1:
                    emo1.performClick();
                    break;
                case 2:
                    emo2.performClick();
                    break;
                case 3:
                    emo3.performClick();
                    break;
                case 4:
                    emo4.performClick();
                    break;
                case 5:
                    emo5.performClick();
                    break;
                default:
            }

            new_entry_txt.setText(ent_edit.getText());

            new_entry_img[0] = ent_edit.getMedia();

        }

        ////
        //Bild hinzufügen
        add_img = (LinearLayout) findViewById(R.id.add_img);
        add_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NewEntry_2.this, ImageSelect.class);
                intent.putExtra(TITLE, new_entry_title);
                intent.putExtra(DATE, new_entry_date);
                intent.putExtra(CATEGORY, cat_str);
                intent.putExtra(LOCATION, "");
                intent.putExtra(EMOTION, emo_int[0]);
                intent.putExtra(TEXT, new_entry_txt.getText().toString());
                intent.putExtra(PRIORITY, new_entry_priority);
                intent.putExtra(ENTRY_ID, entry_edit_id);
                intent.putExtra(EDIT, entry_edit);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
            }
        });


        ////
        //FAB
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NewEntry_2.this, MainActivity.class);
                intent.putExtra(TITLE, new_entry_title);
                intent.putExtra(DATE, new_entry_date);
                intent.putExtra(CATEGORY, cat_str);
                intent.putExtra(LOCATION, new_entry_location);
                intent.putExtra(EMOTION, emo_int[0]);
                intent.putExtra(TEXT, new_entry_txt.getText().toString());
                intent.putExtra(IMG_CHOICE, new_entry_img);
                intent.putExtra(PRIORITY, new_entry_priority);

                ////
                //Daten exportieren
                Entry newEntry = entry_edit ? new Entry(new_entry_title, new_entry_date, cat_str,
                        new_entry_location, emo_int[0], new_entry_txt.getText().toString(), new_entry_img[0], new_entry_priority, NewEntry_2.this, entry_edit_id) : new Entry(new_entry_title, new_entry_date, cat_str,
                        new_entry_location, emo_int[0], new_entry_txt.getText().toString(), new_entry_img[0], new_entry_priority, NewEntry_2.this);
                //Entry newEntry = new Entry(new_entry_title, new_entry_date, cat_str,
                //        new_entry_location, emo_int[0], new_entry_txt.getText().toString(), new_entry_img[0]);
                newEntry.saveToFile(getFilesDir()); // getFilesDir() retourniert das directory, das android unserer app zur verf. stellt

                startActivity(intent);
            }
        });


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            finish();
            overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);
            return true;
        }
        return false;
    }
}
