package com.example.stalban_app.sta_tour;

// imports

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.stalban_app.R;
import com.example.stalban_app.sta_gallery.StaGalleryActivityMain;
import com.example.stalban_app.sta_gallery.StaGalleryActivityView;
import com.example.stalban_app.sta_impressum.StaImActivityMain;
import com.example.stalban_app.sta_menu.StaMenuActivityMain;
import com.example.stalban_app.sta_timeline.StaTimelineActivityMain;

/**
 * @author ChristineSchaefer
 * <p>
 * Activity to set the functionality of the tour-stops.
 * Change content by clicking on button next or back.
 */
public class StaTourActivityStops extends AppCompatActivity {

    // counter for tour stops
    // starts by 1 for the first stop
    private int index = 1;
    // array with tour stop strings (resource file: strings.xml)
    private final int[] stopStrings = {
            R.string.empty, R.string.stop1, R.string.stop2,
            R.string.stop3, R.string.stop4, R.string.stop5,
            R.string.stop6, R.string.stop7, R.string.stop8,
            R.string.stop9, R.string.stop10, R.string.stop11,
            R.string.stop12, R.string.stop13, R.string.stop14,
            R.string.stop15, R.string.stop16, R.string.stop17,
            R.string.stop18, R.string.stop19, R.string.empty};
    // array with tour stops images
    private final int[] stopImages = {
            0, 0, 0, 0,
            0, 0, 0, R.drawable.brba_d048794_kleiner,
            R.drawable.brba_d048796_kleiner, R.drawable.brba_d048792_kleiner, R.drawable.crba_mf091406, R.drawable.brba_d048793_kleiner,
            R.drawable.akoeln_altstadt_nord_die_ruine_von_st_alban_denkmal_kirche_konservator_4ad597619_600x450xfr, R.drawable.brba_d048795_kleiner, R.drawable.brba_d048797_kleiner, 0,
            R.drawable.crba_mf104470, R.drawable.crba_115946, 0, 0,
            0, 0, 0, 0,
            0, 0, 0, 0
    };
    // global declaration of needed objects
    private ScrollView scrollView;
    private TextView tourContent;
    private ImageView tourImage;
    private Button back;
    private Button next;

    /**
     * Method for loading the layout and setting the functionality.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        // basic overwrite-part for setting layout
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sta_tour_stop_template);

        // instantiate the Toolbar above the content
        // contains a menu for navigation
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // ad up button
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        // set first tour stop text and image
        tourContent = findViewById(R.id.stop);
        tourContent.setText(Html.fromHtml(getString(stopStrings[1])));
        tourImage = findViewById(R.id.tour_image);
        tourImage.setImageResource(stopImages[1]);

        // change text by pressed button and scroll to top of text
        back = findViewById(R.id.btn_back);
        back.setOnClickListener(v -> {
            showContent(stopStrings, 0);
            scrollView.scrollTo(0, 0);
        });
        next = findViewById(R.id.btn_weiter);
        next.setOnClickListener(v -> {
            showContent(stopStrings, 1);
            scrollView.scrollTo(0, 0);
        });

        // allows hiding the toolbar when scrolling through the tour stop to have more screen space available
        scrollView = findViewById(R.id.scrollView2);
        scrollView.getViewTreeObserver().addOnScrollChangedListener(
                () -> {
                    // when not scrolling, the toolbar is visible
                    if (scrollView.getChildAt(0).getBottom() <= (scrollView.getHeight() + scrollView.getScrollY())) {
                        toolbar.setVisibility(View.VISIBLE);
                    } else {
                        toolbar.setVisibility(View.GONE);   // when scrolling, the toolbar is invisible
                    }
                });
    }

    /**
     * Method to change text of tour stop by clicked button.
     *
     * @param tourStops array with tour stop strings
     * @param s         number of button: 0 -> back button, 1 -> next button
     */
    public void showContent(int[] tourStops, int s) {
        // if index is 0: no more tour stops, change to tour start view
        if (index == 0) {
            startActivity(new Intent(StaTourActivityStops.this, StaTourActivityMain.class));
        } else if (index != 0 && s == 1) {      // s == 1: button next
            index++;
            // if index is >= 20, there are 19 available tour stops, tour ends
            if (index >= 20) {
                // make button invisible and start new view - tour end
                back.setVisibility(View.INVISIBLE);
                next.setVisibility(View.INVISIBLE);
                startActivity(new Intent(StaTourActivityStops.this, StaTourActivityEnd.class));
            }
            // change text and image from tour stop
            tourContent.setText(Html.fromHtml(getString(tourStops[index])));
            tourImage.setImageResource(stopImages[index]);
        }
        //s != 1: button back
        else if (index != 0 && s == 0) {
            index--;
            //if index of tourContent == 0, go back to welcome-site
            if (index <= 0) {
                // make button invisible and start new view - tour start
                back.setVisibility(View.INVISIBLE);
                next.setVisibility(View.INVISIBLE);
                startActivity(new Intent(StaTourActivityStops.this, StaTourActivityMain.class));
            }
            // change text and image from tour stop
            tourContent.setText(Html.fromHtml(getString(tourStops[index])));
            tourImage.setImageResource(stopImages[index]);
        }
    }

    /**
     * Method to set toolbar options.
     *
     * @param menu toolbar
     * @return bool
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.sta_menu, menu);
        return true;
    }

    /**
     * Method to change view by selected toolbar-option.
     *
     * @param item pressed button
     * @return started activity
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent i;

        // use parameter to change activity
        switch (item.getItemId()) {
            // tour
            case R.id.action_tour:
                startActivity(new Intent(this, StaTourActivityMain.class));
                return true;
            // gallery menu
            case R.id.action_galleryMenu:
                startActivity(new Intent(this, StaGalleryActivityMain.class));
                return true;
            // sub gallery before war
            case R.id.action_vorKrieg:
                i = new Intent(this, StaGalleryActivityView.class);
                // provides information about the type of gallery
                i.putExtra("button", "before");
                // start new view
                startActivity(i);
                return true;
            // sub gallery war
            case R.id.action_Krieg:
                // navigate to another view
                i = new Intent(this, StaGalleryActivityView.class);
                // provides information about the type of gallery
                i.putExtra("button", "war");
                // start new view
                startActivity(i);
                return true;
            // sub gallery after war
            case R.id.action_nachKrieg:
                // navigate to another view
                i = new Intent(this, StaGalleryActivityView.class);
                // provides information about the type of gallery
                i.putExtra("button", "after");
                // start new view
                startActivity(i);
                return true;
            // sub galley art
            case R.id.action_Kunst:
                i = new Intent(this, StaGalleryActivityView.class);
                // provides information about the type of gallery
                i.putExtra("button", "art");
                // start new view
                startActivity(i);
                return true;
            // timelapse
            case R.id.action_timelaps:
                startActivity(new Intent(this, StaTimelineActivityMain.class));
                return true;
            // impressum
            case R.id.action_impressum:
                startActivity(new Intent(this, StaImActivityMain.class));
                return true;
            // default option
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
