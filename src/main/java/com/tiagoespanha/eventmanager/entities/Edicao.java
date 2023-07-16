package com.tiagoespanha.eventmanager.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Edicao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer numero;
    private Integer ano;
    private Date dataInicial;
    private Date dataFinal;
    private String cidade;

    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Integer getNumero() {
        return numero;
    }
    public void setNumero(Integer numero) {
        this.numero = numero;
    }
    public Integer getAno() {
        return ano;
    }
    public void setAno(Integer ano) {
        this.ano = ano;
    }
    public Date getDataInicial() {
        return dataInicial;
    }
    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }
    public Date getDataFinal() {
        return dataFinal;
    }
    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}
