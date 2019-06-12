package com.malbacinematicuniverse;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.malbacinematicuniverse.R;

public class DetailFilmActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String EXTRA_INDEX = "extra_index";

    private Film list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_film);

        TextView  tvIkhtisar    = findViewById(R.id.tv_ikhtisar),
                  tvTglRilis    = findViewById(R.id.tv_tgl_rilis),
                  tvDurasi      = findViewById(R.id.tv_durasi),
                  tvRating      = findViewById(R.id.tv_rating),
                  tvAliran      = findViewById(R.id.tv_aliran),
                  tvSutradara   = findViewById(R.id.tv_sutradara),
                  tvPenulis     = findViewById(R.id.tv_penulis),
                  tvAktor       = findViewById(R.id.tv_aktor);

        ImageView imgTitleCard  = findViewById(R.id.img_title_card),
                  imgPoster     = findViewById(R.id.img_poster);

        Button btnSetShareDetail = findViewById(R.id.btn_set_share_detail);
        btnSetShareDetail.setOnClickListener(this);

        String index = getIntent().getStringExtra(EXTRA_INDEX);
        list = new Film();
        for (String[] aData : FilmData.data){
            if (index.equals(aData[11])){
                list.setNama(aData[0]);
                list.setIkhtisar(aData[1]);
                list.setTanggalRilis(aData[2]);
                list.setDurasi(aData[3]);
                list.setRating(aData[4]);
                list.setAliran(aData[5]);
                list.setSutradara(aData[6]);
                list.setPenulis(aData[7]);
                list.setAktor(aData[8]);
                list.setTitleCard(aData[9]);
                list.setPoster(aData[10]);
            }
        }
        tvIkhtisar.setText(list.getIkhtisar());
        tvTglRilis.setText(list.getTanggalRilis());
        tvDurasi.setText(list.getDurasi());
        tvRating.setText(list.getRating());
        tvAliran.setText(list.getAliran());
        tvSutradara.setText(list.getSutradara());
        tvPenulis.setText(list.getPenulis());
        tvAktor.setText(list.getAktor());
        Glide.with(this)
             .load(list.getTitleCard())
             .into(imgTitleCard);
        Glide.with(this)
             .load(list.getPoster())
             .into(imgPoster);
    }

   @Override
   public void onClick(View v) {
       if (v.getId() == R.id.btn_set_share_detail) {
           Toast.makeText(this, list.getNama() + " shared", Toast.LENGTH_SHORT).show();
       }
   }
}
