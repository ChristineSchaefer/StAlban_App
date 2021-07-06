package com.example.stalban_app.sta_start;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.stalban_app.R;
import com.example.stalban_app.sta_gallery.StaGalleryActivityMain;
import com.example.stalban_app.sta_gallery.StaGalleryActivityView;
import com.example.stalban_app.sta_menu.StaMenuActivityMain;

public class StaStartActivityMain extends AppCompatActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sta_start);

        findViewById(R.id.sta_start_constraint).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(StaStartActivityMain.this, StaMenuActivityMain.class);
                startActivity(i);
            }
        });
    }
}
