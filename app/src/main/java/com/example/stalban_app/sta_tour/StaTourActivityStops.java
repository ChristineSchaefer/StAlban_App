package com.example.stalban_app.sta_tour;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.stalban_app.R;
import com.example.stalban_app.sta_xmlparser.TourStop;
import com.example.stalban_app.sta_xmlparser.XMLParser;

import org.xmlpull.v1.XmlPullParserException;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class StaTourActivityStops extends AppCompatActivity {

    private List<TourStop> tourStops = new ArrayList<>();

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sta_tour_stop_template);

        XMLParser parser = new XMLParser();
        try {
            InputStream in = new FileInputStream("src/main/res/values/strings.xml");
            tourStops = parser.parse(in);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] array = new String[tourStops.size()];
        tourStops.toArray(array); // fill the array

        TextView tourContent = findViewById(R.id.stop);
        //tourContent.setText(array[1]);

        Button back = findViewById(R.id.btn_back);
        Button next = findViewById(R.id.btn_weiter);
    }

    public String showContent(String[] tourStops, int s) {
        //TODO Verbindung zur Datei strings.xml herstellen
        int index = 1;
        //s == 1: button next
        if (s == 1) {
            index++;
        }
        //s != 1: button back
        else{
            index--;
            //if index of tourContent == 0, go back to welcome-site
            if(index == 0){
                Intent i = new Intent(StaTourActivityStops.this, StaTourActivityMain.class);
                startActivity(i);
            }
        }
        return tourStops[index];
    }
}
