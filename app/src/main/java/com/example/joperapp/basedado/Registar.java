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
import com.example.joperapp.R;
import com.google.android.material.textfield.TextInputEditText;

import java.util.HashMap;
import java.util.Map;

public class Registar extends AppCompatActivity {

    Button btn_regista, btn_voltar;
    TextInputEditText txt_email, txt_user,txt_passs, txt_confpass;
    boolean validar = true;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registar);

        //base de dados
        DbDao dbDao = new DbDao(this);
        Dbhelper dbhelper = new Dbhelper(this);

        //Caixas de texto
        txt_email = findViewById(R.id.txl_Email);
        txt_user = findViewById(R.id.txl_UserR);
        txt_passs = findViewById(R.id.txl_password);
        txt_confpass = findViewById(R.id.txl_confirmar);

        //Botoes
        btn_regista = findViewById(R.id.btn_regista);
        btn_voltar = findViewById(R.id.btn_voltar);

        btn_regista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = txt_email.getText().toString().trim();
                String password = txt_passs.getText().toString().trim();

                if (email.contains("@") && email.indexOf("@") == email.lastIndexOf("@")) {

                    if (isPasswordValid(password)) {

                        if (txt_passs.getText().toString().equals(txt_confpass.getText().toString())) {
                            registarUtilizadores(txt_user.getText().toString(), txt_email.getText().toString(), txt_passs.getText().toString());
                        } else {
                            Toast.makeText(Registar.this, "As palavras pass não são iguais", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        
                        Toast.makeText(Registar.this, "Rever a sua password", Toast.LENGTH_SHORT).show();
                        txt_passs.setError("A senha deve ter pelo menos 10 caracteres, uma letra maiúscula e um número");
                        txt_confpass.setError("A senha deve ter pelo menos 10 caracteres, uma letra maiúscula e um número");
                    }
                }else {
                    Toast.makeText(Registar.this, "Email não valido ", Toast.LENGTH_SHORT).show();
                }
            }

        });
        btn_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Registar.this , MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private boolean isPasswordValid(String password) {
        if (password.length() < 10) {
            // A senha é muito curta
            return false;
        }

        boolean hasUppercase = false;
        boolean hasNumber = false;

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (Character.isUpperCase(c)) {
                hasUppercase = true;
            } else if (Character.isDigit(c)) {
                hasNumber = true;
            }
        }

        return hasUppercase && hasNumber;
    }

    private void registarUtilizadores(String username, String email, String password){
        String url = "http://10.0.2.2:8000/users/store";
        RequestQueue queue = Volley.newRequestQueue(this);
        Log.i("TAG", "registarUtilizadores: loli1" + username);
        // Fazer o request utilizado o url
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(Registar.this, "Utilizador Registado", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Registar.this, MainActivity.class);
                startActivity(intent);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Registar.this, "Erro", Toast.LENGTH_SHORT).show();
                Log.i("TAG", "onErrorResponse: " + error.toString());
            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();
                map.put("nome", username);
                Log.i("TAG", "getParams: loli222" +username);
                map.put("email", email);
                map.put("password", password);
                return map;
            }
        };
                RequestQueue requestQueue = Volley.newRequestQueue(this);
                requestQueue.add(stringRequest);
    }
}