package com.iavariav.submission1.data.remote.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class MovieEntity implements Parcelable {
    String id;
    String poster_path;
    String title;
    String release_date;
    String overview;

    public MovieEntity() {
    }

    public MovieEntity(String id, String poster_path, String title, String release_date, String overview) {
        this.id = id;
        this.poster_path = poster_path;
        this.title = title;
        this.release_date = release_date;
        this.overview = overview;
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

    public static Creator<MovieEntity> getCREATOR() {
        return CREATOR;
    }

    protected MovieEntity(Parcel in) {
        id = in.readString();
        poster_path = in.readString();
        title = in.readString();
        release_date = in.readString();
        overview = in.readString();
    }

    public static final Creator<MovieEntity> CREATOR = new Creator<MovieEntity>() {
        @Override
        public MovieEntity createFromParcel(Parcel in) {
            return new MovieEntity(in);
        }

        @Override
        public MovieEntity[] newArray(int size) {
            return new MovieEntity[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(poster_path);
        parcel.writeString(title);
        parcel.writeString(release_date);
        parcel.writeString(overview);
    }
}
