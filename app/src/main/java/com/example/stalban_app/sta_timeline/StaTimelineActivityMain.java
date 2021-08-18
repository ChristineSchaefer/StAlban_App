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

public class StaTimelineActivityMain extends AppCompatActivity{
    String[] eintrag = {
            "Eintrag 1",
            "Eintrag 2",
            "Eintrag 3",
            "Eintrag 4",
            "Eintrag 5",
            "Eintrag 6",
    };
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sta_timeline);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // ad up button
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        //Listview adapter
        //setListAdapter(new ArrayAdapter<>(this,
          //      android.R.layout.simple_list_item_1,eintrag));
    }
    /*public void onListItemClick(ListView parent, View v,
                                int position, long id) {
        Toast.makeText(this, "Ihre Auswahl : " + eintrag[position],
                Toast.LENGTH_LONG).show();
    }*/

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