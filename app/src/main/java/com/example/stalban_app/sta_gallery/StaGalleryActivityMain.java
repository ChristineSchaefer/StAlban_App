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

        Button galleryWar = (Button) findViewById(R.id.gallery_war);
        galleryWar.setOnClickListener(v -> startActivity(new Intent(StaGalleryActivityMain.this, StaGalleryActivityView.class)));

        Button galleryArt = (Button) findViewById(R.id.gallery_art);
        galleryArt.setOnClickListener(v -> startActivity(new Intent(StaGalleryActivityMain.this, StaGalleryActivityViewArt.class)));
    }
}
