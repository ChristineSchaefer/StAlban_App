package com.example.stalban_app.sta_tour;

// imports

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.stalban_app.R;
import com.example.stalban_app.sta_gallery.StaGalleryActivityMain;
import com.example.stalban_app.sta_gallery.StaGalleryActivityView;
import com.example.stalban_app.sta_impressum.StaImActivityMain;
import com.example.stalban_app.sta_menu.StaMenuActivityMain;
import com.example.stalban_app.sta_timeline.StaTimelineActivityMain;

/**
 * @author ChristineSchaefer
 * <p>
 * Activity to set the functionality of the tour-end.
 * Clicking on a button takes you to different views (start of tour or menu).
 */
public class StaTourActivityEnd extends AppCompatActivity {

    /**
     * Method for loading the layout and setting the functionality.
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        // basic overwrite-part for setting layout
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sta_tour_end);

        // instantiate the Toolbar above the content
        // contains a menu for navigation
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // add up button
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        // instantiate button for menu
        Button menu = findViewById(R.id.btn_menu);
        // set onclick-event
        menu.setOnClickListener(v -> {
            Intent i = new Intent(StaTourActivityEnd.this, StaMenuActivityMain.class);
            // start new view - menu
            startActivity(i);
        });

        // instantiate button for restart tour
        Button tour = findViewById(R.id.btn_tour);
        // set onclick-event
        tour.setOnClickListener(v -> {
            Intent i = new Intent(StaTourActivityEnd.this, StaTourActivityMain.class);
            // start new view - tour start
            startActivity(i);
        });
    }

    /**
     * Method to set toolbar options.
     *
     * @param menu toolbar
     * @return bool
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.sta_menu, menu);
        return true;
    }

    /**
     * Method to change view by selected toolbar-option.
     *
     * @param item pressed button
     * @return started activity
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent i;

        // use parameter to change activity
        switch (item.getItemId()) {
            // tour
            case R.id.action_tour:
                startActivity(new Intent(this, StaTourActivityMain.class));
                return true;
            // gallery menu
            case R.id.action_galleryMenu:
                startActivity(new Intent(this, StaGalleryActivityMain.class));
                return true;
            // sub gallery before war
            case R.id.action_vorKrieg:
                i = new Intent(this, StaGalleryActivityView.class);
                // provides information about the type of gallery
                i.putExtra("button", "before");
                // start new view
                startActivity(i);
                return true;
            // sub gallery war
            case R.id.action_Krieg:
                // navigate to another view
                i = new Intent(this, StaGalleryActivityView.class);
                // provides information about the type of gallery
                i.putExtra("button", "war");
                // start new view
                startActivity(i);
                return true;
            // sub gallery after war
            case R.id.action_nachKrieg:
                // navigate to another view
                i = new Intent(this, StaGalleryActivityView.class);
                // provides information about the type of gallery
                i.putExtra("button", "after");
                // start new view
                startActivity(i);
                return true;
            // sub galley art
            case R.id.action_Kunst:
                i = new Intent(this, StaGalleryActivityView.class);
                // provides information about the type of gallery
                i.putExtra("button", "art");
                // start new view
                startActivity(i);
                return true;
            // timelapse
            case R.id.action_timelaps:
                startActivity(new Intent(this, StaTimelineActivityMain.class));
                return true;
            // impressum
            case R.id.action_impressum:
                startActivity(new Intent(this, StaImActivityMain.class));
                return true;
            // default option
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
