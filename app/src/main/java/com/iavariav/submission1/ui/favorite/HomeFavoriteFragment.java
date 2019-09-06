package com.iavariav.submission1.ui.favorite;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.iavariav.submission1.R;
import com.iavariav.submission1.ui.ProfilFragment;
import com.iavariav.submission1.ui.favorite.movie.MovieFavoriteFragment;
import com.iavariav.submission1.ui.favorite.tvshow.TvShowFavoriteFragment;
import com.iavariav.submission1.ui.movie.MovieFragment;
import com.iavariav.submission1.ui.tvshow.TVShowFragment;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFavoriteFragment extends Fragment {


    public HomeFavoriteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_favorite, container, false);
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getActivity().getSupportFragmentManager(), FragmentPagerItems.with(getActivity())
                .add("Movie", MovieFavoriteFragment.class)
                .add("TV Show", TvShowFavoriteFragment.class)
                .create());

        ViewPager viewPager = view.findViewById(R.id.viewpager);
        viewPager.setAdapter(adapter);

        SmartTabLayout viewPagerTab = view.findViewById(R.id.viewpagertab);
        viewPagerTab.setViewPager(viewPager);
        return view;
    }

}
