package com.example.joperapp.ui.historico;

import android.content.ClipData;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.joperapp.AdpterHistorico;
import com.example.joperapp.R;
import com.example.joperapp.historico;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class historico_users extends Fragment {

    List<historico> historicoo = new ArrayList<historico>();
    RecyclerView rv_historico;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public historico_users() {
        // Required empty public constructor
    }


    public static historico_users newInstance(String param1, String param2) {
        historico_users fragment = new historico_users();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_historico_users, container, false);


        getUsers(view);
        return view;
    }

    public void getUsers(View view) {
        String url = "http://10.0.2.2:8000/users";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject userObject = jsonArray.getJSONObject(i);
                        int id = userObject.getInt("User_id");
                        String nome = userObject.getString("user");
                        String email = userObject.getString("email");
                        historico historic = new historico(id, email, nome);
                        historicoo.add(historic);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                rv_historico = view.findViewById(R.id.rv_historico);

                if (historicoo != null){
                    AdpterHistorico adpterUtilizzadores = new AdpterHistorico(historicoo);
                    LinearLayoutManager llm = new LinearLayoutManager(view.getContext());
                    llm.setOrientation(LinearLayoutManager.VERTICAL);

                    DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(view.getContext(), DividerItemDecoration.VERTICAL);
                    rv_historico.setLayoutManager(llm);
                    rv_historico.addItemDecoration(dividerItemDecoration);
                    rv_historico.setAdapter(adpterUtilizzadores);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), "Erro! Ligação not ok.", Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(stringRequest);

    }


    public void loaduserlist(){
            Log.i("TAG", "loaduserlist: FOIIIII33333");

        if (historicoo != null){
            Log.i("TAG", "loaduserlist: FOIIIII");
            AdpterHistorico adpterUtilizzadores = new AdpterHistorico(historicoo);
            rv_historico.setLayoutManager(new LinearLayoutManager(getContext()));

            DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
            rv_historico.addItemDecoration(dividerItemDecoration);
            rv_historico.setAdapter(adpterUtilizzadores);
        }

    }
}