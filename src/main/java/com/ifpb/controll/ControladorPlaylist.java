/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.controll;

import com.ifpb.model.Banda;
import com.ifpb.persistenciaIF.BandaIF;
import com.ifpb.persistenciaIF.PlaylistIF;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
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
public class ControladorPlaylist {

    @EJB
    private PlaylistIF playlist;
    private BandaIF bandaif;
    private Banda banda;

    public List<Banda> listarCarrinho() {
        return playlist.lista();
    }

    public List<Banda> todasAsBandas() {
        return bandaif.list();
    }

    public void addBanda() {
        playlist.addBanda(this.banda);
    }

    private void finalizarSessao() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        HttpSession session = (HttpSession) externalContext.getSession(true);
        session.invalidate();
    }
}
