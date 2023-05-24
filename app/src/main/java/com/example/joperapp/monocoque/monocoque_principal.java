package com.example.joperapp.monocoque;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;

import com.example.joperapp.R;
import com.example.joperapp.monocoque.basemonocoque;
import com.example.joperapp.monocoque.caractmonocoque;
import com.example.joperapp.monocoque.confgmonocoque;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class monocoque_principal extends AppCompatActivity {

    BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monocoque_principal);


        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        navigationView = findViewById(R.id.bottom_navigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.body_container, new caractmonocoque()).commit();
        navigationView.setSelectedItemId(R.id.nav_caract);

        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment fragment = null;
                switch ( item.getItemId()){

                    case R.id.nav_caract:
                        fragment = new caractmonocoque();
                        break;

                    case R.id.nav_base:
                        fragment = new basemonocoque();
                        break;

                    case R.id.nav_confg:
                        fragment = new confgmonocoque();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.body_container, fragment).commit();
                return true;
            }
        });


    }
}