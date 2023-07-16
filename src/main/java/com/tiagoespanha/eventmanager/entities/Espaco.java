package com.tiagoespanha.eventmanager.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Espaco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getLocalizacao() {
        return localizacao;
    }
    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }
    public Integer getCapacidade() {
        return capacidade;
    }
    public void setCapacidade(Integer capacidade) {
        this.capacidade = capacidade;
    }
    public String[] getRecursos() {
        return recursos;
    }
    public void setRecursos(String[] recursos) {
        this.recursos = recursos;
    }
    private String localizacao;
    private Integer capacidade;
    private String[] recursos;
}
