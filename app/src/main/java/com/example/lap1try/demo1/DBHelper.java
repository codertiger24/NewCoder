package com.example.lap1try.demo1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper( Context context) {
        super(context, "ToDoDB", null, 1);//Tao csdl
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Lenh tao bang du lieu
        String sql = "CREATE TABLE KhoaHoc(\n" +
                "\tid integer PRIMARY key,\n" +
                "  title text,\n" +
                "  content text,\n" +
                "  date text,\n" +
                "  type integer\n" +
                ")";
        db.execSQL(sql);//Tao bang du lieu
        String insertData = "INSERT into KhoaHoc VALUES(1,'title','content','date',0),\n" +
                "(2,'title2','content2','date2',1),\n" +
                "(3,'title3','content3','date3',0)";
        db.execSQL(insertData);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion){
            db.execSQL("DROP TABLE IF EXISTS KhoaHoc");
            onCreate(db);
        }

    }
}
