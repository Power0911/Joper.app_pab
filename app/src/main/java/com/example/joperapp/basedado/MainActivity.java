package com.example.joperapp.basedado;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.joperapp.Menugeral;
import com.example.joperapp.R;
import com.example.joperapp.UserName;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    Button btn_login;
    TextInputEditText txt_login, txt_pass;
    FloatingActionButton btn_registar;
    DbDao dbDao;
    String utilizador;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_login = findViewById(R.id.btn_Alterar);
        btn_registar = findViewById(R.id.btn_registar);
        txt_login = findViewById(R.id.txl_user);
        txt_pass = findViewById(R.id.txl_pass);


        dbDao = new DbDao(this);
        Dbhelper dbhelper = new Dbhelper(this);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                utilizador = txt_login.getText().toString();
                if (txt_login.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "Insira User", Toast.LENGTH_SHORT).show();
                } else if (txt_pass.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "Insira Password", Toast.LENGTH_SHORT).show();
                } else {
                    String username = txt_login.getText().toString();
                    String password = txt_pass.getText().toString();
                    loginUser(username, password);
                    UserName.username = txt_login.getText().toString();
                    txt_login.setText("");
                    txt_pass.setText("");
                }
            }
        });

        btn_registar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Registar.class);
                startActivity(intent);
            }
        });
    }

    private void loginUser(String username, String password) {
        String url = "http://10.0.2.2:8000/users/getuser";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.equals("true")) {
                    Toast.makeText(MainActivity.this, "Bem vindo", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, Menugeral.class);
                    intent.putExtra("nome", utilizador);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Utilizador ou password incorreta" + response, Toast.LENGTH_LONG).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("TAG", "onErrorResponse: " + error);
            }
        }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();
                map.put("nome", username);
                map.put("password", password);
                return map;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(stringRequest);

    }
}