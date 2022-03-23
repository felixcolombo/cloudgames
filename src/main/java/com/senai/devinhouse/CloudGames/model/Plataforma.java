package com.senai.devinhouse.CloudGames.model;

import javax.persistence.*;

@Entity
public class Plataforma {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "plataforma_seq")
    @SequenceGenerator(name = "plataforma_ger", sequenceName = "plataforma_seq")
    private Long id;

    private String nome;

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Plataforma{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}

/*
A lista de plataformas deverá ser uma outra entidade com id e nome do qual você poderá ter
as seguintes plataformas cadastradas : PS1, PS2, PS3, PS4, PS5, Xbox Series S, Xbox Series X e PC.
 */