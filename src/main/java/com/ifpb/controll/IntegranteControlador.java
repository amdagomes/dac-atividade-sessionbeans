package com.ifpb.controll;

import com.ifpb.model.Integrante;
import com.ifpb.persistenciaIF.IntegranteIF;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;


/**
 *
 * @author Amanda
 */


@ManagedBean(name = "integranteControlador")
@RequestScoped
public class IntegranteControlador implements Serializable {

    @EJB
    private IntegranteIF manager;
    private Integrante integrante = new Integrante();
    
    public String salvar(){      
        this.manager.persist(this.integrante);
        return null;
    }
    
    public String remover(int id){
        this.manager.remove(id);
        return null;
    }
    
    public List<Integrante> listar(){
        return this.manager.list();
    }

    public Integrante getIntegrante() {
        return integrante;
    }

    public void setIntegrante(Integrante integrante) {
        this.integrante = integrante;
    }
    
}
