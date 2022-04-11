package com.example.viewpagertest.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.ImageViewCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.viewpagertest.R;
import com.example.viewpagertest.transformer.RotatePageTransformer;
import com.example.viewpagertest.transformer.ScalePageTransformer;
import com.example.viewpagertest.transformer.TransformeType;
import com.example.viewpagertest.transformer.ZoomOutPagerTransformer;
import com.example.viewpagertest.util.ViewAdapter;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class PageActivity extends AppCompatActivity {

private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page);
        InitPager();
viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
});
    }

    private void InitPager() {
        viewPager=findViewById(R.id.view_pager);
        PagerAdapter pagerAdapter =new ViewAdapter(LoadImage());
        viewPager.setAdapter(pagerAdapter);
        switch(getIntent().getIntExtra(TransformeType.TYPE,TransformeType.NORMAL)){
            case TransformeType.SCALE:
                viewPager.setPageTransformer(true,new ScalePageTransformer());
                break;
            case TransformeType.ROTATE:
                viewPager.setPageTransformer(true,new RotatePageTransformer());
                break;
                case TransformeType.ZoomOut:
                    viewPager.setPageTransformer(true,new ZoomOutPagerTransformer());
                    break;
        }
    }

    private List<View> LoadImage() {
        List<View>images = new ArrayList<View>();
        Field[] fields=R.drawable.class.getDeclaredFields();
        try { for (Field field : fields){
            if (field.getName().startsWith("page")){
                ImageView view=new ImageView(this);
                    view.setImageResource(field.getInt(null));
                view.setScaleType(ImageView.ScaleType.CENTER_CROP);
                images.add(view);
            }
        }
        } catch (IllegalAccessException e) {
        e.printStackTrace();
    }
    return images;
    }
}