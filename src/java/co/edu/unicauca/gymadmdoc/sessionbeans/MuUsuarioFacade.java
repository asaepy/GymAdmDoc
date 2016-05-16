/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicauca.gymadmdoc.sessionbeans;

import co.edu.unicauca.gymadmdoc.entities.MuUsuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Ricardo
 */
@Stateless
public class MuUsuarioFacade extends AbstractFacade<MuUsuario> {

   @PersistenceContext(unitName = "Gym_Adm_DocPU")
   private EntityManager em;

   @Override
   protected EntityManager getEntityManager() {
      return em;
   }

   public MuUsuarioFacade() {
      super(MuUsuario.class);
   }
   
}
