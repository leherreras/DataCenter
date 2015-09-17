package co.edu.sena.controller;

import co.edu.sena.entity.TipoProducto;
import co.edu.sena.controller.util.JsfUtil;
import co.edu.sena.controller.util.JsfUtil.PersistAction;
import co.edu.sena.facade.TipoProductoFacade;

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

@Named(value = "tipoProductoController")
@SessionScoped
public class TipoProductoController implements Serializable {

    @EJB
    private co.edu.sena.facade.TipoProductoFacade ejbFacade;
    private List<TipoProducto> items = null;
    private TipoProducto selected;

    public TipoProductoController() {
    }

    public TipoProducto getSelected() {
        return selected;
    }

    public void setSelected(TipoProducto selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private TipoProductoFacade getFacade() {
        return ejbFacade;
    }

    public TipoProducto prepareCreate() {
        selected = new TipoProducto();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Titulos/Bundle").getString("TipoProductoCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Titulos/Bundle").getString("TipoProductoUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Titulos/Bundle").getString("TipoProductoDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<TipoProducto> getItems() {
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

    public TipoProducto getTipoProducto(java.lang.String id) {
        return getFacade().find(id);
    }

    public List<TipoProducto> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<TipoProducto> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = TipoProducto.class)
    public static class TipoProductoControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            TipoProductoController controller = (TipoProductoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "tipoProductoController");
            return controller.getTipoProducto(getKey(value));
        }

        java.lang.String getKey(String value) {
            java.lang.String key;
            key = value;
            return key;
        }

        String getStringKey(java.lang.String value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof TipoProducto) {
                TipoProducto o = (TipoProducto) object;
                return getStringKey(o.getIdTipoProducto());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), TipoProducto.class.getName()});
                return null;
            }
        }

    }

}
