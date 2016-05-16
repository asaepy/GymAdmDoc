/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicauca.gymadmdoc.sessionbeans;

import co.edu.unicauca.gymadmdoc.entities.MvValoracion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Ricardo
 */
@Stateless
public class MvValoracionFacade extends AbstractFacade<MvValoracion> {

   @PersistenceContext(unitName = "Gym_Adm_DocPU")
   private EntityManager em;

   @Override
   protected EntityManager getEntityManager() {
      return em;
   }

   public MvValoracionFacade() {
      super(MvValoracion.class);
   }
   
}
