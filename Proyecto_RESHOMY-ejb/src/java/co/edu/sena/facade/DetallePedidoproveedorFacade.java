/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.facade;

import co.edu.sena.entity.DetallePedidoproveedor;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Cristian
 */
@Stateless
public class DetallePedidoproveedorFacade extends AbstractFacade<DetallePedidoproveedor> {
    @PersistenceContext(unitName = "Proyecto_RESHOMY-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetallePedidoproveedorFacade() {
        super(DetallePedidoproveedor.class);
    }
    
}
