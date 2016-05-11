/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicauca.gymadmdoc.sessionBeans;

import co.edu.unicauca.gymadmdoc.entities.MruEjercicio;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Migdress
 */
@Stateless
public class MruEjercicioFacade extends AbstractFacade<MruEjercicio> {

    @PersistenceContext(unitName = "Gym_Adm_DocPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MruEjercicioFacade() {
        super(MruEjercicio.class);
    }
    
}
