package com.renjithsp.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
    public void btnClick(View view) {
        Button button = (Button)view;
        String location = button.getText().toString();
        Intent intent = new Intent(getBaseContext(), ShowListActivity.class);
        intent.putExtra("FilterType", "COURSE");
        intent.putExtra("COURSE", location);
        startActivity(intent);
    }
}
