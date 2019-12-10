package com.example.ferinadwifitri.emenu.retrofit;


import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Client{

    /** TODO 2 : change base url to localhost example 127.0.0.0/api/
     *  if u have web-server change to your base-url like http://emenu.com/api/
     */
    private static final String BASE_URL = "192.168.100.1";


    private static OkHttpClient.Builder sHttpClient =
            //can add interceptors here
            new OkHttpClient.Builder();

    private static Retrofit.Builder sBuilder =
            new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(sHttpClient.build());

    public static <T> T createService(Class<T> serviceClass) {
        return sBuilder.build().create(serviceClass);
    }
}