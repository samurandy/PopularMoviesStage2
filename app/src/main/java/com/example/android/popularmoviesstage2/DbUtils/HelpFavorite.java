package com.example.android.popularmoviesstage2.DbUtils;


import android.content.Context;
import android.database.Cursor;

public class HelpFavorite {

    public static int isFavorite(Context context, int id) {
        Cursor cursor = context.getContentResolver().query(
                MovieContracts.MovieEntry.CONTENT_URI,
                null,
                MovieContracts.MovieEntry.COLUMN_MOVIE_ID + " = ?",
                new String[]{Integer.toString(id)},
                null
        );
        assert cursor != null;
        int numRows = cursor.getCount();
        cursor.close();
        return numRows;
    }

    public static String buildImageUrl(int width, String fileName) {
        return "http://image.tmdb.org/t/p/w" + Integer.toString(width) + fileName;
    }
}
