package com.iavariav.submission1.data.remote.entity;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class MovieWithTv {
    @Embedded
    public MovieEntity mCourse;

//    @Relation(parentColumn = "id", entityColumn = "id")
//    public List<MovieWithTv> mModules;

}
