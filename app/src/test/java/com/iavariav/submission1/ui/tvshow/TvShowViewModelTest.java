package com.iavariav.submission1.ui.tvshow;

import com.iavariav.submission1.data.DeskripsiEntity;
import com.iavariav.submission1.ui.movie.MovieViewModel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TvShowViewModelTest {
    private TvShowViewModel viewModel;
    @Before
    public void setUp() {
        viewModel = new TvShowViewModel();
    }

    @After
    public void tearDown() {
    }
    @Test
    public void getDeskripsi() {
        List<DeskripsiEntity> courseEntities = viewModel.getDeskripsi();
        assertNotNull(courseEntities);
        assertEquals(10, courseEntities.size());
    }
}