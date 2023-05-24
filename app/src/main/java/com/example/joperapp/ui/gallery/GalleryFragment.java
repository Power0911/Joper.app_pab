package com.example.joperapp.ui.gallery;

import static androidx.fragment.app.FragmentManager.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

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
import com.example.joperapp.basedado.MainActivity;
import com.example.joperapp.databinding.FragmentGalleryBinding;
import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class GalleryFragment extends Fragment {

    private FragmentGalleryBinding binding;
    TextInputEditText txtNome, txtEmail, txtPass;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GalleryViewModel galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        txtNome = root.findViewById(R.id.txt_nomeperfill);
        txtEmail = root.findViewById(R.id.txt_emailperfill);
        txtPass = root.findViewById(R.id.txt_Passwordperfill);


        aterarUser(UserName.username, root);
        Log.i("TAG", "onErrorResponse: MAKOTOOOOOO");

        final Button alteral = binding.btnAlterar;
        alteral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateuser(UserName.username, view);
            }
        });
        //final TextView textView = binding.textGallery;
       // galleryViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void aterarUser(String username, View view) {
        String url = "http://10.0.2.2:8000/users/getuserupdate/" + username;
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                JSONObject object = null;
                try {
                    object = new JSONObject(response.toString());
                    txtEmail.setText(String.valueOf(object.getString("email")));
                    txtNome.setText(String.valueOf(object.getString("user")));
                    Log.i("TAG", "onErrorResponse: LOLIIIIIIIIIIIIIISUIIIIIIIIIII");
                } catch (JSONException e) {
                    Log.i("TAG", "onErrorResponse: LOLIIIIIIIIIIIIII333333333333");
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("TAG", "onErrorResponse: LOLIIIIIIIIIIIIII");
                Log.i("TAG", "onErrorResponse: " + error);
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(stringRequest);

    }

    private void updateuser(String username, View view) {
        String url = "http://10.0.2.2:8000/users/updateuser";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
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
                map.put("username", username);
                map.put("user", txtNome.getText().toString());
                map.put("email", txtEmail.getText().toString());
                map.put("pass", txtPass.getText().toString());
                return map;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(view.getContext());
        requestQueue.add(stringRequest);

    }

}