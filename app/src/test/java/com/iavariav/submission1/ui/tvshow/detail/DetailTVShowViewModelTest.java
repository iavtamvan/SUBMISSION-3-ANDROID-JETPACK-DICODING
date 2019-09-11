package com.iavariav.submission1.ui.tvshow.detail;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.test.espresso.IdlingRegistry;

import com.iavariav.submission1.data.DeskripsiEntity;
import com.iavariav.submission1.data.MovieTVRepository;
import com.iavariav.submission1.data.remote.entity.MovieEmbed;
import com.iavariav.submission1.data.remote.entity.MovieEntity;
import com.iavariav.submission1.data.remote.entity.TvShowEmbed;
import com.iavariav.submission1.data.remote.entity.TvShowEntity;
import com.iavariav.submission1.ui.movie.detail.DetailMovieViewModel;
import com.iavariav.submission1.ui.tvshow.TvShowViewModel;
import com.iavariav.submission1.utils.DataDummy;
import com.iavariav.submission1.utils.EspressoIdlingResource;
import com.iavariav.submission1.vo.Resource;

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


    @Before
    public void setUp() {
        viewModel = new DetailTVShowViewModel(academyRepository);
        viewModel.setCourseId(courseId);
    }
    @Test
    public void getCourseWithModule() {
        Resource<TvShowEmbed> resource = Resource.success(DataDummy.generateDummyTvWithModules(dummyCourse, true));
        MutableLiveData<Resource<TvShowEmbed>> courseEntities = new MutableLiveData<>();
        courseEntities.setValue(resource);

        when(academyRepository.getAllTvDetail(courseId)).thenReturn(courseEntities);

        Observer<Resource<TvShowEmbed>> observer = mock(Observer.class);
        viewModel.courseModule.observeForever(observer);

        verify(observer).onChanged(resource);
    }


}