package converter;

import dao.SirketDao;
import entity.Sirket;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Umut
 */
@FacesConverter(value = "sirketConverter")
public class SirketConverter implements Converter {

    private SirketDao sirketDao;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return this.getSirketDao().find(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Sirket s = (Sirket) value;
        return s.getSirket_id().toString();
    }

    public SirketDao getSirketDao() {
        if (this.sirketDao == null) {
            this.sirketDao = new SirketDao();
        }
        return sirketDao;
    }

}
