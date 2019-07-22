package com.iavariav.submission1.ui.tvshow;

import androidx.lifecycle.ViewModel;

import com.iavariav.submission1.data.DeskripsiEntity;
import com.iavariav.submission1.utils.DataDummy;

import java.util.List;

public class TvShowViewModel extends ViewModel {

    public List<DeskripsiEntity> getDeskripsi() {
        return DataDummy.generateDummymovie();
    }
}
