package com.iavariav.submission1.data.remote;

import android.os.Handler;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.iavariav.submission1.data.remote.response.MovieModel;
import com.iavariav.submission1.data.remote.response.TvShowModel;
import com.iavariav.submission1.utils.EspressoIdlingResource;
import com.iavariav.submission1.utils.JsonHelper;

import java.util.List;

import static androidx.constraintlayout.widget.Constraints.TAG;

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


    public LiveData<ApiResponse<List<MovieModel>>> getMovie() {
        EspressoIdlingResource.increment();
        MutableLiveData<ApiResponse<List<MovieModel>>> resultCourse = new MutableLiveData<>();

        Handler handler = new Handler();
        handler.postDelayed(() -> {
            resultCourse.setValue(ApiResponse.success(jsonHelper.loadMovie()));
            Log.e(TAG, "getMovie: "+ jsonHelper.loadMovie() );
//            Log.e(TAG, "getMovie: "+ jsonHelper.loadMovie() );
            if (!EspressoIdlingResource.getEspressoIdlingResource().isIdleNow()) {
                EspressoIdlingResource.decrement();
            }
        }, SERVICE_LATENCY_IN_MILLIS);

        return resultCourse;
    }


    public LiveData<ApiResponse<List<MovieModel>>> getAllModulesByCourseAsLiveData(String courseId) {

        EspressoIdlingResource.increment();

        MutableLiveData<ApiResponse<List<MovieModel>>> resultModules = new MutableLiveData<>();

        Handler handler = new Handler();
        handler.postDelayed(() -> {
            resultModules.setValue(ApiResponse.success(jsonHelper.loadMovieById(courseId)));
            if (!EspressoIdlingResource.getEspressoIdlingResource().isIdleNow()) {
                EspressoIdlingResource.decrement();
            }
        }, SERVICE_LATENCY_IN_MILLIS);

        return resultModules;
    }


    public LiveData<ApiResponse<List<TvShowModel>>> getTv() {
        EspressoIdlingResource.increment();
        MutableLiveData<ApiResponse<List<TvShowModel>>> resultCourse = new MutableLiveData<>();

        Handler handler = new Handler();
        handler.postDelayed(() -> {
            resultCourse.setValue(ApiResponse.success(jsonHelper.loadTv()));
            Log.e(TAG, "getMovie: "+ jsonHelper.loadMovie() );
//            Log.e(TAG, "getMovie: "+ jsonHelper.loadMovie() );
            if (!EspressoIdlingResource.getEspressoIdlingResource().isIdleNow()) {
                EspressoIdlingResource.decrement();
            }
        }, SERVICE_LATENCY_IN_MILLIS);

        return resultCourse;
    }


    public LiveData<ApiResponse<List<TvShowModel>>> getAllTvById(String courseId) {

        EspressoIdlingResource.increment();

        MutableLiveData<ApiResponse<List<TvShowModel>>> resultModules = new MutableLiveData<>();

        Handler handler = new Handler();
        handler.postDelayed(() -> {
            resultModules.setValue(ApiResponse.success(jsonHelper.loadTvById(courseId)));
            if (!EspressoIdlingResource.getEspressoIdlingResource().isIdleNow()) {
                EspressoIdlingResource.decrement();
            }
        }, SERVICE_LATENCY_IN_MILLIS);

        return resultModules;
    }



//    public void getMovie(LoadMovieCallback callback) {
//        Handler handler = new Handler();
//        handler.postDelayed(() -> callback.onAllCoursesReceived(jsonHelper.loadMovie()), SERVICE_LATENCY_IN_MILLIS);
//    }
//    public void getTv(LoadTvCallback callback) {
//        Handler handler = new Handler();
//        handler.postDelayed(() -> callback.onAllCoursesReceived(jsonHelper.loadTv()), SERVICE_LATENCY_IN_MILLIS);
//    }

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
    public interface LoadTvCallback {
        void onAllCoursesReceived(List<TvShowModel> tvShowModels);

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
