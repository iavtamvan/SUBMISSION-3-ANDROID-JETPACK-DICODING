package com.iavariav.submission1.data.remote.entity;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class MovieEmbed {
    @Embedded
    public MovieEntity mCourse;
}
