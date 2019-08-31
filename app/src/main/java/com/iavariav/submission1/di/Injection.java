package com.iavariav.submission1.di;

import android.app.Application;

import com.iavariav.submission1.data.MovieTVRepository;
import com.iavariav.submission1.data.remote.RemoteRepository;
import com.iavariav.submission1.utils.JsonHelper;

public class Injection {
        public static MovieTVRepository provideRepository(Application application) {

            RemoteRepository remoteRepository = RemoteRepository.getInstance(new JsonHelper(application));

            return MovieTVRepository.getInstance(remoteRepository);
        }
    }

