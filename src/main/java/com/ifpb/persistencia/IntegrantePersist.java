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
import com.ifpb.model.Integrante;
import com.ifpb.persistenciaIF.IntegranteIF;

/**
 *
 * @author Cliente
 */
public class IntegrantePersist implements IntegranteIF {

    EntityManager em = Persistence
            .createEntityManagerFactory("PDP")
            .createEntityManager();

    @Override
    public void persist(Integrante i) {
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();
        em.persist(i);
        transaction.commit();

    }

    @Override
    public void remove(int id) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Integrante i;
        i = em.find(Integrante.class, id);
        em.remove(i);
    }

    @Override
    public Integrante find(int id) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Integrante i;
        i = em.find(Integrante.class, id);
        transaction.commit();
        return i;

    }

    @Override
    public List<Integrante> list() {
        String sql = "SELECT i FROM Integrante i";
        TypedQuery<Integrante> query = em.createQuery(sql, Integrante.class);
        List<Integrante> lista = query.getResultList();
        return lista;

    }

    @Override
    public void update(int id, Integrante integrante) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Integrante i;
        i = em.find(Integrante.class, id);
        i = integrante;
        i.setId(id);
        em.merge(i);
        transaction.commit();

    }

}
