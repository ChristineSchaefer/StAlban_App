package com.example.stalban_app.sta_timeline;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.stalban_app.R;

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
}