package com.salman.zach.widgetlikegoogleplay.handlers;

import android.databinding.BaseObservable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by Salman Zach on 3/22/2018.
 */

public class BaseHandler extends BaseObservable {

    private String widgetTitle;

    private String widgetDescription;

    private ImageView bannerImageView;

    private RecyclerView recyclerView;

    private CardView background;

    private View gradientView;

    public String getWidgetTitle() {
        return widgetTitle;
    }

    public void setWidgetTitle(String widgetTitle) {
        this.widgetTitle = widgetTitle;
    }

    public String getWidgetDescription() {
        return widgetDescription;
    }

    public void setWidgetDescription(String widgetDescription) {
        this.widgetDescription = widgetDescription;
    }

    public ImageView getBannerImageView() {
        return bannerImageView;
    }

    public void setBannerImageView(ImageView bannerImageView) {
        this.bannerImageView = bannerImageView;
    }

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    public void setRecyclerView(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
    }

    public CardView getBackground() {
        return background;
    }

    public void setBackground(CardView background) {
        this.background = background;
    }

    public View getGradientView() {
        return gradientView;
    }

    public void setGradientView(View gradientView) {
        this.gradientView = gradientView;
    }
}
