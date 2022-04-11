package com.example.viewpagertest.transformer;

import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;

public class ScalePageTransformer implements ViewPager.PageTransformer {
    private static final float MIN_SCALE=0.75f;
    private static final String TAG = "ScalePageTransformer";

    @Override
    public void transformPage(@NonNull View page, float position) {
        Log.d(TAG, "transformPage: position="+position);
        if (position<-1.0f){
            page.setScaleX(MIN_SCALE);
            page.setScaleX(MIN_SCALE);
        }else if(position<=0.0f){
            page.setAlpha(1.0f);
            page.setTranslationX(0.0f);
            page.setScaleX(1.0f);
            page.setScaleY(1.0f);
        }else if (position<1.0f){
            page.setAlpha(1.0f-position);
            page.setTranslationX(-page.getWidth()*position);
            float scale=MIN_SCALE+(1.0f-MIN_SCALE)*(1.0f-position);
            page.setScaleY(scale);
            page.setScaleX(scale);
        }else{
            page.setScaleX(MIN_SCALE);
            page.setScaleY(MIN_SCALE);
        }

    }
}
