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

    //List<StaCell> allFilesPaths;

   /* @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull @NotNull String[] permissions, @NonNull @NotNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1000) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                showImages();
            } else {
                Toast.makeText(this, "Permission not granted!", Toast.LENGTH_SHORT).show();
                finish();
            }
        }
    }*/

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



        //for the storage permission
        /*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1000);
        } else {
            //show the images
            showImages();
        }*/
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
                imageIds.add(R.drawable.rba_d016212);
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
                imageTitles.add("Bild17");
                break;
            default:
                Log.e(null, "No Images found.");
                break;
        }

        String[] toReturn = new String[imageTitles.size()];
        imageTitles.toArray(toReturn);

        return toReturn;
    }

    //show images on the screen
    /*private void showImages() {
        //folder with all the images
        String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/pictures/";
        allFilesPaths = new ArrayList<>();
        allFilesPaths = listAllFiles(path);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.gallery_template);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 3);
        recyclerView.setLayoutManager(layoutManager);

        //optimizations
        recyclerView.setItemViewCacheSize(20);
        recyclerView.setDrawingCacheEnabled(true);
        recyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);

        ArrayList<StaCell> cells = new ArrayList<>();
        StaAdapter adapter = new StaAdapter(getApplicationContext(), cells);
        recyclerView.setAdapter(adapter);
    }*/

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

    //load all files from the folder
    /*private List<StaCell> listAllFiles(String pathName) {
        List<StaCell> allFiles = new ArrayList<>();
        File file = new File(pathName);
        File[] files = file.listFiles();
        if (files != null) {
            for (File f : files) {
                StaCell cell = new StaCell();
                cell.setTitle(f.getName());
                cell.setPath(f.getAbsolutePath());
                allFiles.add(cell);
            }
        }
        return allFiles;
    }*/


}


