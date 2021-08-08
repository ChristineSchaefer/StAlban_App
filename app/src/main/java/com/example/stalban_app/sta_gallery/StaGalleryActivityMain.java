package com.example.stalban_app.sta_gallery;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import com.example.stalban_app.R;
import com.example.stalban_app.sta_menu.StaMenuActivityMain;
import com.example.stalban_app.sta_start.StaStartActivityMain;

public class StaGalleryActivityMain extends AppCompatActivity {


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sta_gallery_menu);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.sta_menu, menu);
        return true;
    }
}
