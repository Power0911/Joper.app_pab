package com.example.joperapp.monocoque;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.joperapp.R;
import com.example.joperapp.UserName;
import com.example.joperapp.basedado.MainActivity;
import com.example.joperapp.basedado.Registar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class basemonocoque extends Fragment {

    View view;
    Spinner modelosbase;
    TextView alteral1;
    EditText pesototal, tara, dimensoes, medidas_rodas, eixos, capacidade, valores;
    Toolbar toolbar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_basemonocoque, container, false);

        modelosbase = view.findViewById(R.id.spn_modelos);
        pesototal = view.findViewById(R.id.pesototal);
        tara = view.findViewById(R.id.tara);
        dimensoes = view.findViewById(R.id.dimensoes);
        medidas_rodas = view.findViewById(R.id.medidas_rodas);
        eixos = view.findViewById(R.id.eixos);
        capacidade = view.findViewById(R.id.capacidade);
        valores = view.findViewById(R.id.valores);

        alteral1 = view.findViewById(R.id.alterar);
        alteral1.setVisibility(View.INVISIBLE);

        if (UserName.username.equals("admin")){
            alteral1.setVisibility(View.VISIBLE);
        }else{
            alteral1.setVisibility(View.GONE);
        }

        alteral1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(modelosbase.getSelectedItem().equals("RB-10 ES")){

                    updatecara("RB_10ES", view);

                }else if(modelosbase.getSelectedItem().equals("RB-10")){

                    updatecara("RB_10", view);

                }else if(modelosbase.getSelectedItem().equals("RB-14")){

                    updatecara("RB_14", view);

                }else if(modelosbase.getSelectedItem().equals("RB-18")){

                    updatecara("RB_18", view);
                }

            }
        });

        modelosbase.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if(modelosbase.getSelectedItem().equals("RB-10 ES")){

                    getcara("RB_10ES", view);

                }else if(modelosbase.getSelectedItem().equals("RB-10")){

                    getcara("RB_10", view);

                }else if(modelosbase.getSelectedItem().equals("RB-14")){

                    getcara("RB_14", view);

                }else if(modelosbase.getSelectedItem().equals("RB-18")){

                    getcara("RB_18", view);

                }else if (modelosbase.getSelectedItem().equals("...Modelo...")){

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        List<String> modelo=new ArrayList<>();
        modelo.add("...Modelo...");
        modelo.add("RB-10 ES");
        modelo.add("RB-10");
        modelo.add("RB-14");
        modelo.add("RB-18");
        ArrayAdapter<String> dataAdapter1 =new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, (List<String>)modelo);
        dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_item);
        modelosbase.setAdapter(dataAdapter1);

        return view;
    }

    public void getcara(String valor, View view){
        String url = "http://10.0.2.2:8000/cara/getcara/" + valor.toString();
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                JSONObject object = null;
                try {
                    object = new JSONObject(response.toString());
                    pesototal.setText(String.valueOf(object.getDouble("pesototal")));
                    tara.setText(String.valueOf(object.getDouble("tara")));
                    dimensoes.setText(String.valueOf(object.getString("dimensoes")));
                    capacidade.setText(String.valueOf(object.getDouble("capacidade")));
                    medidas_rodas.setText(String.valueOf(object.getString("medidas_rodas")));
                    eixos.setText(String.valueOf(object.getString("tipo_de_eixo")));
                    valores.setText(String.valueOf(object.getString("preco")));
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(view.getContext());
        requestQueue.add(stringRequest);
    }


    private void updatecara(String carabase, View view) {
        String url = "http://10.0.2.2:8000/cara/update";
        StringRequest stringRequest1 = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(view.getContext(), "Inserido com sucesso", Toast.LENGTH_LONG).show();
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
                Log.i("TAG", "getParams: " + carabase + pesototal.getText().toString()+ tara.getText().toString()+ dimensoes.getText().toString());
                map.put("modelo_base", carabase);
                map.put("pesototal", pesototal.getText().toString());
                map.put("tara", tara.getText().toString());
                map.put("dimensoes", dimensoes.getText().toString());
                map.put("medidas_rodas" , medidas_rodas.getText().toString());
                map.put("tipo_de_eixo" , eixos.getText().toString());
                map.put("capacidade" , capacidade.getText().toString());
                map.put("preco" , valores.getText().toString());
                return map;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(view.getContext());
        requestQueue.add(stringRequest1);

    }
}