package com.example.stalban_app.sta_tour;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.stalban_app.R;
import com.example.stalban_app.sta_menu.StaMenuActivityMain;

public class StaTourActivityEnd extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sta_tour_end);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.sta_menu, menu);
        return true;
    }
}
