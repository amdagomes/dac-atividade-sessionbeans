/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 *
 * @author Cliente
 */
@Entity
public class Banda implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private String localDeOrigem;
    private String nomeFantasia;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "banda_id")
    private List<Integrante> integrantes;

    public Banda() {
        this.integrantes = new ArrayList<>();

    }

    public void adicionar(Integrante i) {
        this.integrantes.add(i);
    }

    public Banda(String localDeOrigem, String nomeFantasia) {

        this.localDeOrigem = localDeOrigem;
        this.nomeFantasia = nomeFantasia;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocalDeOrigem() {
        return localDeOrigem;
    }

    public void setLocalDeOrigem(String localDeOrigem) {
        this.localDeOrigem = localDeOrigem;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public List<Integrante> getIntegrantes() {
        return integrantes;
    }

    public void setIntegrantes(List<Integrante> integrantes) {
        this.integrantes = integrantes;
    }

    @Override
    public String toString() {
        return "Banda{" + "id=" + id + ", localDeOrigem=" + localDeOrigem + ", nomeFantasia=" + nomeFantasia + ", integrantes=" + integrantes + '}';
    }

}
