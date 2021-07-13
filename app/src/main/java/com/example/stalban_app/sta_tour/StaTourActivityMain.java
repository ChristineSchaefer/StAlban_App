package com.example.stalban_app.sta_tour;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.stalban_app.R;

public class StaTourActivityMain extends AppCompatActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sta_tour_start);

        Button startTour = findViewById(R.id.btn_tourstart);
        startTour.setOnClickListener(v -> {
            Intent i = new Intent(StaTourActivityMain.this, StaTourActivityStops.class);
            startActivity(i);

        });
    }
}
