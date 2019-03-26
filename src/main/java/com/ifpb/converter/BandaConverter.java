package com.ifpb.converter;

import com.ifpb.model.Banda;
import com.ifpb.persistencia.BandaPersist;
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
    
    private final BandaPersist dao = new BandaPersist();
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        
        if(value == null || value.isEmpty()){
            return null;
        }else{
            int id = Integer.parseInt(value);
            Banda banda = dao.find(id);
            System.out.println(banda.getNomeFantasia());
            return banda;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
       if(value != null){
            return String.valueOf(value);
        }else{
            return null;
        }
    }

}
