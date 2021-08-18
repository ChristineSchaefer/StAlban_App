package com.example.stalban_app.sta_gallery;

// imports

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.stalban_app.R;
import com.example.stalban_app.sta_impressum.StaImActivityMain;
import com.example.stalban_app.sta_menu.StaMenuActivityMain;
import com.example.stalban_app.sta_timeline.StaTimelineActivityMain;
import com.example.stalban_app.sta_tour.StaTourActivityMain;


import java.util.ArrayList;
import java.util.Collections;

/**
 * @author ChristineSchaefer
 * <p>
 * Activity to set the functionality of the sub-galleries.
 */
public class StaGalleryActivityView extends AppCompatActivity {

    // instantiation of globally usable lists for storing image resources and image descriptions
    private ArrayList<Integer> imageIds = new ArrayList<>(Collections.emptyList());
    private ArrayList<String> imageTitles = new ArrayList<>(Collections.emptyList());

    /**
     * Method for loading the layout and setting the functionality.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        // basic overwrite-part for setting layout
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sta_gallery_view);

        // sets the Toolbar above the content
        // contains a menu for navigation
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // fills lists with button-specific content
        // content changes depending on selected button in gallery menu
        String button = getIntent().getStringExtra("button");
        imageTitles = changeImagesTitles(button);
        imageIds = changeButtonImages(button);

        // instantiate the TextView for the gallery title
        // content changes depending on selected button in gallery menu
        TextView galleryTitle = findViewById(R.id.gallery);
        galleryTitle.setText(changeGalleryTitle(button));

        // instantiate empty GridView for presenting the images of the selected sub-gallery
        GridView gridView = findViewById(R.id.galleryGrid);
        // use ImageAdapter to set images
        gridView.setAdapter(new StaImageAdapter(imageIds, this));

        // set onclick-event for images to show dialog box with information and full screen option
        gridView.setOnItemClickListener((parent, view, position, id) -> {
            int item_pos = imageIds.get(position);

            showDialogBox(item_pos);
        });

    }

    /**
     * Methods to change shown images in sub-galleries.
     *
     * @param button means the selected sub-gallery
     * @return list with image ids for selected gallery
     */
    public ArrayList<Integer> changeButtonImages(String button) {
        ArrayList<Integer> imageIds = new ArrayList<>();

        // use parameter to select images
        switch (button) {
            case "before":
                imageIds.add(R.drawable.dkoeln_alt_st_alban_grundriss_1916);
                imageIds.add(R.drawable.drba_042968);
                imageIds.add(R.drawable.drba_061928);
                imageIds.add(R.drawable.drba_061929);
                imageIds.add(R.drawable.drba_640451);
                imageIds.add(R.drawable.drba_d006153);
                imageIds.add(R.drawable.drba_d006407);
                imageIds.add(R.drawable.drba_mf064822);
                imageIds.add(R.drawable.drba_mf061928);
                imageIds.add(R.drawable.drba_mf061929);
                imageIds.add(R.drawable.drba_mf064823);
                imageIds.add(R.drawable.drba_mf087244);
                imageIds.add(R.drawable.drba_mf090187);
                imageIds.add(R.drawable.drba_mf090890);
                imageIds.add(R.drawable.drba_mf098819);
                imageIds.add(R.drawable.drba_mf191554);
                imageIds.add(R.drawable.drba_mf600987);
                imageIds.add(R.drawable.drba_mf600988);
                break;
            case "war":
                imageIds.add(R.drawable.akoeln_altstadt_nord_martinstr_29_31_denkmal_konservator_253e95210_600x450xfr);
                imageIds.add(R.drawable.akoeln_altstadt_nord_die_ruine_von_st_alban_denkmal_kirche_konservator_4ad597619_600x450xfr);
                imageIds.add(R.drawable.arba_mf136941);
                imageIds.add(R.drawable.arba_mf136942);
                imageIds.add(R.drawable.arba_mf136943);
                imageIds.add(R.drawable.arba_mf630495);
                imageIds.add(R.drawable.arba_mf630496);
                imageIds.add(R.drawable.arba_mfl000454_16a);
                imageIds.add(R.drawable.arba_mfl000454_36a);
                imageIds.add(R.drawable.arba_mfl003314_07);
                imageIds.add(R.drawable.arba_mfl003314_355);
                imageIds.add(R.drawable.arba_mfl003314_1354);
                imageIds.add(R.drawable.arba_mfl003314_1356);
                imageIds.add(R.drawable.arba_mfl003314_1358);
                imageIds.add(R.drawable.arba_mfl003314_1359);
                imageIds.add(R.drawable.arba_mfl003314_1457);
                imageIds.add(R.drawable.arba_mfl003314_1458);
                imageIds.add(R.drawable.arba_mfl003314_1463);
                imageIds.add(R.drawable.arba_mfl003314_1464);
                break;
            case "after":
                imageIds.add(R.drawable.crba_100284);
                imageIds.add(R.drawable.crba_115946);
                imageIds.add(R.drawable.crba_mf074054);
                imageIds.add(R.drawable.crba_mf091406);
                imageIds.add(R.drawable.crba_mf091407);
                imageIds.add(R.drawable.crba_mf091408);
                imageIds.add(R.drawable.crba_mf074054);
                imageIds.add(R.drawable.crba_mf100284);
                imageIds.add(R.drawable.crba_mf100285);
                imageIds.add(R.drawable.crba_mf100286);
                imageIds.add(R.drawable.crba_mf100287);
                imageIds.add(R.drawable.crba_mf104470);
                imageIds.add(R.drawable.crba_mf115946);
                imageIds.add(R.drawable.crba_mf115947);
                imageIds.add(R.drawable.crba_mf115948);
                imageIds.add(R.drawable.crba_mf115949);
                imageIds.add(R.drawable.crba_mf115950);
                imageIds.add(R.drawable.crba_mf133730);
                imageIds.add(R.drawable.crba_mf133732);
                imageIds.add(R.drawable.crba_mf133733);
                imageIds.add(R.drawable.crba_mf133734);
                imageIds.add(R.drawable.crba_mf137461);
                imageIds.add(R.drawable.crba_mf631161);
                imageIds.add(R.drawable.crba_mf631163);
                imageIds.add(R.drawable.crba_mf631176);
                imageIds.add(R.drawable.crba_mf631177);
                imageIds.add(R.drawable.crba_mf631589);
                imageIds.add(R.drawable.crba_mf631611);
                imageIds.add(R.drawable.crba_mf631613);
                imageIds.add(R.drawable.crba_mf631614);
                imageIds.add(R.drawable.crba_mf631615);
                imageIds.add(R.drawable.crba_mf631616);
                imageIds.add(R.drawable.crba_mf631617);
                imageIds.add(R.drawable.crba_mfl000214_43);
                imageIds.add(R.drawable.crba_mfl000214_44);
                imageIds.add(R.drawable.crba_mfl000453_37);
                imageIds.add(R.drawable.crba_mfl000453_39);
                imageIds.add(R.drawable.crba_mfl000453_40);
                imageIds.add(R.drawable.crba_mfl000453_41);
                imageIds.add(R.drawable.crba_mfl000454_38a);
                imageIds.add(R.drawable.crba_mfl007513_02);
                imageIds.add(R.drawable.crba_mfl007513_03);
                break;
            case "art":
                imageIds.add(R.drawable.brba_d048792_kleiner);
                imageIds.add(R.drawable.brba_d048793_kleiner);
                imageIds.add(R.drawable.brba_d048794_kleiner);
                imageIds.add(R.drawable.brba_d048795_kleiner);
                imageIds.add(R.drawable.brba_d048796_kleiner);
                imageIds.add(R.drawable.brba_d048797_kleiner);
                break;
            default:
                Log.e(null, "No Images found.");
                break;
        }

        return imageIds;
    }

