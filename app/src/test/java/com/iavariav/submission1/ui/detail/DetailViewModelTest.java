package com.iavariav.submission1.ui.detail;

import com.iavariav.submission1.data.DeskripsiEntity;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class DetailViewModelTest {
    private DetailViewModel viewModel;
    private DeskripsiEntity dummyEntity;


    @Before
    public void setUp() {
        viewModel = new DetailViewModel();
        dummyEntity = (new DeskripsiEntity("420818",
                "https://image.tmdb.org/t/p/w500/dzBtMocZuJbjLOXvrl4zGYigDzh.jpg",
                "The Lion King",
                "Simba idolises his father, King Mufasa, and takes to heart his own royal destiny. But not everyone in the kingdom celebrates the new cub's arrival. Scar, Mufasa's brother—and former heir to the throne—has plans of his own. The battle for Pride Rock is ravaged with betrayal, tragedy and drama, ultimately resulting in Simba's exile. With help from a curious pair of newfound friends, Simba will have to figure out how to grow up and take back what is rightfully his.",
                "2019-07-12"));
    }

    @After
    public void tearDown() {
    }

    @Test
    public void getCourse() {
        viewModel.setCourseId(dummyEntity.getId());
        DeskripsiEntity entity = viewModel.getMovie();
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
        List<DeskripsiEntity> moduleEntities = viewModel.getModules();
        assertNotNull(moduleEntities);
        assertEquals(10, moduleEntities.size());
    }



}