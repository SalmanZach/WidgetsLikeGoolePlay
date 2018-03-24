package com.salman.zach.widgetlikegoogleplay.baseWidgets;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

/**
 * Created by Salman Zach on 3/22/2018.
 */

public abstract class BaseRenderer extends LinearLayout {

    protected ViewDataBinding binder;

    public BaseRenderer(Context context) {
        super(context);
        initViews(getBinder());
    }

    public BaseRenderer(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initViews(getBinder());

    }

    public BaseRenderer(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initViews(getBinder());

    }

    public BaseRenderer(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initViews(getBinder());
    }


    private ViewDataBinding getBinder() {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        return DataBindingUtil.inflate(inflater, getLayoutId(), this, true);
    }

    /*
    * method to consume xml layout and bind them
    *
    * */
    protected abstract int getLayoutId();


    /*
    * bind  and return layout
    *
    * */
    protected abstract void initViews(ViewDataBinding v);


}