    /**
     * Method to change information of shown images in sub-gallery.
     *
     * @param button means the selected sub-gallery
     * @return list with titles for images
     */
    public ArrayList<String> changeImagesTitles(String button) {
        ArrayList<String> imageTitles = new ArrayList<>();

        // use parameter to select images
        switch (button) {
            case "before":
                imageTitles.add("Grundriss der Kirche");
                imageTitles.add("Dekorative Decke des Hauptraumes");
                imageTitles.add("Einblick in die Kirche");
                imageTitles.add("Einblick in die Kirche");
                imageTitles.add("Grundriss des Geländes");
                imageTitles.add("Ein Blick über die Dächer");
                imageTitles.add("Ein Blick über die Dächer");
                imageTitles.add("Bau der Kirche");
                imageTitles.add("Einblick in die Kirche");
                imageTitles.add("Einblick in die Kirche");
                imageTitles.add("Altar");
                imageTitles.add("Dekorative Decke des Hauptraumes");
                imageTitles.add("Einblick in den Hauptraum");
                imageTitles.add("Ein Blick über die Dächer");
                imageTitles.add("Außenbereich der Kirche");
                imageTitles.add("Einblick in den Hauptraum");
                imageTitles.add("Einblick in den Hauptraum");
                imageTitles.add("Einblick in den Hauptraum");
                break;
            case "war":
                imageTitles.add("Ruine aus Sicht der Martinstr.");
                imageTitles.add("Ruine von St. Alban");
                imageTitles.add("Außenmauern der Ruine");
                imageTitles.add("Zerstörte Außenmauern der Kirche");
                imageTitles.add("Zerstörte Außenmauern der Kirche");
                imageTitles.add("Ruine von St. Alban");
                imageTitles.add("Ruine von St. Alban mit dem Gürzenich");
                imageTitles.add("Ruine von St. Alban");
                imageTitles.add("Ein Blick über die Dächer");
                imageTitles.add("Zerstörter Innenbereich");
                imageTitles.add("Zerstörter Hauptraum");
                imageTitles.add("Ein Blick über die Dächer");
                imageTitles.add("Zerstörtes Dach");
                imageTitles.add("Zerstörtes Dach");
                imageTitles.add("Zerstörtes Dach");
                imageTitles.add("Zerstörte Mauern");
                imageTitles.add("Zerstörte Mauern");
                imageTitles.add("Zerstörte Mauern");
                imageTitles.add("Zerstörte Mauern");
                break;
            case "after":
                imageTitles.add("Instandgesetzte Außenmauern");
                imageTitles.add("Altar");
                imageTitles.add("Gebetsbänke");
                imageTitles.add("Außenansicht der Kirchenüberreste");
                imageTitles.add("Außenansicht der Kirchenüberreste");
                imageTitles.add("Außenansicht der Kirchenüberreste");
                imageTitles.add("Gebetsbänke");
                imageTitles.add("Außenansicht der Kirchenüberreste");
                imageTitles.add("Blick in den Kirchenhof");
                imageTitles.add("Blick in den Kirchenhof");
                imageTitles.add("Kirchenhof");
                imageTitles.add("Blick aus dem Gürzenich");
                imageTitles.add("Altar");
                imageTitles.add("Gebetsbänke");
                imageTitles.add("Heiligenstatue");
                imageTitles.add("Rundbogen mit Tür");
                imageTitles.add("Künstlerische Elemente des Rundbogens");
                imageTitles.add("Kirchenhof");
                imageTitles.add("Wiederaufbau Kirchenhof");
                imageTitles.add("Kirchenhof");
                imageTitles.add("Wiederaufbau Kirchenhof");
                imageTitles.add("Blick über die Dächer");
                imageTitles.add("Kirche mit Gürzenich");
                imageTitles.add("Kirche mit Gürzenich");
                imageTitles.add("Kirche mit Gürzenich");
                imageTitles.add("Kirche mit Gürzenich");
                imageTitles.add("Verbindung zwischen Kirche und Gürzenich");
                imageTitles.add("Zerstörte Mauern Gürzenich");
                imageTitles.add("Zerstörte Mauern Gürzenich");
                imageTitles.add("Wiederaufbau");
                imageTitles.add("Zerstörte Innenräume");
                imageTitles.add("Zerstörte Innenräume");
                imageTitles.add("Zerstörte Innenräume");
                imageTitles.add("Außenansicht der Kirchenüberreste");
                imageTitles.add("Außenansicht der Kirchenüberreste");
                imageTitles.add("Kirchenhof");
                imageTitles.add("Blick zum Gürzenich aus dem Hof");
                imageTitles.add("Blick zum Gürzenich aus dem Hof");
                imageTitles.add("Blick nach oben");
                imageTitles.add("Wiederaufbau");
                imageTitles.add("Säule des Daches");
                imageTitles.add("Säule des Daches");
                break;
            case "art":
                imageTitles.add("Grundriss der Kirche");
                imageTitles.add("Äußere Ansicht Süd-West-Seite");
                imageTitles.add("Orgelaltar");
                imageTitles.add("Seitenflügel");
                imageTitles.add("Rundbogen");
                imageTitles.add("Mittelraum");
                break;
            default:
                Log.e(null, "No Images found.");
                break;
        }

        return imageTitles;
    }

