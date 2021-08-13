package com.example.stalban_app.sta_tour;

// imports

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.stalban_app.R;

/**
 * @author ChristineSchaefer
 * <p>
 * Activity to set the functionality of the tour-start.
 * Clicking on the button starts the historical tour.
 */
public class StaTourActivityMain extends AppCompatActivity {

    /**
     * Method for loading the layout and setting the functionality.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        // basic overwrite-part for setting layout
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sta_tour_start);

        // instantiate the Toolbar above the content
        // contains a menu for navigation
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // instantiate button for tour start
        Button startTour = findViewById(R.id.btn_tourstart);
        // set onclick-event
        startTour.setOnClickListener(v -> {
            Intent i = new Intent(StaTourActivityMain.this, StaTourActivityStops.class);
            // start new view - tour stops
            startActivity(i);

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.sta_menu, menu);
        return true;
    }
}
