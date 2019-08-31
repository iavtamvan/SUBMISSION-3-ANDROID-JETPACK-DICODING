package com.iavariav.submission1.data.remote;

import android.os.Handler;

import com.iavariav.submission1.data.remote.response.MovieModel;
import com.iavariav.submission1.utils.JsonHelper;

import java.util.List;

public class RemoteRepository {

    private static RemoteRepository INSTANCE;
    private JsonHelper jsonHelper;
    private final long SERVICE_LATENCY_IN_MILLIS = 2000;

    private RemoteRepository(JsonHelper jsonHelper) {
        this.jsonHelper = jsonHelper;
    }

    public static RemoteRepository getInstance(JsonHelper helper) {
        if (INSTANCE == null) {
            INSTANCE = new RemoteRepository(helper);
        }
        return INSTANCE;
    }

    public void getMovie(LoadMovieCallback callback) {
        Handler handler = new Handler();
        handler.postDelayed(() -> callback.onAllCoursesReceived(jsonHelper.loadCourses()), SERVICE_LATENCY_IN_MILLIS);
    }

//    public void getModules(String courseId, LoadModulesCallback callback) {
//        Handler handler = new Handler();
//        handler.postDelayed(() -> callback.onAllModulesReceived(jsonHelper.loadModule(courseId)), SERVICE_LATENCY_IN_MILLIS);
//    }
//
//    public void getContent(String moduleId, GetContentCallback callback) {
//        Handler handler = new Handler();
//        handler.postDelayed(() -> callback.onContentReceived(jsonHelper.loadContent(moduleId)), SERVICE_LATENCY_IN_MILLIS);
//    }

    public interface LoadMovieCallback {
        void onAllCoursesReceived(List<MovieModel> movieModels);

        void onDataNotAvailable();
    }

//    public interface LoadModulesCallback {
//        void onAllModulesReceived(List<ModuleResponse> moduleResponses);
//
//        void onDataNotAvailable();
//    }
//
//    public interface GetContentCallback {
//        void onContentReceived(ContentResponse contentResponse);
//
//        void onDataNotAvailable();
//    }
}
