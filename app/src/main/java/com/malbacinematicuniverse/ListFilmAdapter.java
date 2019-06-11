package com.malbacinematicuniverse;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.malbacinematicuniverse.R;

import java.util.ArrayList;

public class ListFilmAdapter extends RecyclerView.Adapter<ListFilmAdapter.FilmViewHolder> {

    public ListFilmAdapter(Context context) {
        this.context = context;
    }

    private Context context;

    public ArrayList<Film> getListFilm() {
        return listFilm;
    }

    public void setListFilm(ArrayList<Film> listFilm) {
        this.listFilm = listFilm;
    }

    private ArrayList<Film> listFilm;

    @NonNull
    @Override
    public ListFilmAdapter.FilmViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_film, viewGroup, false);
        return new FilmViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmViewHolder filmViewHolder, int i) {
        filmViewHolder.number.setText(getListFilm().get(i).getIndex());

        Glide.with(context)
                .load(getListFilm().get(i).getTitleCard())
                .apply(new RequestOptions().override(180, 100))
                .into(filmViewHolder.title_card);
    }

    @Override
    public int getItemCount() {
        return getListFilm().size();
    }

    public class FilmViewHolder extends RecyclerView.ViewHolder {
        public TextView number;
        public ImageView title_card;

        public FilmViewHolder(@NonNull View itemView) {
            super(itemView);
            number = itemView.findViewById(R.id.number);
            title_card = itemView.findViewById(R.id.title_card);
        }
    }
}
