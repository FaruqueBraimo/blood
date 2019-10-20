package com.OptimizationBlood.blood.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
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

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "sangue_id")
    private Sangue sangue;
    private int numeroDeDoacoes;
    private String nomeMae;
    private String nomePai;
    private String numeroDocumento;
    private String tipoDocumento;
    private String nacionalidade;
    private String situacaoAptidao;
    private String Provincia;
    private String FatorRH;

    @OneToOne
    private Usuario usuario;

     @OneToMany(mappedBy = "dador")
     private  List<Triagem> triagem;


    @OneToMany(mappedBy = "dador")
    private  List<Agendamento> agendamento;



    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Sangue getSangue() {
        return sangue;
    }

    public void setSangue(Sangue sangue) {
        this.sangue = sangue;
    }

    public int getNumeroDeDoacoes() {
        return numeroDeDoacoes;
    }

    public void setNumeroDeDoacoes(int numeroDeDoacoes) {
        this.numeroDeDoacoes = numeroDeDoacoes;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getNomePai() {
        return nomePai;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getSituacaoAptidao() {
        return situacaoAptidao;
    }

    public void setSituacaoAptidao(String situacaoAptidao) {
        this.situacaoAptidao = situacaoAptidao;
    }

    public String getProvincia() {
        return Provincia;
    }

    public void setProvincia(String provincia) {
        Provincia = provincia;
    }

    public String getFatorRH() {
        return FatorRH;
    }

    public void setFatorRH(String fatorRH) {
        FatorRH = fatorRH;
    }



    public Dador() {

    }






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


}
