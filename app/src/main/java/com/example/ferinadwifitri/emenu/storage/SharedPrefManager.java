package com.example.ferinadwifitri.emenu.storage;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.ferinadwifitri.emenu.model.User;

public class SharedPrefManager {
    private static final String SHARED_PREF_NAME= "my_shared_preff";

    private static SharedPrefManager mInstance;
    private Context mContext;

    public SharedPrefManager(Context mContext) {
        this.mContext = mContext;
    }

    public static synchronized SharedPrefManager getInstance(Context mContext){
        if(mInstance==null){
            mInstance = new SharedPrefManager(mContext);
        }
        return mInstance;
    }

    public void saveUser(User user, boolean isMeja){
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();


        editor.putInt("user_id",user.getUserId());
        editor.putString("email",user.getEmail());
        if (isMeja){
            editor.putString("nama","Meja " + String.valueOf(user.getUserId()));
        }else {
            editor.putString("nama",user.getNama());
        }
        editor.putInt("id_member",user.getIdMember());
        editor.putString("alamat",user.getAlamat());
        editor.putString("no_hp",user.getNoHp());
        editor.putInt("saldo",user.getSaldo());

        editor.apply();
    }

    public boolean isLoggedIn(){
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        return sharedPreferences.getInt("user_id",-1) != -1;
    }

    public User getUser(){
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        return new User(
                sharedPreferences.getInt("user_id",-1),
                sharedPreferences.getString("email",null),
                sharedPreferences.getString("nama",null),
                sharedPreferences.getInt("id_member",1),
                sharedPreferences.getString("no_hp",null),
                sharedPreferences.getString("alamat",null),
                sharedPreferences.getInt("saldo",1)
        );

    }

    public void clear(){
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }
}
