package com.example.yzu_community;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MySqliteOpenHelper extends SQLiteOpenHelper {
    private static SQLiteOpenHelper mInstance;

    public static synchronized SQLiteOpenHelper getmInstance(Context context){
        if (mInstance==null){
            mInstance=new MySqliteOpenHelper(context,"derryDB.db",null,1);
        }
        return mInstance;
    }

    private MySqliteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//创建数据表users，表中包含_account和_password两个字段，为了方便我把他们的类型全部设为text
        String  sql="create table users(_account text,_password text)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}