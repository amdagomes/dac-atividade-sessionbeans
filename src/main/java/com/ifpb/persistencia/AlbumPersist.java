/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.persistencia;

import java.util.List;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import com.ifpb.model.Album;
import com.ifpb.persistenciaIF.AlbumIF;
import com.ifpb.persistenciaIF.BandaIF;

/**
 *
 * @author Cliente
 */
@Stateless
@Remote(AlbumIF.class)
public class AlbumPersist implements AlbumIF {

    EntityManager em = Persistence
            .createEntityManagerFactory("PDP")
            .createEntityManager();

    @Override
    public void persist(Album a) {
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();
        em.persist(a);
        transaction.commit();
    }

    @Override
    public void remove(int id) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Album a;
        a = em.find(Album.class, id);
        em.remove(a);
    }

    @Override
    public Album find(int id) {

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Album a;
        a = em.find(Album.class, id);
        transaction.commit();
        return a;
    }

    @Override
    public List<Album> list(Album a) {
        String sql = "SELECT a FROM Album a";
        TypedQuery<Album> query = em.createQuery(sql, Album.class);
        List<Album> lista = query.getResultList();
        return lista;
    }

    @Override
    public void update(int id, Album a) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Album album;
        album = em.find(Album.class, id);
        album = a;
        album.setId(id);
        em.merge(album);
    }

}
