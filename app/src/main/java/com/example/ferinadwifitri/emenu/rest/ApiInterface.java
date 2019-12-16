package com.example.ferinadwifitri.emenu.rest;

import com.example.ferinadwifitri.emenu.model.Kategori;
import com.example.ferinadwifitri.emenu.model.KategoriResponse;
import com.example.ferinadwifitri.emenu.model.Menu;
import com.example.ferinadwifitri.emenu.model.MenuResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface ApiInterface {

    @GET("mobile/lihat_menu")
    Call<MenuResponse> getSemuaMenu();

    @GET("mobile/kategori")
    Call<KategoriResponse> getAllCategories();

    @GET("mobile/carikategori/{id}")
    Call<MenuResponse > getByCategories(@Path("id") int kategoriId);



}
