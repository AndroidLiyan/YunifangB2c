package com.yunifang.my.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by lenovo on 2017/3/28.
 */

public class ShopDBOpenHelper extends SQLiteOpenHelper {

    public ShopDBOpenHelper(Context context) {
        super(context, "shop.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //创建一个person表
        db.execSQL("create table shop (id Integer primary key autoincrement,name varchar(20),img varchar(100),sid varchar(20),price double(20))");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
