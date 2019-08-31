package com.iavariav.submission1.ui.movie;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.iavariav.submission1.R;
import com.iavariav.submission1.adapter.MovieAdapter;
import com.iavariav.submission1.data.DeskripsiEntity;
import com.iavariav.submission1.data.remote.response.MovieModel;
import com.iavariav.submission1.utils.DataDummy;
import com.iavariav.submission1.utils.ViewModelFactory;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MovieFragment extends Fragment {
    private RecyclerView rvCourse;
    private ProgressBar progressBar;
    private MovieAdapter movieAdapter;

    private MovieViewModel viewModel;
    private List<MovieModel> courses;

    public MovieFragment() {
        // Required empty public constructor
    }

    public static Fragment newInstance() {
        return new MovieFragment();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvCourse = view.findViewById(R.id.rv_movie);
        progressBar = view.findViewById(R.id.progress_bar);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() != null) {
//            viewModel = ViewModelProviders.of(this).get(AcademyViewModel.class);
            viewModel = obtainViewModel(getActivity());

            viewModel.getCourses().observe(this, courses -> {
                progressBar.setVisibility(View.GONE);
                movieAdapter.setListCourses(courses);
                movieAdapter.notifyDataSetChanged();
            });
            movieAdapter = new MovieAdapter(getActivity());
            movieAdapter.setListCourses(courses);
            rvCourse.setLayoutManager(new LinearLayoutManager(getContext()));
            rvCourse.setHasFixedSize(true);
            rvCourse.setAdapter(movieAdapter);
        }


//        if (getActivity() != null) {
//            viewModel = ViewModelProviders.of(this).get(MovieViewModel.class);
//            courses = viewModel.getCourses();
//            movieAdapter = new MovieAdapter(getActivity());
//            movieAdapter.setListCourses(DataDummy.generateDummymovie());
//            rvCourse.setLayoutManager(new LinearLayoutManager(getContext()));
//            rvCourse.setHasFixedSize(true);
//            rvCourse.setAdapter(movieAdapter);
//        }
    }
    @NonNull
    private static MovieViewModel obtainViewModel(FragmentActivity activity) {
        // Use a Factory to inject dependencies into the ViewModel
        ViewModelFactory factory = ViewModelFactory.getInstance(activity.getApplication());
        return ViewModelProviders.of(activity, factory).get(MovieViewModel.class);
    }



}
