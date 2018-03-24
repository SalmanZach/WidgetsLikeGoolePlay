package com.salman.zach.widgetlikegoogleplay.utility;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;

/**
 * Created by Zach on 3/24/2018.
 */

public class ColorUtils {

    public static GradientDrawable getHorizontalGradient(int darkColor) {

        GradientDrawable gradient = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT,
                new int[]{Color.TRANSPARENT, darkColor});
        gradient.setShape(GradientDrawable.RECTANGLE);
        return gradient;
    }

    public static GradientDrawable getVerticalGradient(int darkColor) {

        GradientDrawable gradient = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM,
                new int[]{Color.TRANSPARENT, darkColor});
        gradient.setShape(GradientDrawable.RECTANGLE);
        //        gradient.setCornerRadius(10.f);
        return gradient;
    }
}
