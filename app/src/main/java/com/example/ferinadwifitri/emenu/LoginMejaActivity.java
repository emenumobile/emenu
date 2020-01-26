package com.example.ferinadwifitri.emenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.ferinadwifitri.emenu.model.UserResponse;
import com.example.ferinadwifitri.emenu.rest.ApiClient;
import com.example.ferinadwifitri.emenu.rest.ApiInterface;
import com.example.ferinadwifitri.emenu.storage.SharedPrefManager;
import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginMejaActivity extends AppCompatActivity  implements ZXingScannerView.ResultHandler{
    private ZXingScannerView mScannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_meja);

        mScannerView = findViewById(R.id.scannerView);
//        setContentView(mScannerView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mScannerView.setResultHandler(this);
        mScannerView.startCamera();
    }


    @Override
    protected void onPause() {
        super.onPause();
        mScannerView.setResultHandler(this);
        mScannerView.stopCamera();
    }

    @Override
    public void handleResult(Result result) {
        String uNamePass = result.getText();
        String[] pisah = uNamePass.split("-");
        String uName = pisah[0];
        String pass = pisah[1];

        ApiInterface apiClient = ApiClient.getClient().create(ApiInterface.class);

        apiClient.loginMeja(uName, pass).enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                UserResponse userResponse = response.body();

                assert userResponse != null;
                if(!userResponse.getError()){
                    SharedPrefManager.getInstance(LoginMejaActivity.this)
                            .saveUser(userResponse.getUser(), true);

                    Intent intent = new Intent(LoginMejaActivity.this,HomeActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);

                }else {
                    Toast.makeText(LoginMejaActivity.this,userResponse.getMessage(),Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Toast.makeText(LoginMejaActivity.this,t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
