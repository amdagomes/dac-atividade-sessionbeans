package com.ifpb.converter;

import com.ifpb.model.Integrante;
import com.ifpb.persistencia.IntegrantePersist;
import com.ifpb.persistenciaIF.IntegranteIF;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Amanda
 */
@FacesConverter(value = "converter.Integrante", forClass = Integrante.class)
public class IntegranteConverter implements Converter {
    
//    @EJB
    private final IntegranteIF dao = new IntegrantePersist();

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value == null || value.isEmpty()){
            return null;
        }else{
            int id = Integer.parseInt(value);
            Integrante i = dao.find(id);
            System.out.println("Integrante: " + i.getNome());
            return i;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Integrante i = (Integrante) value;
       if(i != null){
            return String.valueOf(i.getId());
        }else{
            return null;
        }
    }

}
