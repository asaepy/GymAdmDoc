/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicauca.gymadmdoc.dao;

import co.edu.unicauca.gymadmdoc.dao.exceptions.NonexistentEntityException;
import co.edu.unicauca.gymadmdoc.dao.exceptions.RollbackFailureException;
import co.edu.unicauca.gymadmdoc.entities.MuExamenFisico;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.UserTransaction;

/**
 *
 * @author Ricardo
 */
public class MuExamenFisicoJpaController implements Serializable {

   public MuExamenFisicoJpaController(UserTransaction utx, EntityManagerFactory emf) {
      this.utx = utx;
      this.emf = emf;
   }
   private UserTransaction utx = null;
   private EntityManagerFactory emf = null;

   public EntityManager getEntityManager() {
      return emf.createEntityManager();
   }

   public void create(MuExamenFisico muExamenFisico) throws RollbackFailureException, Exception {
      EntityManager em = null;
      try {
         utx.begin();
         em = getEntityManager();
         em.persist(muExamenFisico);
         utx.commit();
      } catch (Exception ex) {
         try {
            utx.rollback();
         } catch (Exception re) {
            throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
         }
         throw ex;
      } finally {
         if (em != null) {
            em.close();
         }
      }
   }

   public void edit(MuExamenFisico muExamenFisico) throws NonexistentEntityException, RollbackFailureException, Exception {
      EntityManager em = null;
      try {
         utx.begin();
         em = getEntityManager();
         muExamenFisico = em.merge(muExamenFisico);
         utx.commit();
      } catch (Exception ex) {
         try {
            utx.rollback();
         } catch (Exception re) {
            throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
         }
         String msg = ex.getLocalizedMessage();
         if (msg == null || msg.length() == 0) {
            Long id = muExamenFisico.getEfisId();
            if (findMuExamenFisico(id) == null) {
               throw new NonexistentEntityException("The muExamenFisico with id " + id + " no longer exists.");
            }
         }
         throw ex;
      } finally {
         if (em != null) {
            em.close();
         }
      }
   }

   public void destroy(Long id) throws NonexistentEntityException, RollbackFailureException, Exception {
      EntityManager em = null;
      try {
         utx.begin();
         em = getEntityManager();
         MuExamenFisico muExamenFisico;
         try {
            muExamenFisico = em.getReference(MuExamenFisico.class, id);
            muExamenFisico.getEfisId();
         } catch (EntityNotFoundException enfe) {
            throw new NonexistentEntityException("The muExamenFisico with id " + id + " no longer exists.", enfe);
         }
         em.remove(muExamenFisico);
         utx.commit();
      } catch (Exception ex) {
         try {
            utx.rollback();
         } catch (Exception re) {
            throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
         }
         throw ex;
      } finally {
         if (em != null) {
            em.close();
         }
      }
   }

   public List<MuExamenFisico> findMuExamenFisicoEntities() {
      return findMuExamenFisicoEntities(true, -1, -1);
   }

   public List<MuExamenFisico> findMuExamenFisicoEntities(int maxResults, int firstResult) {
      return findMuExamenFisicoEntities(false, maxResults, firstResult);
   }

   private List<MuExamenFisico> findMuExamenFisicoEntities(boolean all, int maxResults, int firstResult) {
      EntityManager em = getEntityManager();
      try {
         CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
         cq.select(cq.from(MuExamenFisico.class));
         Query q = em.createQuery(cq);
         if (!all) {
            q.setMaxResults(maxResults);
            q.setFirstResult(firstResult);
         }
         return q.getResultList();
      } finally {
         em.close();
      }
   }

   public MuExamenFisico findMuExamenFisico(Long id) {
      EntityManager em = getEntityManager();
      try {
         return em.find(MuExamenFisico.class, id);
      } finally {
         em.close();
      }
   }

   public int getMuExamenFisicoCount() {
      EntityManager em = getEntityManager();
      try {
         CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
         Root<MuExamenFisico> rt = cq.from(MuExamenFisico.class);
         cq.select(em.getCriteriaBuilder().count(rt));
         Query q = em.createQuery(cq);
         return ((Long) q.getSingleResult()).intValue();
      } finally {
         em.close();
      }
   }
   
}
