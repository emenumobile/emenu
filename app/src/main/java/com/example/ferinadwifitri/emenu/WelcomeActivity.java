package com.example.ferinadwifitri.emenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);


    }

    public void onClickMember(View view) {
        Intent intent = new Intent(WelcomeActivity.this,MainActivity.class);
        startActivity(intent);
    }

    public void onClickPengunjung(View view) {
        Intent intent = new Intent(WelcomeActivity.this,LoginMejaActivity.class);
        startActivity(intent);
    }
}
