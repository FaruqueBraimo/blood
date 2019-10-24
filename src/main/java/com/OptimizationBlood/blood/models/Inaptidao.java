package com.OptimizationBlood.blood.models;


import javax.persistence.*;

@Entity
public class Inaptidao {

    @Id
    @GeneratedValue
    private int codigo;
    private String motivo;
    @ManyToOne(optional = false)
    @JoinColumn(name = "triagem_id")
    private Triagem Triagem;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Triagem getTriagem() {
        return Triagem;
    }

    public void setTriagem(Triagem triagem) {
        Triagem = triagem;
    }
}
