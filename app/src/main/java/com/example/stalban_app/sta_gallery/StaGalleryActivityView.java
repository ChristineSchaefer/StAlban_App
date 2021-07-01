package com.example.stalban_app.sta_gallery;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.stalban_app.R;

import java.util.ArrayList;
import java.util.List;

public class StaGalleryActivityView extends AppCompatActivity {

    private String button;
    private String image_titles[];
    private Integer image_ids[];

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sta_gallery_view);

        button = getIntent().getStringExtra("button");
        image_titles = changeImagesTitles(button);
        image_ids = changeButtonImages(button);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.gallery_template);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 3);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<StaCell> cells = prepareDate();
        StaAdapter adapter = new StaAdapter(getApplicationContext(), cells);
        recyclerView.setAdapter(adapter);

    }

    static Integer[] changeButtonImages(String button) {
        List<Integer> imageIds = new ArrayList<>();

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
                imageIds.add(R.drawable.brba_d048792);
                imageIds.add(R.drawable.brba_d048793);
                imageIds.add(R.drawable.brba_d048794);
                imageIds.add(R.drawable.brba_d048795);
                imageIds.add(R.drawable.brba_d048796);
                imageIds.add(R.drawable.brba_d048797);
                break;
            default:
                Log.e(null, "No Images found.");
                break;
        }

        Integer[] toReturn = new Integer[imageIds.size()];
        imageIds.toArray(toReturn);

        return toReturn;
    }

    static String[] changeImagesTitles(String button) {
        List<String> imageTitles = new ArrayList<>();

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

        String[] toReturn = new String[imageTitles.size()];
        imageTitles.toArray(toReturn);

        return toReturn;
    }

    //prepare the images for the list
    private ArrayList<StaCell> prepareDate() {
        ArrayList<StaCell> allImages = new ArrayList<>();
        /*for (StaCell c : allFilesPaths) {
            StaCell cell = new StaCell();
            cell.setTitle(c.getTitle());
            cell.setPath(c.getPath());
            allImages.add(cell);
        }*/
        for (int i = 0; i < image_titles.length; i++) {
            StaCell cell = new StaCell();
            cell.setTitle(image_titles[i]);
            cell.setImg(image_ids[i]);
            allImages.add(cell);
        }
        return allImages;
    }

}


