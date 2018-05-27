package mym3app.hci.univie.ac.at.dialyapp;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;

import java.util.Arrays;
import java.util.Calendar;

public class NewEntry_1 extends AppCompatActivity {

    public static final String TITLE = "title";
    public static final String DATE = "date";
    public static final String CATEGORY = "category";
    public static final String LOCATION ="location";

    EditText new_entry_title;
    TextView new_entry_date_view;
    Button new_entry_date_btn;

    CardView cat_work;
    CardView cat_friends;
    CardView cat_food;
    CardView cat_shopping;
    CardView cat_health;
    CardView cat_custom;

    Button place_btn;

    Calendar cal;
    DatePickerDialog date_pick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_entry_1);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        new_entry_title = (EditText) findViewById(R.id.new_entry_title);


        new_entry_date_view = (TextView) findViewById(R.id.new_entry_date_view);
        new_entry_date_btn = (Button) findViewById(R.id.new_entry_date_btn);

        new_entry_date_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cal = Calendar.getInstance();
                int day = cal.get(Calendar.DAY_OF_MONTH);
                int month = cal.get(Calendar.MONTH);
                int year = cal.get(Calendar.YEAR);

                date_pick = new DatePickerDialog(NewEntry_1.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int yr, int mnth, int dy) {
                        new_entry_date_view.setText(dy + ". " + (mnth+1) + ". " + yr);
                    }
                }, year, month, day);
                date_pick.show();
            }
        });

        final boolean[] press_arr = new boolean[6];
        Arrays.fill(press_arr, Boolean.FALSE);

        cat_work = (CardView) findViewById(R.id.cat_work);
        cat_work.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (press_arr[0]) {
                    cat_work.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
                    cat_work.setCardElevation(2);
                    press_arr[0] = false;
                } else {
                    cat_work.setCardBackgroundColor(Color.parseColor("#7cb342"));
                    cat_work.setCardElevation(8);
                    press_arr[0] = true;
                }
            }
        });

        cat_friends = (CardView) findViewById(R.id.cat_friends);
        cat_friends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (press_arr[1]) {
                    cat_friends.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
                    cat_friends.setCardElevation(2);
                    press_arr[1] = false;
                } else {
                    cat_friends.setCardBackgroundColor(Color.parseColor("#7cb342"));
                    cat_friends.setCardElevation(8);
                    press_arr[1] = true;
                }
            }
        });

        cat_food = (CardView) findViewById(R.id.cat_food);
        cat_food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (press_arr[2]) {
                    cat_food.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
                    cat_food.setCardElevation(2);
                    press_arr[2] = false;
                } else {
                    cat_food.setCardBackgroundColor(Color.parseColor("#7cb342"));
                    cat_food.setCardElevation(8);
                    press_arr[2] = true;
                }
            }
        });

        cat_shopping = (CardView) findViewById(R.id.cat_shopping);
        cat_shopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (press_arr[3]) {
                    cat_shopping.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
                    cat_shopping.setCardElevation(2);
                    press_arr[3] = false;
                } else {
                    cat_shopping.setCardBackgroundColor(Color.parseColor("#7cb342"));
                    cat_shopping.setCardElevation(8);
                    press_arr[3] = true;
                }
            }
        });

        cat_health = (CardView) findViewById(R.id.cat_health);
        cat_health.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (press_arr[4]) {
                    cat_health.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
                    cat_health.setCardElevation(2);
                    press_arr[4] = false;
                } else {
                    cat_health.setCardBackgroundColor(Color.parseColor("#7cb342"));
                    cat_health.setCardElevation(8);
                    press_arr[4] = true;
                }
            }
        });

        cat_custom = (CardView) findViewById(R.id.cat_custom);
        cat_custom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (press_arr[5]) {
                    cat_custom.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
                    cat_custom.setCardElevation(2);
                    press_arr[5] = false;
                } else {
                    cat_custom.setCardBackgroundColor(Color.parseColor("#7cb342"));
                    cat_custom.setCardElevation(8);
                    press_arr[5] = true;
                }
            }
        });

        place_btn = (Button) findViewById(R.id.place_btn);
        /*
        place_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int PLACE_PICKER_REQUEST = 1;
                PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();

                startActivityForResult(builder.build(this), PLACE_PICKER_REQUEST);
            }
        });*/


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Boolean[] auslesen
                String cats = "";
                for (boolean press: press_arr){
                    if (press) cats += "true ";
                    else cats += "false ";
                }

                final String cat_str = cats;

                Intent intent = new Intent(NewEntry_1.this, NewEntry_2.class);
                intent.putExtra(TITLE, new_entry_title.getText().toString());
                intent.putExtra(DATE, new_entry_date_view.getText());
                intent.putExtra(CATEGORY, cat_str);
                intent.putExtra(LOCATION, "");

                startActivity(intent);
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                //        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
