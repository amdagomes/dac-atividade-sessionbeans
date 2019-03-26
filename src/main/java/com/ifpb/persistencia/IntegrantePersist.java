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
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Cliente
 */
@Stateless
//@Remote(IntegranteIF.class)
public class IntegrantePersist implements IntegranteIF {

//    EntityManager em = Persistence
//            .createEntityManagerFactory("DAC")
//            .createEntityManager();

    @PersistenceContext
    EntityManager em;
    
    @Override
    public void persist(Integrante i) {
        em.persist(i);
    }

    @Override
    public void remove(int id) {
        Integrante i = em.find(Integrante.class, id);
        em.remove(i);
    }

    @Override
    public Integrante find(int id) {
        return em.find(Integrante.class, id);
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
        Integrante i;
        i = em.find(Integrante.class, id);
        i.setId(id);
        i.setCpf(integrante.getCpf());
        i.setDataDeNascimento(integrante.getDataDeNascimento());
        i.setNome(integrante.getNome());
        em.merge(i);
    }

}
