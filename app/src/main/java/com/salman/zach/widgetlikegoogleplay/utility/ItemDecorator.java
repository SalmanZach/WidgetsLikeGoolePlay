package com.salman.zach.widgetlikegoogleplay.utility;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by salman on 12/3/18.
 */

public class ItemDecorator extends RecyclerView.ItemDecoration {
    private int mBottomOffset;
    private boolean isVertical;

    public ItemDecorator(int mBottomOffset, boolean isVertical) {
        this.mBottomOffset = mBottomOffset;
        this.isVertical = isVertical;
    }


    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        int dataSize = state.getItemCount();
        int position = parent.getChildAdapterPosition(view);
        if (dataSize > 0 && position == 0) {
            if (isVertical) {
                outRect.set(0, mBottomOffset, 0, 0);
            } else {
                outRect.set(mBottomOffset, 0, 0, 0);
            }
        } else {
            outRect.set(0, 0, 0, 0);
        }
    }
}
