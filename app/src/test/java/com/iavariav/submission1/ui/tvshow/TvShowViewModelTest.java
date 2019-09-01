package com.iavariav.submission1.ui.tvshow;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.iavariav.submission1.data.DeskripsiEntity;
import com.iavariav.submission1.data.MovieTVRepository;
import com.iavariav.submission1.data.remote.entity.MovieEntity;
import com.iavariav.submission1.data.remote.entity.TvShowEntity;
import com.iavariav.submission1.ui.movie.MovieViewModel;
import com.iavariav.submission1.utils.DataDummy;

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
        ArrayList<TvShowEntity> dummyCourses = DataDummy.generateDummytv();

        MutableLiveData<List<TvShowEntity>> courses = new MutableLiveData<>();
        courses.setValue(dummyCourses);

        when(academyRepository.getAllTv()).thenReturn(courses);

        Observer<List<TvShowEntity>> observer = mock(Observer.class);

        viewModel.getCourses().observeForever(observer);

        verify(observer).onChanged(dummyCourses);
    }
}