package com.iavariav.submission1.ui.movie.detail;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.iavariav.submission1.data.DeskripsiEntity;
import com.iavariav.submission1.data.MovieTVRepository;
import com.iavariav.submission1.data.remote.entity.MovieEntity;
import com.iavariav.submission1.data.remote.response.MovieModel;
import com.iavariav.submission1.utils.DataDummy;

import java.util.List;

public class DetailMovieViewModel extends ViewModel {
//    private DeskripsiEntity mCourse;
//    private String courseId;
//
//    public DeskripsiEntity getMovie() {
//        for (int i = 0; i < DataDummy.generateDummymovie().size(); i++) {
//            DeskripsiEntity courseEntity = DataDummy.generateDummymovie().get(i);
//            if (courseEntity.getId().equals(courseId)) {
//                mCourse = courseEntity;
//            }
//        }
//        return mCourse;
//    }
//
//    public List<DeskripsiEntity> getMoviewModule() {
//        return DataDummy.generateDummymovie();
//    }
//
//    public void setCourseId(String courseId) {
//        this.courseId = courseId;
//    }
//
//    public String getCourseId(){
//        return courseId;
//    }

//    private CourseEntity mCourse;
    private String courseId;
    private MovieTVRepository academyRepository;

    public DetailMovieViewModel(MovieTVRepository mAcademyRepository) {
        this.academyRepository = mAcademyRepository;
    }
    LiveData<MovieEntity> getCourse() {
        return academyRepository.getAllMovieDetail(courseId);
    }
//    public LiveData<List<ModuleEntity>> getModules() {
//        return academyRepository.getAllModulesByCourse(courseId);
//    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseId(){
        return courseId;
    }
}
