package com.malbacinematicuniverse;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.malbacinematicuniverse.R;

import java.util.ArrayList;

public class DetailFilmActivity extends AppCompatActivity {

    public static final String EXTRA_NAMA = "extra_nama";
    private ArrayList<Film> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_film);

        TextView  tv_ikhtisar    = findViewById(R.id.tv_ikhtisar),
                  tv_tgl_rilis   = findViewById(R.id.tv_tgl_rilis),
                  tv_durasi      = findViewById(R.id.tv_durasi),
                  tv_rating      = findViewById(R.id.tv_rating),
                  tv_aliran      = findViewById(R.id.tv_aliran),
                  tv_sutradara   = findViewById(R.id.tv_sutradara),
                  tv_penulis     = findViewById(R.id.tv_penulis),
                  tv_aktor       = findViewById(R.id.tv_aktor);

        ImageView img_title_card = findViewById(R.id.img_title_card),
                  img_poster     = findViewById(R.id.img_poster);

        String nama = getIntent().getStringExtra(EXTRA_NAMA);
        list = new ArrayList<>();
        list.addAll(FilmData.getData(nama));
        tv_ikhtisar.setText(list.get(0).getIkhtisar());
        tv_tgl_rilis.setText(list.get(0).getTanggalRilis());
        tv_durasi.setText(list.get(0).getDurasi());
        tv_rating.setText(list.get(0).getRating());
        tv_aliran.setText(list.get(0).getAliran());
        tv_sutradara.setText(list.get(0).getSutradara());
        tv_penulis.setText(list.get(0).getPenulis());
        tv_aktor.setText(list.get(0).getAktor());
        Glide.with(this)
             .load(list.get(0).getTitleCard())
             .into(img_title_card);
        Glide.with(this)
             .load(list.get(0).getPoster())
             .into(img_poster);
    }
}