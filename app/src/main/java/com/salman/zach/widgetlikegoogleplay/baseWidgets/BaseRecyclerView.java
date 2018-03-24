package com.salman.zach.widgetlikegoogleplay.baseWidgets;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.salman.zach.widgetlikegoogleplay.BR;

import java.util.List;

/**
 * Created by Salman Zach on 3/22/2018.
 */

public abstract class BaseRecyclerView<T extends ViewModel> extends BaseRenderer {


    private BindableAdapter adapter;

    public BaseRecyclerView(Context context) {
        super(context);
    }

    public BaseRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BaseRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    public BaseRecyclerView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    public void buildWidget(List<T> list) {
        setLoading(false);
        if (adapter == null) {
            adapter = new BindableAdapter(list);
            getRecyclerView().setAdapter(adapter);
        } else {
            adapter.notifyDataSetChanged();
        }
    }


    /*
   * need to know recycler view is loading
   * @
   */
    protected abstract void setLoading(boolean loading);

    /*
   * bind recycler view at runtime
   * @
   */
    protected abstract RecyclerView getRecyclerView();

    protected static class BindingViewHolder<V extends ViewDataBinding> extends RecyclerView.ViewHolder {

        private V itemView;

        public BindingViewHolder(V itemView) {
            super(itemView.getRoot());
            this.itemView = itemView;
        }

        public V getBinding() {
            return itemView;
        }
    }

    protected class BindableAdapter extends RecyclerView.Adapter<BindingViewHolder> {
        private List<T> list;

        public BindableAdapter(List<T> list) {
            this.list = list;
        }


        @Override
        public BaseRecyclerView.BindingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            ViewDataBinding binding = DataBindingUtil.bind(inflater.inflate(viewType, parent, false));
            return new BindingViewHolder<>(binding);

        }

        @Override
        public void onBindViewHolder(BaseRecyclerView.BindingViewHolder bindingViewHolder, int position) {
            final T model = list.get(position);
            bindingViewHolder.getBinding().setVariable(BR.model, model);
            bindingViewHolder.getBinding().executePendingBindings();
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        @Override
        public int getItemViewType(int position) {
            return list.get(position).getLayoutId();
        }

    }

}
