package com.OptimizationBlood.blood.models;


import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "codigo")
public class Agendamento implements Serializable {

     @Id
     @GeneratedValue
     private int codigo;

    @JsonFormat(pattern="yyyy/MM/dd")
     private LocalDate  data_agendada;
     private LocalDate data =  LocalDate.now() ;;
     private String hora;
     private String descricao;
     private  String status = "por realizar";

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "dador_id")
    private Dador dador;

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

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data_marcada) {
        this.data = data;
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

}
