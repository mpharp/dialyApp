package mym3app.hci.univie.ac.at.dialyapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
//import android.support.v7.widget.GridLayout;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    //public static final String EXTRA_MESSAGE = "mymm3app.hci.univie.ac.at.MESSAGE";

    LinearLayout mainLayout;
    CardView highlights_btn;
    CardView stats_btn;
    CardView new_entry_btn;


    public static int theme = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();

        mainLayout = (LinearLayout) findViewById(R.id.mainLayout);
        highlights_btn = (CardView) findViewById(R.id.highlights_btn);
        stats_btn = (CardView) findViewById(R.id.stats_btn);
        new_entry_btn = (CardView) findViewById(R.id.new_entry_btn);

        highlights_btn.setCardElevation(8);
        stats_btn.setCardElevation(8);
        new_entry_btn.setCardElevation(8);

        /*
         * TEST
         */
        String[] fileList = fileList();
        ArrayList<Entry> entries = new ArrayList<Entry>();
        for(String f : fileList) {
            if(f.startsWith("entry.")) {
                try {
                    entries.add(new Entry(openFileInput(f),this));
                } catch (FileNotFoundException e) { //wird nie passieren
                    e.printStackTrace();
                }
            }
        }


        int num_entries = entries.size();


        /*
         *
         */



        highlights_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                highlights_btn.setCardElevation(16);
                Intent intent = new Intent(MainActivity.this, Highlights.class);
                startActivity(intent);
            }
        });

        stats_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stats_btn.setCardElevation(16);
                Intent intent = new Intent(MainActivity.this, Statistics.class);
                startActivity(intent);
            }
        });

        new_entry_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new_entry_btn.setCardElevation(20);
                Intent intent = new Intent(MainActivity.this, NewEntry_1.class);
                startActivity(intent);
            }
        });


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    public void sendMessage(View view) {
        Toast.makeText(MainActivity.this, "Clicked on item.", Toast.LENGTH_LONG).show();
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_settings) {
            Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_pdf) {

        } else if (id == R.id.nav_readme) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
