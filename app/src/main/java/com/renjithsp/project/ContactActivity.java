package com.renjithsp.project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ContactActivity extends BaseDrawerActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_contact2);
        getLayoutInflater().inflate(R.layout.app_bar_main, frameLayout);
        getLayoutInflater().inflate(R.layout.activity_contact, frameLayout);
    }
}
