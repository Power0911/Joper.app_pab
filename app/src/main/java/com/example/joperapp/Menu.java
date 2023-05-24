package com.example.joperapp;

import static com.example.joperapp.R.id.btn_reboquesCisternas;


import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.sax.StartElementListener;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Menu extends AppCompatActivity {

    Button btn_Reboques, btn_Requescisternas, btn_chisses, btn_equipamento, btn_fresas, btn_corta, btn_diverso;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        //Recolhecimento dos botoes
        btn_Reboques = findViewById(R.id.btn_reboques1);
        btn_Requescisternas = findViewById(btn_reboquesCisternas);
        btn_chisses = findViewById(R.id.btn_Chisses);
        btn_equipamento = findViewById(R.id.btn_Equipamento);
        btn_fresas = findViewById(R.id.btn_fresas);
        btn_corta = findViewById(R.id.btn_Corta);
        btn_diverso = findViewById(R.id.btn_Diverso);

        //Onclick Reboques
        btn_Reboques.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this , Reboques.class);
                startActivity(intent);
            }
        });
        // Onclick Reboques Cisternas
        btn_Requescisternas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Menu.this, "Opção em Desenvolvimento", Toast.LENGTH_SHORT).show();
            }
        });
        //Onclick chisses
        btn_chisses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Menu.this, "Opção em Desenvolvimento", Toast.LENGTH_SHORT).show();
            }
        });
        //Onclick Equipamento
        btn_equipamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Menu.this, "Opção em Desenvolvimento", Toast.LENGTH_SHORT).show();
            }
        });
        //Onclick Fresa
        btn_fresas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Menu.this, "Opção em Desenvolvimento", Toast.LENGTH_SHORT).show();
            }
        });
        //Onclick corta
        btn_corta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Menu.this, "Opção em Desenvolvimento", Toast.LENGTH_SHORT).show();
            }
        });
        //Onclick diverso
        btn_diverso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Menu.this, "Opção em Desenvolvimento  ", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_item, menu);
        return true;
    }
}