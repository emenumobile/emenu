package com.example.ferinadwifitri.emenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.ferinadwifitri.emenu.Adapter.KategoriAdapter;
import com.example.ferinadwifitri.emenu.R;
import com.example.ferinadwifitri.emenu.model.Kategori;
import com.example.ferinadwifitri.emenu.model.KategoriResponse;
import com.example.ferinadwifitri.emenu.rest.ApiClient;
import com.example.ferinadwifitri.emenu.rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class KategoriActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_kategori);

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_kategori);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<KategoriResponse> call = apiService.getAllCategories();
        call.enqueue(new Callback<KategoriResponse>() {
            @Override
            public void onResponse(Call<KategoriResponse> call, Response<KategoriResponse> response) {
                int statusCode = response.code();
                List<Kategori> kategoris = response.body().getKategori();
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
