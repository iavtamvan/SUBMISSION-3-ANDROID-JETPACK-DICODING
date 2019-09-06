package com.iavariav.submission1.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.iavariav.submission1.R;
import com.iavariav.submission1.data.remote.entity.MovieEntity;
import com.iavariav.submission1.ui.favorite.FavoriteFragmentCallback;
import com.iavariav.submission1.ui.movie.detail.DetailMovieActivity;
import com.iavariav.submission1.ui.movie.detail.DetailMovieViewModel;

import java.util.ArrayList;
import java.util.List;

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.AcademyViewHolder> {

    private final Activity activity;
    private final FavoriteFragmentCallback callback;
    private ArrayList<MovieEntity> courses = new ArrayList<>();

    public FavoriteAdapter(Activity activity, FavoriteFragmentCallback callback) {
        this.activity = activity;
        this.callback = callback;
    }

    public void setListCourses(List<MovieEntity> courses) {
        if (courses == null) return;
        this.courses.clear();
        this.courses.addAll(courses);
    }

    @NonNull
    @Override
    public AcademyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_data, parent, false);
        return new AcademyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final AcademyViewHolder holder, int position) {
        MovieEntity course = courses.get(position);

        holder.tvTitle.setText(course.getTitle());
        holder.tvDate.setText(String.format("Deadline %s", course.getRelease_date()));
        holder.tvDescription.setText(course.getOverview());
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(activity, DetailMovieViewModel.class);
            intent.putExtra(DetailMovieActivity.EXTRA_ID, course.getId());
            activity.startActivity(intent);
        });
//        holder.imgShare.setOnClickListener(v -> callback.onShareClick(courses.get(holder.getAdapterPosition())));

        Glide.with(holder.itemView.getContext())
                .load("https://image.tmdb.org/t/p/w500" + course.getPoster_path())
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
                .into(holder.imgPoster);
    }

    @Override
    public int getItemCount() {
        return courses.size();
    }

    class AcademyViewHolder extends RecyclerView.ViewHolder {
        final TextView tvTitle;
        final TextView tvDescription;
        final TextView tvDate;
//        final ImageButton imgShare;
        final ImageView imgPoster;

        AcademyViewHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_item_title);
            tvDescription = itemView.findViewById(R.id.tv_item_description);
            tvDate = itemView.findViewById(R.id.tv_item_date);
//            imgShare = itemView.findViewById(R.id.img_share);
            imgPoster = itemView.findViewById(R.id.img_poster);
        }
    }
}
