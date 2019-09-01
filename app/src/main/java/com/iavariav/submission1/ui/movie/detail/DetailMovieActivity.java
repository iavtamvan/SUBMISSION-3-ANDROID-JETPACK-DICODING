package com.iavariav.submission1.ui.movie.detail;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProviders;

import com.bumptech.glide.request.RequestOptions;
import com.iavariav.submission1.R;
import com.iavariav.submission1.adapter.MovieAdapter;
import com.iavariav.submission1.data.DeskripsiEntity;
import com.iavariav.submission1.data.remote.entity.MovieEntity;
import com.iavariav.submission1.data.remote.response.MovieModel;
import com.iavariav.submission1.utils.DataDummy;
import com.iavariav.submission1.utils.GlideApp;
import com.iavariav.submission1.utils.ViewModelFactory;

import java.util.List;

public class DetailMovieActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ImageView imagePoster;
    private TextView textTitle;
    private TextView textReleaseDate;
    private TextView textDesc;
    private View line1;
    private TextView textOverview;

    private DetailMovieViewModel viewModel;
    private List<MovieEntity> modules;
    private MovieAdapter listAdapter;

    public static final String EXTRA_ID = "extra_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initView();
//        viewModel = ViewModelProviders.of(this).get(DetailMovieViewModel.class);
        viewModel = obtainViewModel(this);
        listAdapter = new MovieAdapter(this);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
//
//        Bundle extras = getIntent().getExtras();
//        if (extras != null) {
//            String courseId = extras.getString(EXTRA_ID);
//            if (courseId != null) {
//                viewModel.setCourseId(courseId);
//                modules = viewModel.getMoviewModule();
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

                viewModel.getCourse().observe(this, courseEntity -> {
                    if (courseEntity != null) {
                        populateCourse(courseEntity); // koskkk
                    }
                });
            }
        }

    }

    @NonNull
    private static DetailMovieViewModel obtainViewModel(AppCompatActivity activity) {
        // Use a Factory to inject dependencies into the ViewModel
        ViewModelFactory factory = ViewModelFactory.getInstance(activity.getApplication());

        return ViewModelProviders.of(activity, factory).get(DetailMovieViewModel.class);
    }

    private void populateCourse(MovieEntity courseEntity) {
        textTitle.setText(courseEntity.getTitle());
        textDesc.setText(courseEntity.getOverview());
        textReleaseDate.setText(String.format("Release Date %s", courseEntity.getRelease_date()));

        GlideApp.with(getApplicationContext())
                .load("https://image.tmdb.org/t/p/w500" + courseEntity.getPoster_path())
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error))
                .into(imagePoster);

    }

    private void initView() {
        toolbar = findViewById(R.id.toolbar);
        imagePoster = findViewById(R.id.image_poster);
        textTitle = findViewById(R.id.text_title);
        textReleaseDate = findViewById(R.id.text_release_date);
        textDesc = findViewById(R.id.text_desc);
        line1 = findViewById(R.id.line1);
        textOverview = findViewById(R.id.text_overview);
    }
}
