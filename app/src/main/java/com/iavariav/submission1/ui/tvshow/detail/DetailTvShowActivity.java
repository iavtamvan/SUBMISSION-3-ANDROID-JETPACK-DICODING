package com.iavariav.submission1.ui.tvshow.detail;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProviders;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.iavariav.submission1.R;
import com.iavariav.submission1.adapter.MovieAdapter;
import com.iavariav.submission1.adapter.TVShowAdapter;
import com.iavariav.submission1.data.DeskripsiEntity;
import com.iavariav.submission1.data.remote.entity.MovieEntity;
import com.iavariav.submission1.data.remote.entity.TvShowEntity;
import com.iavariav.submission1.ui.movie.detail.DetailMovieViewModel;
import com.iavariav.submission1.utils.DataDummy;
import com.iavariav.submission1.utils.ViewModelFactory;

import java.util.List;

public class DetailTvShowActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private ImageView imagePoster;
    private TextView textTitle;
    private TextView textReleaseDate;
    private TextView textOverview;

    private DetailTVShowViewModel viewModel;
    private List<TvShowEntity> modules;
    private TVShowAdapter listAdapter;

    private Menu menu;

    public static final String EXTRA_ID = "extra_id";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tv_show);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        listAdapter = new TVShowAdapter(this);
        initView();
        viewModel = obtainViewModel(this);
//        viewModel = ViewModelProviders.of(this).get(DetailTVShowViewModel.class);
//        Bundle extras = getIntent().getExtras();
//        if (extras != null) {
//            String courseId = extras.getString(EXTRA_ID);
//            if (courseId != null) {
//                viewModel.setCourseId(courseId);
//                modules = viewModel.getTvModule();
////                listAdapter.setListCourses(modules);
//                populateCourse(String.valueOf(viewModel.getCourseId()));
//            }
//        }

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String courseId = extras.getString(EXTRA_ID);
            if (courseId != null) {
                viewModel.setCourseId(courseId);
//                modules = viewModel.getModules();
//                viewModel.getMovie().observe(this, moduleEntities -> {
//                    listAdapter.setModules(moduleEntities);
//                });
                listAdapter.notifyDataSetChanged();
                listAdapter.setModules(modules);
//                populateCourse(String.valueOf(viewModel.getCourseId()));
                viewModel.courseModule.observe(this, courseWithModuleResource -> {
                    if (courseWithModuleResource != null) {

                        switch (courseWithModuleResource.status) {
                            case LOADING:
//                                progressBar.setVisibility(View.VISIBLE);
                                break;
                            case SUCCESS:
                                if (courseWithModuleResource.data != null) {
//                                    progressBar.setVisibility(View.GONE);
//                                    adapter.setModules(courseWithModuleResource.data.mModules);
//                                    adapter.notifyDataSetChanged();
                                    populateCourse(courseWithModuleResource.data.tvShowEntity);
                                }
                                break;
                            case ERROR:
//                                progressBar.setVisibility(View.GONE);
                                break;
                        }
                    }
                });
            }
        }

    }

    @NonNull
    private static DetailTVShowViewModel obtainViewModel(AppCompatActivity activity) {
        // Use a Factory to inject dependencies into the ViewModel
        ViewModelFactory factory = ViewModelFactory.getInstance(activity.getApplication());

        return ViewModelProviders.of(activity, factory).get(DetailTVShowViewModel.class);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        this.menu = menu;
        viewModel.courseModule.observe(this, courseWithModule -> {
            if (courseWithModule != null) {
                switch (courseWithModule.status) {
                    case LOADING:
//                        progressBar.setVisibility(View.VISIBLE);
                        break;
                    case SUCCESS:
                        if (courseWithModule.data != null) {
//                            progressBar.setVisibility(View.GONE);
                            boolean state = courseWithModule.data.tvShowEntity.isFavorite();
                            setBookmarkState(state);
                        }
                        break;
                    case ERROR:
//                        progressBar.setVisibility(View.GONE);
                        Toast.makeText(getApplicationContext(), "Terjadi kesalahan", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_bookmark) {
            viewModel.setFavorited();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setBookmarkState(boolean state) {
        if (menu == null) return;
        MenuItem menuItem = menu.findItem(R.id.action_bookmark);
        if (state) {
            menuItem.setIcon(ContextCompat.getDrawable(this, R.drawable.ic_bookmarked_white));
        } else {
            menuItem.setIcon(ContextCompat.getDrawable(this, R.drawable.ic_bookmark_white_24dp));
        }
    }


    private void populateCourse(TvShowEntity courseEntity) {
        textTitle.setText(courseEntity.getName());
        textOverview.setText(courseEntity.getOverview());
        textReleaseDate.setText(String.format("Release Date %s", courseEntity.getFirstAirDate()));

        Glide.with(getApplicationContext())
                .load("https://image.tmdb.org/t/p/w500" + courseEntity.getPosterPath())
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error))
                .into(imagePoster);

    }


    private void initView() {
        toolbar = findViewById(R.id.toolbar);
        imagePoster = findViewById(R.id.image_poster);
        textTitle = findViewById(R.id.text_title);
        textReleaseDate = findViewById(R.id.text_release_date);
        textOverview = findViewById(R.id.text_overview);
    }
}
