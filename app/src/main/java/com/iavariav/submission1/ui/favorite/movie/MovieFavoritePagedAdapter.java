package com.iavariav.submission1.ui.favorite.movie;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.iavariav.submission1.R;
import com.iavariav.submission1.data.remote.entity.MovieEntity;
import com.iavariav.submission1.ui.favorite.FavoriteFragmentCallback;
import com.iavariav.submission1.ui.movie.detail.DetailMovieActivity;

import static android.content.ContentValues.TAG;


public class MovieFavoritePagedAdapter extends PagedListAdapter<MovieEntity, MovieFavoritePagedAdapter.BookmarkViewHolder> {

    private FavoriteFragmentCallback callback;

    MovieFavoritePagedAdapter(FavoriteFragmentCallback callback) {
        super(DIFF_CALLBACK);

        this.callback = callback;
    }

    @Override
    public void onBindViewHolder(@NonNull final BookmarkViewHolder holder, int position) {
        final MovieEntity bookmark = getItem(position);
        if (bookmark != null) {
            Log.e(TAG, "onBindViewHolder: "+ bookmark.getOverview() );
            Log.e(TAG, "onBindViewHolder: "+ bookmark.getOverview() );
            Log.e(TAG, "onBindViewHolder: "+ bookmark.getOverview() );
            Log.e(TAG, "onBindViewHolder: "+ bookmark.getOverview() );
            Log.e(TAG, "onBindViewHolder: "+ bookmark.getOverview() );
            Log.e(TAG, "onBindViewHolder: "+ bookmark.getOverview() );
            Log.e(TAG, "onBindViewHolder: "+ bookmark.getOverview() );
            Log.e(TAG, "onBindViewHolder: "+ bookmark.getOverview() );
            Log.e(TAG, "onBindViewHolder: "+ bookmark.getOverview() );
            holder.tvTitle.setText(bookmark.getTitle());
            holder.tvDate.setText(String.format("Deadline %s", bookmark.getRelease_date()));
            holder.tvDescription.setText(bookmark.getOverview());
            holder.itemView.setOnClickListener(v -> {
                Context context = holder.itemView.getContext();
                Intent intent = new Intent(context, DetailMovieActivity.class);
                String courseId = bookmark.getId();
                intent.putExtra(DetailMovieActivity.EXTRA_ID, courseId);
                context.startActivity(intent);
            });

//            holder.imgShare.setOnClickListener(v -> {
//                MovieEntity course = new MovieEntity(
//                        bookmark.getId(),
//                        bookmark.getPoster_path(),
//                        bookmark.getTitle(),
//                        bookmark.getRelease_date(),
//                        bookmark.getOverview(),
//                        null
//                );
//                callback.onShareClick(course);
//            });

            Glide.with(holder.itemView.getContext())
                    .load("https://image.tmdb.org/t/p/w500" + bookmark.getPoster_path())
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error))
                    .into(holder.imgPoster);
        }
    }

    @NonNull
    @Override
    public BookmarkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_data, parent, false);
        return new BookmarkViewHolder(view);
    }


    private static DiffUtil.ItemCallback<MovieEntity> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<MovieEntity>() {
                @Override
                public boolean areItemsTheSame(@NonNull MovieEntity oldItem, @NonNull MovieEntity newItem) {
                    return oldItem.getId().equals(newItem.getId());
                }

                @SuppressLint("DiffUtilEquals")
                @Override
                public boolean areContentsTheSame(@NonNull MovieEntity oldItem, @NonNull MovieEntity newItem) {
                    return oldItem.equals(newItem);
                }
            };

    MovieEntity getItemById(int swipedPosition) {
        return getItem(swipedPosition);
    }

    class BookmarkViewHolder extends RecyclerView.ViewHolder {
        final TextView tvTitle;
        final TextView tvDescription;
        final TextView tvDate;
//        final ImageButton imgShare;
        final ImageView imgPoster;

        BookmarkViewHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_item_title);
            tvDescription = itemView.findViewById(R.id.tv_item_description);
            tvDate = itemView.findViewById(R.id.tv_item_date);
//            imgShare = itemView.findViewById(R.id.img_share);
            imgPoster = itemView.findViewById(R.id.img_poster);
        }
    }

}