package com.iavariav.submission1.data.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.iavariav.submission1.data.remote.entity.MovieEntity;
import com.iavariav.submission1.data.remote.entity.TvShowEntity;

@Database(entities = {MovieEntity.class, TvShowEntity.class},
        version = 2,
        exportSchema = false)
public abstract class MovieTvDatabase extends RoomDatabase {

    private static MovieTvDatabase INSTANCE;

    public abstract MovieTvDao academyDao();

    private static final Object sLock = new Object();

    public static MovieTvDatabase getInstance(Context context) {
        synchronized (sLock) {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                        MovieTvDatabase.class, "movieTv.db")
                        .build();
            }
            return INSTANCE;
        }
    }
}
