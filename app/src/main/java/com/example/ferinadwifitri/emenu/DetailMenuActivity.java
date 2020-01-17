package com.example.ferinadwifitri.emenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ferinadwifitri.emenu.model.Menu;
import com.example.ferinadwifitri.emenu.rest.ApiClient;
import com.google.gson.GsonBuilder;

public class DetailMenuActivity extends AppCompatActivity {

    TextView Nama,Harga,Deskripsi;
    ImageView Gambar;
    Menu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_menu);

        Nama = (TextView)findViewById(R.id.food_name);
        Harga = (TextView)findViewById(R.id.harga);
        Deskripsi = (TextView)findViewById(R.id.food_description);
        Gambar = (ImageView)findViewById(R.id.gambar_menu);

        menu = new GsonBuilder()
                .create()
                .fromJson(getIntent().getStringExtra("menus"), Menu.class);

        Nama.setText(menu.getNama());
        Harga.setText(menu.getHarga().toString());
        Deskripsi.setText(menu.getDeskripsi());
        Glide.with(this).load(ApiClient.IMAGE_URL+menu.getGambar() ).into(Gambar);
    }

    public void onClickCart(View view) {
        Intent intent = new Intent(DetailMenuActivity.this,KeranjangActivity.class);
        startActivity(intent);
    }
}
