package com.example.stalban_app.sta_start;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.stalban_app.R;
import com.example.stalban_app.sta_menu.StaMenuActivityMain;

public class StaStartActivityMain extends AppCompatActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sta_start);

        findViewById(R.id.sta_start_constraint).setOnClickListener(v -> {
            Intent i = new Intent(StaStartActivityMain.this, StaMenuActivityMain.class);
            startActivity(i);
        });
    }
}
