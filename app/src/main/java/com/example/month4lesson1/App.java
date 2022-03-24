package com.example.month4lesson1;

import android.app.Application;

import androidx.room.Room;

import com.example.month4lesson1.local.AppDataBase;
import com.example.month4lesson1.ui.Prefs;
import com.google.firebase.auth.FirebaseAuth;

public class App extends Application {
    public static Prefs prefs;
    public static FirebaseAuth auth;
    public static AppDataBase appDataBase;
    @Override
    public void onCreate() {
        super.onCreate();
        prefs = new Prefs(this);
        auth = FirebaseAuth.getInstance();
         appDataBase = Room.databaseBuilder(this, AppDataBase.class, "dataBase")
                 .fallbackToDestructiveMigration().allowMainThreadQueries().build();

    }
}
