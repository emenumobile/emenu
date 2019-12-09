package com.example.ferinadwifitri.emenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.ferinadwifitri.emenu.Adapter.MenuAdapter;
import com.example.ferinadwifitri.emenu.model.Menu;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_menu);

        recyclerView = findViewById(R.id.recycler_menu);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        MenuAdapter adapter = new MenuAdapter(MenuActivity.this);
        recyclerView.setAdapter(adapter);

        //ambil data dummy local
        List<Menu> menus = new ArrayList<>();
        Menu menu = new Menu(1, "Ramen Original");
        menus.add(menu);
        menus.add(new Menu(2,"Ramen Cumi"));
        menus.add(new Menu(3, "Yakisoba"));
        menus.add(new Menu(4,"Okonomiyaki"));

        //set data ke adapter
        adapter.setMenus(menus);
        adapter.notifyDataSetChanged();
    }

    public void onClickDetailMenu(View view) {
        Intent intent = new Intent(MenuActivity.this,DetailMenuActivity.class);
        startActivity(intent);
    }
}
