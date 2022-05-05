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
        db.execSQL("INSERT INTO student (stuId,stuName,stuClass) values (1,'李冬霖','移动应用开发4班')");
        db.execSQL("INSERT INTO student (stuId,stuName,stuClass) values (2,'刘怡','移动应用开发4班')");
        db.execSQL("INSERT INTO student (stuId,stuName,stuClass) values (3,'大刘','移动应用开发4班')");
        db.execSQL("INSERT INTO student (stuId,stuName,stuClass) values (4,'小仙女','移动应用开发4班')");
        db.execSQL("INSERT INTO student (stuId,stuName,stuClass) values (5,'大傻逼','移动应用开发4班')");
        db.execSQL("INSERT INTO student (stuId,stuName,stuClass) values (6,'小煞笔','移动应用开发4班')");
        db.execSQL("INSERT INTO student (stuId,stuName,stuClass) values (7,'LDL','移动应用开发4班')");
        db.execSQL("INSERT INTO student (stuId,stuName,stuClass) values (8,'ldl','移动应用开发4班')");
        db.execSQL("INSERT INTO student (stuId,stuName,stuClass) values (9,'LY','移动应用开发4班')");
        db.execSQL("INSERT INTO student (stuId,stuName,stuClass) values (10,'ly','移动应用开发4班')");
        db.execSQL("INSERT INTO student (stuId,stuName,stuClass) values (11,'YW','移动应用开发4班')");
        db.execSQL("INSERT INTO student (stuId,stuName,stuClass) values (12,'怡宝','移动应用开发4班')");
        db.execSQL("INSERT INTO student (stuId,stuName,stuClass) values (13,'yibao','移动应用开发4班')");
        db.execSQL("INSERT INTO student (stuId,stuName,stuClass) values (14,'xianer','移动应用开发4班')");
        db.execSQL("INSERT INTO student (stuId,stuName,stuClass) values (15,'xianer','移动应用开发4班')");
        db.execSQL("INSERT INTO student (stuId,stuName,stuClass) values (16,'刘怡','移动应用开发4班')");
        db.execSQL("INSERT INTO student (stuId,stuName,stuClass) values (17,'刘怡','移动应用开发4班')");
        db.execSQL("INSERT INTO student (stuId,stuName,stuClass) values (18,'刘怡','移动应用开发4班')");
        db.execSQL("INSERT INTO student (stuId,stuName,stuClass) values (19,'刘怡','移动应用开发4班')");
        db.execSQL("INSERT INTO student (stuId,stuName,stuClass) values (20,'刘怡','移动应用开发4班')");
        db.execSQL("INSERT INTO student (stuId,stuName,stuClass) values (21,'刘怡','移动应用开发4班')");
        db.execSQL("INSERT INTO student (stuId,stuName,stuClass) values (22,'刘怡','移动应用开发4班')");
        db.execSQL("INSERT INTO student (stuId,stuName,stuClass) values (23,'刘怡','移动应用开发4班')");
        db.execSQL("INSERT INTO student (stuId,stuName,stuClass) values (24,'刘怡','移动应用开发4班')");
        db.execSQL("INSERT INTO student (stuId,stuName,stuClass) values (25,'刘怡','移动应用开发4班')");
        db.execSQL("INSERT INTO student (stuId,stuName,stuClass) values (26,'刘怡','移动应用开发4班')");
        db.execSQL("INSERT INTO student (stuId,stuName,stuClass) values (27,'刘怡','移动应用开发4班')");
        db.execSQL("INSERT INTO student (stuId,stuName,stuClass) values (28,'刘怡','移动应用开发4班')");
        db.execSQL("INSERT INTO student (stuId,stuName,stuClass) values (29,'刘怡','移动应用开发4班')");
        db.execSQL("INSERT INTO student (stuId,stuName,stuClass) values (30,'刘怡','移动应用开发4班')");
        db.execSQL("INSERT INTO student (stuId,stuName,stuClass) values (31,'刘怡','移动应用开发4班')");
        db.execSQL("INSERT INTO student (stuId,stuName,stuClass) values (32,'刘怡','移动应用开发4班')");
        db.execSQL("INSERT INTO student (stuId,stuName,stuClass) values (33,'刘怡','移动应用开发4班')");
        db.execSQL("INSERT INTO student (stuId,stuName,stuClass) values (34,'刘怡','移动应用开发4班')");
        db.execSQL("INSERT INTO student (stuId,stuName,stuClass) values (35,'刘怡','移动应用开发4班')");
        db.execSQL("INSERT INTO student (stuId,stuName,stuClass) values (36,'刘怡','移动应用开发4班')");
        db.execSQL("INSERT INTO student (stuId,stuName,stuClass) values (37,'刘怡','移动应用开发4班')");
        db.execSQL("INSERT INTO student (stuId,stuName,stuClass) values (38,'刘怡','移动应用开发4班')");





    }

    /**
     * 数据库升级时调用
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists student");
        onCreate(db);


    }
}
