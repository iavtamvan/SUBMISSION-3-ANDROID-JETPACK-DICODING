package com.iavariav.submission1.ui.movie;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.iavariav.submission1.data.MovieTVRepository;
import com.iavariav.submission1.data.remote.entity.MovieEntity;
import com.iavariav.submission1.data.remote.response.MovieModel;
import com.iavariav.submission1.vo.Resource;

import java.util.List;

public class MovieViewModel extends ViewModel {


    private MovieTVRepository academyRepository;

    private MutableLiveData<String> mLogin = new MutableLiveData<>();

    public MovieViewModel(MovieTVRepository mAcademyRepository) {
        this.academyRepository = mAcademyRepository;
    }

//    LiveData<Resource<List<MovieEntity>>> getCourses() {
//        return academyRepository.getAllMovie();
//    }
    LiveData<Resource<List<MovieEntity>>> getCourses = Transformations.switchMap(mLogin,
            data -> academyRepository.getAllMovie());


    void setUsername(String username) {
        mLogin.setValue(username);
    }

}
