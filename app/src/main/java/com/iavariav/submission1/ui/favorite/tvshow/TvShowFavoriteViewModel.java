package com.iavariav.submission1.ui.favorite.tvshow;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.PagedList;

import com.iavariav.submission1.data.MovieTVRepository;
import com.iavariav.submission1.data.remote.entity.MovieEntity;
import com.iavariav.submission1.data.remote.entity.TvShowEntity;
import com.iavariav.submission1.vo.Resource;

public class TvShowFavoriteViewModel extends ViewModel {
    //    List<CourseEntity> getBookmarks() {
//        return DataDummy.generateDummyCourses();
//    }
    private MovieTVRepository academyRepository;

    public TvShowFavoriteViewModel(MovieTVRepository mAcademyRepository) {
        this.academyRepository = mAcademyRepository;
    }

    //    LiveData<Resource<List<CourseEntity>>> getBookmarks() {
//        return academyRepository.getBookmarkedCourses();
//    }
    LiveData<Resource<PagedList<TvShowEntity>>> getBookmarksPaged() {
        return academyRepository.getBookmarkedTvShowPaged();
    }

    void setBookmark(TvShowEntity courseEntity) {
        final boolean newState = !courseEntity.isFavorite();
        academyRepository.setCourseFavorite(courseEntity, newState);
    }
}
