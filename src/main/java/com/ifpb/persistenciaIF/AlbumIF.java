/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.persistenciaIF;

import java.util.List;
import com.ifpb.model.Album;

/**
 *
 * @author Cliente
 */
public interface AlbumIF {

    public void persist(Album a);

    public void remove(int id);

    public Album find(int id);

    public void update(int id, Album a);

    public List<Album> list(Album a);
}
