package com.iavariav.submission1.ui.tvshow;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.test.espresso.IdlingRegistry;

import com.iavariav.submission1.data.DeskripsiEntity;
import com.iavariav.submission1.data.MovieTVRepository;
import com.iavariav.submission1.data.remote.entity.MovieEntity;
import com.iavariav.submission1.data.remote.entity.TvShowEntity;
import com.iavariav.submission1.ui.movie.MovieViewModel;
import com.iavariav.submission1.utils.DataDummy;
import com.iavariav.submission1.utils.EspressoIdlingResource;
import com.iavariav.submission1.vo.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TvShowViewModelTest {

    private String USERNAME = "Dicoding";

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private TvShowViewModel viewModel;
    private MovieTVRepository academyRepository = mock(MovieTVRepository.class);

    @Before
    public void setUp() {
        viewModel = new TvShowViewModel(academyRepository);
    }

    @Test
    public void getCourses() {
        Resource<List<TvShowEntity>> resource = Resource.success(DataDummy.generateDummytv());
        MutableLiveData<Resource<List<TvShowEntity>>> dummyCourses = new MutableLiveData<>();
        dummyCourses.setValue(resource);

        when(academyRepository.getAllTv()).thenReturn(dummyCourses);

        Observer<Resource<List<TvShowEntity>>> observer = mock(Observer.class);

        viewModel.setUsername(USERNAME);

        viewModel.getCourses.observeForever(observer);

        verify(observer).onChanged(resource);
    }

}