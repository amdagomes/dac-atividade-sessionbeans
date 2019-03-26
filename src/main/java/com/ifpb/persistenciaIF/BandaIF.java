/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.persistenciaIF;

import java.util.List;

import com.ifpb.model.Banda;

/**
 *
 * @author Cliente
 */
public interface BandaIF {

    public void persist(Banda b);

    public void remove(int id);

    public Banda find(int id);

    public List<Banda> list();

    public void update(int id, Banda b);

    public Banda BandaIntegrante(String integrante);

    public List<Banda> listBandaPorIntegrante(String integrante);
    
    

}
