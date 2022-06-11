package com.example.a21173067_samplemovie;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {
    ArrayList<Movie> items = new ArrayList<Movie>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.movie_item, viewGroup, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Movie item = items.get(position);
        viewHolder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
    public void addItem(Movie item){
        items.add(item);
    }
    public void setItems(ArrayList<Movie> items){
        this.items = items;
    }
    public Movie getItem(int position){
        return items.get(position);
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView movieName;
        TextView peopleCount;
        TextView ranking;
        TextView peopleAcc;
        TextView date;
        TextView movieCount;


        public ViewHolder(View itemView) {
            super(itemView);
            movieName = itemView.findViewById(R.id.movieName);
            peopleCount = itemView.findViewById(R.id.peopleCount);
            ranking = itemView.findViewById(R.id.ranking);
            peopleAcc = itemView.findViewById(R.id.peopleAcc);
            date = itemView.findViewById(R.id.date);
            movieCount = itemView.findViewById(R.id.movieCount);

        }
        public void setItem(Movie item){
            movieName.setText(item.movieNm);
            peopleCount.setText(item.audiCnt + " 명");
            ranking.setText(item.rank + "위");
            peopleAcc.setText("누적관객수 " + item.audiAcc + "명");
            date.setText("영화개봉일: " + item.openDt);
            movieCount.setText("상영횟수: " + item.showCnt + "번");
        }
    }
}
