package com.iavariav.submission1.data;

import androidx.lifecycle.LiveData;
import androidx.paging.PagedList;

import com.iavariav.submission1.data.remote.entity.MovieEntity;
import com.iavariav.submission1.data.remote.entity.MovieWithTv;
import com.iavariav.submission1.data.remote.entity.TvShowEntity;
import com.iavariav.submission1.data.remote.response.MovieModel;
import com.iavariav.submission1.data.remote.response.TvShowModel;
import com.iavariav.submission1.vo.Resource;

import java.util.List;

public interface MovieTVDataSource {

    LiveData<Resource<List<MovieEntity>>> getAllMovie();
    LiveData<Resource<MovieWithTv>> getAllMovieDetail(String courseId);
    void setCourseBookmark(MovieEntity course, boolean state);
    LiveData<Resource<PagedList<MovieEntity>>> getBookmarkedCoursesPaged();



    LiveData<Resource<List<TvShowEntity>>> getAllTv();
    LiveData<Resource<TvShowEntity>> getAllTvDetail(String courseId);
    void setCourseFavorite(TvShowEntity course, boolean state);

//    LiveData<DeskripsiEntity> getCourseWithModules(String courseId);
//
//    LiveData<List<DeskripsiEntity>> getAllModulesByCourse(String courseId);
//
//    LiveData<List<DeskripsiEntity>> getBookmarkedCourses();
//
//    LiveData<DeskripsiEntity> getContent(String courseId, String moduleId);


}
