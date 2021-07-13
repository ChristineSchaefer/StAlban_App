package com.example.stalban_app.sta_gallery;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.List;

public class StaImageAdapter extends BaseAdapter {

    private final List<Integer> mThumIds;
    private final Context mContext;

    public StaImageAdapter(List<Integer> mThumbIds, Context mContext){
        this.mContext = mContext;
        this.mThumIds = mThumbIds;
    }

    @Override
    public int getCount() {
        return mThumIds.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return mThumIds.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = (ImageView) convertView;

        if(imageView == null){
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(350, 450));
            imageView.setScaleType((ImageView.ScaleType.CENTER_CROP));
        }

        imageView.setImageResource(mThumIds.get(position));

        return imageView;
    }
}
