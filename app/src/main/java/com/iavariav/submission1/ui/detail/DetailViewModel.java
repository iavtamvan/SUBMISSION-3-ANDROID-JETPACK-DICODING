package com.iavariav.submission1.ui.detail;

import androidx.lifecycle.ViewModel;

import com.iavariav.submission1.data.DeskripsiEntity;
import com.iavariav.submission1.utils.DataDummy;

import java.util.List;

public class DetailViewModel extends ViewModel {
    private DeskripsiEntity mCourse;
    private String courseId;

    public DeskripsiEntity getMovie() {
        for (int i = 0; i < DataDummy.generateDummymovie().size(); i++) {
            DeskripsiEntity courseEntity = DataDummy.generateDummymovie().get(i);
            if (courseEntity.getId().equals(courseId)) {
                mCourse = courseEntity;
            }
        }
        return mCourse;
    }

    public List<DeskripsiEntity> getModules() {
        return DataDummy.generateDummymovie();
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseId(){
        return courseId;
    }
}
