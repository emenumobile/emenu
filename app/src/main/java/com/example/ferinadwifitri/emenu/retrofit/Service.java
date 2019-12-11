package com.example.ferinadwifitri.emenu.retrofit;


import com.example.ferinadwifitri.emenu.model.KategoriResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * TODO 3: write your api endpoint here with parameters
 * example : your api link http://emenu.com/api/user/signup
 * then -> your baseurl before http://emenu.com/api/  (check TODO2)
 * so your endpoint is user/signup
 */

public interface Service {

    /**
     * formurlencoded is for post
     * @POST("this is your endpoint")
     * Call<your model here> your-function-name(@Field("your key in postman") variable varName)
     */
//    @FormUrlEncoded
//    @POST("user/signup")
//    Call<Auth> signUp(@Field("username") String uName,
//                      @Field("password") String pass,
//                      @Field("email") String email);
//
//    @FormUrlEncoded
//    @POST("user/google-signin")
//    Call<Auth> gSignIn(@Field("username") String uName,
//                       @Field("password") String idToken,
//                       @Field("email") String email);


    /**
     * remove formurlencoded for get
     * @GET("this is your endpoint")
     * Call<your model here> your-function-name(@Field("your key in postman") variable varName)
     * example below
     */


    @GET("mobile/kategori")
    Call<KategoriResponse> getDataKategori();





}
