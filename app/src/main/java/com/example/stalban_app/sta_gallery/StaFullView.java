package com.example.stalban_app.sta_gallery;

// imports

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.stalban_app.R;

/**
 * @author ChristineSchaefer
 * <p>
 * Activity to enable viewing the images in full screen.
 */
public class StaFullView extends AppCompatActivity {

    @Override
    /**
     * Method for loading the layout and setting the functionality.
     *
     */
    protected void onCreate(Bundle savedInstanceStates) {
        // basic overwrite-part for setting layout
        super.onCreate(savedInstanceStates);
        setContentView(R.layout.sta_full_image_view);

        // sets the ImageView for full screen
        ImageView imageView = findViewById(R.id.img_full);
        // returns the image that is actually clicked for full screen
        int img_id = getIntent().getExtras().getInt("img_id");

        // sets the actually clicked image als resource for the ImageView
        imageView.setImageResource(img_id);
    }
}
