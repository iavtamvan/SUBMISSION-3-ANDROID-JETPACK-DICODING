package com.iavariav.submission1.ui.movie.detail;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProviders;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.iavariav.submission1.R;
import com.iavariav.submission1.adapter.MovieAdapter;
import com.iavariav.submission1.data.remote.entity.MovieEntity;
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

    private Menu menu;

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
                                    populateCourse(courseWithModuleResource.data.mCourse);
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
    private static DetailMovieViewModel obtainViewModel(AppCompatActivity activity) {
        // Use a Factory to inject dependencies into the ViewModel
        ViewModelFactory factory = ViewModelFactory.getInstance(activity.getApplication());

        return ViewModelProviders.of(activity, factory).get(DetailMovieViewModel.class);
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
                            boolean state = courseWithModule.data.mCourse.isFavorite();
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
            Toast.makeText(this, "Klikced" , Toast.LENGTH_SHORT).show();
            Toast.makeText(this, "Klikced" , Toast.LENGTH_SHORT).show();
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


    private void populateCourse(MovieEntity courseEntity) {
        textTitle.setText(courseEntity.getTitle());
        textDesc.setText(courseEntity.getOverview());
        textReleaseDate.setText(String.format("Release Date %s", courseEntity.getRelease_date()));

        Glide.with(getApplicationContext())
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
