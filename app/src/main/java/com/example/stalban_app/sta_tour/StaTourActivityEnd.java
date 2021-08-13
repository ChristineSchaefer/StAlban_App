package com.example.stalban_app.sta_tour;

// imports

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.stalban_app.R;
import com.example.stalban_app.sta_menu.StaMenuActivityMain;

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.sta_menu, menu);
        return true;
    }
}
