package com.example.android.popularmoviesstage2.DbUtils;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class MovieDb extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "movie.db";

    public MovieDb(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String SQL_CREATE_MOVIE_TABLE = "CREATE TABLE " + MovieContracts.MovieEntry.TABLE_NAME + " (" +
                MovieContracts.MovieEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                MovieContracts.MovieEntry.COLUMN_MOVIE_ID + " INTEGER NOT NULL, " +
                MovieContracts.MovieEntry.COLUMN_TITLE + " TEXT NOT NULL, " +
                MovieContracts.MovieEntry.COLUMN_POSTER + " TEXT, " +
                MovieContracts.MovieEntry.COLUMN_BACKDROP + " TEXT, " +
                MovieContracts.MovieEntry.COLUMN_OVERVIEW + " TEXT, " +
                MovieContracts.MovieEntry.COLUMN_RATING + " INTEGER, " +
                MovieContracts.MovieEntry.COLUMN_DATE + " TEXT);";

        db.execSQL(SQL_CREATE_MOVIE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + MovieContracts.MovieEntry.TABLE_NAME);
        onCreate(db);
    }
}

