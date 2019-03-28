/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.persistenciaIF;

import com.ifpb.model.Banda;
import java.util.List;

/**
 *
 * @author Cliente
 */
public interface PlaylistIF {

    public void addBanda(Banda banda);

    public void removerBanda(Banda banda);

    public List<Banda> lista();

    public void finalizar();
}
