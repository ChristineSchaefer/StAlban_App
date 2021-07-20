package com.example.stalban_app.sta_menu;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.stalban_app.R;
import com.example.stalban_app.sta_gallery.StaGalleryActivityMain;
import com.example.stalban_app.sta_impressum.StaImActivityMain;
import com.example.stalban_app.sta_timeline.StaTimelineActivityMain;
import com.example.stalban_app.sta_tour.StaTourActivityMain;

public class StaMenuActivityMain extends AppCompatActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sta_menu);

        /*
        Button Tour
         */
        Button tour = findViewById(R.id.menu_button_1);
        tour.setOnClickListener(v -> {
            Intent i = new Intent(StaMenuActivityMain.this, StaTourActivityMain.class);
            startActivity(i);
        });

        // Button Bildergallerie
        Button galleryArt = findViewById(R.id.menu_button_2);
        galleryArt.setOnClickListener(v -> {
            Intent i = new Intent(StaMenuActivityMain.this, StaGalleryActivityMain.class);
            startActivity(i);
        });

        // Button Timeline
        Button timeLine = findViewById(R.id.menu_button_3);
        timeLine.setOnClickListener(v -> {
            Intent i = new Intent(StaMenuActivityMain.this, StaTimelineActivityMain.class);
            startActivity(i);
        });

        /*
        Button Impressum
        Hier noch Zielklasse ändern
         */
        Button im = findViewById(R.id.menu_button_4);
        im.setOnClickListener(v -> {
            Intent i = new Intent(StaMenuActivityMain.this, StaImActivityMain.class);
            startActivity(i);
        });

    }
}
