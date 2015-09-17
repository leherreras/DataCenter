package co.edu.sena.web.controller;

import co.edu.sena.ejb.SeguridadColaboradorEJB;
import co.edu.sena.entity.Colaborador;
import co.edu.sena.web.util.NavigatorRulesEnum;
import co.edu.sena.web.util.RolesEnum;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Named(value = "principalControllerCollaborator")
@SessionScoped
public class PrincipalControllerCollaborator implements Serializable {

    @EJB
    private SeguridadColaboradorEJB seguridadEJB;

    private Colaborador colaboradorLog;
    private String colaborador;
    private String clave;

    public Colaborador getColaboradorLog() {
        return this.colaboradorLog;
    }

    public String validarUser() {

        this.colaboradorLog = null;
        this.colaboradorLog = this.seguridadEJB.validarColaborador(this.colaborador, this.clave);

        if (this.colaboradorLog != null) {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido", this.colaboradorLog.getNombresColaborador()));

            String rule = null;

            if (this.colaboradorLog.getRol() != null) {

                if (this.colaboradorLog.getRol().getNombreRol().equalsIgnoreCase(RolesEnum.ADMINISTRADOR.getRule())) {
                    rule = NavigatorRulesEnum.ADMINISTRADOR.getRule();
                } else if (this.colaboradorLog.getRol().getNombreRol().equalsIgnoreCase(RolesEnum.COLABORADOR.getRule())) {
                    rule = NavigatorRulesEnum.COLABORADOR.getRule();
                }
            }

            return rule;

        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Colaborador Inválido", ""));
            return null;
        }
    }

    //<editor-fold defaultstate="collapsed" desc="Getter and Sette">
    public void setColaboradorLog(Colaborador colaboradorLog) {
        this.colaboradorLog = colaboradorLog;
    }

    public String getColaborador() {
        return colaborador;
    }

    public void setColaborador(String colaborador) {
        this.colaborador = colaborador;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public PrincipalControllerCollaborator() {
    }

    //</editor-fold>
}
