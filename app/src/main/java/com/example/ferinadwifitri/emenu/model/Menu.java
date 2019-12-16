package com.example.ferinadwifitri.emenu.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Menu {
    @SerializedName("id_menu")
    @Expose
    private Integer idMenu;
    @SerializedName("nama")
    @Expose
    private String nama;
    @SerializedName("harga")
    @Expose
    private Integer harga;
    @SerializedName("deskripsi")
    @Expose
    private String deskripsi;
    @SerializedName("stok")
    @Expose
    private Integer stok;
    @SerializedName("gambar")
    @Expose
    private String gambar;
    @SerializedName("kategori_id")
    @Expose
    private Integer kategoriId;

    public static final String id_menu = "ID_MENU";

    public Menu(Integer idMenu,String nama,Integer harga,String deskripsi,Integer stok,String gambar,Integer kategoriId){
        this.idMenu=idMenu;
        this.nama=nama;
        this.harga=harga;
        this.deskripsi=deskripsi;
        this.stok=stok;
        this.gambar=gambar;
        this.kategoriId=kategoriId;
    }

    public Integer getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(Integer idMenu) {
        this.idMenu = idMenu;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Integer getHarga() {
        return harga;
    }

    public void setHarga(Integer harga) {
        this.harga = harga;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public Integer getStok() {
        return stok;
    }

    public void setStok(Integer stok) {
        this.stok = stok;
    }

    public Object getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public Integer getKategoriId() {
        return kategoriId;
    }

    public void setKategoriId(Integer kategoriId) {
        this.kategoriId = kategoriId;
    }
}
