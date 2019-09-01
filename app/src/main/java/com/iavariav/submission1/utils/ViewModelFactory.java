package com.iavariav.submission1.utils;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.iavariav.submission1.data.MovieTVRepository;
import com.iavariav.submission1.di.Injection;
import com.iavariav.submission1.ui.movie.MovieViewModel;
import com.iavariav.submission1.ui.movie.detail.DetailMovieActivity;
import com.iavariav.submission1.ui.movie.detail.DetailMovieViewModel;
import com.iavariav.submission1.ui.tvshow.TvShowViewModel;
import com.iavariav.submission1.ui.tvshow.detail.DetailTVShowViewModel;

public class ViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private static volatile ViewModelFactory INSTANCE;

    private final MovieTVRepository mAcademyRepository;

    private ViewModelFactory(MovieTVRepository academyRepository) {
        mAcademyRepository = academyRepository;
    }

    public static ViewModelFactory getInstance(Application application) {
        if (INSTANCE == null) {
            synchronized (ViewModelFactory.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ViewModelFactory(Injection.provideRepository(application));
                }
            }
        }
        return INSTANCE;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {

        if (modelClass.isAssignableFrom(MovieViewModel.class)) {
            //noinspection unchecked
            return (T) new MovieViewModel(mAcademyRepository);
        }
        else if (modelClass.isAssignableFrom(TvShowViewModel.class)) {
            //noinspection unchecked
            return (T) new TvShowViewModel(mAcademyRepository);
        }
        else if (modelClass.isAssignableFrom(DetailMovieViewModel.class)) {
            //noinspection unchecked
            return (T) new DetailMovieViewModel(mAcademyRepository);
        }
        else if (modelClass.isAssignableFrom(DetailTVShowViewModel.class)) {
            //noinspection unchecked
            return (T) new DetailTVShowViewModel(mAcademyRepository);
        }

        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }
}
