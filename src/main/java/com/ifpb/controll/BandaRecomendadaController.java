package com.ifpb.controll;

import com.ifpb.model.Banda;
import com.ifpb.persistenciaIF.RecomendaBandaIF;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;

/**
 *
 * @author Amanda
 */

@Named
public class BandaRecomendadaController {
    
    @EJB
    private RecomendaBandaIF manager;
    
    public List<Banda> recomendarBanda() {
        return this.manager.listBandaAleatoria();
    }
}
