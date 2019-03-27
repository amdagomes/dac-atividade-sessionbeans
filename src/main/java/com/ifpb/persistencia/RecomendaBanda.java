package com.ifpb.persistencia;

import com.ifpb.model.Banda;
import com.ifpb.persistenciaIF.RecomendaBandaIF;
import java.util.List;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Amanda
 */
@Singleton
public class RecomendaBanda implements RecomendaBandaIF{

    @PersistenceContext
    private EntityManager em;
    
    public List<Banda> listBandaAleatoria() {
        String sql = "SELECT * FROM Banda  ORDER BY RANDOM() LIMIT 3";
        Query query = em.createNativeQuery(sql, Banda.class);
        List<Banda> resultList = query.getResultList();
        return resultList;
    }
}
