package co.edu.sena.web.controller;

import co.edu.sena.ejb.SeguridadClienteEJB;
import co.edu.sena.entity.Cliente;
import co.edu.sena.web.util.NavigatorRulesEnum;
import co.edu.sena.web.util.RolesEnum;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@Named(value = "principalControllerClient")
@SessionScoped
public class PrincipalControllerClient implements Serializable {

    @EJB
    private SeguridadClienteEJB seguridadEJB;

    private Cliente clienteLog;
    private String cliente;
    private String clave;

    public Cliente getClienteLog() {
        return clienteLog;
    }

    public String validarUser() {

        this.clienteLog = null;

        this.clienteLog = this.seguridadEJB.validarCliente(this.cliente, this.clave);

        if (this.clienteLog != null){

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido", this.clienteLog.getNombresCliente()));

            String rule = NavigatorRulesEnum.CLIENTE.getRule();

            if (this.clienteLog != null){
                rule = NavigatorRulesEnum.CLIENTE.getRule();
            }
            
            return rule;
        } 
        else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Cliente Inválido", ""));
            
            return null;
        }

    }

    public String cerrarSesion() {

        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);

        if (session != null) {
            session.invalidate();
        }
        return "/Content_View/Main_Menu.xhtml";
    }

    //<editor-fold defaultstate="collapsed" desc="Getter and Sette">
    public void setClienteLog(Cliente clienteLog) {
        this.clienteLog = clienteLog;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public PrincipalControllerClient() {
    }

    //</editor-fold>
}
