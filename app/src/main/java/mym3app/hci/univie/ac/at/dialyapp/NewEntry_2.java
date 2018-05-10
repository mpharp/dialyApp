package mym3app.hci.univie.ac.at.dialyapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class NewEntry_2 extends AppCompatActivity {

    TextView title_set;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_entry_2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();

        String title = intent.getStringExtra(NewEntry_1.TITLE);
        String date = intent.getStringExtra(NewEntry_1.DATE);
        boolean[] categories = intent.getBooleanArrayExtra(NewEntry_1.CATEGORY);
        String location = intent.getStringExtra(NewEntry_1.LOCATION);

        String cat = String.valueOf(categories.length) + ": ";

        for (boolean press: categories){
            if (press) cat += "1";
            else cat += "0";
        }


        title_set = (TextView) findViewById(R.id.title_set);
        title_set.setText(title);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NewEntry_2.this, MainActivity.class);
                startActivity(intent);
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                //        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
