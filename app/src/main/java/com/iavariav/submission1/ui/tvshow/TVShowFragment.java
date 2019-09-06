package com.iavariav.submission1.ui.tvshow;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.iavariav.submission1.R;
import com.iavariav.submission1.adapter.MovieAdapter;
import com.iavariav.submission1.adapter.TVShowAdapter;
import com.iavariav.submission1.data.remote.entity.TvShowEntity;
import com.iavariav.submission1.utils.ViewModelFactory;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class TVShowFragment extends Fragment {

    private RecyclerView rvCourse;
    private ProgressBar progressBar;
    private TVShowAdapter tvShowAdapter;

    private TvShowViewModel viewModel;
    private List<TvShowEntity> courses;
    public TVShowFragment() {
        // Required empty public constructor
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
        rvCourse = view.findViewById(R.id.rv_tvshow);
        progressBar = view.findViewById(R.id.progress_bar);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() != null) {
//            viewModel = ViewModelProviders.of(this).get(AcademyViewModel.class);
            viewModel = obtainViewModel(getActivity());

            viewModel.setUsername("Dicoding");
            viewModel.getCourses.observe(this, courses -> {
                if (courses != null) {
                    switch (courses.status) {
                        case LOADING:
                            progressBar.setVisibility(View.VISIBLE);
                            break;
                        case SUCCESS:
                            progressBar.setVisibility(View.GONE);
                            tvShowAdapter.setListCourses(courses.data);
                            tvShowAdapter.notifyDataSetChanged();
                            break;
                        case ERROR:
                            progressBar.setVisibility(View.GONE);
                            Toast.makeText(getContext(), "Terjadi kesalahan", Toast.LENGTH_SHORT).show();
                            break;

                    }
                }
            });
            tvShowAdapter = new TVShowAdapter(getActivity());
            tvShowAdapter.setListCourses(courses);
            rvCourse.setLayoutManager(new LinearLayoutManager(getContext()));
            rvCourse.setHasFixedSize(true);
            rvCourse.setAdapter(tvShowAdapter);
        }

//        if (getActivity() != null) {
//            viewModel = ViewModelProviders.of(this).get(TvShowViewModel.class);
//            courses = viewModel.getDeskripsi();
//            tvShowAdapter = new TVShowAdapter(getActivity());
//            tvShowAdapter.setListCourses(DataDummy.generateDummytv());
//            rvCourse.setLayoutManager(new LinearLayoutManager(getContext()));
//            rvCourse.setHasFixedSize(true);
//            rvCourse.setAdapter(tvShowAdapter);
//        }
    }

    @NonNull
    private static TvShowViewModel obtainViewModel(FragmentActivity activity) {
        // Use a Factory to inject dependencies into the ViewModel
        ViewModelFactory factory = ViewModelFactory.getInstance(activity.getApplication());
        return ViewModelProviders.of(activity, factory).get(TvShowViewModel.class);
    }


}
