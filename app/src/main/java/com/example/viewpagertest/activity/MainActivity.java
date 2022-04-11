package com.example.viewpagertest.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.viewpagertest.R;
import com.example.viewpagertest.transformer.TransformeType;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
private Button normalButton;
private Button scaleBt;
private Button rotateBt;
private Button zoom_outBt;
private Button tDGalleryBt;
private Button fragPagerBt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        normalButton=findViewById(R.id.normal_bt);
        normalButton.setOnClickListener(this);
        scaleBt=findViewById(R.id.scale_bt);
        scaleBt.setOnClickListener(this);
        rotateBt=findViewById(R.id.rotate_bt);
        rotateBt.setOnClickListener(this);
        zoom_outBt=findViewById(R.id.zoom_out);
        zoom_outBt.setOnClickListener(this);
        tDGalleryBt=findViewById(R.id.td_gallery_bt);
        tDGalleryBt.setOnClickListener(this);
        fragPagerBt=findViewById(R.id.frag_pager_bt);
        fragPagerBt.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, PageActivity.class);
        switch (v.getId()) {
            case R.id.normal_bt:
                intent.putExtra(TransformeType.TYPE,TransformeType.NORMAL);
                break;
                case R.id.scale_bt:
                    intent.putExtra(TransformeType.TYPE,TransformeType.SCALE);
                    break;
            case R.id.rotate_bt:
                    intent.putExtra(TransformeType.TYPE,TransformeType.ROTATE);
                    break;
            case R.id.zoom_out:
                intent.putExtra(TransformeType.TYPE,TransformeType.ZoomOut);
                break;
            case R.id.td_gallery_bt:
                intent=new Intent(this,GalleryActivity.class);
                break;
            case R.id.frag_pager_bt:
                intent=new Intent(this,FragPagerActivity.class);
            default:break;
        }
        startActivity(intent);
    }
}