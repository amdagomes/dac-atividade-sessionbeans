/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.controll;

import com.ifpb.model.Album;
import com.ifpb.model.Banda;
import com.ifpb.model.Estilo;

import com.ifpb.persistenciaIF.AlbumIF;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Cliente
 */
@ManagedBean(name = "albumControlador")
@RequestScoped
public class AlbumControlador implements Serializable {

    @EJB
    private AlbumIF albuns;
    private Album album = new Album();

    public String salvar() {
        System.out.println("banda: " + this.album.getBanda().toString());
        this.albuns.persist(album);
        return null;
    }

    public String remove() {
        this.albuns.remove(this.album.getId());
        return null;

    }

    public List<Album> listar() {
        return this.listar();
    }
    
    public Estilo[] getEstilos(){
        return Estilo.values();
    }

    public AlbumIF getAlbuns() {
        return albuns;
    }

    public void setAlbuns(AlbumIF albuns) {
        this.albuns = albuns;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

}
