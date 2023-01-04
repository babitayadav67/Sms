package com.example.sms;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class database  extends SQLiteOpenHelper {
    public  static  final String dbname="signup.db";
    public  database(@Nullable Context context){
        super(context,dbname,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String s ="create table users(_id integer primary key, name text,username text,password text)";
        sqLiteDatabase.execSQL(s);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists users");
        onCreate(sqLiteDatabase);
    }

public  boolean insert_data(String name,String username,String password){
        SQLiteDatabase db=this.getWritableDatabase();
    ContentValues cv=new ContentValues();
    cv.put("name",name);
    cv.put("username",username);
    cv.put("password",password);
    long lg=db.insert("users",null,cv);
    if (lg==-1)return  false;
    else return  true;
}

}
