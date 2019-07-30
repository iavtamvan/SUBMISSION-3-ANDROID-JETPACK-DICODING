package com.iavariav.submission1.ui.movie;

import com.iavariav.submission1.data.DeskripsiEntity;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MovieViewModelTest {
    private MovieViewModel viewModel;
    @Before
    public void setUp() {
        viewModel = new MovieViewModel();
    }

    @Test
    public void getDeskripsi() {
        List<DeskripsiEntity> courseEntities = viewModel.getDeskripsi();
        assertNotNull(courseEntities);
        assertEquals(10, courseEntities.size());
    }
}