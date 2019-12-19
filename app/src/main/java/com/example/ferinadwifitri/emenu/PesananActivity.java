package com.example.ferinadwifitri.emenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.ferinadwifitri.emenu.Adapter.MenuAdapter;
import com.example.ferinadwifitri.emenu.Adapter.TransaksiAdapter;
import com.example.ferinadwifitri.emenu.R;
import com.example.ferinadwifitri.emenu.model.Menu;
import com.example.ferinadwifitri.emenu.model.MenuResponse;
import com.example.ferinadwifitri.emenu.model.Transaksi;
import com.example.ferinadwifitri.emenu.model.TransaksiResponse;
import com.example.ferinadwifitri.emenu.rest.ApiClient;
import com.example.ferinadwifitri.emenu.rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PesananActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_pesanan);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_pesanan);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



        if(getIntent().hasExtra("id")){
            ApiInterface apiService =
                    ApiClient.getClient().create(ApiInterface.class);

            Call<TransaksiResponse> call = apiService.riwayatTransaksi(getIntent().getIntExtra("id",2));
        call.enqueue(new Callback<TransaksiResponse>() {
                @Override
                public void onResponse(Call<TransaksiResponse> call, Response<TransaksiResponse> response) {
                    int statusCode = response.code();
                    List<Transaksi> transaksis = response.body().getTransaksi();
                    recyclerView.setAdapter(new TransaksiAdapter(transaksis, R.layout.activity_pesanan, getApplicationContext()));
                }
                @Override
                public void onFailure(Call<TransaksiResponse> call, Throwable t) {
                    Log.e(TAG, t.toString());
                }
            });

        }
    }
}
