package com.example.ferinadwifitri.emenu.retrofit;


import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Client{

    /** TODO 2 : change base url to localhost example 127.0.0.0/api/ (done)
     *  if u have web-server change to your base-url like http://emenu.com/api/
     */
    public static final String BASE_URL = "http://192.168.100.28/";
    private static Retrofit retrofit = null;


    public static Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}