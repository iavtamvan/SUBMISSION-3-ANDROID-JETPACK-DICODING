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

import com.bumptech.glide.request.RequestOptions;
import com.iavariav.submission1.R;
import com.iavariav.submission1.data.DeskripsiEntity;
import com.iavariav.submission1.data.remote.response.MovieModel;
import com.iavariav.submission1.data.remote.response.TvShowModel;
import com.iavariav.submission1.ui.movie.detail.DetailMovieActivity;
import com.iavariav.submission1.ui.tvshow.detail.DetailTvShowActivity;
import com.iavariav.submission1.utils.GlideApp;

import java.util.ArrayList;
import java.util.List;

public class TVShowAdapter extends RecyclerView.Adapter<TVShowAdapter.AcademyViewHolder> {
    private final Activity activity;
    private List<TvShowModel> mCourses = new ArrayList<>();

    public TVShowAdapter(Activity activity) {
        this.activity = activity;
    }

    private List<TvShowModel> getListCourses() {
        return mCourses;
    }

    public void setListCourses(List<TvShowModel> listCourses) {
        if (listCourses == null) return;
        this.mCourses.clear();
        this.mCourses.addAll(listCourses);
    }

    @NonNull
    @Override
    public AcademyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_data, parent, false);
        return new AcademyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final AcademyViewHolder holder, final int position) {
        holder.tvTitle.setText(getListCourses().get(position).getName());
        holder.tvDescription.setText(getListCourses().get(position).getOverview());
        holder.tvDate.setText("Release : " + getListCourses().get(position).getFirstAirDate());
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(activity, DetailTvShowActivity.class);
            intent.putExtra(DetailTvShowActivity.EXTRA_ID, getListCourses().get(position).getId());
            activity.startActivity(intent);

        });

        GlideApp.with(holder.itemView.getContext())
                .load("https://image.tmdb.org/t/p/w500" +getListCourses().get(position).getPosterPath())
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
                .into(holder.imgPoster);
    }

    @Override
    public int getItemCount() {
        return getListCourses().size();
    }

    class AcademyViewHolder extends RecyclerView.ViewHolder {
        final TextView tvTitle;
        final TextView tvDescription;
        final TextView tvDate;
        final ImageView imgPoster;

        AcademyViewHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_item_title);
            imgPoster = itemView.findViewById(R.id.img_poster);
            tvDescription = itemView.findViewById(R.id.tv_item_description);
            tvDate = itemView.findViewById(R.id.tv_item_date);
        }
    }
}
