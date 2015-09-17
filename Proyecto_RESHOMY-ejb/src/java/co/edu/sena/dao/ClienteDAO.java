

package co.edu.sena.dao;

import co.edu.sena.entity.Cliente;
import co.edu.sena.util.UtilidadDaoBean;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;



@Stateless
@LocalBean
public class ClienteDAO extends UtilidadDaoBean<Cliente,Integer> {

    public ClienteDAO(){
        setMiClase(Cliente.class);
    }
    public Cliente validarCliente(String nombreCliente, String contrasenaCliente){
        
        
        try{
            
            Query q = em.createNamedQuery("Cliente.findByAutenticar");
            q.setParameter("nombreUsuario", nombreCliente);
            q.setParameter("contrasena", contrasenaCliente);
            return (Cliente) q.getSingleResult();
            
        }catch(Exception ex){
            return null;
        }
        
    }
}
