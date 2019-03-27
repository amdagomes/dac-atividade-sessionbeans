package com.ifpb.converter;

import com.ifpb.model.Banda;
import com.ifpb.persistencia.BandaPersist;
import javax.enterprise.inject.spi.CDI;
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
    
    private final BandaPersist dao;

    public BandaConverter() {
        this.dao = CDI.current().select(BandaPersist.class).get();
    }

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
       Banda banda = (Banda) value;
       if(banda != null){
            return String.valueOf(banda.getId());
        }else{
            return null;
        }
    }

}
