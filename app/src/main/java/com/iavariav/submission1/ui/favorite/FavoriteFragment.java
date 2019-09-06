package com.iavariav.submission1.ui.favorite;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ShareCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.iavariav.submission1.R;
import com.iavariav.submission1.data.remote.entity.MovieEntity;
import com.iavariav.submission1.utils.ViewModelFactory;

import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavoriteFragment extends Fragment implements FavoriteFragmentCallback {
    private FavoritePagedAdapter adapter;
    private RecyclerView rvBookmark;
    private ProgressBar progressBar;

    private FavoriteViewModel viewModel;
    private List<MovieEntity> courses;


    public FavoriteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvBookmark = view.findViewById(R.id.rv_bookmark);
        progressBar = view.findViewById(R.id.progress_bar);
    }

    @Override
    public void onShareClick(MovieEntity course) {
        if (getActivity() != null) {
            String mimeType = "text/plain";
            ShareCompat.IntentBuilder
                    .from(getActivity())
                    .setType(mimeType)
                    .setChooserTitle("Bagikan aplikasi ini sekarang.")
                    .setText(String.format("Segera daftar kelas %s di dicoding.com", course.getTitle()))
                    .startChooser();
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() != null) {
//            viewModel = ViewModelProviders.of(this).get(BookmarkViewModel.class);
            //Memberikan aksi untuk swipe
            itemTouchHelper.attachToRecyclerView(rvBookmark);
            viewModel = obtainViewModel(getActivity());

            adapter = new FavoritePagedAdapter(this);

            viewModel.getBookmarksPaged().observe(this, courses -> {
                if (courses != null) {
                    switch (courses.status) {
                        case LOADING:
                            progressBar.setVisibility(View.VISIBLE);
                            break;
                        case SUCCESS:
                            Log.e(TAG, "onActivityCreated: " + courses.data );
                            Log.e(TAG, "onActivityCreated: " + courses.data );
                            progressBar.setVisibility(View.GONE);
                            adapter.submitList(courses.data);
                            adapter.notifyDataSetChanged();
                            break;
                        case ERROR:
                            progressBar.setVisibility(View.GONE);
                            Toast.makeText(getContext(), "Terjadi kesalahan", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }

            });

//            adapter.setListCourses(DataDummy.generateDummyCourses());

            rvBookmark.setLayoutManager(new LinearLayoutManager(getContext()));
            rvBookmark.setHasFixedSize(true);
            rvBookmark.setAdapter(adapter);
        }
    }
    @NonNull
    private static FavoriteViewModel obtainViewModel(FragmentActivity activity) {
        // Use a Factory to inject dependencies into the ViewModel
        ViewModelFactory factory = ViewModelFactory.getInstance(activity.getApplication());
        return ViewModelProviders.of(activity, factory).get(FavoriteViewModel.class);
    }

    private ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.Callback() {
        @Override
        public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
            return makeMovementFlags(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT);
        }

        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return true;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            if (getView() != null) {
                int swipedPosition = viewHolder.getAdapterPosition();
                MovieEntity courseEntity = adapter.getItemById(swipedPosition);
                viewModel.setBookmark(courseEntity);
                Snackbar snackbar = Snackbar.make(getView(), R.string.message_undo, Snackbar.LENGTH_LONG);
                snackbar.setAction(R.string.message_ok, v -> viewModel.setBookmark(courseEntity));
                snackbar.show();
            }
        }
    });
}
