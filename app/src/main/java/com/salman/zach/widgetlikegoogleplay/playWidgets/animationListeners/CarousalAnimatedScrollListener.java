package com.salman.zach.widgetlikegoogleplay.playWidgets.animationListeners;

import android.graphics.drawable.BitmapDrawable;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.salman.zach.widgetlikegoogleplay.utility.ColorUtils;

/**
 * Created by Salman Zach on 3/22/2018.
 */

public class CarousalAnimatedScrollListener extends RecyclerView.OnScrollListener {
    private static final float BACKGROUND_MIN_DIM = 0.9f;
    private static final int BACKGROUND_SCROLL_RATE = 12;
    private int baseColor;
    private int scrollOffset;
    private View gradientView;
    private ImageView backgroundImage;

    public void generateBackground(ImageView backgroundImage, final CardView parent, final View gradientView) {
        this.backgroundImage = backgroundImage;
        this.gradientView = gradientView;

        BitmapDrawable drawable = (BitmapDrawable) backgroundImage.getDrawable();
        Palette.from(drawable.getBitmap()).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
                parent.setCardBackgroundColor(palette.getDarkMutedSwatch().getRgb());
                baseColor = palette.getDarkMutedSwatch().getRgb();
                gradientView.setBackground(ColorUtils.getHorizontalGradient(palette.getDarkMutedSwatch().getRgb()));
            }
        });

    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        scrollOffset = scrollOffset + dx;
        applyAnimationOnRecyclerView(recyclerView, backgroundImage);
    }

    private void applyAnimationOnRecyclerView(RecyclerView recyclerView, ImageView backgroundImage) {
        /*
        * calculate alpha according base color
        * */
        float alpha = Math.min(BACKGROUND_MIN_DIM, (float) scrollOffset / recyclerView.getWidth());

        int a = Math.min(255, Math.max(0, (int) (alpha * 255))) << 24;

        int rgb = 0x00ffffff & baseColor;

        //setup alpha for background image
        backgroundImage.setColorFilter(a + rgb);

        //setup translate x for background image
        if (scrollOffset < recyclerView.getWidth()) {
            backgroundImage.setTranslationX(-scrollOffset / BACKGROUND_SCROLL_RATE);
            gradientView.setTranslationX(-scrollOffset / BACKGROUND_SCROLL_RATE);

        }
    }


}
