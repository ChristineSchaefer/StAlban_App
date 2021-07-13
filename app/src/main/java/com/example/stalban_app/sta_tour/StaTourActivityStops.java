package com.example.stalban_app.sta_tour;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.stalban_app.R;

public class StaTourActivityStops extends AppCompatActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sta_tour_stop_template);

        Button back = findViewById(R.id.btn_back);
        back.setOnClickListener(v -> {
            Intent i = new Intent(StaTourActivityStops.this, StaTourActivityMain.class);
            startActivity(i);

        });
    }
}
