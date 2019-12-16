package com.example.ferinadwifitri.emenu.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ferinadwifitri.emenu.DetailMenuActivity;
import com.example.ferinadwifitri.emenu.R;
import com.example.ferinadwifitri.emenu.model.Menu;
import com.google.gson.GsonBuilder;

import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder> {
    private List<Menu> menus;
    private int rowLayout;
    private Context context;

    public static class MenuViewHolder extends RecyclerView.ViewHolder {
        LinearLayout menuLayout;
        TextView nama;
        TextView deskripsi;
        TextView harga;

        public MenuViewHolder(View v) {
            super(v);
            menuLayout = (LinearLayout) v.findViewById(R.id.menuLayout);
            nama = (TextView) v.findViewById(R.id.nama);
            deskripsi = (TextView) v.findViewById(R.id.deskripsi);
            harga = (TextView) v.findViewById(R.id.harga);
        }
    }

    public MenuAdapter(List<Menu> menus, int rowLayout, Context context) {
        this.menus = menus;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public MenuAdapter.MenuViewHolder onCreateViewHolder(ViewGroup parent,
                                                                 int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new MenuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MenuViewHolder holder, final int position) {
        holder.nama.setText(menus.get(position).getNama());
        holder.deskripsi.setText(menus.get(position).getDeskripsi());
        holder.harga.setText(menus.get(position).getHarga().toString());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Menu data = menus.get(position);
                Intent i = new Intent(holder.itemView.getContext(), DetailMenuActivity.class);
                i.putExtra("menus",new GsonBuilder().create().toJson(data));
                holder.itemView.getContext().startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return menus.size();
    }
}
