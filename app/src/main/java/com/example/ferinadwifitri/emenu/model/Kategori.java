package com.example.ferinadwifitri.emenu.model;

/**
 * TODO 4 : change model into api response check http://jsonschema2pojo.org
 * copy paste response from postman into url above then make model here
 * don't forget to check this model name. it must be same.
 */
public class Kategori {
    private int id;
    private String nama;
    private String urlGambar;

    public Kategori(int id, String nama) {
        this.id = id;
        this.nama = nama;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getUrlGambar() {
        return urlGambar;
    }

    public void setUrlGambar(String urlGambar) {
        this.urlGambar = urlGambar;
    }
}
