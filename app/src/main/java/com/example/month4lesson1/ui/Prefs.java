package com.example.month4lesson1.ui;

import android.content.Context;
import android.content.SharedPreferences;

public class Prefs {
    private SharedPreferences preferences;

    public Prefs(Context context ) {
        preferences = context.getSharedPreferences("prefs", Context.MODE_PRIVATE);
    }

    public  void isShowed(){
        preferences.edit().putBoolean("keyBool", true).apply();
    }

    public Boolean isShown() {
        return preferences.getBoolean("keyBool", false);
    }
}
