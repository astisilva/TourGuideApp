package com.example.android.tourguideapp;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;


public class TourAdapter extends ArrayAdapter<Tour> {


    /**
     * Resource ID for the background color for this list of places
     */
    private int mColorResourceId;

    /**
     * Create a new {@link TourAdapter} object.
     *
     * @param context         is the current context (i.e. Activity) that the adapter is being created in.
     * @param tours           is the list of {@link Tour}s to be displayed.
     * @param colorResourceId is the resource ID for the background color for this list of places
     */
    public TourAdapter(Context context, ArrayList<Tour> tours, int colorResourceId) {
        super(context, 0, tours);
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Orientation} object located at this position in the list
        Tour currentTour = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID about_text_view.
        TextView aboutTextView = (TextView) listItemView.findViewById(R.id.about_text_view);
        // Get the About from the currentOrientation object and set this text on
        // the About TextView.
        aboutTextView.setText(currentTour.getAboutTour());

        // Find the TextView in the list_item.xml layout with the ID default_text_view.
        TextView placeTextView = (TextView) listItemView.findViewById(R.id.place_text_view);
        // Get the place from the currentOrientation object and set this text on
        // the place TextView.
        placeTextView.setText(currentTour.getPlaceTour());

        // Find the ImageView in the list_item.xml layout with the ID image.
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        // Check if an image is provided for this tour or not
        if (currentTour.hasImage()) {
            // If an image is  available, display the provided image based on the resource ID
            imageView.setImageResource(currentTour.getImageResourceId());
            // Make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            imageView.setVisibility(View.GONE);
        }

        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);
        // Return the whole list item layout (containing 2 TextViews) so that it can be shown in
        // the ListView.
        return listItemView;
    }
}