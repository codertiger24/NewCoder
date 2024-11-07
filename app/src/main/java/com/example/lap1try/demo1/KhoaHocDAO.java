package com.example.lap1try.demo1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

public class KhoaHocDAO  {
    private DBHelper dbHelper;
    private SQLiteDatabase database;
    public KhoaHocDAO(Context context){
        dbHelper = new DBHelper(context);//goi lenh tao DB
        database = dbHelper.getWritableDatabase();

    }
    //lenh insert
    public long addKhoaHoc(KhoaHoc khoaHoc){
        ContentValues values = new ContentValues();
        values.put("id",khoaHoc.getId());
        values.put("title",khoaHoc.getTitle());
        values.put("content",khoaHoc.getContent());
        values.put("date",khoaHoc.getDate());
        values.put("type",khoaHoc.getType());
        long check = database.insert("KhoaHoc",null,values);
        return check;
    }
    //ham xoa
    public long deleteKhoaHoc(int id){
        long check = database.delete("KhoaHoc","id=?",
                new String[]{String.valueOf(id)});
        return check;
    }
    //ham sua
    public long updateKhoaHoc(KhoaHoc khoaHoc){
        ContentValues values = new ContentValues();
        values.put("id",khoaHoc.getId());
        values.put("title",khoaHoc.getTitle());
        values.put("content",khoaHoc.getContent());
        values.put("date",khoaHoc.getDate());
        values.put("type",khoaHoc.getType());
        long check = database.update("KhoaHoc",values,"id=?",
                new String[]{String.valueOf(khoaHoc.getId())});
        return check;
    }
    //select
    public ArrayList<KhoaHoc> getListKhoaHoc(){
        ArrayList<KhoaHoc> list = new ArrayList<>();
        database = dbHelper.getReadableDatabase();
        try {
            Cursor cursor = database.rawQuery("Select * from KhoaHoc",null);
            if(cursor.getCount()>0){
                cursor.moveToFirst();
                do {
                    list.add(new KhoaHoc(cursor.getInt(0),
                            cursor.getString(1),
                            cursor.getString(2),
                            cursor.getString(3),
                            cursor.getInt(4)));
                }while (cursor.moveToNext());
            }
        }catch (Exception e){
            Log.e("TAG",e.getMessage());
        }
        return list;
    }
}
