package com.renjithsp.project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by varun on 2017-09-16.
 */

public class DbHelper extends SQLiteOpenHelper {

    public static final int DB_VERSION = 1;
    public static final String DB_NAME = "nzcs.db";
    public static final String COLLEGE_TABLE_NAME = "colleges";
    public static final String COLLEGE_COLUMN_ID = "collegeid";
    public static final String COLLEGE_COLUMN_NAME = "name";
    public static final String COLLEGE_COLUMN_TYPE = "type";
    public static final String COLLEGE_COLUMN_DESCRIPTION = "description";
    public static final String COLLEGE_COLUMN_IMAGE = "image";
    public static final String COLLEGE_COLUMN_PHONE = "phone";
    public static final String COLLEGE_COLUMN_EMAIL = "email";
    public static final String COLLEGE_COLUMN_WEBSITE = "website";
    public static final String COLLEGE_COLUMN_ADDRESS = "address";
    public static final String COLLEGE_COLUMN_LOCATION = "location";
    public static final String COLLEGE_COLUMN_RATING = "rating";


    public static final String COURSE_TABLE_NAME = "course";
    public static final String COURSE_COLUMN_ID = "courseid";
    public static final String COURSE_COLLEGE_ID = "collegeid";
    public static final String COURSE_COLUMN_NAME = "collegename";

