package com.example.ferinadwifitri.emenu.rest;

import com.example.ferinadwifitri.emenu.model.Kategori;
import com.example.ferinadwifitri.emenu.model.KategoriResponse;
import com.example.ferinadwifitri.emenu.model.Menu;
import com.example.ferinadwifitri.emenu.model.MenuResponse;
import com.example.ferinadwifitri.emenu.model.TransaksiResponse;
import com.example.ferinadwifitri.emenu.model.UserResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface ApiInterface {

    @GET("mobile/lihat_menu")
    Call<MenuResponse> getSemuaMenu();

    @GET("mobile/kategori")
    Call<KategoriResponse> getAllCategories();

    @GET("mobile/carikategori/{id}")
    Call<MenuResponse > getByCategories(@Path("id") int kategoriId);

    @GET("mobile/login/{email}/{password}")
    Call<UserResponse> userLogin(@Path("email") String email,
                                 @Path("password") String password);

    @GET("mobile/lihat_transaksi/{id_member}")
    Call<TransaksiResponse> riwayatTransaksi(@Path("id_member") int memberId);

    @GET("mobile/loginmeja/{username}/{password}")
    Call<UserResponse> loginMeja(@Path("username") String username,
                                 @Path("password") String password);



}
