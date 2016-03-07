package com.drawthink.carcare.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.drawthink.carcare.R;
import com.drawthink.carcare.view.listener.BaseViewListener;

public class WelcomeActivity extends AppCompatActivity implements BaseViewListener {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        imageView = (ImageView) findViewById(R.id.imageView);
        String internetUrl = "http://img2.3lian.com/2014/f5/158/d/87.jpg";
        Glide.with(this)
                .load(internetUrl)
                .into(imageView);
    }


    @Override
    public void loadSuccess() {

    }

    @Override
    public void loadError() {
    }

}
