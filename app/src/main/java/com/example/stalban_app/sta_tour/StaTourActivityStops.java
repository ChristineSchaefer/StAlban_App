package com.example.stalban_app.sta_tour;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.stalban_app.R;

public class StaTourActivityStops extends AppCompatActivity {

    private int index = 1;
    private final int[] stopStrings = {R.string.empty, R.string.stop1, R.string.stop2, R.string.stop3, R.string.stop4,
            R.string.stop5, R.string.stop6, R.string.stop7, R.string.stop8, R.string.stop9,
            R.string.stop10, R.string.stop11, R.string.stop12, R.string.stop13, R.string.stop14,
            R.string.stop15, R.string.stop16, R.string.stop17, R.string.stop18, R.string.stop19, R.string.empty};
    private TextView tourContent;
    private Button back;
    private Button next;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sta_tour_stop_template);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tourContent = findViewById(R.id.stop);
        tourContent.setText(Html.fromHtml(getString(stopStrings[1])));

        back = findViewById(R.id.btn_back);
        back.setOnClickListener(v -> showContent(stopStrings, 0));
        next = findViewById(R.id.btn_weiter);
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
                back.setVisibility(View.INVISIBLE);
                next.setVisibility(View.INVISIBLE);
                startActivity(new Intent(StaTourActivityStops.this, StaTourActivityEnd.class));
            }
            tourContent.setText(Html.fromHtml(getString(tourStops[index])));
        }
        //s != 1: button back
        else if(index != 0 && s == 0){
            index--;
            //if index of tourContent == 0, go back to welcome-site
            if (index <= 0) {
                back.setVisibility(View.INVISIBLE);
                next.setVisibility(View.INVISIBLE);
                startActivity(new Intent(StaTourActivityStops.this, StaTourActivityMain.class));
            }
            tourContent.setText(Html.fromHtml(getString(tourStops[index])));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.sta_menu, menu);
        return true;
    }

    public void makeTextBold(String text){

    }

}
