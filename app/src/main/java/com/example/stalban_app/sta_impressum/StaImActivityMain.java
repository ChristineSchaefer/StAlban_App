package com.example.stalban_app.sta_impressum;

// imports

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.stalban_app.R;
import com.example.stalban_app.sta_gallery.StaGalleryActivityMain;
import com.example.stalban_app.sta_gallery.StaGalleryActivityView;
import com.example.stalban_app.sta_menu.StaMenuActivityMain;
import com.example.stalban_app.sta_timeline.StaTimelineActivityMain;
import com.example.stalban_app.sta_tour.StaTourActivityMain;

/**
 * @author ChristineSchaefer
 * <p>
 * Activity to set the functionality and the content of the impressum.
 */
public class StaImActivityMain extends AppCompatActivity {

    /**
     * Method for loading the layout and setting the functionality.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        // basic overwrite-part for setting layout
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sta_imp);

        // instantiate the Toolbar above the content
        // contains a menu for navigation
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // add up button
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        // sets content of impressum
        TextView development = findViewById(R.id.entwicklerinnen);
        development.setText(Html.fromHtml(getString(R.string.impressum_entwicklung)));

        TextView description = findViewById(R.id.projektbeschreibung);
        description.setText(Html.fromHtml(getString(R.string.impressum_projektbeschreibung)));

        TextView actuality = findViewById(R.id.aktualität);
        actuality.setText(Html.fromHtml(getString(R.string.impressum_aktualität)));

        TextView information = findViewById(R.id.informationen);
        information.setText(Html.fromHtml(getString(R.string.impressum_informationen)));

        // link to github repository
        ImageView github = findViewById(R.id.github_repository);
        github.setImageResource(R.drawable.github);
        github.setOnClickListener(v -> {
            Uri uri = Uri.parse("https://github.com/ChristineSchaefer/StAlban_App");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        });
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