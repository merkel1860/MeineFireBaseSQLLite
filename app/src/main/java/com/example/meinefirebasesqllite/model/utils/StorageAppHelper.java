package com.example.meinefirebasesqllite.model.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class StorageAppHelper extends SQLiteOpenHelper {
    
    private static final String  DB_NAME = "meineFireBaseSQL";
    private static final int DB_VERSION = 1;

    public StorageAppHelper(Context context) {
        super(context,DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table user (\n" +
                "_id INTEGER primary key autoincrement,\n" +
                " fname Text,\n" +
                " lanem Text,\n" +
                " yob INTEGER\n" +
                ");");

        db.execSQL("CREATE TABLE login(\n" +
                "_id integer primary key autoincrement,\n" +
                "username Text,\n" +
                "password Text,\n" +
                "user_id integer,\n" +
                "FOREIGN KEY(user_id) REFERENCES usert(_id)\n" +
                ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public static void insertUser(SQLiteDatabase db, String fname, String lname, int yob){
        ContentValues anUserContenValue = new ContentValues();
        anUserContenValue.put("fname",fname);
        anUserContenValue.put("lname",lname);
        anUserContenValue.put("yob",yob);
        db.insert("user",null,anUserContenValue);
    }

    public static void insertLogin(SQLiteDatabase db, String username, String pass){
        ContentValues aLogin = new ContentValues();
        aLogin.put("fname",username);
        aLogin.put("lname",pass);
        db.insert("user",null,aLogin);
    }
}
