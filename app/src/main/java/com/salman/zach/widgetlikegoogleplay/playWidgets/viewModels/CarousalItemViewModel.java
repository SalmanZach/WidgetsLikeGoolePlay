package com.salman.zach.widgetlikegoogleplay.playWidgets.viewModels;

import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.salman.zach.widgetlikegoogleplay.R;
import com.salman.zach.widgetlikegoogleplay.baseWidgets.ViewModel;

/**
 * Created by Salman Zach on 3/22/2018.
 */

public class CarousalItemViewModel extends BaseObservable implements ViewModel {

    private String title = "";
    private String price = "";
    private float rating;
    private int imageResource;

    @BindingAdapter("bind:image")
    public static void setImage(ImageView image, CarousalItemViewModel model) {
        image.setImageResource(model.getImageResource());

    }

    @Override
    public int getLayoutId() {
        return R.layout.item_play_carousal_widget;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public void itemClicked(View view) {
        Toast.makeText(view.getContext(), getTitle(), Toast.LENGTH_SHORT).show();
    }
}
