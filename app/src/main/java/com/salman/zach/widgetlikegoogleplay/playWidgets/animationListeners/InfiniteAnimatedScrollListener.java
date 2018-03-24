package com.salman.zach.widgetlikegoogleplay.playWidgets.animationListeners;

/**
 * Created by Salman Zach on 3/22/2018.
 */

import android.graphics.drawable.BitmapDrawable;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.salman.zach.widgetlikegoogleplay.utility.ColorUtils;

public abstract class InfiniteAnimatedScrollListener extends RecyclerView.OnScrollListener {
    private static final float BACKGROUND_MIN_DIM = 0.9f;
    private static final int BACKGROUND_SCROLL_RATE = 12;

    // The minimum number of items to have below your current scroll position
    // before loading more.
    private int visibleThreshold = 5;
    // The current offset index of data you have loaded
    private int currentPage = 0;
    // The total number of items in the dataset after the last load
    private int previousTotalItemCount = 0;
    // True if we are still waiting for the last set of data to load.
    private boolean loading = true;
    // Sets the starting page index
    private int startingPageIndex = 0;

    private LinearLayoutManager mLinearLayoutManager;
    private TextView tvTitle;
    private TextView tvDescription;
    private int baseColor;
    private int scrollOffset;
    private View gradientView;
    private ImageView backgroundImage;
    private TextView tvCount;

    public InfiniteAnimatedScrollListener(LinearLayoutManager linearLayoutManager, int currentPage) {
        this.mLinearLayoutManager = linearLayoutManager;
        this.currentPage = currentPage;
    }

    public void generateBackground(ImageView backgroundImage, final CardView parent, final View gradientView, TextView tvCount) {
        this.backgroundImage = backgroundImage;
        this.gradientView = gradientView;
        this.tvCount = tvCount;
        BitmapDrawable drawable = (BitmapDrawable) backgroundImage.getDrawable();
        Palette.from(drawable.getBitmap()).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
                parent.setCardBackgroundColor(palette.getDarkMutedSwatch().getRgb());
                baseColor = palette.getDarkMutedSwatch().getRgb();
                gradientView.setBackground(ColorUtils.getVerticalGradient(palette.getDarkMutedSwatch().getRgb()));
            }
        });
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);

        scrollOffset = scrollOffset + dy;
        applyAnimationOnRecyclerView(recyclerView, backgroundImage);

        int totalItemCount = recyclerView.getLayoutManager().getItemCount();

        if (totalItemCount < previousTotalItemCount) {
            this.currentPage = this.startingPageIndex;
            this.previousTotalItemCount = totalItemCount;
            if (totalItemCount == 0) {
                this.loading = true;
            }
        }


        if (loading && (totalItemCount > previousTotalItemCount)) {
            loading = false;
            previousTotalItemCount = totalItemCount;
            currentPage++;
        }


        int lastVisibleItem = mLinearLayoutManager.findLastVisibleItemPosition();
        if (!loading && totalItemCount <= (lastVisibleItem + visibleThreshold)) {
            loading = onLoadMore(currentPage + 1, totalItemCount);
        }

        tvCount.setText(String.valueOf(mLinearLayoutManager.findLastCompletelyVisibleItemPosition()) + " Items");
    }

    @Override
    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        super.onScrollStateChanged(recyclerView, newState);
        showCount(newState == RecyclerView.SCROLL_STATE_IDLE && mLinearLayoutManager.findLastCompletelyVisibleItemPosition() > 10);

    }

    public void animateTitle(TextView tvTitle, TextView tvDescription) {
        this.tvTitle = tvTitle;
        this.tvDescription = tvDescription;
    }


    public abstract boolean onLoadMore(int page, int totalItemsCount);


    private void applyAnimationOnRecyclerView(RecyclerView recyclerView, ImageView backgroundImage) {

        /*
        * calculate alpha according base color
        * */
        float alpha = Math.min(BACKGROUND_MIN_DIM, (float) scrollOffset / recyclerView.getWidth());

        int a = Math.min(255, Math.max(0, (int) (alpha * 255))) << 24;

        int rgb = 0x00ffffff & baseColor;

        //setup alpha for background image
        backgroundImage.setColorFilter(a + rgb);

        //setup translate Y for background image
        if (scrollOffset < recyclerView.getWidth()) {
            backgroundImage.setTranslationY(-scrollOffset / BACKGROUND_SCROLL_RATE);
            gradientView.setTranslationY(-scrollOffset / BACKGROUND_SCROLL_RATE);

            if (tvTitle != null && tvDescription != null) {
                tvTitle.setTranslationY(-scrollOffset / (BACKGROUND_SCROLL_RATE / 4) * 2);
                tvDescription.setTranslationY(-scrollOffset / (BACKGROUND_SCROLL_RATE / 3) * 2);
            }
        }
    }


    public void showCount(boolean isShowTopUp) {
        Animation scaleAnimation = null;
        if (isShowTopUp) {
            if (tvCount.getVisibility() == View.GONE) {
                tvCount.setVisibility(View.VISIBLE);
                scaleAnimation = new ScaleAnimation(0, 1, 0, 1, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                scaleAnimation.setDuration(300);
                scaleAnimation.setInterpolator(new DecelerateInterpolator());
                tvCount.startAnimation(scaleAnimation);
            }
        } else {
            if (tvCount.getVisibility() == View.VISIBLE) {
                scaleAnimation = new ScaleAnimation(1, 0, 1, 0, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                scaleAnimation.setDuration(300);
                scaleAnimation.setInterpolator(new DecelerateInterpolator());
                tvCount.startAnimation(scaleAnimation);
                tvCount.setVisibility(View.GONE);
            }
        }
    }

}

