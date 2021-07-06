package com.example.stalban_app.sta_gallery;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsetsController;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.stalban_app.R;

import java.util.ArrayList;

//use for the list of the images (RecyclerView)
public class StaAdapter extends RecyclerView.Adapter<StaAdapter.ViewHolder> {
    private final ArrayList<StaCell> galleryList;
    private final Context context;
    private String fullScreenInd;
    private Object StaGalleryActivityView;


    public StaAdapter(Context context, ArrayList<StaCell> galleryList) {
        this.galleryList = galleryList;
        this.context = context;
    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public StaAdapter.ViewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sta_gallery_cell, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull StaAdapter.ViewHolder holder, int position) {
        holder.title.setText(galleryList.get(position).getTitle());
        holder.img.setScaleType(ImageView.ScaleType.CENTER_CROP);
        holder.img.setImageResource(galleryList.get(position).getImg());
    }

    @Override
    public int getItemCount() {
        return galleryList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private ImageView img;
        public ViewHolder(View view){
            super(view);

            title = (TextView) view.findViewById(R.id.cellTitle);
            img = (ImageView) view.findViewById(R.id.img_cell);
        }

        public TextView getTitle() {
            return title;
        }

        public ImageView getImg() {
            return img;
        }

        public void changeToFullScreen(Activity a) {
            String fullScreenInd = a.getIntent().getStringExtra("fullScreenIndicator");
            if ("y".equals(fullScreenInd)) {
                a.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                        WindowManager.LayoutParams.FLAG_FULLSCREEN);
                a.getActionBar().hide();

                getImg().getLayoutParams().height = ViewGroup.LayoutParams.MATCH_PARENT;
                getImg().getLayoutParams().width = ViewGroup.LayoutParams.MATCH_PARENT;
                getImg().setAdjustViewBounds(false);
                getImg().setScaleType(ImageView.ScaleType.FIT_XY);

            }
        }
    }





}
