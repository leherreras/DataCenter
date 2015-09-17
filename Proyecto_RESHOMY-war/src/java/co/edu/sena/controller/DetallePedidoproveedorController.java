package co.edu.sena.controller;

import co.edu.sena.entity.DetallePedidoproveedor;
import co.edu.sena.controller.util.JsfUtil;
import co.edu.sena.controller.util.JsfUtil.PersistAction;
import co.edu.sena.facade.DetallePedidoproveedorFacade;

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

@Named(value = "detallePedidoproveedorController")
@SessionScoped
public class DetallePedidoproveedorController implements Serializable {

    @EJB
    private co.edu.sena.facade.DetallePedidoproveedorFacade ejbFacade;
    private List<DetallePedidoproveedor> items = null;
    private DetallePedidoproveedor selected;

    public DetallePedidoproveedorController() {
    }

    public DetallePedidoproveedor getSelected() {
        return selected;
    }

    public void setSelected(DetallePedidoproveedor selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private DetallePedidoproveedorFacade getFacade() {
        return ejbFacade;
    }

    public DetallePedidoproveedor prepareCreate() {
        selected = new DetallePedidoproveedor();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Titulos/Bundle").getString("DetallePedidoproveedorCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Titulos/Bundle").getString("DetallePedidoproveedorUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Titulos/Bundle").getString("DetallePedidoproveedorDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<DetallePedidoproveedor> getItems() {
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

    public DetallePedidoproveedor getDetallePedidoproveedor(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<DetallePedidoproveedor> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<DetallePedidoproveedor> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = DetallePedidoproveedor.class)
    public static class DetallePedidoproveedorControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            DetallePedidoproveedorController controller = (DetallePedidoproveedorController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "detallePedidoproveedorController");
            return controller.getDetallePedidoproveedor(getKey(value));
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
            if (object instanceof DetallePedidoproveedor) {
                DetallePedidoproveedor o = (DetallePedidoproveedor) object;
                return getStringKey(o.getIdDetallePedidoProveedor());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), DetallePedidoproveedor.class.getName()});
                return null;
            }
        }

    }

}
