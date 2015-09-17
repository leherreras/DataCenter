

package co.edu.sena.dao;

import co.edu.sena.entity.Colaborador;
import co.edu.sena.util.UtilidadDaoBean;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;



@Stateless
@LocalBean
public class ColaboradorDAO extends UtilidadDaoBean<Colaborador,Integer> {

    public ColaboradorDAO(){
        setMiClase(Colaborador.class);
    }
    public Colaborador validarColaborador(String nombreColaborador, String contrasenaColaborador){
        
        
        try{
            
            Query q = em.createNamedQuery("Colaborador.findByAutenticar");
            q.setParameter("nombreUsuario", nombreColaborador);
            q.setParameter("contrasena", contrasenaColaborador);
            return (Colaborador) q.getSingleResult();
            
        }catch(Exception ex){
            return null;
        }
        
    }
}
