package com.example.myapplication;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class TodoDatabaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "todo.db";
    private static final int DB_VERSION = 1;

    public TodoDatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE todo (id INTEGER PRIMARY KEY AUTOINCREMENT, task TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS todo");
        onCreate(db);
    }

    public void insertTodo(String task) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("INSERT INTO todo (task) VALUES (?)", new Object[]{task});
        db.close();
    }

    public void deleteTodo(String task) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM todo WHERE task = ?", new Object[]{task});
        db.close();
    }

    public ArrayList<String> getAllTodos() {
        ArrayList<String> list = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT task FROM todo", null);
        while (cursor.moveToNext()) {
            list.add(cursor.getString(0));
        }
        cursor.close();
        db.close();
        return list;
    }
}
