package com.OptimizationBlood.blood.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.Valid;
import java.util.List;

@Entity
@ApiModel(description = "Todos os detalhes sobre o dador . ")
public class Dador  {

    private static final  long serialVersionUID =1L;

    @Id
    @ApiModelProperty(notes = "Este é o ID  do dador e ele é gerado automaticamente")

    @GeneratedValue()
     private long codigo ;

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }
    @ApiModelProperty(notes = "Este é o nome  do dador")

    private String nome;
    @ApiModelProperty(notes = "Este é o apelido  do dador")

    private String Apelido;
    private String endereco;
    private String sexo;
    private int telefone;
    private String email;





    public Dador() {

    }



    private     String grupoSanguineo;



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return Apelido;
    }

    public void setApelido(String apelido) {
        Apelido = apelido;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }

    public void setGrupoSanguineo(String grupoSanguineo) {
        this.grupoSanguineo = grupoSanguineo;
    }




}
