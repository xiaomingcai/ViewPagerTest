package com.example.viewpagertest.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.viewpagertest.R;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class GalleryActivity extends AppCompatActivity {
private ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        InitViewPager();
    }

    private void InitViewPager() {
        
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