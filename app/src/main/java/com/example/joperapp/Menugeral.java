package com.example.joperapp;

import android.content.ClipData;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.joperapp.databinding.ActivityMenugeralBinding;

public class Menugeral extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMenugeralBinding binding;
    TextView txtBannerUser;
    public static String nomeFragmento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMenugeralBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        NavigationView navigationView2 = findViewById(R.id.nav_view);
        View headerView = navigationView2.getHeaderView(0);
        Menu menuNav = navigationView2.getMenu();
        MenuItem log = menuNav.findItem(R.id.nav_historico_users);

        if (UserName.username.equals("admin")){
            log.setVisible(true);
        }else{
            log.setVisible(false);
        }

        txtBannerUser = headerView.findViewById(R.id.txtBannerUser);
        String nome = getIntent().getExtras().getString("nome");
        nomeFragmento = getIntent().getExtras().getString("nome");
        txtBannerUser.setText(nome.toString());


        Toast.makeText(this, nome, Toast.LENGTH_SHORT).show();

        setSupportActionBar(binding.appBarMenugeral.toolbar);
        binding.appBarMenugeral.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Menugeral.this, "A sua sessão foi encerrada", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_menugeral);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menugeral, menu);

        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_menugeral);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}