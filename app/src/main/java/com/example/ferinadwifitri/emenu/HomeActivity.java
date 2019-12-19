package com.example.ferinadwifitri.emenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;

import com.example.ferinadwifitri.emenu.model.User;
import com.example.ferinadwifitri.emenu.storage.SharedPrefManager;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    private CardView CvTransaksi;
    private TextView namaPelanggan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        namaPelanggan = findViewById(R.id.txtnamapelanggan);

        final User user = SharedPrefManager.getInstance(this).getUser();
        namaPelanggan.setText(user.getNama());

        findViewById(R.id.btnLogout).setOnClickListener(this);

        CvTransaksi = findViewById(R.id.cv_transaksi);
        CvTransaksi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (CvTransaksi.getContext(),PesananActivity.class);
                intent.putExtra("id",user.getIdMember());
                CvTransaksi.getContext().startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(!SharedPrefManager.getInstance(this).isLoggedIn()){
            Intent intent = new Intent(this,MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
    }

    public void onClickMenu(View view) {
        Intent intent = new Intent(HomeActivity.this,MenuActivity.class);
        startActivity(intent);
    }

    public void onClickKategori (View view){
        Intent intent = new Intent (HomeActivity.this, KategoriActivity.class);
        startActivity(intent);
    }

    public void onClickKeranjang(View view) {
        Intent intent = new Intent (HomeActivity.this,KeranjangActivity.class);
        startActivity(intent);
    }



    public void onClickProfil (View view){
        Intent intent = new Intent(HomeActivity.this,ProfilActivity.class);
        startActivity(intent);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnLogout:
                logout();
                break;
        }
    }

    private void logout() {
        SharedPrefManager.getInstance(this).clear();
        Intent intent = new Intent(this,WelcomeActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}
