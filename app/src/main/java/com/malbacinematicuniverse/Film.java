package com.malbacinematicuniverse;

import android.os.Parcel;
import android.os.Parcelable;

public class Film implements Parcelable {

    private String nama, ikhtisar, tanggalRilis, durasi, rating, aktor, aliran, sutradara, penulis, poster, titleCard;

    protected Film(Parcel in) {
        nama = in.readString();
        ikhtisar = in.readString();
        tanggalRilis = in.readString();
        durasi = in.readString();
        rating = in.readString();
        aktor = in.readString();
        aliran = in.readString();
        sutradara = in.readString();
        penulis = in.readString();
        poster = in.readString();
        titleCard = in.readString();
        index = in.readString();
    }

    public Film() {

    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nama);
        dest.writeString(ikhtisar);
        dest.writeString(tanggalRilis);
        dest.writeString(durasi);
        dest.writeString(rating);
        dest.writeString(aktor);
        dest.writeString(aliran);
        dest.writeString(sutradara);
        dest.writeString(penulis);
        dest.writeString(poster);
        dest.writeString(titleCard);
        dest.writeString(index);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Film> CREATOR = new Creator<Film>() {
        @Override
        public Film createFromParcel(Parcel in) {
            return new Film(in);
        }

        @Override
        public Film[] newArray(int size) {
            return new Film[size];
        }
    };

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    private String index;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getIkhtisar() {
        return ikhtisar;
    }

    public void setIkhtisar(String ikhtisar) {
        this.ikhtisar = ikhtisar;
    }

    public String getTanggalRilis() {
        return tanggalRilis;
    }

    public void setTanggalRilis(String tanggalRilis) {
        this.tanggalRilis = tanggalRilis;
    }

    public String getDurasi() {
        return durasi;
    }

    public void setDurasi(String durasi) {
        this.durasi = durasi;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getAktor() {

        return aktor;
    }

    public void setAktor(String aktor) {
        this.aktor = aktor;
    }

    public String getAliran() {
        return aliran;
    }

    public void setAliran(String aliran) {
        this.aliran = aliran;
    }

    public String getSutradara() {
        return sutradara;
    }

    public void setSutradara(String sutradara) {
        this.sutradara = sutradara;
    }

    public String getPenulis() {
        return penulis;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getTitleCard() {
        return titleCard;
    }

    public void setTitleCard(String titleCard) {
        this.titleCard = titleCard;
    }
}
