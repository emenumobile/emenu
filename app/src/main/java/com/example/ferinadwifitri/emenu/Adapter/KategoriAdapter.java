package com.example.ferinadwifitri.emenu.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ferinadwifitri.emenu.MenuActivity;
import com.example.ferinadwifitri.emenu.R;
import com.example.ferinadwifitri.emenu.model.Kategori;

import java.util.List;

public class KategoriAdapter extends RecyclerView.Adapter<KategoriAdapter.KategoriViewHolder> {
    private List<Kategori> kategoris;
    private int rowLayout;
    private Context context;

    public static class KategoriViewHolder extends RecyclerView.ViewHolder {
        View view;
        LinearLayout kategoriLayout;
        TextView nama_kategori;

        public KategoriViewHolder(View v) {
            super(v);
            kategoriLayout = (LinearLayout) v.findViewById(R.id.kategori_layout);
            nama_kategori = (TextView) v.findViewById(R.id.nama_kategori);
            view = v;
        }
    }

    public KategoriAdapter(List<Kategori> kategoris, int rowLayout, Context context) {
        this.kategoris = kategoris;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public KategoriAdapter.KategoriViewHolder onCreateViewHolder(ViewGroup parent,
                                                            int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new KategoriViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final KategoriViewHolder holder, final int position) {
        holder.nama_kategori.setText(kategoris.get(position).getNamaKategori());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Kategori data = kategoris.get(position);
                Intent i = new Intent(holder.itemView.getContext(),MenuActivity.class);
                i.putExtra("key",data.getIdKategori());
                holder.itemView.getContext().startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return kategoris.size();
    }
}
