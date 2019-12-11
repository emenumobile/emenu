package com.example.ferinadwifitri.emenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.ferinadwifitri.emenu.model.Kategori;
import com.example.ferinadwifitri.emenu.model.Menu;
import com.example.ferinadwifitri.emenu.retrofit.Client;
import com.example.ferinadwifitri.emenu.retrofit.Service;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private EditText nomorMejaEdt, passEdt, namaEdt;
//    private String nomorMeja, password, namaPelanggan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nomorMejaEdt = findViewById(R.id.nomormeja_main_edt);
        passEdt = findViewById(R.id.pass_main_edt);
        namaEdt = findViewById(R.id.nama_main_edt);


    }


    public void onClickLogin(View view) {
        String nomorMeja = nomorMejaEdt.getText().toString();
        String password = passEdt.getText().toString();
        String namaPelanggan = namaEdt.getText().toString();

        loginDB(namaPelanggan, nomorMeja, password);

    }

    private void loginDB(String namaPelanggan, String nomorMeja, String pass){

        // TODO 5: login implementation with retrofit
        // example below

//        Service api = Client.createService(Service.class);
//        api.getKategori().enqueue(new Callback<List<Kategori>>() {
//            @Override
//            public void onResponse(Call<List<Kategori>> call,
//                                   Response<List<Kategori>> response) {
//                //response if success
//                List<Kategori> kategoris = response.body();
//
//            }
//
//            @Override
//            public void onFailure(Call<List<Kategori>> call,
//                                  Throwable t) {
//                //response if fail
//
//            }
//        });


        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
        intent.putExtra("KeyNama", namaPelanggan);
        intent.putExtra("KeyNomor", nomorMeja);
        startActivity(intent);
    }
}
