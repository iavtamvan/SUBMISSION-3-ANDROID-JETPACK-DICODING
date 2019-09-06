package com.iavariav.submission1.data;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;

import com.iavariav.submission1.data.remote.entity.MovieEntity;
import com.iavariav.submission1.data.remote.entity.MovieWithTv;
import com.iavariav.submission1.data.remote.entity.TvShowEntity;
import com.iavariav.submission1.data.room.MovieTvDao;

import java.util.List;

import static android.content.ContentValues.TAG;

public class LocalRepository {
    private final MovieTvDao mAcademyDao;

    private LocalRepository(MovieTvDao mAcademyDao) {
        this.mAcademyDao = mAcademyDao;
    }

    private static LocalRepository INSTANCE;

    public static LocalRepository getInstance(MovieTvDao academyDao) {
        if (INSTANCE == null) {
            INSTANCE = new LocalRepository(academyDao);
        }
        return INSTANCE;
    }

    public LiveData<List<MovieEntity>> getAllCourses() {
        return mAcademyDao.getAllMovie();
    }

    public LiveData<MovieWithTv> getCourseWithModules(final String courseId) {
        return mAcademyDao.getAllMovieByid(courseId);
    }

    public void setCourseBookmark(MovieEntity course, boolean newState) {
        course.setFavorite(newState);
        mAcademyDao.updateCourse(course);
        Log.e(TAG, "setCourseBookmark: "+course.getOverview() );
        Log.e(TAG, "setCourseBookmark: "+course.getOverview() );
    }

    public void insertMovie(List<MovieEntity> courses) {
        mAcademyDao.insertAllMovie(courses);
    }

    public DataSource.Factory<Integer, MovieEntity> getBookmarkedCoursesPaged() {
        return mAcademyDao.getFavMoviePage();
    }




    // baatas fitur

    public LiveData<List<TvShowEntity>> getAllTv() {
        return mAcademyDao.getAllTv();
    }

    public LiveData<TvShowEntity> getCourseWithTv(final String courseId) {
        return mAcademyDao.getAllTvByid(courseId);
    }

    public void setCourseFavoriteTv(TvShowEntity course, boolean newState) {
        course.setFavorite(newState);
        mAcademyDao.updateTv(course);
    }

    public DataSource.Factory<Integer, TvShowEntity> getFavTvPage() {
        return mAcademyDao.getFavTvPage();
    }

    public void insertTv(List<TvShowEntity> courses) {
        mAcademyDao.insertAllTv(courses);
    }


}
