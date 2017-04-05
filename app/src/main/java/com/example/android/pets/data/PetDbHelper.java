package com.example.android.pets.data;

/**
 * Created by Christian PC on 05/04/2017.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.android.pets.data.PetContract.PetEntry;

public final class PetDbHelper extends SQLiteOpenHelper {

    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "shelter.db";

    public PetDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String TEXT_TYPE = " TEXT";
        String INTEGER_TYPE = " INTEGER";
        String COMMA_SEP = ", ";


        String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + PetEntry.TABLE_NAME + " (" +
                        PetEntry._ID + INTEGER_TYPE + " PRIMARY KEY AUTOINCREMENT" + COMMA_SEP +
                        PetEntry.COLUMN_PET_NAME + TEXT_TYPE + "TEXT NOT NULL" + COMMA_SEP +
                        PetEntry.COLUMN_PET_BREED + TEXT_TYPE + COMMA_SEP +
                        PetEntry.COLUMN_PET_GENDER + INTEGER_TYPE + " NOT NULL" + COMMA_SEP +
                        PetEntry.COLUMN_PET_WEIGHT + INTEGER_TYPE + " NOT NULL DEFAULT 0" + " )";

        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO
    }
}