package com.iavariav.submission1.ui.tvshow.detail;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.iavariav.submission1.data.MovieTVRepository;
import com.iavariav.submission1.data.remote.entity.MovieEmbed;
import com.iavariav.submission1.data.remote.entity.TvShowEmbed;
import com.iavariav.submission1.data.remote.entity.TvShowEntity;
import com.iavariav.submission1.vo.Resource;

import static android.content.ContentValues.TAG;

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


    //    private CourseEntity mCourse;
//    private String courseId;
    private MovieTVRepository academyRepository;

    private MutableLiveData<String> courseId = new MutableLiveData<>();

    public DetailTVShowViewModel(MovieTVRepository mAcademyRepository) {
        this.academyRepository = mAcademyRepository;
    }
    public LiveData<Resource<TvShowEmbed>> courseModule = Transformations.switchMap(courseId,
            id -> academyRepository.getAllTvDetail(id));

//    LiveData<MovieEntity> getCourse() {
//        return academyRepository.getAllMovieDetail(courseId);
//    }
//    public LiveData<List<ModuleEntity>> getModules() {
//        return academyRepository.getAllModulesByCourse(courseId);
//    }


    public void setCourseId(String courseId) {
        this.courseId.setValue(courseId);
    }

    public String getCourseId() {
        if (courseId.getValue() == null) return null;
        return courseId.getValue();
    }

    void setFavorited() {
        if (courseModule.getValue() != null) {
            TvShowEmbed courseWithModule = courseModule.getValue().data;
            if (courseWithModule != null) {
                TvShowEntity courseEntity = courseWithModule.tvShowEntity;
                Log.e(TAG, "setFavorited: " + courseEntity );
                Log.e(TAG, "setFavorited: " + courseEntity );

//                 Kode di bawah menggunakan tanda seru (!),
//                 karena akan mengganti status dari apakah sudah di bookmark atau tidak menjadi apakah sudah siap dibookmark atau tidak
                final boolean newState = !courseEntity.isFavorite();
                Log.e(TAG, "setFavoritedState: "+newState);
                Log.e(TAG, "setFavoritedState: "+newState);
                academyRepository.setCourseFavorite(courseEntity, newState);
            }
        }
    }
}
