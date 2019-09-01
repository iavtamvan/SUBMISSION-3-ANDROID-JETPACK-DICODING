package com.iavariav.submission1.ui.tvshow.detail;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.iavariav.submission1.data.DeskripsiEntity;
import com.iavariav.submission1.data.MovieTVRepository;
import com.iavariav.submission1.data.remote.entity.MovieEntity;
import com.iavariav.submission1.data.remote.entity.TvShowEntity;
import com.iavariav.submission1.utils.DataDummy;

import java.util.List;

public class DetailTVShowViewModel extends ViewModel {
//    private DeskripsiEntity mCourse;
//    private String courseId;
//
//    public DeskripsiEntity getTvShow() {
//        for (int i = 0; i < DataDummy.generateDummytv().size(); i++) {
//            DeskripsiEntity courseEntity = DataDummy.generateDummytv().get(i);
//            if (courseEntity.getId().equals(courseId)) {
//                mCourse = courseEntity;
//            }
//        }
//        return mCourse;
//    }
//
//    public List<DeskripsiEntity> getTvModule() {
//        return DataDummy.generateDummytv();
//    }
//
//    public void setCourseId(String courseId) {
//        this.courseId = courseId;
//    }
//
//    public String getCourseId(){
//        return courseId;
//    }

    private String courseId;
    private MovieTVRepository academyRepository;

    public DetailTVShowViewModel(MovieTVRepository mAcademyRepository) {
        this.academyRepository = mAcademyRepository;
    }
    LiveData<TvShowEntity> getCourse() {
        return academyRepository.getAllTvDetail(courseId);
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
