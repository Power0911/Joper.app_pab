package com.example.joperapp.basedado;

import  android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class Dbhelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "bd_Joper";
    private static final int DATABASE_VERSION = 1;
    public static final String tableLogin = "create table bd_Login"
            + "(_id integer primary key autoincrement,"
            + " email text not null,"
            + " nome text not null,"
            + " pass text not null)";

    SQLiteDatabase db = getReadableDatabase();

    public Dbhelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tableLogin);
        Log.i("bd", "Bd criada com sucesso");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {}

    public void inserirconta(CriarLogin criarLogin){

        ContentValues contentValues=new ContentValues();
        Log.i("TAG", "inserirconta: " + criarLogin.getNome());
        contentValues.put("nome",criarLogin.getNome());
        contentValues.put("pass",criarLogin.getPass());
        contentValues.put("email",criarLogin.getEmail());
        db.insert("bd_Login", null, contentValues);
    }

    public String validarlogin (String nome , String pass) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("Select * FROM bd_Login WHERE nome=? AND pass=?" , new String[]{nome, pass});
        if (c.getCount() > 0) return "OK";
        return "error";
    }

}
