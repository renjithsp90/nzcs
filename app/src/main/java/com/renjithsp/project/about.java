package com.renjithsp.project;

import android.os.Bundle;

public class about extends BaseDrawerActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_location);
        getLayoutInflater().inflate(R.layout.activity_about, frameLayout);
        toolbar.setTitle(getResources().getString(R.string.nav_header_aboutus));

    }
    @Override
    protected void onResume() {
        super.onResume();
        navigationView.getMenu().getItem(5).setChecked(true);
    }
}
