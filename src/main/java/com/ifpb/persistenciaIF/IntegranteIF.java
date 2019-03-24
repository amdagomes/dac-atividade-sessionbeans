/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.persistenciaIF;

import java.util.List;

import com.ifpb.model.Integrante;

/**
 *
 * @author Cliente
 */
public interface IntegranteIF {

    public void persist(Integrante i);

    public void remove(int id);

    public Integrante find(int id);

    public List<Integrante> list();

    public void update(int id, Integrante i);
}
