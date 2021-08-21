package com.example.stalban_app.sta_timeline;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.stalban_app.R;
import com.example.stalban_app.sta_gallery.StaGalleryActivityMain;
import com.example.stalban_app.sta_gallery.StaGalleryActivityView;
import com.example.stalban_app.sta_impressum.StaImActivityMain;
import com.example.stalban_app.sta_menu.StaMenuActivityMain;
import com.example.stalban_app.sta_tour.StaTourActivityMain;

public class StaTimelineActivityMain extends AppCompatActivity {

    private List<String> mDateList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sta_timeline);

        createDateList();
        bindAdapterToListView();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // ad up button
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

    }

    private void createDateList() {
        String[] timelineDates = getResources().getStringArray(R.array.timeline_dates);
        mDateList = new ArrayList<>(Arrays.asList(timelineDates));
    }

    private void bindAdapterToListView() {
        ArrayAdapter<String> dateArrayAdapter =
                new ArrayAdapter<>(
                        this, // Die aktuelle Umgebung (diese Activity)
                        R.layout.sta_timeline_listview, // Die ID des Zeilenlayouts (der XML-Layout Datei)
                        R.id.date,   // Die ID des TextView-Elements im Zeilenlayout
                        mDateList); // Daten in der ArrayList

        ListView dateListView = (ListView) findViewById(R.id.listview_sta_timeline);
        dateListView.setAdapter(dateArrayAdapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.sta_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent i;
        switch (item.getItemId()) {

            case R.id.action_tour:

                startActivity(new Intent(this, StaTourActivityMain.class));

                return true;

            case R.id.action_galleryMenu:

                startActivity(new Intent(this, StaGalleryActivityMain.class));

                return true;

            case R.id.action_vorKrieg:

                i = new Intent(this, StaGalleryActivityView.class);
                // provides information about the type of gallery
                i.putExtra("button", "before");
                // start new view
                startActivity(i);

                return true;

            case R.id.action_Krieg:

                // navigate to another view
                i = new Intent(this, StaGalleryActivityView.class);
                // provides information about the type of gallery
                i.putExtra("button", "war");
                // start new view
                startActivity(i);

                return true;

            case R.id.action_nachKrieg:

                // navigate to another view
                i = new Intent(this, StaGalleryActivityView.class);
                // provides information about the type of gallery
                i.putExtra("button", "after");
                // start new view
                startActivity(i);

                return true;

            case R.id.action_Kunst:

                i = new Intent(this, StaGalleryActivityView.class);
                // provides information about the type of gallery
                i.putExtra("button", "art");
                // start new view
                startActivity(i);

                return true;

            case R.id.action_timelaps:

                startActivity(new Intent(this, StaTimelineActivityMain.class));

                return true;

            case R.id.action_impressum:

                startActivity(new Intent(this, StaImActivityMain.class));

                return true;


            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
