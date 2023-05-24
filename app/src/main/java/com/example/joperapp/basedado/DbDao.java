package com.example.joperapp.basedado;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class DbDao {

    private SQLiteDatabase db;
    private Dbhelper dbhelper;

    public DbDao(Context context){

        dbhelper = new Dbhelper(context);
        db = dbhelper.getWritableDatabase();
    }
    @SuppressLint("Range")
    public ArrayList<CriarLogin> getLogin(){

        String strSql = "select * from bd_Joper";
        ArrayList contas = new ArrayList<CriarLogin>();
        SQLiteDatabase db = dbhelper.getReadableDatabase();
        Cursor c = db.rawQuery(strSql, null);
        if(c.moveToFirst()){
            do{
                CriarLogin criarLogin = new CriarLogin();
                criarLogin.setNome(c.getString(c.getColumnIndex("email")));
                criarLogin.setPass(c.getString(c.getColumnIndex("nome")));
                criarLogin.setPass(c.getString(c.getColumnIndex("pass")));
                contas.add(criarLogin);
            }while (c.moveToNext());
        }
        return contas;
    }
}
