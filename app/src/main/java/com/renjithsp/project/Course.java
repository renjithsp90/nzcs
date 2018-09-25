package com.renjithsp.project;

public class Course {
    public int courseID, collegeID;
    public String courseName;

    public Course(int courseID, int collegeID, String courseName){
        this.courseID = courseID;
        this.collegeID = collegeID;
        this.courseName = courseName;
    }
}
