package com.renjithsp.project;

import android.os.Bundle;

public class poly extends BaseDrawerActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_location);
        getLayoutInflater().inflate(R.layout.activity_poly, frameLayout);
        toolbar.setTitle(getResources().getString(R.string.nav_header_poly));

    }
    @Override
    protected void onResume() {
        super.onResume();
        navigationView.getMenu().getItem(3).setChecked(true);
    }
}
