package com.renjithsp.project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ShowListActivity extends BaseDrawerActivity {
    public static DbHelper db;
    String filterValue = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_show_list);
        getLayoutInflater().inflate(R.layout.app_bar_main, frameLayout);
        getLayoutInflater().inflate(R.layout.activity_show_list, frameLayout);
        db = new DbHelper(this);

        TextView txtLocation = (TextView) findViewById(R.id.txtLocation);
        ArrayList<College> colleges = new ArrayList<>();
        String filterType = getIntent().getStringExtra("FilterType");
        filterValue = getIntent().getStringExtra(filterType);
        txtLocation.setText(filterValue);
        toolbar.setTitle(filterValue);
        switch (filterType) {
            case "LOCATION":
                colleges = db.getCollagesByLocation(filterValue);
                break;
            case "TYPE":
                colleges = db.getCollagesByType(filterValue);
                break;
        }

        ListView lstColleges = (ListView) findViewById(R.id.lstCollege);
        ListAdapter collagesAdapter = new ListAdapter(this, 1, colleges);
        lstColleges.setAdapter(collagesAdapter);
    }
    @Override
    protected void onResume() {
        super.onResume();
        switch (filterValue){
            case "Polytechnic":
                navigationView.getMenu().getItem(3).setChecked(true);
                break;
            case "University":
                navigationView.getMenu().getItem(4).setChecked(true);
                break;
        }

    }
}
