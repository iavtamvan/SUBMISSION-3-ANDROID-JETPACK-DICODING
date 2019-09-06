package com.iavariav.submission1.data.room;

import androidx.annotation.WorkerThread;
import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.iavariav.submission1.data.remote.entity.MovieEntity;
import com.iavariav.submission1.data.remote.entity.MovieWithTv;
import com.iavariav.submission1.data.remote.entity.TvShowEntity;

import java.util.List;

@Dao
public interface MovieTvDao {
    @WorkerThread
    @Query("SELECT * FROM movieEntity")
    LiveData<List<MovieEntity>> getAllMovie();

    @Transaction
    @Query("SELECT * FROM movieEntity WHERE id = :courseId")
    LiveData<MovieWithTv> getAllMovieByid(String courseId);

    @WorkerThread
    @Query("SELECT * FROM movieEntity where favorite = 1")
    LiveData<List<MovieEntity>> getFavMovie();

    @WorkerThread
    @Query("SELECT * FROM movieEntity where favorite = 1")
    DataSource.Factory<Integer, MovieEntity> getFavMoviePage();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAllMovie(List<MovieEntity> list);

    @Update(onConflict = OnConflictStrategy.FAIL)
    int updateCourse(MovieEntity course);



    @WorkerThread
    @Query("SELECT * FROM tvshowentity")
    LiveData<List<TvShowEntity>> getAllTv();

    @Transaction
    @Query("SELECT * FROM tvshowentity WHERE id = :courseId")
    LiveData<TvShowEntity> getAllTvByid(String courseId);

    @WorkerThread
    @Query("SELECT * FROM tvshowentity where favorite = 1")
    LiveData<List<TvShowEntity>> getFavTv();

    @WorkerThread
    @Query("SELECT * FROM movieEntity where favorite = 1")
    DataSource.Factory<Integer, TvShowEntity> getFavTvPage();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAllTv(List<TvShowEntity> list);

    @Update(onConflict = OnConflictStrategy.FAIL)
    int updateTv(TvShowEntity course);







//    @WorkerThread
//    @Query("SELECT * FROM tvEntity")
//    LiveData<List<TvShowEntity>> getAllTv();
//
//    @WorkerThread
//    @Query("SELECT * FROM tvEntity where favorite = 1")
//    LiveData<List<TvShowEntity>> getFavTv();
//
//    @Insert(onConflict = OnConflictStrategy.IGNORE)
//    void insertAllTv(List<TvShowEntity> list);

//    @Query("SELECT * FROM courseentities where bookmarked = 1")
//    DataSource.Factory<Integer, CourseEntity> getBookmarkedCourseAsPaged();
//
//    @Transaction
//    @Query("SELECT * FROM courseentities WHERE courseId = :courseId")
//    LiveData<CourseWithModule> getCourseWithModuleById(String courseId);
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    long[] insertMovie(List<CourseEntity> courses);
//
//    @Update(onConflict = OnConflictStrategy.FAIL)
//    int updateCourse(CourseEntity course);
//
//    @Query("SELECT * FROM moduleentities WHERE courseId = :courseId")
//    LiveData<List<ModuleEntity>> getModulesByCourseId(String courseId);
//
//    @Query("SELECT * FROM moduleentities WHERE moduleId = :moduleId")
//    LiveData<ModuleEntity> getModuleById(String moduleId);
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    long[] insertModules(List<ModuleEntity> module);
//
//    @Update
//    int updateModule(ModuleEntity module);
//
//    @Query("UPDATE moduleentities SET content = :content WHERE moduleId = :moduleId")
//    int updateModuleByContent(String content, String moduleId);
}
