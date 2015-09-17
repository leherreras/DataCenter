package co.edu.sena.controller;

import co.edu.sena.entity.TipoSalida;
import co.edu.sena.controller.util.JsfUtil;
import co.edu.sena.controller.util.JsfUtil.PersistAction;
import co.edu.sena.facade.TipoSalidaFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named(value = "tipoSalidaController")
@SessionScoped
public class TipoSalidaController implements Serializable {

    @EJB
    private co.edu.sena.facade.TipoSalidaFacade ejbFacade;
    private List<TipoSalida> items = null;
    private TipoSalida selected;

    public TipoSalidaController() {
    }

    public TipoSalida getSelected() {
        return selected;
    }

    public void setSelected(TipoSalida selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private TipoSalidaFacade getFacade() {
        return ejbFacade;
    }

    public TipoSalida prepareCreate() {
        selected = new TipoSalida();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Titulos/Bundle").getString("TipoSalidaCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Titulos/Bundle").getString("TipoSalidaUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Titulos/Bundle").getString("TipoSalidaDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<TipoSalida> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Titulos/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Titulos/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public TipoSalida getTipoSalida(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<TipoSalida> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<TipoSalida> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = TipoSalida.class)
    public static class TipoSalidaControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            TipoSalidaController controller = (TipoSalidaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "tipoSalidaController");
            return controller.getTipoSalida(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof TipoSalida) {
                TipoSalida o = (TipoSalida) object;
                return getStringKey(o.getIdTipoSalida());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), TipoSalida.class.getName()});
                return null;
            }
        }

    }

}
