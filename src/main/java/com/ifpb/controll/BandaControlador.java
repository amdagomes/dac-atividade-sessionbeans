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
import com.ifpb.model.Integrante;
import com.ifpb.persistencia.BandaDestaque;
import com.ifpb.persistenciaIF.BandaDestaqueIF;
import com.ifpb.persistenciaIF.BandaIF;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Cliente
 */
@ManagedBean(name = "bandaControlador")
@SessionScoped
public class BandaControlador implements Serializable {

    @EJB
    private BandaIF banda;
    @EJB
    private BandaDestaqueIF bd;
    
    private Banda b = new Banda();
    private Integrante integrante = new Integrante();
    

    public String addBanda() {

        this.banda.persist(this.b);
        this.b = new Banda();
        bandaAleatoria();
        return "index.xhtml";

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
    
    public String addIntegrante(){
        this.b.getIntegrantes().add(this.integrante);
        this.integrante = new Integrante();
         return null;  
    }
    
    public String removerIntegrante(Integrante integrante){
        System.out.println("remover: " + integrante.toString());
        this.b.getIntegrantes().remove(integrante);
        return null;
    }
    
    public List<Banda> bandaAleatoria() {

        return this.bd.listBandaAleatoria();
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

    public Integrante getIntegrante() {
        return integrante;
    }

    public void setIntegrante(Integrante integrante) {
        this.integrante = integrante;
    }

}
