package com.iavariav.submission1.ui.tvshow.detail;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.iavariav.submission1.data.DeskripsiEntity;
import com.iavariav.submission1.data.MovieTVRepository;
import com.iavariav.submission1.data.remote.entity.MovieEntity;
import com.iavariav.submission1.data.remote.entity.TvShowEntity;
import com.iavariav.submission1.ui.movie.detail.DetailMovieViewModel;
import com.iavariav.submission1.utils.DataDummy;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class DetailTVShowViewModelTest {
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private DetailTVShowViewModel viewModel;
    private MovieTVRepository academyRepository = mock(MovieTVRepository.class);
    private TvShowEntity dummyCourse = DataDummy.generateDummytv().get(0);
    private String courseId = dummyCourse.getId();

    //    private ArrayList<MovieEntity> dummyModules = DataDummy.generateDummymovie(courseId);
    @Before
    public void setUp() {
        viewModel = new DetailTVShowViewModel(academyRepository);
        viewModel.setCourseId(courseId);
    }

//    @After
//    public void tearDown() {
//    }

    @Test
    public void getCourse() {
        MutableLiveData<TvShowEntity> courseEntities = new MutableLiveData<>();
        courseEntities.setValue(dummyCourse);

        when(academyRepository.getAllTvDetail(courseId)).thenReturn(courseEntities);

        Observer<TvShowEntity> observer = mock(Observer.class);

        viewModel.getCourse().observeForever(observer);

        verify(observer).onChanged(dummyCourse);
    }


}