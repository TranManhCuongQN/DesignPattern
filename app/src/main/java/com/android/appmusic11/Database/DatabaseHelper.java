package com.android.appmusic11.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.android.appmusic11.Activity.MainActivity;
import com.android.appmusic11.Activity.TrangChuActivity;
import com.android.appmusic11.Model.BaiHatModel;

public class  DatabaseHelper extends SQLiteOpenHelper {


    private DatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    private static DatabaseHelper instance;
    public static synchronized DatabaseHelper getInstance(Context context){
        if(instance == null){
            instance = new DatabaseHelper(context,"MyMusic11.sqlite",null,1);
        }
        return instance;
    }


    public void QueryData(String sql){
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);
    }

    public Cursor getData(String sql){
        SQLiteDatabase database = getReadableDatabase();
        return database.rawQuery(sql,null);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
