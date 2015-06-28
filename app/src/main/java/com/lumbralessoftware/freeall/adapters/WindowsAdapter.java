package com.lumbralessoftware.freeall.adapters;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;
import com.lumbralessoftware.freeall.R;
import com.lumbralessoftware.freeall.views.CircleTransform;
import com.squareup.picasso.Picasso;

/**
 * Created by javiergonzalezcabezas on 28/6/15.
 */
public class WindowsAdapter implements GoogleMap.InfoWindowAdapter {

    private final View mContentsView;
    private Activity mActivity;

    public WindowsAdapter(Activity activity) {
        mContentsView = activity.getLayoutInflater().inflate(R.layout.row_marker, null);
        mActivity = activity;
    }

    static class ViewHolder {
        public TextView mName;
        public TextView mCategory;
        public View mImage;
    }

    @Override
    public View getInfoContents(Marker marker) {


        // configure view holder
        TextView name = (TextView) mContentsView.findViewById(R.id.row_marker_name);
        TextView category = (TextView) mContentsView.findViewById(R.id.row_marker_category);
        ImageView image = (ImageView) mContentsView.findViewById(R.id.row_marker_icon);

        name.setText(marker.getTitle());
        category.setText(marker.getTitle());
        Picasso.with(mActivity).load(marker.getSnippet()).transform(new CircleTransform()).into((ImageView) image);

        return mContentsView;
    }

    @Override
    public View getInfoWindow(Marker marker) {
        return null;
    }

}
