/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.controll;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import com.ifpb.model.Cpf;

/**
 *
 * @author Cliente
 */
public class ConversorCPF implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component,
            String value) {
        if (value == null) {
            return null;
        }
        return new Cpf(value);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component,
            Object value) {
        if (value == null) {
            return null;
        }
        Cpf cpf = (Cpf) value;
        return cpf.numero();

    }

}
