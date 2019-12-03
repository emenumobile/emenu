package com.example.ferinadwifitri.emenu;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ferinadwifitri.emenu.model.Menu;

import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder> {
    private Context context;
    private List<Menu> menus;

    MenuAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public MenuAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_menu,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuAdapter.ViewHolder viewHolder, int i) {
        final Menu menu = menus.get(i);

        viewHolder.menuTxt.setText(menu.getNama());
        viewHolder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Klik id:" + menu.getId() + " - "
                        + menu.getNama(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        int size;
        if(menus == null){
            size= 0;
        }
        else{
            size = menus.size();
        }
        return size;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView menu;
        TextView menuTxt;
        View view;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            menu = itemView.findViewById(R.id.cardview_menu);
            menuTxt = itemView.findViewById(R.id.nama_menu);
            view = itemView;
        }
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }
}
