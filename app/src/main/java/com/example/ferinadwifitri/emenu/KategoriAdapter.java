package com.example.ferinadwifitri.emenu;


import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ferinadwifitri.emenu.model.Kategori;

import java.util.List;

public class KategoriAdapter extends RecyclerView.Adapter<KategoriAdapter.ViewHolder> {
    private Context context;
    private List<Kategori> kategoris;

    public KategoriAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_kategori,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final Kategori kategori = kategoris.get(i);

        viewHolder.kategoriTxt.setText(kategori.getNama());
        viewHolder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Klik id:" + String.valueOf(kategori.getId()) + " - "
                        + kategori.getNama(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public int getItemCount() {
        int size;
        if (kategoris == null){
            size = 0;
        } else {
            size = kategoris.size();
        }
        return size;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView kategoriImage;
        TextView kategoriTxt;
        View view;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            kategoriImage = itemView.findViewById(R.id.kategori_img);
            kategoriTxt = itemView.findViewById(R.id.nama_kategori);
            view = itemView;
        }
    }

    public void setKategoris(List<Kategori> kategoris) {
        this.kategoris = kategoris;
    }
}
