

package co.edu.sena.ejb;

import co.edu.sena.dao.ColaboradorDAO;
import co.edu.sena.entity.Colaborador;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;



@Stateless
@LocalBean
public class SeguridadColaboradorEJB implements Serializable {

    @EJB
    private ColaboradorDAO usuarioDAO;

    public Colaborador validarColaborador(String nombreColaborador, String contrasenaColaborador) {
        return usuarioDAO.validarColaborador(nombreColaborador, contrasenaColaborador);

    }

}
