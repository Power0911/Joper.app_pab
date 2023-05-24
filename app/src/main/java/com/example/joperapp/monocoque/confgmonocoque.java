package com.example.joperapp.monocoque;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.joperapp.R;

import java.util.ArrayList;
import java.util.List;

public class confgmonocoque extends Fragment {

    View view;
    TextView preco, precoI, precoII, precoIII, precoIV, precoV, precoVI, precoVII, precoVIII, precoIX, precoX, precoXI, txt_total, RB_10, RB_18;
    Spinner spinnerI, spinnerII, spinnerIII;
    Switch checkI;
    Switch checkII;
    Switch checkIII;
    Switch checkIV;
    Switch checkV;
    Switch checkVI;
    Switch checkVII;
    Switch checkVIII;
    Switch checkIX;
    double resultado, resultadoI, resultadoII, resultadoIII, resultadoIV, resultadoV, resultadoVI , resultadoVII, resultadoVIII, resultadoIX, resultadoX, resultadoXI;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
         view = inflater.inflate(R.layout.fragment_confgmonocoque, container, false);


         //Editext
         preco = view.findViewById(R.id.txt_text);
         precoI = view.findViewById(R.id.precoI);
         precoII = view.findViewById(R.id.precoII);
         precoIII = view.findViewById(R.id.precoIII);
         precoIV = view.findViewById(R.id.precoIV);
         precoV = view.findViewById(R.id.precoV);
         precoVI = view.findViewById(R.id.precoVI);
         precoVII = view.findViewById(R.id.precoVII);
         precoVIII = view.findViewById(R.id.precoVIII);
         precoIX = view.findViewById(R.id.precoIX);
         precoX = view.findViewById(R.id.precoX);
         precoXI = view.findViewById(R.id.precoXI);
         txt_total = view.findViewById(R.id.txt_total);
         RB_10 = view.findViewById(R.id.RB_10);
         RB_18 = view.findViewById(R.id.RB_18);

         //Spinner
         spinnerI = view.findViewById(R.id.spinnerI);
         spinnerII = view.findViewById(R.id.SpinnerII);
         spinnerIII = view.findViewById(R.id.SpinnerIII);

         //Check
         checkI = view.findViewById(R.id.checkI);
         checkII = view.findViewById(R.id.checkII);
         checkIII = view.findViewById(R.id.checkIII);
         checkIV = view.findViewById(R.id.checkIV);
         checkV = view.findViewById(R.id.checkV);
         checkVI = view.findViewById(R.id.checkVI);
         checkVII = view.findViewById(R.id.checkVII);
         checkVIII = view.findViewById(R.id.checkVIII);
         checkIX = view.findViewById(R.id.checkIX);


