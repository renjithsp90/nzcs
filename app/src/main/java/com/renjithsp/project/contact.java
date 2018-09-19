package com.renjithsp.project;

import android.os.Bundle;

public class contact extends BaseDrawerActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_location);
        getLayoutInflater().inflate(R.layout.activity_contact, frameLayout);
        toolbar.setTitle(getResources().getString(R.string.nav_header_contactus));

    }
    @Override
    protected void onResume() {
        super.onResume();
        navigationView.getMenu().getItem(6).setChecked(true);
    }
}
