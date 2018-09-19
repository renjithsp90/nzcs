package com.renjithsp.project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class location extends BaseDrawerActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_location);
        getLayoutInflater().inflate(R.layout.activity_location, frameLayout);
        toolbar.setTitle(getResources().getString(R.string.nav_header_location));

    }
    @Override
    protected void onResume() {
        super.onResume();
        navigationView.getMenu().getItem(1).setChecked(true);
    }
}
