package com.example.stalban_app.sta_tour;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.stalban_app.R;
import com.example.stalban_app.sta_menu.StaMenuActivityMain;

public class StaTourActivityEnd extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sta_tour_end);

        Button menu = findViewById(R.id.btn_menu);
        menu.setOnClickListener(v -> {
            Intent i = new Intent(StaTourActivityEnd.this, StaMenuActivityMain.class);
            startActivity(i);
        });
        Button tour = findViewById(R.id.btn_tour);
        tour.setOnClickListener(v -> {
            Intent i = new Intent(StaTourActivityEnd.this, StaTourActivityMain.class);
            startActivity(i);
        });
    }
}
