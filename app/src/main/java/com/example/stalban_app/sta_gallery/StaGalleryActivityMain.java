package com.example.stalban_app.sta_gallery;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


import com.example.stalban_app.R;

public class StaGalleryActivityMain extends AppCompatActivity {


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sta_gallery_menu);

        Button galleryBeforeWar = findViewById(R.id.gallery_past);
        galleryBeforeWar.setOnClickListener(v -> {
            Intent i = new Intent(StaGalleryActivityMain.this, StaGalleryActivityView.class);
            i.putExtra("button", "before");
            startActivity(i);

        });

        Button galleryArt = findViewById(R.id.gallery_art);
        galleryArt.setOnClickListener(v -> {
            Intent i = new Intent(StaGalleryActivityMain.this, StaGalleryActivityView.class);
            i.putExtra("button", "art");
            startActivity(i);
        });

        Button galleryAfterWar = findViewById(R.id.galery_present);
        galleryAfterWar.setOnClickListener(v -> {
            Intent i = new Intent(StaGalleryActivityMain.this, StaGalleryActivityView.class);
            i.putExtra("button", "after");
            startActivity(i);
        });

        Button galleryWar = findViewById(R.id.gallery_war);
        galleryWar.setOnClickListener(v -> {
            Intent i = new Intent(StaGalleryActivityMain.this, StaGalleryActivityView.class);
            i.putExtra("button", "war");
            startActivity(i);
        });
    }
}
