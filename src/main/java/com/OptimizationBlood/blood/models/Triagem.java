package com.OptimizationBlood.blood.models;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Triagem {


@Id
@GeneratedValue
private  int codigo;
private String localColheita;

@ManyToOne()
@JoinColumn(name = "dador_id")
private Dador dador;
private String pressao_arterial;
private String peso;
private String altura;
private String resultado_triagem;
private LocalDate Data_triagem;
private String Observacoes;
private String Temperatura;

@OneToOne
private Doacao doacao;

    @OneToOne
    private Agendamento agendamento;



    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getLocalColheita() {
        return localColheita;
    }

    public void setLocalColheita(String localColheita) {
        this.localColheita = localColheita;
    }

    public Dador getDadores() {
        return dador;
    }

    public void setDadores(Dador dadores) {
        this.dador = dadores;
    }

    public String getPressao_arterial() {
        return pressao_arterial;
    }

    public void setPressao_arterial(String pressao_arterial) {
        this.pressao_arterial = pressao_arterial;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getResultado_triagem() {
        return resultado_triagem;
    }

    public void setResultado_triagem(String resultado_triagem) {
        this.resultado_triagem = resultado_triagem;
    }

    public LocalDate getData_triagem() {
        return Data_triagem;
    }

    public void setData_triagem(LocalDate data_triagem) {
        Data_triagem = data_triagem;
    }

    public String getObservacoes() {
        return Observacoes;
    }

    public void setObservacoes(String observacoes) {
        Observacoes = observacoes;
    }

    public String getTemperatura() {
        return Temperatura;
    }

    public void setTemperatura(String temperatura) {
        Temperatura = temperatura;
    }
}