    public DbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("Creating DB","DB");
        db.execSQL(
                "create table " + COLLEGE_TABLE_NAME +
                        "(" + COLLEGE_COLUMN_ID + " INTEGER PRIMARY KEY NOT NULL, " +
                        COLLEGE_COLUMN_NAME + " TEXT, " +
                        COLLEGE_COLUMN_TYPE + " TEXT, " +
                        COLLEGE_COLUMN_DESCRIPTION + " TEXT, " +
                        COLLEGE_COLUMN_IMAGE + " TEXT, "  +
                        COLLEGE_COLUMN_PHONE + " TEXT, " +
                        COLLEGE_COLUMN_EMAIL + " TEXT, " +
                        COLLEGE_COLUMN_WEBSITE + " TEXT, " +
                        COLLEGE_COLUMN_ADDRESS + " TEXT, " +
                        COLLEGE_COLUMN_LOCATION + " TEXT, " +
                        COLLEGE_COLUMN_RATING + " INTEGER )"
        );
        db.execSQL(
                "create table " + COURSE_TABLE_NAME +
                        "(" + COURSE_COLUMN_ID + " INTEGER PRIMARY KEY NOT NULL, " +
                        COURSE_COLLEGE_ID + " TEXT, " +
                        COURSE_COLUMN_NAME + " TEXT )"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + COLLEGE_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + COURSE_TABLE_NAME);
        onCreate(db);
    }

    public boolean insertCollege(int collegeID, String name, String type, String description, String image,
                                 String phone, String email, String website, String address, String location, int ratng) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLLEGE_COLUMN_ID, collegeID);
        contentValues.put(COLLEGE_COLUMN_NAME, name);
        contentValues.put(COLLEGE_COLUMN_TYPE, type);
        contentValues.put(COLLEGE_COLUMN_DESCRIPTION, description);
        contentValues.put(COLLEGE_COLUMN_IMAGE, image);
        contentValues.put(COLLEGE_COLUMN_PHONE, phone);
        contentValues.put(COLLEGE_COLUMN_EMAIL, email);
        contentValues.put(COLLEGE_COLUMN_WEBSITE, website);
        contentValues.put(COLLEGE_COLUMN_ADDRESS, address);
        contentValues.put(COLLEGE_COLUMN_LOCATION, location);
        contentValues.put(COLLEGE_COLUMN_RATING, ratng);
        db.insert(COLLEGE_TABLE_NAME, null, contentValues);
        return true;
    }

    public boolean insertCourse(int courseID, int collegeID, String courseName) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COURSE_COLUMN_ID, courseID);
        contentValues.put(COURSE_COLLEGE_ID, collegeID);
        contentValues.put(COURSE_COLUMN_NAME, courseName);
        db.insert(COURSE_TABLE_NAME, null, contentValues);
        return true;
    }

    /*public Contact getContact(int id) {
        Contact contact = null;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from " + CONTACTS_TABLE_NAME + " where id=" + id + "", null);
        if (res != null && res.getCount() > 0) {
            if (res.moveToFirst()) {
                //int id = res.getInt(res.getColumnIndex(CONTACTS_COLUMN_ID));
                String name = res.getString(res.getColumnIndex(CONTACTS_COLUMN_NAME));
                String phoneNumber = res.getString(res.getColumnIndex(CONTACTS_COLUMN_PHONE));
                String relation = res.getString(res.getColumnIndex(CONTACTS_COLUMN_RELATION));
                byte[] photo = res.getBlob(res.getColumnIndex(CONTACTS_COLUMN_IMAGE));
                contact = new Contact(id, name, phoneNumber, relation, photo);
            }
        }
        return contact;
    }*/

    /*public int numberOfRows() {
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, CONTACTS_TABLE_NAME);
        return numRows;
    }*/

   /* public boolean updateContact(Integer id, String name, String phone, String relation, byte[] image) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(CONTACTS_COLUMN_NAME, name);
        contentValues.put(CONTACTS_COLUMN_PHONE, phone);
        contentValues.put(CONTACTS_COLUMN_RELATION, relation);
        contentValues.put(CONTACTS_COLUMN_IMAGE, image);
        db.update(CONTACTS_TABLE_NAME, contentValues, "id = ? ", new String[]{Integer.toString(id)});
        return true;
    }*/

   /* public boolean updatePersonalInfo(Integer id, String name, String address, String phone, String blood, String foodrisk, byte[] image) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(PERSONAL_COLUMN_NAME, name);
        contentValues.put(PERSONAL_COLUMN_ADDRESS, address);
        contentValues.put(PERSONAL_COLUMN_PHONE, phone);
        contentValues.put(PERSONAL_COLUMN_BLOOD, blood);
        contentValues.put(PERSONAL_COLUMN_FOODRISK, foodrisk);
        contentValues.put(PERSONAL_COLUMN_IMAGE, image);
        db.update(PERSONAL_TABLE_NAME, contentValues, "id = ? ", new String[]{Integer.toString(id)});
        return true;
    }

    public Integer deleteContact(Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(CONTACTS_TABLE_NAME,
                "id = ? ",
                new String[]{Integer.toString(id)});
    }

    public ArrayList<String> getAllCotacts(int pos) {
        ArrayList<String> array_list = new ArrayList<String>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from " + CONTACTS_TABLE_NAME, null);
        res.moveToFirst();

        while (res.isAfterLast() == false) {
            array_list.add(res.getString(res.getColumnIndex(CONTACTS_COLUMN_NAME)));
            res.moveToNext();
        }
        return array_list;
    }*/

    public ArrayList<College> getCollagesByLocation(String location) {
        ArrayList<College> array_list = new ArrayList<College>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from " + COLLEGE_TABLE_NAME + " where " + COLLEGE_COLUMN_LOCATION + " = '" + location + "';", null);
        if (res != null && res.getCount() > 0) {
            if (res.moveToFirst()) {
                do {
                    //DatabaseUtils.dumpCursorToString(res);
                    int id = res.getInt(res.getColumnIndex(COLLEGE_COLUMN_ID));
                    String name = res.getString(res.getColumnIndex(COLLEGE_COLUMN_NAME));
                    String type = res.getString(res.getColumnIndex(COLLEGE_COLUMN_TYPE));
                    String description = res.getString(res.getColumnIndex(COLLEGE_COLUMN_DESCRIPTION));
                    String image = res.getString(res.getColumnIndex(COLLEGE_COLUMN_IMAGE));
                    String phone = res.getString(res.getColumnIndex(COLLEGE_COLUMN_PHONE));
                    String email = res.getString(res.getColumnIndex(COLLEGE_COLUMN_EMAIL));
                    String website = res.getString(res.getColumnIndex(COLLEGE_COLUMN_WEBSITE));
                    String address = res.getString(res.getColumnIndex(COLLEGE_COLUMN_ADDRESS));
                    String loc = res.getString(res.getColumnIndex(COLLEGE_COLUMN_LOCATION));
                    int ratng = res.getInt(res.getColumnIndex(COLLEGE_COLUMN_RATING));
                    College college = new College(id, name, type, description, image,
                            phone, email, website, address, location, ratng);
                    array_list.add(college);
                    //res.moveToNext();
                } while (res.moveToNext());
            }
        }
        return array_list;
    }

    /*public ArrayList<PersonalInfo> getPersonalInfo() {
        ArrayList<PersonalInfo> array_list = new ArrayList<PersonalInfo>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from " + PERSONAL_TABLE_NAME, null);
        if (res != null && res.getCount() > 0) {
            if (res.moveToFirst()) {
                do {
                    DatabaseUtils.dumpCursorToString(res);
                    int id = res.getInt(res.getColumnIndex(PERSONAL_COLUMN_ID));
                    String name = res.getString(res.getColumnIndex(PERSONAL_COLUMN_NAME));
                    String address = res.getString(res.getColumnIndex(PERSONAL_COLUMN_ADDRESS));
                    String phoneNumber = res.getString(res.getColumnIndex(PERSONAL_COLUMN_PHONE));
                    String blood = res.getString(res.getColumnIndex(PERSONAL_COLUMN_BLOOD));
                    String foodrisk = res.getString(res.getColumnIndex(PERSONAL_COLUMN_FOODRISK));
                    byte[] photo = res.getBlob(res.getColumnIndex(CONTACTS_COLUMN_IMAGE));
                    PersonalInfo personalInfo = new PersonalInfo(id, name, address, phoneNumber, blood, foodrisk, photo);
                    array_list.add(personalInfo);
                    //res.moveToNext();
                } while (res.moveToNext());
            }
        }
        return array_list;
    }*/
}

