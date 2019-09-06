package com.iavariav.submission1.data;

import androidx.lifecycle.LiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.iavariav.submission1.data.remote.ApiResponse;
import com.iavariav.submission1.data.remote.RemoteRepository;
import com.iavariav.submission1.data.remote.entity.MovieEmbed;
import com.iavariav.submission1.data.remote.entity.MovieEntity;
import com.iavariav.submission1.data.remote.entity.TvShowEmbed;
import com.iavariav.submission1.data.remote.entity.TvShowEntity;
import com.iavariav.submission1.data.remote.response.MovieModel;
import com.iavariav.submission1.data.remote.response.TvShowModel;
import com.iavariav.submission1.utils.AppExecutors;
import com.iavariav.submission1.vo.Resource;

import java.util.ArrayList;
import java.util.List;

public class MovieTVRepository implements MovieTVDataSource{
    private volatile static MovieTVRepository INSTANCE = null;

    private final LocalRepository localRepository;
    private final RemoteRepository remoteRepository;
    private final AppExecutors appExecutors;

    public MovieTVRepository(LocalRepository localRepository, RemoteRepository remoteRepository, AppExecutors appExecutors) {
        this.localRepository = localRepository;
        this.remoteRepository = remoteRepository;
        this.appExecutors = appExecutors;
    }

    public static MovieTVRepository getInstance(LocalRepository localRepository, RemoteRepository remoteData, AppExecutors appExecutors) {
        if (INSTANCE == null) {
            synchronized (MovieTVRepository.class) {
                if (INSTANCE == null) {
                    INSTANCE = new MovieTVRepository(localRepository, remoteData, appExecutors);
                }
            }
        }
        return INSTANCE;
    }
    @Override
    public LiveData<Resource<List<MovieEntity>>> getAllMovie() {
        return new NetworkBoundResource<List<MovieEntity>, List<MovieModel>>(appExecutors) {
            @Override
            public LiveData<List<MovieEntity>> loadFromDB() {
                return localRepository.getAllCourses();
            }

            @Override
            public Boolean shouldFetch(List<MovieEntity> data) {
                return (data == null) || (data.size() == 0);
            }

            @Override
            public LiveData<ApiResponse<List<MovieModel>>> createCall() {
                return remoteRepository.getMovie();
            }

            @Override
            public void saveCallResult(List<MovieModel> courseResponses) {
                List<MovieEntity> courseEntities = new ArrayList<>();

                for (MovieModel courseResponse : courseResponses) {

                    courseEntities.add(new MovieEntity(
                            courseResponse.getId(),
                            courseResponse.getPoster_path(),
                            courseResponse.getTitle(),
                            courseResponse.getRelease_date(),
                            courseResponse.getOverview(), null
                    ));
                }

                localRepository.insertMovie(courseEntities);
            }
        }.asLiveData();
    }

    @Override
    public LiveData<Resource<MovieEmbed>> getAllMovieDetail(final String courseId) {
        return new NetworkBoundResource<MovieEmbed, List<MovieModel>>(appExecutors) {
            @Override
            protected LiveData<MovieEmbed> loadFromDB() {
                return localRepository.getCourseWithModules(courseId);
            }

            @Override
            protected Boolean shouldFetch(MovieEmbed courseWithModule) {
                return (courseWithModule == null || courseWithModule.mCourse == null);
            }

            @Override
            protected LiveData<ApiResponse<List<MovieModel>>> createCall() {
                return remoteRepository.getAllModulesByCourseAsLiveData(courseId);
            }

            @Override
            protected void saveCallResult(List<MovieModel> moduleResponses) {

                List<MovieEntity> moduleEntities = new ArrayList<>();

                for (MovieModel moduleResponse : moduleResponses) {
                    moduleEntities.add(new MovieEntity(courseId, moduleResponse.getPoster_path(), moduleResponse.getTitle(), moduleResponse.getRelease_date(), moduleResponse.getOverview(), null));
                }

                localRepository.insertMovie(moduleEntities);
            }
        }.asLiveData();
    }

    @Override
    public void setCourseBookmark(MovieEntity course, boolean state) {

        Runnable runnable = () -> localRepository.setCourseBookmark(course, state);

        appExecutors.diskIO().execute(runnable);
    }

