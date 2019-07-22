package com.iavariav.submission1.ui.movie;

import androidx.lifecycle.ViewModel;

import com.iavariav.submission1.data.DeskripsiEntity;
import com.iavariav.submission1.utils.DataDummy;

import java.util.List;

public class MovieViewModel extends ViewModel {

    public List<DeskripsiEntity> getDeskripsi() {
        return DataDummy.generateDummymovie();
    }
}
