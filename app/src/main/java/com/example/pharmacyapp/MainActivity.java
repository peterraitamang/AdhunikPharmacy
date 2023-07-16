package com.example.pharmacyapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.pharmacyapp.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());
        b.bottomNavigation.setSelectedItemId(R.id.nav_home);
        HomeFragment homeFragment = new HomeFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.containerFragment, homeFragment).commit();

        b.bottomNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.nav_home) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.containerFragment, homeFragment).commit();
                    return true;
                } else if (itemId == R.id.nav_prescription) {
                    PrescriptionFragment prescriptionFragment = new PrescriptionFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.containerFragment, prescriptionFragment).commit();
                    return true;
                } else if (itemId == R.id.nav_location) {
                    TrackLocationFragment trackLocationFragment = new TrackLocationFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.containerFragment, trackLocationFragment).commit();
                    return true;
                } else if (itemId == R.id.nav_myCart) {
                    CartFragment cartFragment = new CartFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.containerFragment, cartFragment).commit();
                    return true;
                } else if (itemId == R.id.nav_myprofile) {
                    ProfileFragment profileFragment = new ProfileFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.containerFragment, profileFragment).commit();
                    return true;
                }
                return false;
            }
        });
    }
}