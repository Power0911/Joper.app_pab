package com.example.joperapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.joperapp.monocoque.monocoque_principal;
import com.example.joperapp.rodadosimples.RodadoSimples;

public class Reboques extends AppCompatActivity {

    Button btn_reboqueI, btn_reboqueI2, btn_reboqueI3,btn_reboqueI4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reboques);

        //chamar os butoes
        btn_reboqueI4 = findViewById(R.id.btn_reboqueI4);
        btn_reboqueI = findViewById(R.id.btn_reboqueI);

        //click do rodado simples
        btn_reboqueI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Reboques.this, RodadoSimples.class);
                startActivity(intent);
            }
        });

        //click do monocoque
        btn_reboqueI4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(Reboques.this, monocoque_principal.class);
               startActivity(intent);
            }
        });
    }
}