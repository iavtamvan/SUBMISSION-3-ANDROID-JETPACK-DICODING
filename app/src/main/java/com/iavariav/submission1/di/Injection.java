package com.iavariav.submission1.di;

import android.app.Application;

import com.iavariav.submission1.data.LocalRepository;
import com.iavariav.submission1.data.MovieTVRepository;
import com.iavariav.submission1.data.remote.RemoteRepository;
import com.iavariav.submission1.data.room.MovieTvDatabase;
import com.iavariav.submission1.utils.AppExecutors;
import com.iavariav.submission1.utils.JsonHelper;

public class Injection {
    public static MovieTVRepository provideRepository(Application application) {

        MovieTvDatabase database = MovieTvDatabase.getInstance(application);

        LocalRepository localRepository = LocalRepository.getInstance(database.academyDao());
        RemoteRepository remoteRepository = RemoteRepository.getInstance(new JsonHelper(application));
        AppExecutors appExecutors = new AppExecutors();

        return MovieTVRepository.getInstance(localRepository, remoteRepository, appExecutors);
    }
}

