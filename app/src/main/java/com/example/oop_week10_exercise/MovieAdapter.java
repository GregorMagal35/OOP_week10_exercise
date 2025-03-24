package com.example.oop_week10_exercise;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private List<Movie> movies;

    public MovieAdapter(List<Movie> movies) {
        this.movies = movies;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_movie, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        holder.bind(movies.get(position));
    }

    @Override
    public int getItemCount() {
        return movies != null ? movies.size() : 0;
    }

    // Update data dynamically
    public void updateMovies(List<Movie> newMovies) {
        this.movies = newMovies;
        notifyDataSetChanged();
    }

    // ViewHolder class
    static class MovieViewHolder extends RecyclerView.ViewHolder {

        private final ImageView posterImageView;
        private final TextView titleTextView;
        private final TextView yearTextView;
        private final TextView genreTextView;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            posterImageView = itemView.findViewById(R.id.posterImageView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            yearTextView = itemView.findViewById(R.id.yearTextView);
            genreTextView = itemView.findViewById(R.id.genreTextView);
        }

        void bind(Movie movie) {
            titleTextView.setText(movie.getTitle());
            yearTextView.setText(String.valueOf(movie.getYear()));
            genreTextView.setText(movie.getGenre());

            if (movie.getPosterResourceId() != 0) {
                posterImageView.setImageResource(movie.getPosterResourceId());
            } else {
                posterImageView.setImageResource(R.drawable.ic_launcher_background);
            }
        }
    }
}
