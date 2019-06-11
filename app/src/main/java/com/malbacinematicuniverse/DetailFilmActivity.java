package com.malbacinematicuniverse;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.malbacinematicuniverse.R;

public class DetailFilmActivity extends AppCompatActivity {

    public static final String EXTRA_NAMA = "extra_nama";

    private Film list;

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
        FilmData.getData(nama);
        list = new Film();
        tv_ikhtisar.setText(list.getIkhtisar());
        tv_tgl_rilis.setText(list.getTanggalRilis());
        tv_durasi.setText(list.getDurasi());
        tv_rating.setText(list.getRating());
        tv_aliran.setText(list.getAliran());
        tv_sutradara.setText(list.getSutradara());
        tv_penulis.setText(list.getPenulis());
        tv_aktor.setText(list.getAktor());
        Glide.with(this)
             .load(list.getTitleCard())
             .into(img_title_card);
        Glide.with(this)
             .load(list.getPoster())
             .into(img_poster);
    }
}
