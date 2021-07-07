package com.example.stalban_app.gallery_test;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.stalban_app.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Gallery extends AppCompatActivity {

    ArrayList<Integer> imageIds = new ArrayList<>(Arrays.asList(
            R.drawable.brba_d048792, R.drawable.brba_d048793, R.drawable.brba_d048794,
            R.drawable.brba_d048795, R.drawable.brba_d048796, R.drawable.brba_d048797
    ));

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery_test);

        GridView gridView = findViewById(R.id.galleryGrid);
        gridView.setAdapter(new ImageAdapter(imageIds, this));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int item_pos = imageIds.get(position);

                showDialogBox(item_pos);
            }
        });
    }

    public void showDialogBox(int item_pos){
        Dialog dialog = new Dialog(this);

        dialog.setContentView(R.layout.custom_dialog);

        //Getting custom dialog views
        TextView imageName = dialog.findViewById(R.id.txt_image_name);
        ImageView image = dialog.findViewById(R.id.img);
        Button btnFull = dialog.findViewById(R.id.btn_full);
        Button btnClose = dialog.findViewById(R.id.btn_close);

        String title = getResources().getResourceName(item_pos);

        //extracting name
        int index = title.indexOf("/");
        String name = title.substring(index+1, title.length());
        imageName.setText(name);

        image.setImageResource(item_pos);

        btnClose.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                dialog.dismiss();
            }
        });

        btnFull.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Gallery.this, FullView.class);
                i.putExtra("img_id", item_pos);
                startActivity(i);
            }
        });

        dialog.show();
    }
}
