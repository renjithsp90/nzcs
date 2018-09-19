package com.renjithsp.project;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ContentFrameLayout;
import android.view.View;

import gr.net.maroulis.library.EasySplashScreen;

public class Welcome_Screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EasySplashScreen config = new EasySplashScreen(Welcome_Screen.this)
                .withFullScreen()
                .withTargetActivity(MainActivity.class)
                .withSplashTimeOut(3000)
                .withBackgroundColor(Color.WHITE)
                .withLogo(R.drawable.nzcslogo)
                .withFooterText("Copyright 2018")
                .withAfterLogoText("Welcome to NZCS");

        config.getFooterTextView().setTextColor(Color.BLACK);
        config.getAfterLogoTextView().setTextColor(Color.LTGRAY);
        config.getAfterLogoTextView().setTextSize(20);

        View view = config.create();

        setContentView(view);

    }
}
