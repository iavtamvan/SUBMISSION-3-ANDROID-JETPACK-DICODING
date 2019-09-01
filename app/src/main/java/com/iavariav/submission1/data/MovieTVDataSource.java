package com.iavariav.submission1.data;

import androidx.lifecycle.LiveData;

import com.iavariav.submission1.data.remote.response.MovieModel;
import com.iavariav.submission1.data.remote.response.TvShowModel;

import java.util.List;

public interface MovieTVDataSource {

    LiveData<List<MovieModel>> getAllMovie();
    LiveData<List<TvShowModel>> getAllTv();

//    LiveData<DeskripsiEntity> getCourseWithModules(String courseId);
//
//    LiveData<List<DeskripsiEntity>> getAllModulesByCourse(String courseId);
//
//    LiveData<List<DeskripsiEntity>> getBookmarkedCourses();
//
//    LiveData<DeskripsiEntity> getContent(String courseId, String moduleId);


}
