package com.iavariav.submission1.ui.movie;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.iavariav.submission1.data.DeskripsiEntity;
import com.iavariav.submission1.data.MovieTVRepository;
import com.iavariav.submission1.data.remote.entity.MovieEntity;
import com.iavariav.submission1.utils.DataDummy;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MovieViewModelTest {
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private MovieViewModel viewModel;
    private MovieTVRepository academyRepository = mock(MovieTVRepository.class);

    @Before
    public void setUp() {
        viewModel = new MovieViewModel(academyRepository);
    }

    @Test
    public void getCourses() {
        ArrayList<MovieEntity> dummyCourses = DataDummy.generateDummymovie();

        MutableLiveData<List<MovieEntity>> courses = new MutableLiveData<>();
        courses.setValue(dummyCourses);

        when(academyRepository.getAllMovie()).thenReturn(courses);

        Observer<List<MovieEntity>> observer = mock(Observer.class);

        viewModel.getCourses().observeForever(observer);

        verify(observer).onChanged(dummyCourses);
    }
}