    /**
     * Method to show dialog box when click on image
     *
     * @param item_pos position of image
     */
    public void showDialogBox(int item_pos) {

        // instantiate Dialog object and set layout
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.sta_custom_dialog);

        // getting custom dialog views
        TextView imageName = dialog.findViewById(R.id.txt_image_name);
        ImageView image = dialog.findViewById(R.id.img);
        Button btnFull = dialog.findViewById(R.id.btn_full);
        Button btnClose = dialog.findViewById(R.id.btn_close);

        // set title
        String title = getImageTitle(item_pos);

        imageName.setText(title);
        image.setImageResource(item_pos);

        // set onclick-event to button
        // close dialog box
        btnClose.setOnClickListener(v -> dialog.dismiss());

        // set onclick-event to button
        // open full screen
        btnFull.setOnClickListener(v -> {
            Intent i = new Intent(StaGalleryActivityView.this, StaFullView.class);
            // provides information about image
            i.putExtra("img_id", item_pos);
            // start full view
            startActivity(i);
        });

        // shows dialog
        dialog.show();
    }

    /**
     * Method to change title of sub-galleries.
     *
     * @param button means the selected sub-gallery
     * @return title for sub-gallery
     */
    public String changeGalleryTitle(String button) {
        String title = null;

        // use parameter to select images
        switch (button) {
            case "before":
                title = "St. Alban vor dem Krieg";
                break;
            case "war":
                title = "Kriegsjahre";
                break;
            case "after":
                title = "St. Alban nach dem Krieg";
                break;
            case "art":
                title = "St. Alban in der Kunst";
                break;
            default:
                Log.e(null, "No Images found.");
                break;
        }

        return title;
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
            // back button
            case R.id.backButton:
                startActivity(new Intent(this, StaMenuActivityMain.class));
                return true;
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

    /**
     * Method to get title for selected image.
     *
     * @param id of clicked image
     * @return title of image
     */
    public String getImageTitle(Integer id) {
        // instantiate empty variables
        String title = "";
        Integer index = 0;

        // change list with image ids to array to iterate over it
        Integer[] ids = new Integer[imageIds.size()];
        imageIds.toArray(ids);
        for (int i = 0; i < ids.length; i++) {
            // if id of clicked image is equal with one of the array, the index will be saved
            if (id == ids[i].intValue()) {
                index = i;
            }
        }

        // get the title from list and used selected index
        title = imageTitles.get(index);
        // reset index for next image
        index = 0;

        return title;
    }
}