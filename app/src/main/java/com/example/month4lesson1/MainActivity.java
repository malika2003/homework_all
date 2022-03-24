package com.example.month4lesson1;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.month4lesson1.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private Boolean isShow;
    private  NavController navController;
    private BottomNavigationView navView;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initNavController();
        navigateFragment();
        hideOrShowButtonNav();
    }

    private void navigateFragment() {
        if (!App.prefs.isShown()) {
            navController.navigate(R.id.boardFragment);
            App.prefs.isShowed();
        }
        navController.navigate(R.id. authFragment);
    }
    private void hideOrShowButtonNav() {
        navController.addOnDestinationChangedListener((NavController, navDestination, bundle) -> {
            switch (navDestination.getId()){
                case R.id.detaleFragment:
                    navView.setVisibility(View.GONE);
                    break;
                case R.id.boardFragment:
                    navView.setVisibility(View.GONE);
                    getSupportActionBar().hide();
                default:
                    navView.setVisibility(View.VISIBLE);
                    getSupportActionBar().show();
            }
        });
    }
    private void initNavController() {
        navView = findViewById(R.id.nav_view);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications, R.id.navigation_profile)
                .build();
         navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
    }
}