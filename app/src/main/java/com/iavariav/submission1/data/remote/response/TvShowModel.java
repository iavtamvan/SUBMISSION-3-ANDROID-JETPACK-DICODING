package com.iavariav.submission1.data.remote.response;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class TvShowModel implements Parcelable {
	private String firstAirDate;
	private String overview;
	private String originalLanguage;
	private String genreIds;
	private String posterPath;
	private String originCountry;
	private String backdropPath;
	private String originalName;
	private String popularity;
	private String voteAverage;
	private String name;
	private String id;
	private String voteCount;

	public TvShowModel(String firstAirDate, String overview, String originalLanguage, String genreIds, String posterPath, String originCountry, String backdropPath, String originalName, String popularity, String voteAverage, String name, String id, String voteCount) {
		this.firstAirDate = firstAirDate;
		this.overview = overview;
		this.originalLanguage = originalLanguage;
		this.genreIds = genreIds;
		this.posterPath = posterPath;
		this.originCountry = originCountry;
		this.backdropPath = backdropPath;
		this.originalName = originalName;
		this.popularity = popularity;
		this.voteAverage = voteAverage;
		this.name = name;
		this.id = id;
		this.voteCount = voteCount;
	}

	protected TvShowModel(Parcel in) {
		firstAirDate = in.readString();
		overview = in.readString();
		originalLanguage = in.readString();
		genreIds = in.readString();
		posterPath = in.readString();
		originCountry = in.readString();
		backdropPath = in.readString();
		originalName = in.readString();
		popularity = in.readString();
		voteAverage = in.readString();
		name = in.readString();
		id = in.readString();
		voteCount = in.readString();
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(firstAirDate);
		dest.writeString(overview);
		dest.writeString(originalLanguage);
		dest.writeString(genreIds);
		dest.writeString(posterPath);
		dest.writeString(originCountry);
		dest.writeString(backdropPath);
		dest.writeString(originalName);
		dest.writeString(popularity);
		dest.writeString(voteAverage);
		dest.writeString(name);
		dest.writeString(id);
		dest.writeString(voteCount);
	}

	@Override
	public int describeContents() {
		return 0;
	}

	public static final Creator<TvShowModel> CREATOR = new Creator<TvShowModel>() {
		@Override
		public TvShowModel createFromParcel(Parcel in) {
			return new TvShowModel(in);
		}

		@Override
		public TvShowModel[] newArray(int size) {
			return new TvShowModel[size];
		}
	};

	public void setFirstAirDate(String firstAirDate){
		this.firstAirDate = firstAirDate;
	}

	public String getFirstAirDate(){
		return firstAirDate;
	}

	public void setOverview(String overview){
		this.overview = overview;
	}

	public String getOverview(){
		return overview;
	}

	public void setOriginalLanguage(String originalLanguage){
		this.originalLanguage = originalLanguage;
	}

	public String getOriginalLanguage(){
		return originalLanguage;
	}

	public void setGenreIds(String genreIds){
		this.genreIds = genreIds;
	}

	public String getGenreIds(){
		return genreIds;
	}

	public void setPosterPath(String posterPath){
		this.posterPath = posterPath;
	}

	public String getPosterPath(){
		return posterPath;
	}

	public void setOriginCountry(String originCountry){
		this.originCountry = originCountry;
	}

	public String getOriginCountry(){
		return originCountry;
	}

	public void setBackdropPath(String backdropPath){
		this.backdropPath = backdropPath;
	}

	public String getBackdropPath(){
		return backdropPath;
	}

	public void setOriginalName(String originalName){
		this.originalName = originalName;
	}

	public String getOriginalName(){
		return originalName;
	}

	public void setPopularity(String popularity){
		this.popularity = popularity;
	}

	public String getPopularity(){
		return popularity;
	}

	public void setVoteAverage(String voteAverage){
		this.voteAverage = voteAverage;
	}

	public String getVoteAverage(){
		return voteAverage;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setVoteCount(String voteCount){
		this.voteCount = voteCount;
	}

	public String getVoteCount(){
		return voteCount;
	}

}