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
//    @OneToOne
//    private  Dador dador;
    private  LocalDate data_criado;

    @OneToOne
    private  Privilegios privilegios;

    private String password;
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public Dador getDador() {
//        return dador;
//    }
//
//    public void setDador(Dador dador) {
//        this.dador = dador;
//    }

    public LocalDate getData_criado() {
        return data_criado;
    }

    public void setData_criado(LocalDate data_criado) {
        this.data_criado = data_criado;
    }

    public Privilegios getPrivilegios() {
        return privilegios;
    }

    public void setPrivilegios(Privilegios privilegios) {
        this.privilegios = privilegios;
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
