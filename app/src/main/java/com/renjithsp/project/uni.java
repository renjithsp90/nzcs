package com.renjithsp.project;

import android.os.Bundle;

public class uni extends BaseDrawerActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_location);
        getLayoutInflater().inflate(R.layout.activity_uni, frameLayout);
        toolbar.setTitle(getResources().getString(R.string.nav_header_uni));

    }
    @Override
    protected void onResume() {
        super.onResume();
        navigationView.getMenu().getItem(4).setChecked(true);
    }
}
