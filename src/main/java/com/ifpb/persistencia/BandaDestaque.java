/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.persistencia;

import com.ifpb.model.Banda;
import com.ifpb.persistenciaIF.BandaDestaqueIF;
import java.util.Collections;
import java.util.List;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Remote;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Cliente
 */

@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
@Remote(BandaDestaqueIF.class)

public class BandaDestaque implements BandaDestaqueIF {
    
    
    EntityManager em = Persistence
          .createEntityManagerFactory("DAC")
          .createEntityManager();
    
    @Lock(LockType.READ)
    @Override
    public List<Banda> listBandaAleatoria() {
        String sql = "SELECT * FROM Banda  ORDER BY RANDOM() LIMIT 3";
        Query query = em.createNativeQuery(sql, Banda.class);
        List<Banda> resultList = query.getResultList();
        return  Collections.unmodifiableList(resultList);
    }

}
