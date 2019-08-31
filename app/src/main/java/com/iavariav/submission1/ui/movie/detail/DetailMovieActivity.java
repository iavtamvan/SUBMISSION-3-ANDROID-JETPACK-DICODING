package com.iavariav.submission1.ui.movie.detail;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProviders;

import com.iavariav.submission1.R;
import com.iavariav.submission1.adapter.MovieAdapter;
import com.iavariav.submission1.data.DeskripsiEntity;
import com.iavariav.submission1.utils.DataDummy;
import com.iavariav.submission1.utils.GlideApp;

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
    private List<DeskripsiEntity> modules;
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
        viewModel = ViewModelProviders.of(this).get(DetailMovieViewModel.class);
        listAdapter = new MovieAdapter(this);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String courseId = extras.getString(EXTRA_ID);
            if (courseId != null) {
                viewModel.setCourseId(courseId);
                modules = viewModel.getMoviewModule();
//                listAdapter.setListCourses(modules);
                populateCourse(String.valueOf(viewModel.getCourseId()));
            }
        }

    }
    private void populateCourse(String courseId) {
        DeskripsiEntity deskripsiEntity = DataDummy.getMovie(courseId);
        GlideApp.with(getApplicationContext()).load(deskripsiEntity.getImageURL())
                .error(R.drawable.ic_broken_image_black)
                .override(512, 512)
                .into(imagePoster);

        textTitle.setText(deskripsiEntity.gettitle());
        textReleaseDate.setText(deskripsiEntity.getreleaseDate());
        textOverview.setText(deskripsiEntity.getDeskripsi());

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
