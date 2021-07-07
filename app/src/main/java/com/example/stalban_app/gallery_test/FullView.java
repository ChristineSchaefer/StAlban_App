package com.example.stalban_app.gallery_test;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.stalban_app.R;

import java.nio.BufferUnderflowException;

public class FullView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceStates){
        super.onCreate(savedInstanceStates);
        setContentView(R.layout.full_image_view);

        ImageView imageView = findViewById(R.id.img_full);
        int img_id = getIntent().getExtras().getInt("img_id");

        imageView.setImageResource(img_id);
    }
}
