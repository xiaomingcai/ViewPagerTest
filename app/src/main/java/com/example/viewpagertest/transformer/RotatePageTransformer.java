package com.example.viewpagertest.transformer;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;

public class RotatePageTransformer implements ViewPager.PageTransformer {
    private static final float MAX_ROTATION=20.0f;
    @Override
    public void transformPage(@NonNull View page, float position) {
        if(position<-1){
            rotate(page,MAX_ROTATION);
        }else if(position<=1){
            rotate(page,MAX_ROTATION*position);
        }else{
            rotate(page,MAX_ROTATION);
        }
    }

    private void rotate(View page, float rotation) {
        page.setPivotX(page.getWidth()*0.5f);
        page.setPivotY(page.getHeight());
        page.setRotation(rotation);
    }
}
