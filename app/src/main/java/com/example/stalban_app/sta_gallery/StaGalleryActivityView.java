package com.example.stalban_app.sta_gallery;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.stalban_app.R;


import java.util.ArrayList;
import java.util.Collections;

public class StaGalleryActivityView extends AppCompatActivity {

    private ArrayList<Integer> imageIds = new ArrayList<>(Collections.emptyList());

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sta_gallery_view);

        String button = getIntent().getStringExtra("button");
        ArrayList<String> imageTitles = changeImagesTitles(button);
        imageIds = changeButtonImages(button);

        GridView gridView = findViewById(R.id.galleryGrid);
        gridView.setAdapter(new StaImageAdapter(imageIds, this));

        gridView.setOnItemClickListener((parent, view, position, id) -> {
            int item_pos = imageIds.get(position);

            showDialogBox(item_pos);
        });

    }

    static ArrayList<Integer> changeButtonImages(String button) {
        ArrayList<Integer> imageIds = new ArrayList<>();

        switch (button) {
            case "before":
                imageIds.add(R.drawable.rba_mf043215);
                break;
            case "war":
                imageIds.add(R.drawable.rba_mf137461);
                break;
            case "after":
                imageIds.add(R.drawable.sta_background_gallery_menu);
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

    static ArrayList<String> changeImagesTitles(String button) {
        ArrayList<String> imageTitles = new ArrayList<>();

        switch (button) {
            case "before":
                imageTitles.add("Bild1");
                break;
            case "war":
                imageTitles.add("Bild2");
                break;
            case "after":
                imageTitles.add("3");
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

    public void showDialogBox(int item_pos){
        Dialog dialog = new Dialog(this);

        dialog.setContentView(R.layout.sta_custom_dialog);

        //Getting custom dialog views
        TextView imageName = dialog.findViewById(R.id.txt_image_name);
        ImageView image = dialog.findViewById(R.id.img);
        Button btnFull = dialog.findViewById(R.id.btn_full);
        Button btnClose = dialog.findViewById(R.id.btn_close);

        String title = getResources().getResourceName(item_pos);

        //extracting name
        int index = title.indexOf("/");
        String name = title.substring(index+1);

        imageName.setText(name);

        image.setImageResource(item_pos);

        btnClose.setOnClickListener(v -> dialog.dismiss());

        btnFull.setOnClickListener(v -> {
            Intent i = new Intent(StaGalleryActivityView.this, StaFullView.class);
            i.putExtra("img_id", item_pos);
            startActivity(i);
        });

        dialog.show();
    }

}


