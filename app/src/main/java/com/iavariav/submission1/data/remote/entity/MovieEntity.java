package com.iavariav.submission1.data.remote.entity;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class MovieEntity {

//    @PrimaryKey(autoGenerate = true)
//    int idGenerate;

    @PrimaryKey(autoGenerate = false)
    @NonNull
    @ColumnInfo(name = "id")
    String id;

    @ColumnInfo(name = "poster_path")
    String poster_path;

    @ColumnInfo(name = "title")
    String title;

    @ColumnInfo(name = "release_date")
    String release_date;

    @ColumnInfo(name = "overview")
    String overview;

    @ColumnInfo(name = "favorite")
    private boolean favorite = false;

    public MovieEntity() {
    }

    public MovieEntity(@NonNull String id, String poster_path, String title, String release_date, String overview, Boolean favorite) {
        this.id = id;
        this.poster_path = poster_path;
        this.title = title;
        this.release_date = release_date;
        this.overview = overview;
        if (favorite != null) {
            this.favorite = false;
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

//    public int getIdGenerate() {
//        return idGenerate;
//    }
//
//    public void setIdGenerate(int idGenerate) {
//        this.idGenerate = idGenerate;
//    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean mBookmarked) {
        this.favorite = mBookmarked;
    }
}
