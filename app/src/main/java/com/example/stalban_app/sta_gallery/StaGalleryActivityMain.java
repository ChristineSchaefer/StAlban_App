package com.example.stalban_app.sta_gallery;

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
 * Activity to set the functionality of the gallery menu.
 * Clicking on a button takes you to different sub-galleries.
 */
public class StaGalleryActivityMain extends AppCompatActivity {

    /**
     * Method for loading the layout and setting the functionality.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        // basic overwrite-part for setting layout
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sta_gallery_menu);

        // instantiate the Toolbar above the content
        // contains a menu for navigation
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // instantiate button for sub-gallery
        Button galleryBeforeWar = findViewById(R.id.gallery_past);
        // set onclick-event
        galleryBeforeWar.setOnClickListener(v -> {
            // navigate to another view
            Intent i = new Intent(StaGalleryActivityMain.this, StaGalleryActivityView.class);
            // provides information about the type of gallery
            i.putExtra("button", "before");
            // start new view
            startActivity(i);

        });

        // instantiate button for sub-gallery
        Button galleryArt = findViewById(R.id.gallery_art);
        // set onclick-event
        galleryArt.setOnClickListener(v -> {
            // navigate to another view
            Intent i = new Intent(StaGalleryActivityMain.this, StaGalleryActivityView.class);
            // provides information about the type of gallery
            i.putExtra("button", "art");
            // start new view
            startActivity(i);
        });

        // instantiate button for sub-gallery
        Button galleryAfterWar = findViewById(R.id.galery_present);
        // set onclick-event
        galleryAfterWar.setOnClickListener(v -> {
            // navigate to another view
            Intent i = new Intent(StaGalleryActivityMain.this, StaGalleryActivityView.class);
            // provides information about the type of gallery
            i.putExtra("button", "after");
            // start new view
            startActivity(i);
        });

        // instantiate button for sub-gallery
        Button galleryWar = findViewById(R.id.gallery_war);
        // set onclick-event
        galleryWar.setOnClickListener(v -> {
            // navigate to another view
            Intent i = new Intent(StaGalleryActivityMain.this, StaGalleryActivityView.class);
            // provides information about the type of gallery
            i.putExtra("button", "war");
            // start new view
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
