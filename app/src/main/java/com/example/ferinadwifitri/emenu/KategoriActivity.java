package com.example.ferinadwifitri.emenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.ferinadwifitri.emenu.Adapter.KategoriAdapter;
import com.example.ferinadwifitri.emenu.model.Kategori;

import java.util.ArrayList;
import java.util.List;

public class KategoriActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_kategori);

        recyclerView = findViewById(R.id.recycler_kategori);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        KategoriAdapter adapter = new KategoriAdapter(KategoriActivity.this);
        recyclerView.setAdapter(adapter);

        //ambil data dummy local
        List<Kategori> kategoris = new ArrayList<>();
        Kategori kategori = new Kategori(1, "Ramen");
        kategoris.add(kategori);
        kategoris.add(new Kategori(2,"Nasi"));
        kategoris.add(new Kategori(3, "Minuman"));

        //set data ke adapter
        adapter.setKategoris(kategoris);
        adapter.notifyDataSetChanged();

    }
}
