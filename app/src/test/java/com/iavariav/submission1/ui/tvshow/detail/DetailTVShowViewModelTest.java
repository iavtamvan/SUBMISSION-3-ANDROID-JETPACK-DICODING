package com.iavariav.submission1.ui.tvshow.detail;

import com.iavariav.submission1.data.DeskripsiEntity;
import com.iavariav.submission1.ui.movie.detail.DetailMovieViewModel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class DetailTVShowViewModelTest {
    private DetailTVShowViewModel viewModel;
    private DeskripsiEntity dummyEntity;


    @Before
    public void setUp() {
        viewModel = new DetailTVShowViewModel();
        dummyEntity = (new DeskripsiEntity("11634",
                "https://image.tmdb.org/t/p/w500/b71BaRjp9TwxUZodLGgSRIlkfL8.jpg",
                "See No Evil: The Moors Murders",
                "The dramatisation of one of the most notorious killing sprees in British history.",
                "2006-05-14"));
    }

    @After
    public void tearDown() {
    }

    @Test
    public void getCourse() {
        viewModel.setCourseId(dummyEntity.getId());
        DeskripsiEntity entity = viewModel.getTvShow();
        assertNotNull(entity);
        assertEquals(dummyEntity.getId(), entity.getId());
        assertEquals(dummyEntity.getImageURL(), entity.getImageURL());
        assertEquals(dummyEntity.gettitle(), entity.gettitle());
        assertEquals(dummyEntity.getDeskripsi(), entity.getDeskripsi());
        assertEquals(dummyEntity.getreleaseDate(), entity.getreleaseDate());
    }

    @Test
    public void getModules() {
        viewModel.setCourseId(dummyEntity.getId());
        List<DeskripsiEntity> moduleEntities = viewModel.getTvModule();
        assertNotNull(moduleEntities);
        assertEquals(10, moduleEntities.size());
    }

}