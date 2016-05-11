/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicauca.gymadmdoc.sessionBeans;

import co.edu.unicauca.gymadmdoc.entities.MruGrupomuscular;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Migdress
 */
@Stateless
public class MruGrupomuscularFacade extends AbstractFacade<MruGrupomuscular> {

    @PersistenceContext(unitName = "Gym_Adm_DocPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MruGrupomuscularFacade() {
        super(MruGrupomuscular.class);
    }
    
}
