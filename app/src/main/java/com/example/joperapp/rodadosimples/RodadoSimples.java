package com.example.joperapp.rodadosimples;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;

import com.example.joperapp.R;
import com.example.joperapp.rodadosimples.BaseFragment;
import com.example.joperapp.rodadosimples.ConfgFragment;
import com.example.joperapp.rodadosimples.caractFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class RodadoSimples extends AppCompatActivity {

    BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rodado_simples);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        navigationView = findViewById(R.id.bottom_navigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.body_container, new caractFragment()).commit();
        navigationView.setSelectedItemId(R.id.nav_caract);

        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment fragment = null;
                switch ( item.getItemId()){

                    case R.id.nav_caract:
                        fragment = new caractFragment();
                        break;

                    case R.id.nav_base:
                        fragment = new BaseFragment();
                        break;

                    case R.id.nav_confg:
                        fragment = new ConfgFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.body_container, fragment).commit();
                return true;
            }
        });

    }
}