package com.example.natan.movietralierapp1.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.natan.movietralierapp1.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by natan on 12/2/2017.
 */

public class MovieTrailerAdapter extends RecyclerView.Adapter<MovieTrailerAdapter.MyViewHolder> {

    private List<MovieTrailer> mMovieTrailerList;
    private Context context;
    private ListItemClickListener mListItemClickListener;

    //Interface

    public interface ListItemClickListener {

        void onListItemClick(MovieTrailer movieTrailer);
    }


    public MovieTrailerAdapter(List<MovieTrailer> movieTrailerList, ListItemClickListener listItemClickListener) {
        mMovieTrailerList = movieTrailerList;
        this.mListItemClickListener = listItemClickListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_trailer, parent, false);

        return new MyViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        MovieTrailer movieTrailer = mMovieTrailerList.get(position);

        Picasso.with(context)
                .load("http://img.youtube.com/vi/" + movieTrailer.getTrailer_key() + "/0.jpg")
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_background)
                .into(holder.img);


    }

    @Override
    public int getItemCount() {
        return mMovieTrailerList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView img;

        public MyViewHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img_View_trailer);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int adapterPosition = getAdapterPosition();
            MovieTrailer videoClick = mMovieTrailerList.get(adapterPosition);
            mListItemClickListener.onListItemClick(videoClick);

        }
    }

}
