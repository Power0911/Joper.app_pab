package com.example.joperapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.joperapp.basedado.MainActivity;

import java.util.List;

public class AdpterHistorico extends RecyclerView.Adapter<AdpterHistorico.ViewHolder> {
    List<historico> registos;
    Context context;

    public AdpterHistorico(List<historico> Registos) {
        this.registos = Registos;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_historico, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.lb_nome.setText(registos.get(position).nome);
        holder.lb_email.setText(registos.get(position).email);

        holder.btn_imgEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "http://10.0.2.2:8000/users/deleteuser/" + registos.get(position).id;
                StringRequest stringRequest = new StringRequest(Request.Method.DELETE, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                       Toast.makeText(view.getContext(), "Eliminado com sucesso", Toast.LENGTH_LONG).show();
                       registos.remove(position);
                       notifyDataSetChanged();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i("TAG", "onErrorResponse: " + error);
                    }
                });

                RequestQueue requestQueue = Volley.newRequestQueue(view.getContext());
                requestQueue.add(stringRequest);
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.registos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView lb_nome, lb_email;
        ImageButton btn_imgEliminar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            lb_nome = itemView.findViewById(R.id.lb_nome);
            lb_email = itemView.findViewById(R.id.lb_email);
            btn_imgEliminar = itemView.findViewById(R.id.btn_imgEliminar);
        }
    }
}
