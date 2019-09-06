package com.iavariav.submission1.ui.tvshow;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.iavariav.submission1.data.DeskripsiEntity;
import com.iavariav.submission1.data.MovieTVRepository;
import com.iavariav.submission1.data.remote.entity.MovieEntity;
import com.iavariav.submission1.data.remote.entity.TvShowEntity;
import com.iavariav.submission1.data.remote.response.MovieModel;
import com.iavariav.submission1.data.remote.response.TvShowModel;
import com.iavariav.submission1.utils.DataDummy;
import com.iavariav.submission1.vo.Resource;

import java.util.List;

public class TvShowViewModel extends ViewModel {

    private MovieTVRepository academyRepository;

    private MutableLiveData<String> mLogin = new MutableLiveData<>();

    public TvShowViewModel(MovieTVRepository mAcademyRepository) {
        this.academyRepository = mAcademyRepository;
    }

    LiveData<Resource<List<TvShowEntity>>> getCourses = Transformations.switchMap(mLogin,
            data -> academyRepository.getAllTv());


    void setUsername(String username) {
        mLogin.setValue(username);
    }
}
