package com.renjithsp.project;

public class College {
    public int collegeID, rating;
    public String name, type, description, image, phone, email, website, address, location;

    public  College(int collegeID, String name, String type, String description, String image,
                    String phone, String email, String website, String address, String location, int rating){
        this.collegeID = collegeID;
        this.name = name;
        this.type=type;
        this.description = description;
        this.image=image;
        this.phone=phone;
        this.email = email;
        this.website = website;
        this.address = address;
        this.location = location;
    }
}
