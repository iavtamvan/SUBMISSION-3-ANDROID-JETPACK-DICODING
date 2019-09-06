package com.iavariav.submission1.ui.favorite.movie;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.PagedList;

import com.iavariav.submission1.data.MovieTVRepository;
import com.iavariav.submission1.data.remote.entity.MovieEntity;
import com.iavariav.submission1.vo.Resource;

public class MovieFavoriteViewModel extends ViewModel {
    //    List<CourseEntity> getBookmarks() {
//        return DataDummy.generateDummyCourses();
//    }
    private MovieTVRepository academyRepository;

    public MovieFavoriteViewModel(MovieTVRepository mAcademyRepository) {
        this.academyRepository = mAcademyRepository;
    }

    //    LiveData<Resource<List<CourseEntity>>> getBookmarks() {
//        return academyRepository.getBookmarkedCourses();
//    }
    LiveData<Resource<PagedList<MovieEntity>>> getBookmarksPaged() {
        return academyRepository.getBookmarkedCoursesPaged();
    }

    void setBookmark(MovieEntity courseEntity) {
        final boolean newState = !courseEntity.isFavorite();
        academyRepository.setCourseBookmark(courseEntity, newState);
    }
}
