package com.example.stalban_app.sta_timeline;
import android.app.Dialog;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.view.WindowManager;
import android.view.Gravity;
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

import org.w3c.dom.Text;

/**
 * @author Anna-Maria Evers
 * <p>
 * Activity to load the years from the string array "timeline_dates" into the timeline
 * and to output the appropriate information from the string array "timeline_content" in a dialog with an onclick.
 */

public class StaTimelineActivityMain extends AppCompatActivity {

    private List<String> mDateList;
    private List<String> mContentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sta_timeline);

        createDateList();
        createContentList();


        // Array Adapter to set the dates from the Array timeline_dates into the Listview Element
        ArrayAdapter<String> dateArrayAdapter =
                new ArrayAdapter<>(
                        this,
                        R.layout.sta_timeline_listview, // the id from the layout file
                        R.id.date,   // the id from the textview in the layout file
                        mDateList); // Dates from the ArrayList

        ListView dateListView = (ListView) findViewById(R.id.listview_sta_timeline);
        dateListView.setAdapter(dateArrayAdapter);
        dateListView.setDivider(null);

        // OnClickListener for Alert Dialog with information from the string array "timeline_content"
        dateListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                showTimelineContent(position);
            }
        });

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // add up button
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

    }

    private void createDateList() {
        String[] timelineDates = getResources().getStringArray(R.array.timeline_dates);
        mDateList = new ArrayList<>(Arrays.asList(timelineDates));
    }

    private void createContentList(){
        String [] timelineContent = getResources().getStringArray(R.array.timeline_content);
        mContentList = new ArrayList<>(Arrays.asList(timelineContent));
    }


    // here opens the dialog based on the parameter
    // the parameter is the index of the pressed date
    public void showTimelineContent(int position){

        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.sta_timeline_infotext);

        TextView content = dialog.findViewById(R.id.timeline_content);
        // search for the content based on the parameter
        String actualContent = mContentList.get(position);
        content.setText(actualContent);

        Button btnClose = dialog.findViewById(R.id.btn_close2);
        btnClose.setOnClickListener(v -> dialog.dismiss());

        dialog.show();
        //WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        //layoutParams.copyFrom(dialog.getWindow().getAttributes());
        //layoutParams.gravity = Gravity.BOTTOM;
        //layoutParams.width = 600;
        //layoutParams.height = 280;
        //dialog.getWindow().setAttributes(layoutParams);
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
