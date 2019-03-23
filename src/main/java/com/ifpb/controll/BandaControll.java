/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.controll;

import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import com.ifpb.model.Banda;
import com.ifpb.persistenciaIF.BandaIF;

/**
 *
 * @author Cliente
 */

@Named
@RequestScoped
public class BandaControll {

    @EJB
    private BandaIF banda;
    private Banda b;

    public String addBanda(Banda b) {

        this.banda.persist(this.b);

        return null;

    }

    public String removeBanda(Banda b) {

        this.banda.remove(b.getId());

        return null;

    }

    public List<Banda> listar() {

        return this.banda.list();
    }

    public List<Banda> BandaIntegrante(String integrante) {

        return this.banda.listBandaPorIntegrante(integrante);
    }

    public Banda bandaIntegrante(String integrante) {

        return this.banda.BandaIntegrante(integrante);
    }

}
