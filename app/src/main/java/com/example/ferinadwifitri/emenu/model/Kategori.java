package com.example.ferinadwifitri.emenu.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

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

    public Kategori(Integer idKategori, String namaKategori){
        this.idKategori = idKategori;
        this.namaKategori =namaKategori;
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
}