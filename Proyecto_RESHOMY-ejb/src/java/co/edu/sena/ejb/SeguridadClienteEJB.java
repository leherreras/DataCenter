

package co.edu.sena.ejb;

import co.edu.sena.dao.ClienteDAO;
import co.edu.sena.entity.Cliente;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;



@Stateless
@LocalBean
public class SeguridadClienteEJB implements Serializable {

    @EJB
    private ClienteDAO usuarioDAO;

    public Cliente validarCliente(String nombreCliente, String contrasenaCliente) {
        return usuarioDAO.validarCliente(nombreCliente, contrasenaCliente);

    }

}
