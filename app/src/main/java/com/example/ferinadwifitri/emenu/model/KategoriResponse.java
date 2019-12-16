package com.example.ferinadwifitri.emenu.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class KategoriResponse {
    @SerializedName("kategori")
    @Expose
    private List<Kategori> kategori = null;

    public List<Kategori> getKategori() {
        return kategori;
    }

    public void setKategori(List<Kategori> kategori) {
        this.kategori = kategori;
    }

}
