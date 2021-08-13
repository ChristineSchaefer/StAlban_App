package com.example.stalban_app.sta_gallery;

// imports

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.List;

/**
 * @author ChristineSchaefer
 *
 * Helperclass to fill GridView of gallery-views.
 */
public class StaImageAdapter extends BaseAdapter {

    // instantiation of globally usable lists with image  ids and context
    private final List<Integer> mThumIds;
    private final Context mContext;

    /**
     * Constructor to set image ids and context.
     *
     * @param mThumbIds image ids
     * @param mContext context of the executable activity
     */
    public StaImageAdapter(List<Integer> mThumbIds, Context mContext){
        this.mContext = mContext;
        this.mThumIds = mThumbIds;
    }

    // getter
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

        // if ImageView doesn't exist, create new one
        if(imageView == null){
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(350, 450));
            imageView.setScaleType((ImageView.ScaleType.CENTER_CROP));
        }

        // set image ids as resources for ImageView
        imageView.setImageResource(mThumIds.get(position));

        return imageView;
    }
}
