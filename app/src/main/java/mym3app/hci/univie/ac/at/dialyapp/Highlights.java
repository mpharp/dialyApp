package mym3app.hci.univie.ac.at.dialyapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

public class Highlights extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_map:
                    mTextMessage.setText("Karte");
                    return true;
                case R.id.navigation_list:
                    mTextMessage.setText("Liste");
                    return true;
                case R.id.navigation_calendar:
                    mTextMessage.setText("Kalender");
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highlights);


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

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
