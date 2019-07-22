package com.iavariav.submission1.ui.tvshow;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.iavariav.submission1.R;
import com.iavariav.submission1.adapter.ListAdapter;
import com.iavariav.submission1.data.DeskripsiEntity;
import com.iavariav.submission1.ui.movie.MovieViewModel;
import com.iavariav.submission1.utils.DataDummy;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class TVShowFragment extends Fragment {

    private RecyclerView rvCourse;
    private ProgressBar progressBar;
    private ListAdapter listAdapter;

    private TvShowViewModel viewModel;
    private List<DeskripsiEntity> courses;
    public TVShowFragment() {
        // Required empty public constructor
    }

    public static Fragment newInstance() {
        return new TVShowFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tvshow, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvCourse = view.findViewById(R.id.rv_academy);
        progressBar = view.findViewById(R.id.progress_bar);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() != null) {
            viewModel = ViewModelProviders.of(this).get(TvShowViewModel.class);
            courses = viewModel.getDeskripsi();
            listAdapter = new ListAdapter(getActivity());
            listAdapter.setListCourses(DataDummy.generateDummytv());
            rvCourse.setLayoutManager(new LinearLayoutManager(getContext()));
            rvCourse.setHasFixedSize(true);
            rvCourse.setAdapter(listAdapter);
        }
    }



}
