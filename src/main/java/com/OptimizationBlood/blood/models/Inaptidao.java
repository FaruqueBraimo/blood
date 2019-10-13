package com.OptimizationBlood.blood.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Inaptidao {

    @Id
    @GeneratedValue
    private int codigo;
    private String motivo;

}
