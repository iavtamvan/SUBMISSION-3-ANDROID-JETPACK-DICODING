package com.iavariav.submission1.ui.movie;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.iavariav.submission1.data.MovieTVRepository;
import com.iavariav.submission1.data.remote.response.MovieModel;

import java.util.List;

public class MovieViewModel extends ViewModel {


    private MovieTVRepository academyRepository;

    public MovieViewModel(MovieTVRepository mAcademyRepository) {
        this.academyRepository = mAcademyRepository;
    }

    LiveData<List<MovieModel>> getCourses() {
        return academyRepository.getAllMovie();
    }
}
