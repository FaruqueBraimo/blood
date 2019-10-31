package com.OptimizationBlood.blood.models;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "codigo")
public class Triagem  implements Serializable {


@Id
@GeneratedValue
private  int codigo;
private String localColheita;
private String pressao_arterial;
private String peso;
private String altura;
private String resultado_triagem;
private LocalDate Data_triagem;
private String Observacoes;
private String Temperatura;
private String status = "apto";
private  String feito = "nao";

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "agendamento_id")
    private Agendamento agendamento;

    @OneToMany( mappedBy = "triagem", fetch = FetchType.EAGER)
    private List<Doacao> doacao;


    public List<Doacao> getDoacao() {
        return doacao;
    }

    public void setDoacao(List<Doacao> doacao) {
        this.doacao = doacao;
    }

    public Agendamento getAgendamento() {
        return agendamento;
    }

    public void setAgendamento(Agendamento agendamento) {
        this.agendamento = agendamento;
    }




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
