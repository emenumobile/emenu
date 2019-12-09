package com.example.ferinadwifitri.emenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DetailMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_menu);
    }

    public void onClickCart(View view) {
        Intent intent = new Intent(DetailMenuActivity.this,KeranjangActivity.class);
        startActivity(intent);
    }
}
