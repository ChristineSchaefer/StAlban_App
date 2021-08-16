package com.example.stalban_app.sta_impressum;

// imports

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.stalban_app.R;
import com.example.stalban_app.sta_gallery.StaGalleryActivityMain;
import com.example.stalban_app.sta_menu.StaMenuActivityMain;
import com.example.stalban_app.sta_timeline.StaTimelineActivityMain;
import com.example.stalban_app.sta_tour.StaTourActivityMain;

public class StaImActivityMain extends AppCompatActivity {

    /**
     * Method for loading the layout and setting the functionality.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        // basic overwrite-part for setting layout
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sta_imp);

        // instantiate the Toolbar above the content
        // contains a menu for navigation
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.sta_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case R.id.backButton:

                startActivity(new Intent(this, StaMenuActivityMain.class));

                return true;

            case R.id.action_tour:

                startActivity(new Intent(this, StaTourActivityMain.class));

                return true;

            case R.id.action_galleryMenu:

                startActivity(new Intent(this, StaGalleryActivityMain.class));

                return true;
            /*
            case R.id.action_vorKrieg:

                startActivity(new Intent(this, StaMenuActivityMain.class));

                return true;

            case R.id.action_Krieg:

                startActivity(new Intent(this, StaMenuActivityMain.class));

                return true;

            case R.id.action_nachKrieg:

                startActivity(new Intent(this, StaMenuActivityMain.class));

                return true;

            case R.id.action_Kunst:

                startActivity(new Intent(this, StaMenuActivityMain.class));

                return true;
    */
            case R.id.action_timelaps:

                startActivity(new Intent(this, StaTimelineActivityMain.class));

                return true;

            case R.id.action_impressum:

                startActivity(new Intent(this, StaImActivityMain.class));

                return true;


            default:
                return super.onOptionsItemSelected(item);
        }
    }
}