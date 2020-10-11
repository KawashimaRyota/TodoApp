package com.example.todoapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    /**
     * データベースファイル名の定数
     */
    private static final String DATABASE_NAME = "todo.db";
    /**
     * バージョン情報の定数
     */
    private static final int DATABASE_VERSION = 1;

    /**
     * コンストラクタ
     */
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE todo (");
        sb.append("_id INTEGER PRIMARY KEY, ");
        sb.append("name TEXT,");
        sb.append("day INTEGER,");
        sb.append("month INTEGER,");
        sb.append("year INTEGER,");
        sb.append("memo TEXT,");
        sb.append(");");
        String sql = sb.toString();

        //sql実行
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
