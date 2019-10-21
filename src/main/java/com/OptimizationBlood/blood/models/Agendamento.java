package com.OptimizationBlood.blood.models;


import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Entity
public class Agendamento {

     @Id
     @GeneratedValue
     private int codigo;

    @JsonFormat(pattern="yyyy-MM-dd")
     private LocalDate  data_agendada;
     private Date data_marcada;
     private String hora;
     private String descricao;

     @ManyToOne
    @JoinColumn (name = "dador_id")
    private Dador dador;

     @OneToMany(mappedBy = "agendamento")
     private List<Triagem> triagem;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public LocalDate getData_agendada() {
        return data_agendada;
    }

    public void setData_agendada(LocalDate data_agendada) {
        this.data_agendada = data_agendada;
    }

    public Date getData_marcada() {
        return data_marcada;
    }

    public void setData_marcada(Date data_marcada) {
        this.data_marcada = data_marcada;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Dador getDador() {
        return dador;
    }

    public void setDador(Dador dador) {
        this.dador = dador;
    }

    public List<Triagem> getTriagem() {
        return triagem;
    }

    public void setTriagem(List<Triagem> triagem) {
        this.triagem = triagem;
    }
}
