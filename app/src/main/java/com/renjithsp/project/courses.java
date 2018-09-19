package com.renjithsp.project;

import android.os.Bundle;

public class courses extends BaseDrawerActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_location);
        getLayoutInflater().inflate(R.layout.activity_courses, frameLayout);
        toolbar.setTitle(getResources().getString(R.string.nav_header_courses));

    }
    @Override
    protected void onResume() {
        super.onResume();
        navigationView.getMenu().getItem(2).setChecked(true);
    }
}
