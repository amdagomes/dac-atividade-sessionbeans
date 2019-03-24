/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.controll;

import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;

import com.ifpb.model.Banda;
import com.ifpb.persistenciaIF.BandaIF;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Cliente
 */
@ManagedBean(name = "bandaControlador")
@RequestScoped
public class BandaControlador implements Serializable {

    @EJB
    private BandaIF banda;
    private Banda b = new Banda();

    public String addBanda() {

        this.banda.persist(this.b);
        this.b = new Banda();
        bandaAleatoria();

        return null;

    }

    public String removeBanda(Banda b) {

        this.banda.remove(b.getId());

        return null;

    }

    public List<Banda> listar() {

        return this.banda.list();
    }

    public List<Banda> bandaIntegrante(String integrante) {

        return this.banda.listBandaPorIntegrante(integrante);
    }
public List<Banda> bandaAleatoria() {

        return this.banda.listBandaAleatoria();
    }

    public Banda bandaPorIntegrante(String integrante) {

        return this.banda.BandaIntegrante(integrante);
    }

    public Banda getB() {
        return b;
    }

    public void setB(Banda b) {
        this.b = b;
    }

}
