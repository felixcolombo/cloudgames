package com.senai.devinhouse.CloudGames.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Jogo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jogo_ger")
    @SequenceGenerator(name = "jogo_ger", sequenceName = "jogo_seq")
    private Long id;

    private String nome;

    private LocalDate dataLancamento;

    private String capa;

    @Enumerated(EnumType.STRING)
    private Genero genero;

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

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public String getCapa() {
        return capa;
    }

    public void setCapa(String capa) {
        this.capa = capa;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Jogo{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", dataLancamento=" + dataLancamento +
                ", capa='" + capa + '\'' +
                ", genero=" + genero +
                '}';
    }

}
/*
Nesta atividade você deverá criar a entidade Jogo com os atributos:
Nome, data de lançamento, capa, genero e uma lista de plataformas.
 */