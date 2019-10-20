package com.OptimizationBlood.blood.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Sangue {

    @Id
    @GeneratedValue
    private int codigo;
    private  String nome;
    private String Descricao;

    @OneToMany(mappedBy = "sangue")
    @JsonBackReference
    private List<Dador> dadores;

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

    public List<Dador> getDadores() {
        return dadores;
    }

    public void setDadores(List<Dador> dadores) {
        this.dadores = dadores;
    }
}
