package com.example.stalban_app.sta_menu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.stalban_app.R;
import com.example.stalban_app.sta_gallery.StaGalleryActivityMain;
import com.example.stalban_app.sta_gallery.StaGalleryActivityView;
import com.example.stalban_app.sta_start.StaStartActivityMain;
import com.example.stalban_app.sta_timeline.StaTimelineActivityMain;

public class StaMenuActivityMain extends AppCompatActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sta_menu);

        /*
        Button Tour
        Hier noch Zielklasse ändern!
         */
        Button tour = findViewById(R.id.menu_button_1);
        tour.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(StaMenuActivityMain.this, StaMenuActivityMain.class);
                startActivity(i);
            }
        });

        // Button Bildergallerie
        Button galleryArt = findViewById(R.id.menu_button_2);
        galleryArt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(StaMenuActivityMain.this, StaGalleryActivityMain.class);
                startActivity(i);
            }
        });

        // Button Timeline
        Button timeLine = findViewById(R.id.menu_button_3);
        timeLine.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(StaMenuActivityMain.this, StaTimelineActivityMain.class);
                startActivity(i);
            }
        });

        /*
        Button Impressum
        Hier noch Zielklasse ändern
         */
        Button impressum = findViewById(R.id.menu_button_4);
        impressum.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(StaMenuActivityMain.this, StaMenuActivityMain.class);
                startActivity(i);
            }
        });

    }
}
