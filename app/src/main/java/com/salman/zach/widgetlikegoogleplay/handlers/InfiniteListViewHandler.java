package com.salman.zach.widgetlikegoogleplay.handlers;

import android.widget.TextView;

import com.salman.zach.widgetlikegoogleplay.playWidgets.IInfiniteLoadingListener;

/**
 * Created by Salman Zach on 3/22/2018.
 */

public class InfiniteListViewHandler extends BaseHandler {

    private TextView titleView;

    private TextView descriptionView;

    private boolean isLoading;

    private IInfiniteLoadingListener loadingListener;

    public TextView getTitleView() {
        return titleView;
    }

    public void setTitleView(TextView titleView) {
        this.titleView = titleView;
        notifyChange();
    }

    public TextView getDescriptionView() {
        return descriptionView;
    }

    public void setDescriptionView(TextView descriptionView) {
        this.descriptionView = descriptionView;
        notifyChange();
    }

    public boolean isLoading() {
        return isLoading;
    }

    public void setLoading(boolean loading) {
        this.isLoading = loading;
        notifyChange();

    }

    public IInfiniteLoadingListener getLoadingListener() {
        return loadingListener;
    }

    public void setLoadingListener(IInfiniteLoadingListener loadingListener) {
        this.loadingListener = loadingListener;
        notifyChange();

    }
}
