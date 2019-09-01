package com.iavariav.submission1.ui.movie.detail;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.iavariav.submission1.data.MovieTVRepository;
import com.iavariav.submission1.data.remote.entity.MovieEntity;
import com.iavariav.submission1.utils.DataDummy;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

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

    //    private ArrayList<MovieEntity> dummyModules = DataDummy.generateDummymovie(courseId);
    @Before
    public void setUp() {
        viewModel = new DetailMovieViewModel(academyRepository);
        viewModel.setCourseId(courseId);
    }

//    @After
//    public void tearDown() {
//    }

    @Test
    public void getCourse() {
        MutableLiveData<MovieEntity> courseEntities = new MutableLiveData<>();
        courseEntities.setValue(dummyCourse);

        when(academyRepository.getAllMovieDetail(courseId)).thenReturn(courseEntities);

        Observer<MovieEntity> observer = mock(Observer.class);

        viewModel.getCourse().observeForever(observer);

        verify(observer).onChanged(dummyCourse);
    }

}