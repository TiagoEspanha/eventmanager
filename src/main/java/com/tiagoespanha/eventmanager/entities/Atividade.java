package com.tiagoespanha.eventmanager.entities;

import java.sql.Time;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Atividade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String tipo;
    private String descricao;
    private Date data;
    private Time inicio;
    private Time fim;

    @ManyToOne
    @JoinColumn(name = "edicao_id")
    private Edicao edicao;

    @ManyToOne
    @JoinColumn(name = "espaco_id")
    private Espaco espaco;


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
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public Date getData() {
        return data;
    }
    public void setData(Date data) {
        this.data = data;
    }
    public Time getInicio() {
        return inicio;
    }
    public void setInicio(Time inicio) {
        this.inicio = inicio;
    }
    public Time getFim() {
        return fim;
    }
    public void setFim(Time fim) {
        this.fim = fim;
    }
    public Edicao getEdicao() {
        return edicao;
    }
    public void setEdicao(Edicao edicao) {
        this.edicao = edicao;
    }
    public Espaco getEspaco() {
        return espaco;
    }
    public void setEspaco(Espaco espaco) {
        this.espaco = espaco;
    }
}
