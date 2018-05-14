package mym3app.hci.univie.ac.at.dialyapp;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ImageSelect extends AppCompatActivity {

    ImageView img1;
    ImageView img2;
    ImageView img3;
    ImageView img4;
    ImageView img5;
    ImageView img6;

    TextView test_txt;

    public static final String TITLE = "title";
    public static final String DATE = "date";
    public static final String CATEGORY = "category";
    public static final String LOCATION = "location";
    public static final String EMOTION = "emotion";
    public static final String TEXT = "text";
    public static final String IMG_CHOICE = "img_choice";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_select);

        ActionBar actionBar = getSupportActionBar();

        actionBar.setHomeButtonEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setDisplayShowHomeEnabled(false);

        //ALS OVERLAY:
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width*.8), (int) (height*.6));

        Intent intent = getIntent();
        final String new_entry_title = intent.getStringExtra(NewEntry_2.TITLE);
        final String new_entry_date = intent.getStringExtra(NewEntry_2.DATE);
        final String cat_str = intent.getStringExtra(NewEntry_2.CATEGORY);
        final String new_entry_location = intent.getStringExtra(NewEntry_2.LOCATION);
        int[] emo = new int[1];
        emo[0] = intent.getIntExtra(NewEntry_2.EMOTION, 0);
        final int[] emo_int = emo;
        final String new_entry_txt = intent.getStringExtra(NewEntry_2.TEXT);

        img1 = (ImageView) findViewById(R.id.img01);
        img2 = (ImageView) findViewById(R.id.img02);
        img3 = (ImageView) findViewById(R.id.img03);
        img4 = (ImageView) findViewById(R.id.img04);
        img5 = (ImageView) findViewById(R.id.img05);
        img6 = (ImageView) findViewById(R.id.img06);

        test_txt = (TextView) findViewById(R.id.test_txt);
        test_txt.setText("RESULT: " + Integer.toString(emo_int[0]));

        final int dp_five = dpAsPixels(5);
        final int[] choice = new int[1];
        choice[0] = 0;

        // Um optisch darstellen zu können, welches Bild gewählt wurde

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img1.setPadding(dp_five, dp_five, dp_five, dp_five);
                img2.setPadding(0, 0, 0, 0);
                img3.setPadding(0, 0, 0, 0);
                img4.setPadding(0, 0, 0, 0);
                img5.setPadding(0, 0, 0, 0);
                img6.setPadding(0, 0, 0, 0);
                choice[0] = 1;
            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img1.setPadding(0, 0, 0, 0);
                img2.setPadding(dp_five, dp_five, dp_five, dp_five);
                img3.setPadding(0, 0, 0, 0);
                img4.setPadding(0, 0, 0, 0);
                img5.setPadding(0, 0, 0, 0);
                img6.setPadding(0, 0, 0, 0);
                choice[0] = 2;
            }
        });
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img1.setPadding(0, 0, 0, 0);
                img2.setPadding(0, 0, 0, 0);
                img3.setPadding(dp_five, dp_five, dp_five, dp_five);
                img4.setPadding(0, 0, 0, 0);
                img5.setPadding(0, 0, 0, 0);
                img6.setPadding(0, 0, 0, 0);
                choice[0] = 3;
            }
        });
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img1.setPadding(0, 0, 0, 0);
                img2.setPadding(0, 0, 0, 0);
                img3.setPadding(0, 0, 0, 0);
                img4.setPadding(dp_five, dp_five, dp_five, dp_five);
                img5.setPadding(0, 0, 0, 0);
                img6.setPadding(0, 0, 0, 0);
                choice[0] = 4;
            }
        });
        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img1.setPadding(0, 0, 0, 0);
                img2.setPadding(0, 0, 0, 0);
                img3.setPadding(0, 0, 0, 0);
                img4.setPadding(0, 0, 0, 0);
                img5.setPadding(dp_five, dp_five, dp_five, dp_five);
                img6.setPadding(0, 0, 0, 0);
                choice[0] = 5;
            }
        });

        img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img1.setPadding(0, 0, 0, 0);
                img2.setPadding(0, 0, 0, 0);
                img3.setPadding(0, 0, 0, 0);
                img4.setPadding(0, 0, 0, 0);
                img5.setPadding(0, 0, 0, 0);
                img6.setPadding(dp_five, dp_five, dp_five, dp_five);
                choice[0] = 6;
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ImageSelect.this, NewEntry_2.class);
                intent.putExtra(TITLE, new_entry_title);
                intent.putExtra(DATE, new_entry_date);
                intent.putExtra(CATEGORY, cat_str);
                intent.putExtra(LOCATION, new_entry_location);
                intent.putExtra(EMOTION, emo_int);
                intent.putExtra(TEXT, new_entry_txt);
                intent.putExtra(IMG_CHOICE, choice);
                startActivity(intent);
            }
        });

    }

    public int dpAsPixels(int sizeInDp) {
        float scale = getResources().getDisplayMetrics().density;
        return (int) (sizeInDp*scale + 0.5f);
    }

}
