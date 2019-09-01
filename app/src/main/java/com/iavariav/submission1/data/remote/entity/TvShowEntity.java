package com.iavariav.submission1.data.remote.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class TvShowEntity implements Parcelable {
    private String id;
    private String name;
    private String firstAirDate;
    private String posterPath;
    private String overview;

    public TvShowEntity() {
    }

    public TvShowEntity(String id, String name, String firstAirDate, String posterPath, String overview) {
        this.id = id;
        this.name = name;
        this.firstAirDate = firstAirDate;
        this.posterPath = posterPath;
        this.overview = overview;
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

    public static Creator<TvShowEntity> getCREATOR() {
        return CREATOR;
    }

    protected TvShowEntity(Parcel in) {
        id = in.readString();
        name = in.readString();
        firstAirDate = in.readString();
        posterPath = in.readString();
        overview = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(name);
        dest.writeString(firstAirDate);
        dest.writeString(posterPath);
        dest.writeString(overview);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<TvShowEntity> CREATOR = new Creator<TvShowEntity>() {
        @Override
        public TvShowEntity createFromParcel(Parcel in) {
            return new TvShowEntity(in);
        }

        @Override
        public TvShowEntity[] newArray(int size) {
            return new TvShowEntity[size];
        }
    };
}
