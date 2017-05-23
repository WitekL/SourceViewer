package com.example.witek.sourceviewer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Witek on 23.05.2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "sources.db", factory, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTable = "CREATE TABLE Cache (_id INTEGER PRIMARY KEY AUTOINCREMENT, address TEXT, source TEXT);";
        sqLiteDatabase.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void addSource(PageModel pageModel) {
        ContentValues values = new ContentValues();
        values.put("address", pageModel.getAddress());
        values.put("source", pageModel.getSource());
        SQLiteDatabase db = getWritableDatabase();
        db.insert("Cache", null, values);
        db.close();
    }

    public PageModel getSource(String address){
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM Cache WHERE address = '" + address + "';";
        Cursor cursor = db.rawQuery(query, null);
        PageModel pageModel = new PageModel(null, null);
        if(cursor.getCount()>0){
            cursor.moveToFirst();
            while(!cursor.isAfterLast()){
                pageModel.setAddres(cursor.getString(1));
                pageModel.setSource(cursor.getString(2));
                cursor.moveToNext();
            }
        }
        cursor.close();
        db.close();
        System.out.println("From db");
        return pageModel;
    }

    public boolean search(String address){
        PageModel pageModel = null;
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM Cache WHERE address = '" + address + "';";
        Cursor cursor = db.rawQuery(query, null);
        if(cursor.getCount()<=0) {
            cursor.close();
            db.close();
            return false;
        }
        else {
            cursor.close();
            db.close();
            return true;
        }
    }
}
