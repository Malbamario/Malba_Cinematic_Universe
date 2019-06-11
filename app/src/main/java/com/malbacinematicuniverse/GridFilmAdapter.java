package com.malbacinematicuniverse;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.malbacinematicuniverse.R;

import java.util.ArrayList;

public class GridFilmAdapter extends RecyclerView.Adapter<GridFilmAdapter.GridViewHolder> {

   Context context;

   public GridFilmAdapter(Context context) {
      this.context = context;
   }

   public ArrayList<Film> getListFilm() {
      return listFilm;
   }

   public void setListFilm(ArrayList<Film> listFilm) {
      this.listFilm = listFilm;
   }

   ArrayList<Film> listFilm;

   @NonNull
   @Override
   public GridViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
      View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_grid_film, viewGroup, false);
      return new GridViewHolder(view);
   }

   @Override
   public void onBindViewHolder(@NonNull GridFilmAdapter.GridViewHolder filmViewHolder, int i) {
      Glide.with(context)
              .load(getListFilm().get(i).getPoster())
              .apply(new RequestOptions().override(382,566))
              .into(filmViewHolder.img_poster);
   }

   @Override
   public int getItemCount() {
      return getListFilm().size();
   }

   public class GridViewHolder extends RecyclerView.ViewHolder {
      public ImageView img_poster;

      public GridViewHolder(@NonNull View itemView) {
         super(itemView);
         img_poster = itemView.findViewById(R.id.img_poster);
      }
   }
}
