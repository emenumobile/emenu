package com.example.ferinadwifitri.emenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    private TextView namaPelanggan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        namaPelanggan = findViewById(R.id.txtnamapelanggan);

        String namaStr, nomorStr;
        namaStr = getIntent().getStringExtra("KeyNama");
        namaPelanggan.setText(namaStr);
    }


    public void onClickMenu(View view) {
        Intent intent = new Intent(HomeActivity.this,MenuActivity.class);
        startActivity(intent);
    }

    public void onClickKategori (View view){
        Intent intent = new Intent (HomeActivity.this,kategoriActivity.class);
        startActivity(intent);
    }

    public void onClickKeranjang(View view) {
        Intent intent = new Intent (HomeActivity.this,KeranjangActivity.class);
        startActivity(intent);
    }

    public void onClickPesanan (View view){
        Intent intent = new Intent (HomeActivity.this,PesananActivity.class);
        startActivity(intent);
    }

    public void onClickProfil (View view){
        Intent intent = new Intent(HomeActivity.this,ProfilActivity.class);
        startActivity(intent);
    }



}
