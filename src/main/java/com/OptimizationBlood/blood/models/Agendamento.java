package com.OptimizationBlood.blood.models;


import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Entity
public class Agendamento {

     @Id
     @GeneratedValue
     private int id;
     private Date data_agendada;
     private LocalDate data_marcada;
     private LocalTime hora;
     private String descricao;

     @ManyToOne
    @JoinColumn (name = "dador_id")
    private Dador dador;


     @OneToOne
     private Triagem triagem;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Dador getDador() {
        return dador;
    }

    public void setDador(Dador dador) {
        this.dador = dador;
    }

    public Date getData_agendada() {
        return data_agendada;
    }

    public void setData_agendada(Date data_agendada) {
        this.data_agendada = data_agendada;
    }

    public LocalDate getData_marcada() {
        return data_marcada;
    }

    public void setData_marcada(LocalDate data_marcada) {
        this.data_marcada = data_marcada;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