         checkI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                 if(b==true){
                     precoI.setText("940.00€");
                     resultado = 940.00;
                     String str = Double.toString(resultado);
                     txt_total.setText(resultado + resultadoI + resultadoII + resultadoIII + resultadoIV + resultadoV + resultadoVI + resultadoVII + resultadoVIII + resultadoIX + resultadoX + resultadoXI + "€");
                 }else if (b==false){
                     precoI.setText("0€");
                     resultado = 0;
                     String str = Double.toString(resultado);
                     txt_total.setText(resultado + resultadoI + resultadoII + resultadoIII + resultadoIV + resultadoV + resultadoVI + resultadoVII + resultadoVIII + resultadoIX + resultadoX + resultadoXI + "€");
                 }
             }
         });

         checkII.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton compoundButton, boolean b1) {
                 if (b1==true){
                     precoII.setText("230.00€");
                     resultadoII = 230.00;
                     String str = Double.toString(resultadoII);
                     txt_total.setText(resultado + resultadoI + resultadoII + resultadoIII + resultadoIV + resultadoV + resultadoVI + resultadoVII + resultadoVIII + resultadoIX + resultadoX + resultadoXI + "€");
                 }else if (b1==false){
                     precoII.setText("0€");
                     resultadoII = 0;
                     String str = Double.toString(resultadoII);
                     txt_total.setText(resultado + resultadoI + resultadoII + resultadoIII + resultadoIV + resultadoV + resultadoVI + resultadoVII + resultadoVIII + resultadoIX + resultadoX + resultadoXI + "€");
                 }
             }
         });

         checkIII.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton compoundButton, boolean b2) {
                 if (b2==true){
                     precoV.setText("430.00€");
                     resultadoIII = 430.00;
                     String str = Double.toString(resultadoIII);
                     txt_total.setText(resultado + resultadoI + resultadoII + resultadoIII + resultadoIV + resultadoV + resultadoVI + resultadoVII + resultadoVIII + resultadoIX + resultadoX + resultadoXI + "€");
                 }else if(b2==false){
                     precoV.setText("0€");
                     resultadoIII = 0;
                     String str = Double.toString(resultadoIII);
                     txt_total.setText(resultado + resultadoI + resultadoII + resultadoIII + resultadoIV + resultadoV + resultadoVI + resultadoVII + resultadoVIII + resultadoIX + resultadoX + resultadoXI + "€");
                 }
             }
         });

         checkIV.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton compoundButton, boolean b3) {
                 if(b3==true){
                     precoVI.setText("130.00");
                     resultadoIV = 130.00;
                     String str = Double.toString(resultadoIV);
                     txt_total.setText(resultado + resultadoI + resultadoII + resultadoIII + resultadoIV + resultadoV + resultadoVI + resultadoVII + resultadoVIII + resultadoIX + resultadoX + resultadoXI + "€");
                 }else if(b3==false){
                     precoVI.setText("0€");
                     resultadoIV = 0;
                     String str = Double.toString(resultadoIV);
                     txt_total.setText(resultado + resultadoI + resultadoII + resultadoIII + resultadoIV + resultadoV + resultadoVI + resultadoVII + resultadoVIII + resultadoIX + resultadoX + resultadoXI + "€");
                 }
             }
         });

         checkV.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton compoundButton, boolean b4) {
                 if(b4==true){
                     precoVII.setText("310.00€");
                     resultadoV = 310.00;
                     String str = Double.toString(resultadoV);
                     txt_total.setText(resultado + resultadoI + resultadoII + resultadoIII + resultadoIV + resultadoV + resultadoVI + resultadoVII + resultadoVIII + resultadoIX + resultadoX + resultadoXI + "€");
                 }else if(b4==false){
                     precoVII.setText("0€");
                     resultadoV = 0;
                     String str = Double.toString(resultadoV);
                     txt_total.setText(resultado + resultadoI + resultadoII + resultadoIII + resultadoIV + resultadoV + resultadoVI + resultadoVII + resultadoVIII + resultadoIX + resultadoX + resultadoXI + "€");
                 }
             }
         });

         checkVI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                 if (b==true){
                     precoVIII.setText("?");

                 }else if (b==false){
                     precoVIII.setText("0€");
                     resultadoVI = 0;
                     String str = Double.toString(resultadoV);
                     txt_total.setText(resultado + resultadoI + resultadoII + resultadoIII + resultadoIV + resultadoV + resultadoVI + resultadoVII + resultadoVIII + resultadoIX + resultadoX + resultadoXI + "€");
                 }
             }
         });

         checkVII.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                 if (b==true){
                     precoIX.setText("??");
                 }else if (b==false){
                     precoIX.setText("0€");
                     resultadoVII = 0;
                     String str = Double.toString(resultadoV);
                     txt_total.setText(resultado + resultadoI + resultadoII + resultadoIII + resultadoIV + resultadoV + resultadoVI + resultadoVII + resultadoVIII + resultadoIX + resultadoX + resultadoXI + "€");
                 }
             }
         });

         checkVIII.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                 if (b==true){
                     precoX.setText("???");
                 }else if (b==false){
                     precoX.setText("0€");
                     resultadoVIII = 0;
                     String str = Double.toString(resultadoV);
                     txt_total.setText(resultado + resultadoI + resultadoII + resultadoIII + resultadoIV + resultadoV + resultadoVI + resultadoVII + resultadoVIII + resultadoIX + resultadoX + resultadoXI + "€");
                 }
             }
         });

         checkIX.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                 if(b==true){
                     precoXI.setText("????");
                 }else if(b==false){
                     precoXI.setText("0€");
                     resultadoIX = 0;
                     String str = Double.toString(resultadoIX);
                     txt_total.setText(resultado + resultadoI + resultadoII + resultadoIII + resultadoIV + resultadoV + resultadoVI + resultadoVII + resultadoVIII + resultadoIX + resultadoX + resultadoXI + "€");
                 }
             }
         });

         spinnerI.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                 if (spinnerI.getSelectedItem().equals("RB-10 ES")) {
                     preco.setText("22.150.00€");
                     resultadoI = 22150.00;
                     String str = Double.toString(resultadoI);
                     txt_total.toString().equals(resultadoI);
                     RB_10.setVisibility(view.VISIBLE);
                     checkI.setVisibility(view.VISIBLE);
                     precoI.setVisibility(view.VISIBLE);
                     RB_18.setVisibility(view.INVISIBLE);
                     checkVII.setVisibility(view.INVISIBLE);
                     precoIX.setVisibility(view.INVISIBLE);
                     txt_total.setText(resultado + resultadoI + resultadoII + resultadoIII + resultadoIV + resultadoV + resultadoVI + resultadoVII + resultadoVIII + resultadoIX + resultadoX + resultadoXI + "€");
                 } else if (spinnerI.getSelectedItem().equals("RB-10")) {
                     preco.setText("24.140.00€");
                     resultadoI = 24140.00;
                     String str = Double.toString(resultadoI);
                     txt_total.toString().equals(resultadoI);
                     RB_10.setVisibility(view.VISIBLE);
                     checkI.setVisibility(view.VISIBLE);
                     precoI.setVisibility(view.VISIBLE);
                     RB_18.setVisibility(view.INVISIBLE);
                     checkVII.setVisibility(view.INVISIBLE);
                     precoIX.setVisibility(view.INVISIBLE);
                     txt_total.setText(resultado + resultadoI + resultadoII + resultadoIII + resultadoIV + resultadoV + resultadoVI + resultadoVII + resultadoVIII + resultadoIX + resultadoX + resultadoXI + "€");
                 }else if (spinnerI.getSelectedItem().equals("RB-14")) {
                     preco.setText("27.400.00€");
                     resultadoI = 27400.00;
                     String str = Double.toString(resultadoI);
                     txt_total.toString().equals(resultadoI);
                     RB_10.setVisibility(view.INVISIBLE);
                     checkI.setVisibility(view.INVISIBLE);
                     precoI.setVisibility(view.INVISIBLE);
                     RB_18.setVisibility(view.INVISIBLE);
                     checkVII.setVisibility(view.INVISIBLE);
                     precoIX.setVisibility(view.INVISIBLE);
                     txt_total.setText(resultado + resultadoI + resultadoII + resultadoIII + resultadoIV + resultadoV + resultadoVI + resultadoVII + resultadoVIII + resultadoIX + resultadoX + resultadoXI + "€");
                 } else if (spinnerI.getSelectedItem().equals("RB-18")) {
                     preco.setText("31.830.00€");
                     resultadoI = 31830.00;
                     String str = Double.toString(resultadoI);
                     txt_total.toString().equals(resultadoI);
                     RB_10.setVisibility(view.INVISIBLE);
                     checkI.setVisibility(view.INVISIBLE);
                     precoI.setVisibility(view.INVISIBLE);
                     RB_18.setVisibility(view.VISIBLE);
                     checkVII.setVisibility(view.VISIBLE);
                     precoIX.setVisibility(view.VISIBLE);
                     txt_total.setText(resultado + resultadoI + resultadoII + resultadoIII + resultadoIV + resultadoV + resultadoVI + resultadoVII + resultadoVIII + resultadoIX + resultadoX + resultadoXI + "€");
                 }  else if (spinnerI.getSelectedItem().equals("")){
                     preco.setText("0€");
                     resultadoI = 0;
                     String str = Double.toString(resultadoI);
                     txt_total.toString().equals(resultadoI);
                     RB_10.setVisibility(view.INVISIBLE);
                     checkI.setVisibility(view.INVISIBLE);
                     precoI.setVisibility(view.INVISIBLE);
                     RB_18.setVisibility(view.INVISIBLE);
                     checkVII.setVisibility(view.INVISIBLE);
                     precoIX.setVisibility(view.INVISIBLE);
                     txt_total.setText(resultado + resultadoI + resultadoII + resultadoIII + resultadoIV + resultadoV + resultadoVI + resultadoVII + resultadoVIII + resultadoIX + resultadoX + resultadoXI + "€");
                 }
             }
             @Override
             public void onNothingSelected(AdapterView<?> adapterView) {

             }
         });

         spinnerII.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                 if (spinnerII.getSelectedItem().equals("Eixo traseiro direccional livre")){
                     precoIII.setText("3,100.00€");
                     resultadoX = 3100.00;
                     String str = Double.toString(resultadoX);
                     txt_total.setText(resultado + resultadoI + resultadoII + resultadoIII + resultadoIV + resultadoV + resultadoVI + resultadoVII + resultadoVIII + resultadoIX + resultadoX + resultadoXI + "€");
                 }else if(spinnerII.getSelectedItem().equals("Eixo traseiro direccional forçado")){
                     precoIII.setText("4,770.00€");
                     resultadoX = 4770.00;
                     String str = Double.toString(resultadoX);
                     txt_total.setText(resultado + resultadoI + resultadoII + resultadoIII + resultadoIV + resultadoV + resultadoVI + resultadoVII + resultadoVIII + resultadoIX + resultadoX + resultadoXI + "€");
                 }else if(spinnerII.getSelectedItem().equals("")){
                     precoIII.setText("0€");
                     resultadoX = 0;
                     String str = Double.toString(resultadoX);
                     txt_total.setText(resultado + resultadoI + resultadoII + resultadoIII + resultadoIV + resultadoV + resultadoVI + resultadoVII + resultadoVIII + resultadoIX + resultadoX + resultadoXI + "€");
                 }
             }
             @Override
             public void onNothingSelected(AdapterView<?> adapterView) {

             }
         });

         spinnerIII.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                 if (spinnerIII.getSelectedItem().equals("")){
                     precoIV.setText("0€");
                     resultadoXI = 0;
                     String str = Double.toString(resultadoXI);
                     txt_total.setText(resultado + resultadoI + resultadoII + resultadoIII + resultadoIV + resultadoV + resultadoVI + resultadoVII + resultadoVIII + resultadoIX + resultadoX + resultadoXI + "€");
                 }else if(spinnerIII.getSelectedItem().equals("Taipais suplementares com 0,30m (m línear)")){
                     precoIV.setText("390.00€");
                     resultadoXI = 390.00;
                     String str = Double.toString(resultadoXI);
                     txt_total.setText(resultado + resultadoI + resultadoII + resultadoIII + resultadoIV + resultadoV + resultadoVI + resultadoVII + resultadoVIII + resultadoIX + resultadoX + resultadoXI + "€");
                 }else if (spinnerIII.getSelectedItem().equals("Taipais suplementares com 0,50m (m línear)")){
                     precoIV.setText("440.00€");
                     resultadoXI = 440.00;
                     String str = Double.toString(resultadoXI);
                     txt_total.setText(resultado + resultadoI + resultadoII + resultadoIII + resultadoIV + resultadoV + resultadoVI + resultadoVII + resultadoVIII + resultadoIX + resultadoX + resultadoXI + "€");
                 }else if (spinnerIII.getSelectedItem().equals("Taipais suplementares em rede com 0,80m (m línear)")){
                     precoIV.setText("580.00€");
                     resultadoXI = 580.00;
                     String str = Double.toString(resultadoXI);
                     txt_total.setText(resultado + resultadoI + resultadoII + resultadoIII + resultadoIV + resultadoV + resultadoVI + resultadoVII + resultadoVIII + resultadoIX + resultadoX + resultadoXI + "€");
                 }
             }

             @Override
             public void onNothingSelected(AdapterView<?> adapterView) {

             }
         });

        List<String> Ano=new ArrayList<>();
        Ano.add("");
        Ano.add("RB-10 ES");
        Ano.add("RB-10");
        Ano.add("RB-14");
        Ano.add("RB-18");
        ArrayAdapter<String> dataAdapter1 =new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, (List<String>)Ano);
        dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnerI.setAdapter(dataAdapter1);

        List<String> II=new ArrayList<>();
        II.add("");
        II.add("Eixo traseiro direccional livre");
        II.add("Eixo traseiro direccional forçado");
        ArrayAdapter<String> dataAdapter2 =new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, (List<String>)II);
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnerII.setAdapter(dataAdapter2);

        List<String> III=new ArrayList<>();
        III.add("");
        III.add("Taipais suplementares com 0,30m (m línear)");
        III.add("Taipais suplementares com 0,50m (m línear)");
        III.add("Taipais suplementares em rede com 0,80m (m línear)");
        ArrayAdapter<String> dataAdapter3 =new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, (List<String>)III);
        dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnerIII.setAdapter(dataAdapter3);
        return view;
    }
}