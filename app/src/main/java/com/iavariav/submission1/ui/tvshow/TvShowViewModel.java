package com.iavariav.submission1.ui.tvshow;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.iavariav.submission1.data.DeskripsiEntity;
import com.iavariav.submission1.data.MovieTVRepository;
import com.iavariav.submission1.data.remote.entity.TvShowEntity;
import com.iavariav.submission1.data.remote.response.MovieModel;
import com.iavariav.submission1.data.remote.response.TvShowModel;
import com.iavariav.submission1.utils.DataDummy;

import java.util.List;

public class TvShowViewModel extends ViewModel {

    private MovieTVRepository academyRepository;

    public TvShowViewModel(MovieTVRepository mAcademyRepository) {
        this.academyRepository = mAcademyRepository;
    }

    LiveData<List<TvShowEntity>> getCourses() {
        return academyRepository.getAllTv();
    }
}
