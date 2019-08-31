package com.iavariav.submission1.data;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.iavariav.submission1.data.remote.RemoteRepository;
import com.iavariav.submission1.data.remote.response.MovieModel;

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

}
