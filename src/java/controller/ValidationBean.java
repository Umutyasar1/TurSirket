/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;

/**
 *
 * @author Umut
 */

@Named
@SessionScoped
public class ValidationBean implements Serializable {

    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String str = value.toString();
        if (str.length() < 2) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "summary", "en az 2 karakter"));
        }
        if (str.length() > 20) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "summary", "en fazla 20 karakter"));
        }
    }
}
