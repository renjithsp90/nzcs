package com.renjithsp.project;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class location extends BaseDrawerActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_location);
        getLayoutInflater().inflate(R.layout.app_bar_main, frameLayout);
        getLayoutInflater().inflate(R.layout.activity_location, frameLayout);
        toolbar.setTitle(getResources().getString(R.string.nav_header_location));
        final Context context = this;

        /*Button btnAuckland = (Button)findViewById(R.id.buttonAuckland);
        btnAuckland.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ShowListActivity.class);
                startActivity(intent);
            }
        });*/
    }
    @Override
    protected void onResume() {
        super.onResume();
        navigationView.getMenu().getItem(1).setChecked(true);
    }

    public void btnClick(View view) {
        Button button = (Button)view;
        String location = button.getText().toString();
        Intent intent = new Intent(getBaseContext(), ShowListActivity.class);
        intent.putExtra("FilterType", "LOCATION");
        intent.putExtra("LOCATION", location);
        startActivity(intent);
    }
}
