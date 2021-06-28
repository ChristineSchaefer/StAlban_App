package com.example.stalban_app.sta_gallery;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.stalban_app.MainActivity;
import com.example.stalban_app.R;

public class StaGalleryActivityMain extends AppCompatActivity {

    StaGalleryActivityView galleryView;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sta_gallery_menu);

        Button galleryBeforeWar = findViewById(R.id.gallery_past);
        galleryBeforeWar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(StaGalleryActivityMain.this, StaGalleryActivityView.class);
                i.putExtra("button", "before");
                startActivity(i);

            }
        });

        Button galleryArt = findViewById(R.id.gallery_art);
        galleryArt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(StaGalleryActivityMain.this, StaGalleryActivityView.class);
                i.putExtra("button", "art");
                startActivity(i);
            }
        });

        Button galleryAfterWar = findViewById(R.id.galery_present);
        galleryAfterWar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(StaGalleryActivityMain.this, StaGalleryActivityView.class);
                i.putExtra("button", "after");
                startActivity(i);
            }
        });

        Button galleryWar = findViewById(R.id.gallery_war);
        galleryWar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(StaGalleryActivityMain.this, StaGalleryActivityView.class);
                i.putExtra("button", "war");
                startActivity(i);
            }
        });
    }
}
