package com.iavariav.submission1.ui.movie.detail;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.test.espresso.IdlingRegistry;

import com.iavariav.submission1.data.MovieTVRepository;
import com.iavariav.submission1.data.remote.entity.MovieEmbed;
import com.iavariav.submission1.data.remote.entity.MovieEntity;
import com.iavariav.submission1.utils.DataDummy;
import com.iavariav.submission1.utils.EspressoIdlingResource;
import com.iavariav.submission1.vo.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class DetailMovieViewModelTest {
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private DetailMovieViewModel viewModel;
    private MovieTVRepository academyRepository = mock(MovieTVRepository.class);
    private MovieEntity dummyCourse = DataDummy.generateDummymovie().get(0);
    private String courseId = dummyCourse.getId();


    @Before
    public void setUp() {
        viewModel = new DetailMovieViewModel(academyRepository);
        viewModel.setCourseId(courseId);
    }

    @Test
    public void getCourseWithModule() {
        Resource<MovieEmbed> resource = Resource.success(DataDummy.generateDummyCourseWithModules(dummyCourse, true));
        MutableLiveData<Resource<MovieEmbed>> courseEntities = new MutableLiveData<>();
        courseEntities.setValue(resource);

        when(academyRepository.getAllMovieDetail(courseId)).thenReturn(courseEntities);

        Observer<Resource<MovieEmbed>> observer = mock(Observer.class);
        viewModel.courseModule.observeForever(observer);

        verify(observer).onChanged(resource);
    }
}