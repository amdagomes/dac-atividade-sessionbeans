/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.controll;

import com.ifpb.model.Banda;
import com.ifpb.persistenciaIF.PlaylistIF;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Cliente
 */
@Named
@SessionScoped
public class ControladorPlaylist implements Serializable{

    @EJB
    private PlaylistIF playlist;
//    private List<Banda> bandas = new ArrayList<>();
    
    public List<Banda> listarPlaylist() {
//        this.bandas = playlist.lista();
        return this.playlist.lista();
    }
    
    public String remover(Banda banda){
        this.playlist.removerBanda(banda);
        listarPlaylist();
        return null;
    }

    public String addBanda(Banda banda) {
        playlist.addBanda(banda);
        listarPlaylist();
        return null;
    }

    private void finalizarSessao() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        HttpSession session = (HttpSession) externalContext.getSession(true);
        session.invalidate();
    }

//    public List<Banda> getBandas() {
//        return bandas;
//    }
//
//    public void setBandas(List<Banda> bandas) {
//        this.bandas = bandas;
//    }
    
}
