/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.model;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.AttributeOverride;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Cliente
 */
@Entity
public class Integrante implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private String nome;
    @Embedded
    @AttributeOverride(name = "numero", column = @Column(name = "cpf"))
    private Cpf cpf = new Cpf("");

    @Convert(converter = ConversorLocalDate.class)
    private LocalDate dataDeNascimento;

    public Integrante() {
    }

    public Integrante(String nome, LocalDate dataDeNascimento, Cpf cpf) {
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
        this.cpf = cpf;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cpf getCpf() {
        return cpf;
    }

    public void setCpf(Cpf cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

}
