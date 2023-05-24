package com.example.joperapp.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.joperapp.Menu;
import com.example.joperapp.Menugeral;
import com.example.joperapp.R;
import com.example.joperapp.Reboques;
import com.example.joperapp.databinding.FragmentHomeBinding;
import com.example.joperapp.ui.gallery.GalleryFragment;

public class HomeFragment extends Fragment {


    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final Button reboque = binding.btnReboques;
        reboque.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), Reboques.class);
                startActivity(intent);
            }
        });

        final Button btn_Requescisternas = binding.btnReboquesCisternas;
        btn_Requescisternas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(binding.getRoot().getContext(), "Opção em Desenvolvimento", Toast.LENGTH_SHORT).show();
            }
        });

        final Button btn_chisses = binding.btnChisses;
        btn_chisses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(binding.getRoot().getContext(), "Opção em Desenvolvimento", Toast.LENGTH_SHORT).show();
            }
        });

        final Button btn_equipamento = binding.btnEquipamento;
        btn_equipamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(binding.getRoot().getContext(), "Opção em Desenvolvimento", Toast.LENGTH_SHORT).show();
            }
        });

        final Button btn_fresas = binding.btnFresas;
        btn_fresas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(binding.getRoot().getContext(), "Opção em Desenvolvimento", Toast.LENGTH_SHORT).show();
            }
        });

        final Button btn_corta = binding.btnCorta;
        btn_corta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(binding.getRoot().getContext(), "Opção em Desenvolvimento", Toast.LENGTH_SHORT).show();
            }
        });

        final Button btn_diverso = binding.btnDiverso;
        btn_diverso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(binding.getRoot().getContext(), "Opção em Desenvolvimento", Toast.LENGTH_SHORT).show();
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}