package com.example.ferinadwifitri.emenu.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ferinadwifitri.emenu.R;
import com.example.ferinadwifitri.emenu.model.Transaksi;

import java.util.List;

public class TransaksiAdapter extends RecyclerView.Adapter<TransaksiAdapter.TransaksiViewHolder> {
    private List<Transaksi> transaksis;
    private int rowLayout;
    private Context context;

    public TransaksiAdapter(List<Transaksi> transaksis, int rowLayout, Context context) {
        this.transaksis = transaksis;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @NonNull
    @Override
    public TransaksiViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(rowLayout,viewGroup,false);
        return new TransaksiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TransaksiViewHolder transaksiViewHolder, int i) {
        transaksiViewHolder.ID.setText("No. Transaksi : "+transaksis.get(i).getIdTransaksi().toString());
        transaksiViewHolder.Tanggal.setText("Tanggal :"+transaksis.get(i).getTanggal());
        transaksiViewHolder.Harga.setText("Total Pembayaran :"+transaksis.get(i).getTotalHarga().toString());
        transaksiViewHolder.Status.setText(transaksis.get(i).getStatusBayarId());

    }

    @Override
    public int getItemCount() {
        return transaksis.size();
    }

    public class TransaksiViewHolder extends RecyclerView.ViewHolder {
        LinearLayout transaksiLayout;
        TextView ID;
        TextView Tanggal;
        TextView Harga,Status;

        public TransaksiViewHolder(@NonNull View itemView) {
            super(itemView);
            transaksiLayout =(LinearLayout) itemView.findViewById(R.id.pesananLayout);
            ID = (TextView) itemView.findViewById(R.id.id_transaksi);
            Tanggal = (TextView) itemView.findViewById(R.id.tanggal);
            Harga =(TextView) itemView.findViewById(R.id.total_harga);
            Status = (TextView) itemView.findViewById(R.id.harga);
        }
    }
}
