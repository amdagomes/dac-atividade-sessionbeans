package com.ifpb.converter;

import com.ifpb.model.Banda;
import com.ifpb.persistencia.BandaPersist;
import com.ifpb.persistenciaIF.BandaIF;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Amanda
 */
@FacesConverter(value = "converter.Banda", forClass = Banda.class)
public class BandaConverter implements Converter {
    
//    @EJB
    private final BandaIF dao = new BandaPersist();

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value == null || value.isEmpty()){
            return null;
        }else{
            int id = Integer.parseInt(value);
            Banda b = dao.find(id);
            System.out.println("Integrante: " + b.getNomeFantasia());
            return b;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Banda b = (Banda) value;
       if(b != null){
            return String.valueOf(b.getId());
        }else{
            return null;
        }
    }

}
