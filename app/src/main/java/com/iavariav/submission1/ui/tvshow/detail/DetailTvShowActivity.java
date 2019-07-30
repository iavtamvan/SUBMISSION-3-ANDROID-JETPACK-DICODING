package com.iavariav.submission1.ui.tvshow.detail;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProviders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.iavariav.submission1.R;
import com.iavariav.submission1.adapter.MovieAdapter;
import com.iavariav.submission1.data.DeskripsiEntity;
import com.iavariav.submission1.utils.DataDummy;
import com.iavariav.submission1.utils.GlideApp;

import java.util.List;

public class DetailTvShowActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private ImageView imagePoster;
    private TextView textTitle;
    private TextView textReleaseDate;
    private TextView textOverview;

    private DetailTVShowViewModel viewModel;
    private List<DeskripsiEntity> modules;
    private MovieAdapter listAdapter;

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
        listAdapter = new MovieAdapter(this);
        initView();
        viewModel = ViewModelProviders.of(this).get(DetailTVShowViewModel.class);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String courseId = extras.getString(EXTRA_ID);
            if (courseId != null) {
                viewModel.setCourseId(courseId);
                modules = viewModel.getTvModule();
                listAdapter.setListCourses(modules);
                populateCourse(String.valueOf(viewModel.getCourseId()));
            }
        }

    }

    private void populateCourse(String courseId) {
        DeskripsiEntity deskripsiEntity = DataDummy.getTvShow(courseId);
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
        textOverview = findViewById(R.id.text_overview);
    }
}
