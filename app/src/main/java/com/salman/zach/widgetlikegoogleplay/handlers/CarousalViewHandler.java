package com.salman.zach.widgetlikegoogleplay.handlers;

import android.content.Intent;
import android.databinding.BindingAdapter;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.View;

import com.salman.zach.widgetlikegoogleplay.R;
import com.salman.zach.widgetlikegoogleplay.playWidgets.animationListeners.CarousalAnimatedScrollListener;
import com.salman.zach.widgetlikegoogleplay.screens.ListWidgetActivity;
import com.salman.zach.widgetlikegoogleplay.utility.ItemDecorator;

/**
 * Created by Salman Zach on 3/22/2018.
 */

public class CarousalViewHandler extends BaseHandler {


    @BindingAdapter("horizontalRecycler")
    public static void setRecyclerVew(RecyclerView recyclerVew, CarousalViewHandler handler) {

        CarousalAnimatedScrollListener animatedScrollListener = new CarousalAnimatedScrollListener();
        recyclerVew.addOnScrollListener(animatedScrollListener);

        int itemMargin = (int) (recyclerVew.getResources().getDimensionPixelSize(R.dimen.item_width) * 2.5);
        ItemDecorator decorator = new ItemDecorator(itemMargin, false);
        recyclerVew.addItemDecoration(decorator);

        SnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(recyclerVew);

        LinearLayoutManager linearLayoutManage = new LinearLayoutManager(recyclerVew.getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerVew.setLayoutManager(linearLayoutManage);

        animatedScrollListener.generateBackground(handler.getBannerImageView(), handler.getBackground(), handler.getGradientView());
    }

    public void openMore(View v) {
        ((AppCompatActivity) v.getContext()).startActivity(new Intent(v.getContext(), ListWidgetActivity.class));

    }
}

