/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import dao.MusteriDao;
import entity.Musteri;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author casper
 */
@FacesConverter(value = "musteriConverter")
public class MusteriConverter implements Converter {

    private MusteriDao musteriDao;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return this.getMusteriDao().find(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Musteri m = (Musteri) value;
        return m.getMusteri_id().toString();
    }

    public MusteriDao getMusteriDao() {
        if (this.musteriDao == null) {
            this.musteriDao = new MusteriDao();
        }
        return musteriDao;
    }

}
