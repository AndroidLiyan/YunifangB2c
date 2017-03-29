package com.yunifang.my.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.yunifang.my.jsonbean.ProductInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/3/28.
 */

public class ShopDao {

    private final SQLiteDatabase db;

    public ShopDao(Context context) {
        ShopDBOpenHelper helper = new ShopDBOpenHelper(context);
        db = helper.getWritableDatabase();
    }


    public boolean adddb(String name, String img, String sid, double price) {
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("img", img);
        values.put("sid", sid);
        values.put("price", price);
        long result = db.insert("shop", null, values);
        if (result != -1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean delete(String name) {
        int result = db.delete("shop", "name = ?", new String[]{name});
        if (result > 0) {
            return true;
        } else {
            return false;
        }
    }

    //    id Integer primary key autoincrement,name varchar(20),img varchar(100),sid varchar(20) price varchar(20)
    public List<ProductInfo> findAll() {
        Cursor cursor = db.query("shop", null, null, null, null, null, null);
        List<ProductInfo> list = new ArrayList<>();
        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String img = cursor.getString(cursor.getColumnIndex("img"));
            String sid = cursor.getString(cursor.getColumnIndex("sid"));
            double price = cursor.getDouble(cursor.getColumnIndex("price"));
            ProductInfo productInfo = new ProductInfo(name, img, sid, price, 1, false);
            list.add(productInfo);
        }
        return list;
    }
}
