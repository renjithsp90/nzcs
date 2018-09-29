package com.renjithsp.project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.widget.TextView;

import java.io.Console;
import java.util.ArrayList;

public class CollegeDetailsActivity extends BaseDrawerActivity {
    public static DbHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_college_details);
        getLayoutInflater().inflate(R.layout.app_bar_main, frameLayout);
        getLayoutInflater().inflate(R.layout.activity_college_details, frameLayout);
        db = new DbHelper(this);

        int collegeID = getIntent().getIntExtra("COLLEGE_ID", 0);
        College college = db.getCollagesByID(collegeID);

        TextView txtName = findViewById(R.id.txtCollegeName);
        txtName.setText(college.name);
        TextView txtDescription = findViewById(R.id.txtDescription);
        txtDescription.setText(college.description);
        TextView txtCourses=findViewById(R.id.txtCourses);
        ArrayList<Course> courses = db.getCourses(college.collegeID);
        String htmlStr = "";
        for (Course course: courses) {
            htmlStr += course.courseName + "<br />";
        }
        txtCourses.setText(Html.fromHtml(htmlStr));
        TextView txtPhone = findViewById(R.id.txtPhone);
        txtPhone.setText(college.phone);
        TextView txtEmail = findViewById(R.id.txtEmail);
        txtEmail.setText(college.email);
        TextView txtWebsite = findViewById(R.id.txtWebsite);
        txtWebsite.setText(college.website);
    }
}
