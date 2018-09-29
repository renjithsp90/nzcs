package com.renjithsp.project;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class ListAdapter extends ArrayAdapter<College> implements android.widget.ListAdapter {

    Context thisContext;
    public ListAdapter(@NonNull Context context, int resource, @NonNull List<College> collages) {
        super(context, resource, collages);
        thisContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final College college = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_card_layout, parent, false);
        }

        final ImageView collegeImg = (ImageView) convertView.findViewById(R.id.imgCollege);
        String mDrawableName = "r" + college.collegeID;
        int resID = convertView.getResources().getIdentifier(mDrawableName , "drawable", convertView.getContext().getPackageName());
        collegeImg.setImageResource(resID);
        //Bitmap bmp = ImageManager.getImage(contact.image);
        //contactImg.setImageBitmap(bmp);

        final TextView txtName = (TextView)convertView.findViewById(R.id.txtName);
        txtName.setText(college.name);
        final TextView txtLocation = (TextView)convertView.findViewById(R.id.txtLocation);
        txtLocation.setText(college.location);

        final Button btnReadMore = convertView.findViewById(R.id.btnReadMore);
        btnReadMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thisContext, CollegeDetailsActivity.class);
                //Log.d("COLLEGEID", college.collegeID);
                intent.putExtra("COLLEGE_ID", college.collegeID);
                view.getContext().startActivity(intent);
            }
        });

        return convertView;
    }
}
