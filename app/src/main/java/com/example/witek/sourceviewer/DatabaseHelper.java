package com.example.witek.sourceviewer;

import android.content.ContentValues;
import android.content.Context;
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
}
