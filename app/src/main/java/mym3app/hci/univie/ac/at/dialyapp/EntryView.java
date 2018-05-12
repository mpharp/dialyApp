package mym3app.hci.univie.ac.at.dialyapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Vector;

public class EntryView extends AppCompatActivity {

    TextView title_entry_view;
    TextView notes_entry_view;
    ImageView photo_entry_view;
    TextView date_entry_view;
    ImageView emote_entry_view;
    TextView location_entry_view;






    @Override
    protected void onCreate(Bundle savedInstanceState) {

        final String entry_title = "title";
        final String entry_date = "date";
        final String entry_category = "category";
        final String entry_location = "location";
        final Integer entry_emote = 1;
        final String entry_notes = "laaaanger text";
        Vector<String> entry_photofiles = new Vector<>();
        Vector<String> entry_alarms = new Vector<>();

        /*
        *
        * json auslesen und variablen beschreiben
        * */

        title_entry_view = (TextView) findViewById(R.id.titel_entry_view);
        title_entry_view.setText(entry_title);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
