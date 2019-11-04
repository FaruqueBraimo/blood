package com.OptimizationBlood.blood.models;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "codigo")
public class Sangue implements Serializable {

    @Id
    @GeneratedValue
    private int codigo;
    private  String nome;
    private String Descricao;


//    @OneToMany( mappedBy = "sangue", fetch = FetchType.EAGER)
////    @JsonBackReference
//    private List<Dador> dador;


    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String descricao) {
        Descricao = descricao;
    }

//    public List<Dador> getDador() {
//        return dador;
//    }
//
//    public void setDador(List<Dador> dadores) {
//        this.dador = dadores;
//    }
}
