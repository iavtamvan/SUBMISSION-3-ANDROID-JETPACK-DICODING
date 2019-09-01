package com.iavariav.submission1.data;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.iavariav.submission1.data.remote.RemoteRepository;
import com.iavariav.submission1.data.remote.response.MovieModel;
import com.iavariav.submission1.data.remote.response.TvShowModel;

import java.util.ArrayList;
import java.util.List;

public class MovieTVRepository implements MovieTVDataSource{
    private volatile static MovieTVRepository INSTANCE = null;

    private final RemoteRepository remoteRepository;

    public MovieTVRepository(@NonNull RemoteRepository remoteRepository) {
        this.remoteRepository = remoteRepository;
    }

    public static MovieTVRepository getInstance(RemoteRepository remoteData) {
        if (INSTANCE == null) {
            synchronized (MovieTVRepository.class) {
                if (INSTANCE == null) {
                    INSTANCE = new MovieTVRepository(remoteData);
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public LiveData<List<MovieModel>> getAllMovie() {
        MutableLiveData<List<MovieModel>> courseResults = new MutableLiveData<>();

        remoteRepository.getMovie(new RemoteRepository.LoadMovieCallback() {
            @Override
            public void onAllCoursesReceived(List<MovieModel> courseResponses) {
                ArrayList<MovieModel> courseList = new ArrayList<>();
                for (int i = 0; i < courseResponses.size(); i++) {
                    MovieModel response = courseResponses.get(i);
                    MovieModel course = new MovieModel(response.getPopularity(),
                            response.getVote_count(),
                            response.getVideo(),
                            response.getPoster_path(),
                            response.getId(),
                            response.getAdult(),
                            response.getBackdrop_path(),
                            response.getOriginal_language(),
                            response.getOriginal_title(),
                            response.getGenre_ids(),
                            response.getTitle(),
                            response.getVote_average(),
                            response.getOverview(),
                            response.getRelease_date()
                            );

                    courseList.add(course);
                }
                courseResults.postValue(courseList);
            }

            @Override
            public void onDataNotAvailable() {

            }
        });
        return courseResults;
    }
    @Override
    public LiveData<List<TvShowModel>> getAllTv() {
        MutableLiveData<List<TvShowModel>> courseResults = new MutableLiveData<>();

        remoteRepository.getTv(new RemoteRepository.LoadTvCallback() {
            @Override
            public void onAllCoursesReceived(List<TvShowModel> courseResponses) {
                ArrayList<TvShowModel> courseList = new ArrayList<>();
                for (int i = 0; i < courseResponses.size(); i++) {
                    TvShowModel response = courseResponses.get(i);
                    TvShowModel course = new TvShowModel(
                            response.getFirstAirDate(),
                            response.getOverview(),
                            response.getOriginalLanguage(),
                            response.getGenreIds(),
                            response.getPosterPath(),
                            response.getOriginCountry(),
                            response.getBackdropPath(),
                            response.getOriginalName(),
                            response.getPopularity(),
                            response.getVoteAverage(),
                            response.getName(),
                            response.getId(),
                            response.getVoteCount()
                            );

                    courseList.add(course);
                }
                courseResults.postValue(courseList);
            }

            @Override
            public void onDataNotAvailable() {

            }
        });
        return courseResults;
    }

}
