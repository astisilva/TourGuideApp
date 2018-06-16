
/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
+ * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package com.example.android.tourguideapp;

/**
 * {@link Tour} represents a Place that the user wants to kow more about.
 * It contains an about the place.
 */
public class Tour {

    /** Name of the place */
    private String mPlaceTour;

    /** bout the Place  */
    private String mAboutTour;

    /** Image resource ID of the place */
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    /** Constant value that represents no image was provided for this placed */
    private static final int NO_IMAGE_PROVIDED = -1;




    /**
     * Create a new Place object.
     *
     * @param placeTour is the place
     * @param aboutTour about the place
     * @param imageResourceId is the drawable resource ID for the image associated with the place
     */
    public Tour(String placeTour, String aboutTour, int imageResourceId) {
        mPlaceTour = placeTour;
        mAboutTour = aboutTour;
        mImageResourceId = imageResourceId;
        }


    /**
     * Get the place.
     */
    public String getPlaceTour() { return mPlaceTour; }

    /**
     * Get about the place.
     */
    public String getAboutTour() { return mAboutTour;}

    /**
     * Return the image resource ID of the place.
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    /**
     * Returns whether or not there is an image for the place.
     */
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }


}
