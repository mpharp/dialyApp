package mym3app.hci.univie.ac.at.dialyapp;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;

public class ImageSelect extends AppCompatActivity {

    ImageView img1;
    ImageView img2;
    ImageView img3;
    ImageView img4;
    ImageView img5;
    ImageView img6;

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

        img1 = (ImageView) findViewById(R.id.img01);
        img2 = (ImageView) findViewById(R.id.img02);
        img3 = (ImageView) findViewById(R.id.img03);
        img4 = (ImageView) findViewById(R.id.img04);
        img5 = (ImageView) findViewById(R.id.img05);
        img6 = (ImageView) findViewById(R.id.img06);

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img1.setPadding(dpAsPixels(5),dpAsPixels(5),dpAsPixels(5),dpAsPixels(5));
            }
        });

    }

    public int dpAsPixels(int sizeInDp) {
        float scale = getResources().getDisplayMetrics().density;
        return (int) (sizeInDp*scale + 0.5f);
    }

}
