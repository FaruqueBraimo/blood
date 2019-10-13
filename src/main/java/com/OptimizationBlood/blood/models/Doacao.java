package com.OptimizationBlood.blood.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Doacao {

    @Id
    @GeneratedValue
    private  int codigo;

    private String numero_bolsa;

    @OneToOne(mappedBy = "doacao")
    private Triagem triagem;
    private LocalDate data_coletada;
    private LocalTime hora_coletada;
    private String volume_coletado;
    private String Reacao;
    private String Observacoes;





}
