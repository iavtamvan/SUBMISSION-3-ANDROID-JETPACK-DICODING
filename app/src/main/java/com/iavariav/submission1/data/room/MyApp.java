package com.iavariav.submission1.data.room;

import android.app.Application;

import androidx.room.Room;

public class MyApp extends Application {
    public static MovieTvDatabase db;

    @Override
    public void onCreate() {
        super.onCreate();
        db = Room.databaseBuilder(getApplicationContext(),
                MovieTvDatabase.class,"movieTv").allowMainThreadQueries().build();
    }
}
