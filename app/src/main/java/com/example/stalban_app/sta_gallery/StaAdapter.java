package com.example.stalban_app.sta_gallery;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.stalban_app.R;

import java.io.File;
import java.util.ArrayList;

//use for the list of the images (RecyclerView)
public class StaAdapter extends RecyclerView.Adapter<StaAdapter.ViewHolder> {
    private final ArrayList<StaCell> galleryList;
    private final Context context;

    boolean isImageFitToScreen;

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
        holder.img.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(isImageFitToScreen) {
                    isImageFitToScreen=false;
                    holder.img.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                    holder.img.setAdjustViewBounds(true);
                }else{
                    isImageFitToScreen=true;
                    holder.img.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
                    holder.img.setScaleType(ImageView.ScaleType.FIT_XY);
                }
            }
        });

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
    }



}
