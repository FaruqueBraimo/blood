package com.OptimizationBlood.blood.models;


import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Doacao {

    @Id
    @GeneratedValue
    private  int codigo;

    private String numero_bolsa;

    @OneToOne
    @JoinColumn(name="triagem_id")
    private Triagem triagem;
    @JsonFormat(pattern="yyyy/MM/dd")
    private LocalDate data_coletada;
    
    @JsonFormat(pattern="HH:mm")
    private LocalTime hora_coletada;
    private String volume_coletado;
    private String Reacao;
    private String Observacoes;


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

    public String getReacao() {
        return Reacao;
    }

    public void setReacao(String reacao) {
        Reacao = reacao;
    }

    public String getObservacoes() {
        return Observacoes;
    }

    public void setObservacoes(String observacoes) {
        Observacoes = observacoes;
    }
}
