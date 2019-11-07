package com.OptimizationBlood.blood.models;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "codigo")
public class Doacao implements Serializable {

    @Id
    @GeneratedValue
    private  int codigo;

    private String numero_bolsa;

    @ManyToOne
    @JoinColumn(name="triagem_id")
    private Triagem triagem;

    @JsonFormat(pattern="yyyy/MM/dd")
    private LocalDate data_coletada = LocalDate.now();
    
    @JsonFormat(pattern="HH:mm")
    private LocalTime hora_coletada = LocalTime.now() ;
    private String volume_coletado;
    private LocalDate validade;

    private String expirado;

    public String getExpirado() {
        return expirado;
    }

    public void setExpirado(String expirado) {
        this.expirado = expirado;
    }

    public LocalDate getValidade() {
        return validade;
    }

    public void setValidade(LocalDate validade) {
        this.validade = validade;
    }

    private String status = "nao verificada";

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private String obs;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNumero_bolsa() {
        return numero_bolsa;
    }

    public void setNumero_bolsa(String numero_bolsa) {
        this.numero_bolsa = numero_bolsa;
    }

    public Triagem getTriagem() {
        return triagem;
    }

    public void setTriagem(Triagem triagem) {
        this.triagem = triagem;
    }

    public LocalDate getData_coletada() {
        return data_coletada;
    }

    public void setData_coletada(LocalDate data_coletada) {
        this.data_coletada = data_coletada;
    }

    public LocalTime getHora_coletada() {
        return hora_coletada;
    }

    public void setHora_coletada(LocalTime hora_coletada) {
        this.hora_coletada = hora_coletada;
    }

    public String getVolume_coletado() {
        return volume_coletado;
    }

    public void setVolume_coletado(String volume_coletado) {
        this.volume_coletado = volume_coletado;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }
}
