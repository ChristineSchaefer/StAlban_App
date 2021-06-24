package com.example.stalban_app.sta_gallery;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.stalban_app.R;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class StaGalleryActivityView extends AppCompatActivity {

    private final String image_titles[] = {
            "Img1",
            "Img2"
    };
    private final Integer image_ids[] = {
            R.drawable.rba_mf043215,
            R.drawable.rba_mf137461
    };
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
        for(int i = 0; i < image_titles.length; i++){
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


