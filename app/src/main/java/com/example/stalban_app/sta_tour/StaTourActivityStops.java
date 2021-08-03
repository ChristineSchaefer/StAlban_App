package com.example.stalban_app.sta_tour;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.stalban_app.R;

public class StaTourActivityStops extends AppCompatActivity {

    private int index = 1;
    private final int[] stopStrings = {R.string.empty, R.string.stop1, R.string.stop2, R.string.stop3, R.string.stop4,
            R.string.stop5, R.string.stop6, R.string.stop7, R.string.stop8, R.string.stop9,
            R.string.stop10, R.string.stop11, R.string.stop12, R.string.stop13, R.string.stop14,
            R.string.stop15, R.string.stop16, R.string.stop17, R.string.stop18, R.string.stop19, R.string.empty};
    private TextView tourContent;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sta_tour_stop_template);

        tourContent = findViewById(R.id.stop);
        tourContent.setText(getString(stopStrings[1]));

        Button back = findViewById(R.id.btn_back);
        back.setOnClickListener(v -> showContent(stopStrings, 0));
        Button next = findViewById(R.id.btn_weiter);
        next.setOnClickListener(v -> showContent(stopStrings, 1));
    }

    public void showContent(int[] tourStops, int s) {
        //s == 1: button next
        if(index == 0){
            startActivity(new Intent(StaTourActivityStops.this, StaTourActivityMain.class));
        }
        else if (index != 0 && s == 1) {
            index++;
            if(index >= 20){
                startActivity(new Intent(StaTourActivityStops.this, StaTourActivityEnd.class));
            }
            tourContent.setText(getString(tourStops[index]));
        }
        //s != 1: button back
        else if(index != 0 && s == 0){
            index--;
            //if index of tourContent == 0, go back to welcome-site
            if (index <= 0) {
                startActivity(new Intent(StaTourActivityStops.this, StaTourActivityMain.class));
            }
            tourContent.setText(getString(tourStops[index]));
        }
    }
}
