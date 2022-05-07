package com.example.io;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MyContent extends ContentProvider {
    private MySQL mySQL;
    public MyContent() {
    }

    @Override
    public boolean onCreate() {
        mySQL = new MySQL(getContext(),"student.db",null,2);
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        SQLiteDatabase dbReader = mySQL.getReadableDatabase();
        Cursor cursor = dbReader.query("student",projection,selection,selectionArgs,null,null,sortOrder);

        return cursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        SQLiteDatabase db = mySQL.getWritableDatabase();
        long i = db.insert("student",null,values);
        uri = ContentUris.withAppendedId(uri,i);
        return uri;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        SQLiteDatabase db = mySQL.getWritableDatabase();
        int a = db.delete("student",selection,selectionArgs);
        return a;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        SQLiteDatabase database = mySQL.getWritableDatabase();
        int a = database.update("student",values,selection,selectionArgs);
        return a;
    }
}
