/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.persistencia;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import com.ifpb.model.Banda;
import com.ifpb.persistenciaIF.BandaIF;

/**
 *
 * @author Cliente
 */
public class BandaPersist implements BandaIF {

    EntityManager em = Persistence
            .createEntityManagerFactory("DAC")
            .createEntityManager();

    @Override
    public void persist(Banda b) {
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();
        em.persist(b);
        transaction.commit();
    }

    @Override
    public void remove(int id) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Banda b;
        b = em.find(Banda.class, id);
        em.remove(b);
    }

    @Override
    public Banda find(int id) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Banda b;
        b = em.find(Banda.class, id);
        transaction.commit();
        return b;
    }

    @Override
    public List<Banda> list() {
        String sql = "SELECT b FROM Banda b";
        TypedQuery<Banda> query = em.createQuery(sql, Banda.class);
        List<Banda> lista = query.getResultList();
        return lista;
    }

    @Override
    public List<Banda> listBandaPorIntegrante(String integrante) {
        integrante = integrante.toUpperCase();
        String sql = "SELECT b FROM Banda b, IN (b.integrantes) i WHERE UPPER(i.nome) = :integrante";
        TypedQuery<Banda> query = em.createQuery(sql, Banda.class);
        query.setParameter("integrante", integrante);
        List<Banda> resultList = query.getResultList();
        return resultList;
    }

    @Override
    public Banda BandaIntegrante(String integrante) {
        EntityTransaction transaction = em.getTransaction();

        integrante = integrante.toUpperCase();
        String sql = " SELECT b FROM Banda b, IN (b.integrantes) i WHERE UPPER(i.nome) = :integrante";
        TypedQuery<Banda> query = em.createQuery(sql, Banda.class);
        query.setParameter("integrante", integrante);
        Banda b = query.getSingleResult();

        return b;
    }

    @Override
    public void update(int id, Banda b) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Banda banda;
        banda = em.find(Banda.class, id);
        banda = b;
        banda.setId(id);
        em.merge(banda);
        transaction.commit();
    }

}
