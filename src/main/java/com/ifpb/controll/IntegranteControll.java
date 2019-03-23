package com.ifpb.controll;

import com.ifpb.model.Integrante;
import com.ifpb.persistenciaIF.IntegranteIF;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Amanda
 */
@Named
@RequestScoped
public class IntegranteControll {

    @EJB
    private IntegranteIF manager;
    private Integrante integrante = new Integrante();
    
    public String salvar(){
        this.manager.persist(integrante);
        this.integrante = new Integrante();
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
