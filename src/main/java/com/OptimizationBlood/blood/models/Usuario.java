package com.OptimizationBlood.blood.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.time.LocalDate;

@Entity
public class Usuario {

    @Id
    @GeneratedValue
    private  int id;

    private String password;
    private String email;
    private LocalDate ultima_vez_logado;

    public LocalDate getUltima_vez_logado() {
        return ultima_vez_logado;
    }

    public void setUltima_vez_logado(LocalDate ultima_vez_logado) {
        this.ultima_vez_logado = ultima_vez_logado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
