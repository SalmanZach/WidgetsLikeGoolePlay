package com.salman.zach.widgetlikegoogleplay.playWidgets.widgets;

import android.content.Context;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

import com.salman.zach.widgetlikegoogleplay.R;
import com.salman.zach.widgetlikegoogleplay.baseWidgets.BaseRecyclerView;
import com.salman.zach.widgetlikegoogleplay.databinding.WidgetPlayInfiniteListBinding;
import com.salman.zach.widgetlikegoogleplay.handlers.InfiniteListViewHandler;
import com.salman.zach.widgetlikegoogleplay.playWidgets.IInfiniteLoadingListener;
import com.salman.zach.widgetlikegoogleplay.playWidgets.animationListeners.InfiniteAnimatedScrollListener;
import com.salman.zach.widgetlikegoogleplay.utility.ItemDecorator;


/**
 * Created by Salman Zach on 3/22/2018.
 */

public class PlayListingWidget extends BaseRecyclerView {

    private WidgetPlayInfiniteListBinding mBinding;

    private InfiniteListViewHandler viewHandler;

    public PlayListingWidget(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void setLoading(boolean loading) {
        viewHandler.setLoading(loading);
    }


    @Override
    protected RecyclerView getRecyclerView() {
        LinearLayoutManager linearLayoutManage = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        mBinding.recyclerView.setLayoutManager(linearLayoutManage);
        ItemDecorator decorator = new ItemDecorator((getResources().getDisplayMetrics().widthPixels / 2), true);
        mBinding.recyclerView.addItemDecoration(decorator);

        InfiniteAnimatedScrollListener animatedScrollListener;
        mBinding.recyclerView.addOnScrollListener(animatedScrollListener = new InfiniteAnimatedScrollListener(linearLayoutManage, 1) {
            @Override
            public boolean onLoadMore(int page, int totalItemsCount) {
                if (viewHandler.getLoadingListener() != null) {
                    viewHandler.getLoadingListener().onLoadMore(page, totalItemsCount);
                    viewHandler.setLoading(true);
                }
                return true;
            }

        });
        animatedScrollListener.animateTitle(mBinding.textViewHeading, mBinding.textViewDes);
        animatedScrollListener.generateBackground(mBinding.backgroundImage, mBinding.background,
                mBinding.gradientView, mBinding.count);
        return mBinding.recyclerView;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.widget_play_infinite_list;
    }

    @Override
    protected void initViews(ViewDataBinding v) {
        mBinding = (WidgetPlayInfiniteListBinding) v;

        viewHandler = new InfiniteListViewHandler();
        viewHandler.setBackground(mBinding.background);
        viewHandler.setBannerImageView(mBinding.backgroundImage);
        viewHandler.setGradientView(mBinding.gradientView);
        viewHandler.setTitleView(mBinding.textViewHeading);
        viewHandler.setDescriptionView(mBinding.textViewDes);
        viewHandler.setRecyclerView(mBinding.recyclerView);
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

    public void setLoadingListener(IInfiniteLoadingListener loadingListener) {
        viewHandler.setLoadingListener(loadingListener);
    }
}
