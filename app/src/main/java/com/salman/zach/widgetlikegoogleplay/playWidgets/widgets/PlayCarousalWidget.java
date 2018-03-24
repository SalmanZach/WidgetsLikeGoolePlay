package com.salman.zach.widgetlikegoogleplay.playWidgets.widgets;

import android.content.Context;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

import com.salman.zach.widgetlikegoogleplay.R;
import com.salman.zach.widgetlikegoogleplay.baseWidgets.BaseRecyclerView;
import com.salman.zach.widgetlikegoogleplay.databinding.WidgetPlayCarousalBinding;
import com.salman.zach.widgetlikegoogleplay.handlers.CarousalViewHandler;


/**
 * Created by Salman Zach on 3/22/2018.
 */

public class PlayCarousalWidget extends BaseRecyclerView {

    private WidgetPlayCarousalBinding mBinding;

    private CarousalViewHandler viewHandler;


    public PlayCarousalWidget(Context context) {
        super(context);
    }

    public PlayCarousalWidget(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void setLoading(boolean loading) {

    }


    @Override
    protected RecyclerView getRecyclerView() {
        return mBinding.recyclerView;
    }


    @Override
    public int getLayoutId() {
        return R.layout.widget_play_carousal;
    }

    @Override
    protected void initViews(ViewDataBinding v) {
        mBinding = (WidgetPlayCarousalBinding) v;
        viewHandler = new CarousalViewHandler();
        viewHandler.setRecyclerView(mBinding.recyclerView);
        viewHandler.setBannerImageView(mBinding.backgroundImage);
        viewHandler.setBackground(mBinding.background);
        viewHandler.setGradientView(mBinding.gradientView);
        mBinding.setHandler(viewHandler);
    }


    public void setTitle(String title) {
        viewHandler.setWidgetTitle(title);
    }

    public void setDescription(String description) {
        viewHandler.setWidgetDescription(description);
    }


    public void setBannerImage(int resource) {
        viewHandler.getBannerImageView().setImageResource(resource);
    }

}
