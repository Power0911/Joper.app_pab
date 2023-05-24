package com.example.joperapp.basedado;

import java.io.Serializable;

public class CriarLogin implements Serializable {
    String nome , pass , email;
    private int id;

    public CriarLogin(String nome, String pass, String email) {
        this.nome = nome;
        this.pass = pass;
        this.email = email;
    }

    public CriarLogin() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
