package com.example.ferinadwifitri.emenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ferinadwifitri.emenu.model.User;
import com.example.ferinadwifitri.emenu.storage.SharedPrefManager;

public class ProfilActivity extends AppCompatActivity {
    private TextView nama,id_member,nominal,alamat,no_telp;
    private Button GenerateQr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nama = findViewById(R.id.nama);
        alamat=findViewById(R.id.alamat);
        no_telp=findViewById(R.id.no_telp);
        id_member=findViewById(R.id.id_member);
        nominal =findViewById(R.id.nominal);
        GenerateQr =  findViewById(R.id.btnqr);

        final User user = SharedPrefManager.getInstance(this).getUser();
        nama.setText(user.getNama());
        alamat.setText(user.getAlamat());
        no_telp.setText(user.getNoHp());
        id_member.setText(user.getIdMember().toString());
        nominal.setText(user.getSaldo().toString());

        GenerateQr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(GenerateQr.getContext(),QrCodeActivity.class);
                i.putExtra("id",user.getIdMember().toString());
                GenerateQr.getContext().startActivity(i);

            }
        });
    }



    public void onClickQrcode(View view){
        Intent intent = new Intent(ProfilActivity.this,QrCodeActivity.class);
        startActivity(intent);
    }
}