    @Override
    public LiveData<Resource<PagedList<MovieEntity>>> getBookmarkedCoursesPaged() {
        return new NetworkBoundResource<PagedList<MovieEntity>, List<MovieModel>>(appExecutors) {
            @Override
            protected LiveData<PagedList<MovieEntity>> loadFromDB() {
                return new LivePagedListBuilder<>(localRepository.getBookmarkedCoursesPaged(), /* page size */ 20).build();
            }

            @Override
            protected Boolean shouldFetch(PagedList<MovieEntity> data) {
                return false;
            }

            @Override
            protected LiveData<ApiResponse<List<MovieModel>>> createCall() {
                return null;
            }

            @Override
            protected void saveCallResult(List<MovieModel> data) {

            }
        }.asLiveData();
    }


// batas fitur


    public LiveData<Resource<List<TvShowEntity>>> getAllTv() {
        return new NetworkBoundResource<List<TvShowEntity>, List<TvShowModel>>(appExecutors) {
            @Override
            public LiveData<List<TvShowEntity>> loadFromDB() {
                return localRepository.getAllTv();
            }

            @Override
            public Boolean shouldFetch(List<TvShowEntity> data) {
                return (data == null) || (data.size() == 0);
            }

            @Override
            public LiveData<ApiResponse<List<TvShowModel>>> createCall() {
                return remoteRepository.getTv();
            }

            @Override
            public void saveCallResult(List<TvShowModel> courseResponses) {
                List<TvShowEntity> courseEntities = new ArrayList<>();

                for (TvShowModel courseResponse : courseResponses) {

                    courseEntities.add(new TvShowEntity(
                           courseResponse.getId(),
                           courseResponse.getName(),
                           courseResponse.getFirstAirDate(),
                           courseResponse.getPosterPath(),
                           courseResponse.getOverview(),
                           null
                    ));
                }

                localRepository.insertTv(courseEntities);
            }
        }.asLiveData();
    }

    @Override
    public LiveData<Resource<TvShowEmbed>> getAllTvDetail(final String courseId) {
        return new NetworkBoundResource<TvShowEmbed, List<TvShowModel>>(appExecutors) {
            @Override
            protected LiveData<TvShowEmbed> loadFromDB() {
                return localRepository.getCourseWithTv(courseId);
            }

            @Override
            protected Boolean shouldFetch(TvShowEmbed courseWithModule) {
                return (courseWithModule == null);
            }

            @Override
            protected LiveData<ApiResponse<List<TvShowModel>>> createCall() {
                return remoteRepository.getAllTvById(courseId);
            }

            @Override
            protected void saveCallResult(List<TvShowModel> moduleResponses) {

                List<TvShowEntity> moduleEntities = new ArrayList<>();

                for (TvShowModel moduleResponse : moduleResponses) {
                    moduleEntities.add(new TvShowEntity(courseId, moduleResponse.getName(),
                            moduleResponse.getFirstAirDate(),
                            moduleResponse.getPosterPath(),
                            moduleResponse.getOverview(),
                            null)
                    );
                }

                localRepository.insertTv(moduleEntities);
            }
        }.asLiveData();
    }

    @Override
    public void setCourseFavorite(TvShowEntity course, boolean state) {
        Runnable runnable = () -> localRepository.setCourseFavoriteTv(course, state);

        appExecutors.diskIO().execute(runnable);
    }

    @Override
    public LiveData<Resource<PagedList<TvShowEntity>>> getBookmarkedTvShowPaged() {
        return new NetworkBoundResource<PagedList<TvShowEntity>, List<TvShowModel>>(appExecutors) {
            @Override
            protected LiveData<PagedList<TvShowEntity>> loadFromDB() {
                return new LivePagedListBuilder<>(localRepository.getBookmarkedTvPaged(), /* page size */ 20).build();
            }

            @Override
            protected Boolean shouldFetch(PagedList<TvShowEntity> data) {
                return false;
            }

            @Override
            protected LiveData<ApiResponse<List<TvShowModel>>> createCall() {
                return null;
            }

            @Override
            protected void saveCallResult(List<TvShowModel> data) {

            }
        }.asLiveData();
    }


}
