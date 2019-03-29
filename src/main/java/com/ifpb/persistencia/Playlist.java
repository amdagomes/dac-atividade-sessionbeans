/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.persistencia;

import com.ifpb.model.Banda;
import com.ifpb.persistenciaIF.PlaylistIF;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.ejb.Local;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.ejb.StatefulTimeout;

/**
 *
 * @author Cliente
 */
@Stateful
//@Remote(PlaylistIF.class)
@StatefulTimeout(unit = TimeUnit.MINUTES, value = 5)
@Local(PlaylistIF.class)
public class Playlist implements PlaylistIF {

    private final List<Banda> bandaList = new ArrayList<>();
    
    @Override
    public void addBanda(Banda banda) {
        this.bandaList.add(banda);
    }

    @Override
    public void removerBanda(Banda banda) {
        this.bandaList.remove(banda);
    }

    @Override
    public List<Banda> lista() {
        return Collections.unmodifiableList(this.bandaList);
    }
    @Remove
    @Override
    public void finalizar() {
        System.out.println("--- bandas ----");
        this.bandaList.forEach(System.out::println);
    }

}
