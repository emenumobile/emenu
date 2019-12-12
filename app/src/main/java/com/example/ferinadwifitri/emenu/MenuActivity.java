package com.example.ferinadwifitri.emenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import com.example.ferinadwifitri.emenu.Adapter.MenuAdapter;
import com.example.ferinadwifitri.emenu.model.Menu;
import com.example.ferinadwifitri.emenu.model.MenuResponse;
import com.example.ferinadwifitri.emenu.rest.ApiClient;
import com.example.ferinadwifitri.emenu.rest.ApiInterface;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MenuActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_menu);

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_menu);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<MenuResponse> call = apiService.getSemuaMenu();
        call.enqueue(new Callback<MenuResponse>() {
            @Override
            public void onResponse(Call<MenuResponse> call, Response<MenuResponse> response) {
                int statusCode = response.code();
                List<Menu> menus = response.body().getMenu();
                recyclerView.setAdapter(new MenuAdapter(menus, R.layout.activity_menu, getApplicationContext()));
            }
            @Override
            public void onFailure(Call<MenuResponse> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });
    }
}
