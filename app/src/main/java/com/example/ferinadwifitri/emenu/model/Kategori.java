package com.example.ferinadwifitri.emenu.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * TODO 4 : change model into api response check http://jsonschema2pojo.org
 * copy paste response from postman into url above then make model here
 * don't forget to check this model name. it must be same.
 */
public class Kategori {
    @SerializedName("id_kategori")
    @Expose
    private Integer idKategori;
    @SerializedName("nama_kategori")
    @Expose
    private String namaKategori;
    @SerializedName("gambar")
    @Expose
    private String gambar;

    public Kategori(Integer idKategori, String namaKategori, String gambar){
        this.idKategori = idKategori;
        this.namaKategori =namaKategori;
        this.gambar = gambar;
    }

    public Integer getIdKategori() {
        return idKategori;
    }

    public void setIdKategori(Integer idKategori) {
        this.idKategori = idKategori;
    }

    public String getNamaKategori() {
        return namaKategori;
    }

    public void setNamaKategori(String namaKategori) {
        this.namaKategori = namaKategori;
    }

    public Object getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }
}