package com.salman.zach.widgetlikegoogleplay.screens;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.salman.zach.widgetlikegoogleplay.R;
import com.salman.zach.widgetlikegoogleplay.databinding.ActivityListWidgetBinding;
import com.salman.zach.widgetlikegoogleplay.playWidgets.IInfiniteLoadingListener;
import com.salman.zach.widgetlikegoogleplay.playWidgets.viewModels.ListItemViewModel;

import java.util.ArrayList;
import java.util.List;

public class ListWidgetActivity extends AppCompatActivity implements IInfiniteLoadingListener {

    private List<ListItemViewModel> listModel = new ArrayList<>();
    private ActivityListWidgetBinding mBinding;


    private float[] rating = {4.3f, 4.0f, 4.2f, 4.5f, 5.0f, 4.5f, 4.0f, 4.4f, 4.3f, 4.0f, 4.2f, 4.5f, 5.0f, 4.5f, 4.0f, 4.4f, 5.0f, 4.5f, 4.0f, 4.4f};
    private int[] images = {R.drawable.captainamarica, R.drawable.avengers, R.drawable.wonderwoman, R.drawable.justiceleague, R.drawable.antman, R.drawable.superman, R.drawable.captainamarica, R.drawable.wonderwoman, R.drawable.captainamarica, R.drawable.avengers, R.drawable.wonderwoman, R.drawable.justiceleague, R.drawable.antman, R.drawable.superman, R.drawable.captainamarica, R.drawable.wonderwoman, R.drawable.antman, R.drawable.superman, R.drawable.captainamarica, R.drawable.wonderwoman,};
    private String[] titles = {"Captain America", "Avengers", "Wonder Woman", "Justice League", "Ant Man", "Superman", "Captain America", "Wonder Woman", "Captain America", "Avengers", "Wonder Woman", "Justice League", "Ant Man", "Superman", "Captain America", "Wonder Woman", "Ant Man", "Superman", "Captain America", "Wonder Woman"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_list_widget);
        mBinding.listWidget.setTitle("Super Hero Movies !");
        mBinding.listWidget.setDescription("Search Latest Super Hero Movies");
        mBinding.listWidget.setBannerImage(R.drawable.deadpool);
        mBinding.listWidget.setLoadingListener(this);
        fillData();
    }


    private void fillDataWithDelay(int page) {

        if (page != 1) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    fillData();

                }
            }, 2000);
        }

    }

    private void fillData() {
        for (int i = 0; i < 10; i++) {
            ListItemViewModel model = new ListItemViewModel();
            model.setRating(rating[i]);
            model.setImageResource(images[i]);
            model.setTitle(titles[i]);
            model.setPrice("FREE");
            listModel.add(model);
        }
        mBinding.listWidget.buildWidget(listModel);
    }

    @Override
    public void onLoadMore(int page, int totalItems) {
        fillDataWithDelay(page);
    }
}
