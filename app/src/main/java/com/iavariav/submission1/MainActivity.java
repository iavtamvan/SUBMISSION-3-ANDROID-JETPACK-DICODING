package com.iavariav.submission1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.facebook.stetho.Stetho;
import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.iavariav.submission1.ui.ProfilFragment;
import com.iavariav.submission1.ui.favorite.FavoriteFragment;
import com.iavariav.submission1.ui.movie.MovieFragment;
import com.iavariav.submission1.ui.tvshow.TVShowFragment;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

import okhttp3.OkHttpClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Stetho.initializeWithDefaults(this);
        new OkHttpClient.Builder()
                .addNetworkInterceptor(new StethoInterceptor())
                .build();
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(), FragmentPagerItems.with(this)
                .add("Movie", MovieFragment.class)
                .add("TV Show", TVShowFragment.class)
                .add("Favorite", FavoriteFragment.class)
                .add("Profil", ProfilFragment.class)
                .create());

        ViewPager viewPager = findViewById(R.id.viewpager);
        viewPager.setAdapter(adapter);

        SmartTabLayout viewPagerTab = findViewById(R.id.viewpagertab);
        viewPagerTab.setViewPager(viewPager);
    }
}
