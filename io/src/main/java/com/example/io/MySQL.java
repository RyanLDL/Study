package com.example.io;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public class MySQL extends SQLiteOpenHelper {
    //参数：上下文（getApplicationContext()）、数据库名称，游标工厂（通常时null）、 版本号
    public MySQL(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public MySQL(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version, @Nullable DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @RequiresApi(api = Build.VERSION_CODES.P)
    public MySQL(@Nullable Context context, @Nullable String name, int version, @NonNull SQLiteDatabase.OpenParams openParams) {
        super(context, name, version, openParams);
    }

    /**
     * 创建数据库，执行建表语句
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE student("+"_id INTEGER PRIMARY KEY AUTOINCREMENT,"+"stuId INTEGER UNIQUE,"+"stuName TEXT NOT NULL,"+"stuClass TEXT);");
        db.execSQL("INSERT INTO student (stuId,stuName,stuClass) values (31,'李冬霖','移动应用开发4班')");
        db.execSQL("INSERT INTO student (stuId,stuName,stuClass) values (31,'刘怡','移动应用开发4班')");
    }

    /**
     * 数据库升级时调用
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
