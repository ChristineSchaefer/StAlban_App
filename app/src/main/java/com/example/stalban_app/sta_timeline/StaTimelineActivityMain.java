package com.example.stalban_app.sta_timeline;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.example.stalban_app.R;

public class StaTimelineActivityMain extends ListActivity {
    String[] eintrag = {
            "Eintrag 1",
            "Eintrag 2",
            "Eintrag 3",
            "Eintrag 4",
            "Eintrag 5",
            "Eintrag 6",
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sta_timeline);
        //Listview adapter
        setListAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,eintrag));
    }
    public void onListItemClick(ListView parent, View v,
                                int position, long id) {
        Toast.makeText(this, "Ihre Auswahl : " + eintrag[position],
                Toast.LENGTH_LONG).show();
    }
}