package com.iavariav.submission1.data.remote.entity;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class TvShowEntity{
    @PrimaryKey(autoGenerate = false)
    @NonNull
    @ColumnInfo(name = "id")
    private String id;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "firstAirDate")
    private String firstAirDate;

    @ColumnInfo(name = "posterPath")
    private String posterPath;

    @ColumnInfo(name = "overview")
    private String overview;

    @ColumnInfo(name = "favorite")
    boolean favorite;

    public TvShowEntity() {
    }

    public TvShowEntity(@NonNull String id, String name, String firstAirDate, String posterPath, String overview, Boolean favorite) {
        this.id = id;
        this.name = name;
        this.firstAirDate = firstAirDate;
        this.posterPath = posterPath;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstAirDate() {
        return firstAirDate;
    }

    public void setFirstAirDate(String firstAirDate) {
        this.firstAirDate = firstAirDate;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean mBookmarked) {
        this.favorite = mBookmarked;
    }

}
