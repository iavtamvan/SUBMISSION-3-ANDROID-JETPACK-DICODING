package com.iavariav.submission1.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.iavariav.submission1.R;
import com.iavariav.submission1.data.DeskripsiEntity;
import com.iavariav.submission1.ui.detail.DetailActivity;
import com.iavariav.submission1.utils.GlideApp;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.AcademyViewHolder> {
    private final Activity activity;
    private List<DeskripsiEntity> mCourses = new ArrayList<>();

    public ListAdapter(Activity activity) {
        this.activity = activity;
    }

    private List<DeskripsiEntity> getListCourses() {
        return mCourses;
    }

    public void setListCourses(List<DeskripsiEntity> listCourses) {
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
        holder.tvTitle.setText(getListCourses().get(position).gettitle());
        holder.tvDescription.setText(getListCourses().get(position).getDeskripsi());
        holder.tvDate.setText(String.format("Release ", getListCourses().get(position).getreleaseDate()));
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(activity, DetailActivity.class);
            intent.putExtra(DetailActivity.EXTRA_ID, getListCourses().get(position).getId());
            intent.putExtra(DetailActivity.EXTRA_IMAGE, getListCourses().get(position).getImageURL());
            intent.putExtra(DetailActivity.EXTRA_TITTLE, getListCourses().get(position).gettitle());
            intent.putExtra(DetailActivity.EXTRA_OVERVIEW, getListCourses().get(position).getDeskripsi());
            intent.putExtra(DetailActivity.EXTRA_RELEASE_DATE, getListCourses().get(position).getreleaseDate());
            activity.startActivity(intent);

        });

        GlideApp.with(holder.itemView.getContext())
                .load(getListCourses().get(position).getImageURL())
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
