package com.iavariav.submission1.ui.detail;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProviders;

import com.iavariav.submission1.R;
import com.iavariav.submission1.data.DeskripsiEntity;
import com.iavariav.submission1.utils.GlideApp;

import java.util.List;

public class DetailActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ImageView imagePoster;
    private TextView textTitle;
    private TextView textReleaseDate;
    private TextView textDesc;
    private View line1;
    private TextView textOverview;

    private DetailViewModel viewModel;
    private List<DeskripsiEntity> modules;

    public static final String EXTRA_ID = "extra_id";
    public static final String EXTRA_IMAGE = "extra_image";
    public static final String EXTRA_TITTLE = "extra_tittle";
    public static final String EXTRA_OVERVIEW = "extra_overview";
    public static final String EXTRA_RELEASE_DATE = "extra_release_date";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initView();
        viewModel = ViewModelProviders.of(this).get(DetailViewModel.class);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        GlideApp.with(getApplicationContext()).load(getIntent().getStringExtra(EXTRA_IMAGE))
                .error(R.drawable.ic_broken_image_black)
                .override(512, 512)
                .into(imagePoster);
        textTitle.setText(getIntent().getStringExtra(EXTRA_TITTLE));
        textReleaseDate.setText(getIntent().getStringExtra(EXTRA_RELEASE_DATE));
        textOverview.setText(getIntent().getStringExtra(EXTRA_OVERVIEW));
//        textTitle.setText(getIntent().getStringExtra(EXTRA_TITTLE));

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
