package com.renjithsp.project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class ShowListActivity extends AppCompatActivity {
    public static DbHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_list);
        db = new DbHelper(this);

        ListView lstColleges = (ListView) findViewById(R.id.lstCollege);
        final ArrayList<College> contacts = db.getCollagesByLocation("Auckland");

        ListAdapter collagesAdapter = new ListAdapter(this, 1, contacts);
        lstColleges.setAdapter(collagesAdapter);
    }
}
