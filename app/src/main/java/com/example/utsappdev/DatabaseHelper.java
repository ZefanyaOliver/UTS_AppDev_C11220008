package com.example.utsappdev;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "MyAppDB";
    private static final int DATABASE_VERSION = 1;

    private static final String LOGIN_TABLE = "Users";
    private static final String COL_ID = "id";
    private static final String COL_USERNAME = "username";
    private static final String COL_PASSWORD = "password";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Membuat tabel Users
        String CREATE_LOGIN_TABLE = "CREATE TABLE " + LOGIN_TABLE + "("
                + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COL_USERNAME + " TEXT,"
                + COL_PASSWORD + " TEXT" + ")";
        db.execSQL(CREATE_LOGIN_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Hapus tabel lama jika ada pembaruan versi
        db.execSQL("DROP TABLE IF EXISTS " + LOGIN_TABLE);
        onCreate(db);
    }

    // Menambahkan pengguna baru ke dalam database
    public void addUser(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COL_USERNAME, username);
        values.put(COL_PASSWORD, password);

        // Memasukkan data pengguna ke dalam tabel Users
        long newRowId = db.insert(LOGIN_TABLE, null, values);
        db.close();
        Log.d("DatabaseHelper", "New user inserted into row: " + newRowId);
    }
}
