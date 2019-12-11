package com.example.ferinadwifitri.emenu;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.ferinadwifitri.emenu.Adapter.KategoriAdapter;
import com.example.ferinadwifitri.emenu.model.Kategori;
import com.example.ferinadwifitri.emenu.model.KategoriResponse;
import com.example.ferinadwifitri.emenu.retrofit.Client;
import com.example.ferinadwifitri.emenu.retrofit.Service;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class KategoriActivity extends AppCompatActivity {

    private static final String TAG = KategoriActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_kategori);


        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_kategori);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Service apiService =
                Client.getClient().create(Service.class);

        Call<KategoriResponse> call = apiService.getDataKategori();
        call.enqueue(new Callback<KategoriResponse>() {
            @Override
            public void onResponse(Call<KategoriResponse> call, Response<KategoriResponse> response) {
                int statusCode = response.code();

                List<Kategori> kategoris = response.body().getResults();
                recyclerView.setAdapter(new KategoriAdapter(kategoris, R.layout.activity_kategori, getApplicationContext()));
            }

            @Override
            public void onFailure(Call<KategoriResponse> call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
            }
        });
    }
}


