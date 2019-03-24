/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

/**
 *
 * @author Cliente
 */
@Embeddable
public class Cpf implements Serializable {

    private String numero;

    public Cpf() {
        this("");
    }

    public Cpf(String numero) {
        this.numero = numero;
    }

    public String numero() {

        return this.numero;
    }

    public String formatado() {

        return this.numero.substring(0, 3) + "."
                + this.numero.substring(3, 6) + "."
                + this.numero.substring(6, 9) + "-"
                + this.numero.substring(9, 11);
    }

    public boolean ehValido() {
        return this.numero.length() == 11;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cpf other = (Cpf) obj;
        if (!Objects.equals(this.numero, other.numero)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cpf{" + "numero=" + numero + '}';
    }

}
