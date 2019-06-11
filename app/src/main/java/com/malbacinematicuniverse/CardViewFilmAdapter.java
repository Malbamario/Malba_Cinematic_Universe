package com.malbacinematicuniverse;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.malbacinematicuniverse.R;

import java.util.ArrayList;

public class CardViewFilmAdapter extends RecyclerView.Adapter<CardViewFilmAdapter.CardViewViewHolder> {

   public CardViewFilmAdapter(Context context) {
      this.context = context;
   }

   Context context;

   public ArrayList<Film> getListFilm() {
      return listFilm;
   }

   public void setListFilm(ArrayList<Film> listFilm) {
      this.listFilm = listFilm;
   }

   ArrayList<Film> listFilm;

   @NonNull
   @Override
   public CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
      View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_cardview_film, viewGroup, false);
      return new CardViewViewHolder(view);
   }

   @Override
   public void onBindViewHolder(@NonNull CardViewViewHolder cardViewViewHolder, final int i) {
      Glide.with(context)
              .load(getListFilm().get(i).getPoster())
              .apply(new RequestOptions().override(382, 566))
              .into(cardViewViewHolder.imgPoster);

      cardViewViewHolder.tvName.setText(getListFilm().get(i).getNama());
      cardViewViewHolder.tvDes.setText(getListFilm().get(i).getIkhtisar());

      cardViewViewHolder.btnSetShare.setOnClickListener(new CustomOnItemClickListerner(i, new CustomOnItemClickListerner.OnItemClickCallback() {
         @Override
         public void onItemClicked(View view, int position) {
            Toast.makeText(context, getListFilm().get(i).getNama()+" shared", Toast.LENGTH_SHORT).show();
         }
      }));

      cardViewViewHolder.btnSetDetail.setOnClickListener(new CustomOnItemClickListerner(i, new CustomOnItemClickListerner.OnItemClickCallback() {
         @Override
         public void onItemClicked(View view, int position) {
            Intent intent = new Intent(context, DetailFilmActivity.class);
            intent.putExtra(DetailFilmActivity.EXTRA_NAMA, getListFilm().get(i).getNama());
            context.startActivity(intent);
         }
      }));
   }

   @Override
   public int getItemCount() {
      return 0;
   }

   public class CardViewViewHolder extends RecyclerView.ViewHolder {
      public ImageView imgPoster;
      public TextView tvName, tvDes;
      public Button btnSetShare, btnSetDetail;

      public CardViewViewHolder(@NonNull View itemView) {
         super(itemView);

         imgPoster = itemView.findViewById(R.id.img_item_poster);
         tvName = itemView.findViewById(R.id.tv_nama_cv);
         tvDes = itemView.findViewById(R.id.tv_des_cv);
         btnSetShare = itemView.findViewById(R.id.btn_set_share);
         btnSetDetail = itemView.findViewById(R.id.btn_set_detail);
      }
   }
}
