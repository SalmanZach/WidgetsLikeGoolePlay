package com.salman.zach.widgetlikegoogleplay.screens;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.salman.zach.widgetlikegoogleplay.R;
import com.salman.zach.widgetlikegoogleplay.databinding.ActivityMainBinding;
import com.salman.zach.widgetlikegoogleplay.playWidgets.viewModels.CarousalItemViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mainBinding;
    private float[] rating = {4.3f, 4.0f, 4.2f, 4.5f, 5.0f, 4.5f, 4.0f, 4.4f, 4.3f, 4.0f, 4.2f, 4.5f, 5.0f, 4.5f, 4.0f, 4.4f, 5.0f, 4.5f, 4.0f, 4.4f};
    private int[] images = {R.drawable.captainamarica, R.drawable.avengers, R.drawable.wonderwoman, R.drawable.justiceleague, R.drawable.antman, R.drawable.superman, R.drawable.captainamarica, R.drawable.wonderwoman, R.drawable.captainamarica, R.drawable.avengers, R.drawable.wonderwoman, R.drawable.justiceleague, R.drawable.antman, R.drawable.superman, R.drawable.captainamarica, R.drawable.wonderwoman, R.drawable.antman, R.drawable.superman, R.drawable.captainamarica, R.drawable.wonderwoman,};
    private String[] titles = {"Captain America", "Avengers", "Wonder Woman", "Justice League", "Ant Man", "Superman", "Captain America", "Wonder Woman", "Captain America", "Avengers", "Wonder Woman", "Justice League", "Ant Man", "Superman", "Captain America", "Wonder Woman", "Ant Man", "Superman", "Captain America", "Wonder Woman"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        List<CarousalItemViewModel> list = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            CarousalItemViewModel model = new CarousalItemViewModel();
            model.setRating(rating[i]);
            model.setImageResource(images[i]);
            model.setTitle(titles[i]);
            model.setPrice("FREE");
            list.add(model);
        }
        mainBinding.carousalWidget.setBannerImage(R.drawable.js_banner);
        mainBinding.carousalWidget.setTitle("Super Hero Movies !");
        mainBinding.carousalWidget.setDescription("Search Latest Super Hero Movies");
        mainBinding.carousalWidget.buildWidget(list);


        mainBinding.carousalWidget2.setTitle("Super Hero Movies !");
        mainBinding.carousalWidget2.setDescription("Search Latest Super Hero Movies");
        mainBinding.carousalWidget2.setBannerImage(R.drawable.deadpool);
        mainBinding.carousalWidget2.buildWidget(list);
    }
}
