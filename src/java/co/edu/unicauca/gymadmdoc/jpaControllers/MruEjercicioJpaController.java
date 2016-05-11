/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicauca.gymadmdoc.jpaControllers;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import co.edu.unicauca.gymadmdoc.entities.GrupomuscRealizaEjercicio;
import co.edu.unicauca.gymadmdoc.entities.MruEjercicio;
import co.edu.unicauca.gymadmdoc.jpaControllers.exceptions.IllegalOrphanException;
import co.edu.unicauca.gymadmdoc.jpaControllers.exceptions.NonexistentEntityException;
import co.edu.unicauca.gymadmdoc.jpaControllers.exceptions.PreexistingEntityException;
import co.edu.unicauca.gymadmdoc.jpaControllers.exceptions.RollbackFailureException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.UserTransaction;

/**
 *
 * @author Migdress
 */
public class MruEjercicioJpaController implements Serializable {

    public MruEjercicioJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(MruEjercicio mruEjercicio) throws PreexistingEntityException, RollbackFailureException, Exception {
        if (mruEjercicio.getGrupomuscRealizaEjercicioCollection() == null) {
            mruEjercicio.setGrupomuscRealizaEjercicioCollection(new ArrayList<GrupomuscRealizaEjercicio>());
        }
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Collection<GrupomuscRealizaEjercicio> attachedGrupomuscRealizaEjercicioCollection = new ArrayList<GrupomuscRealizaEjercicio>();
            for (GrupomuscRealizaEjercicio grupomuscRealizaEjercicioCollectionGrupomuscRealizaEjercicioToAttach : mruEjercicio.getGrupomuscRealizaEjercicioCollection()) {
                grupomuscRealizaEjercicioCollectionGrupomuscRealizaEjercicioToAttach = em.getReference(grupomuscRealizaEjercicioCollectionGrupomuscRealizaEjercicioToAttach.getClass(), grupomuscRealizaEjercicioCollectionGrupomuscRealizaEjercicioToAttach.getGrupomuscRealizaEjercicioPK());
                attachedGrupomuscRealizaEjercicioCollection.add(grupomuscRealizaEjercicioCollectionGrupomuscRealizaEjercicioToAttach);
            }
            mruEjercicio.setGrupomuscRealizaEjercicioCollection(attachedGrupomuscRealizaEjercicioCollection);
            em.persist(mruEjercicio);
            for (GrupomuscRealizaEjercicio grupomuscRealizaEjercicioCollectionGrupomuscRealizaEjercicio : mruEjercicio.getGrupomuscRealizaEjercicioCollection()) {
                MruEjercicio oldMruEjercicioOfGrupomuscRealizaEjercicioCollectionGrupomuscRealizaEjercicio = grupomuscRealizaEjercicioCollectionGrupomuscRealizaEjercicio.getMruEjercicio();
                grupomuscRealizaEjercicioCollectionGrupomuscRealizaEjercicio.setMruEjercicio(mruEjercicio);
                grupomuscRealizaEjercicioCollectionGrupomuscRealizaEjercicio = em.merge(grupomuscRealizaEjercicioCollectionGrupomuscRealizaEjercicio);
                if (oldMruEjercicioOfGrupomuscRealizaEjercicioCollectionGrupomuscRealizaEjercicio != null) {
                    oldMruEjercicioOfGrupomuscRealizaEjercicioCollectionGrupomuscRealizaEjercicio.getGrupomuscRealizaEjercicioCollection().remove(grupomuscRealizaEjercicioCollectionGrupomuscRealizaEjercicio);
                    oldMruEjercicioOfGrupomuscRealizaEjercicioCollectionGrupomuscRealizaEjercicio = em.merge(oldMruEjercicioOfGrupomuscRealizaEjercicioCollectionGrupomuscRealizaEjercicio);
                }
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findMruEjercicio(mruEjercicio.getEjId()) != null) {
                throw new PreexistingEntityException("MruEjercicio " + mruEjercicio + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(MruEjercicio mruEjercicio) throws IllegalOrphanException, NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            MruEjercicio persistentMruEjercicio = em.find(MruEjercicio.class, mruEjercicio.getEjId());
            Collection<GrupomuscRealizaEjercicio> grupomuscRealizaEjercicioCollectionOld = persistentMruEjercicio.getGrupomuscRealizaEjercicioCollection();
            Collection<GrupomuscRealizaEjercicio> grupomuscRealizaEjercicioCollectionNew = mruEjercicio.getGrupomuscRealizaEjercicioCollection();
            List<String> illegalOrphanMessages = null;
            for (GrupomuscRealizaEjercicio grupomuscRealizaEjercicioCollectionOldGrupomuscRealizaEjercicio : grupomuscRealizaEjercicioCollectionOld) {
                if (!grupomuscRealizaEjercicioCollectionNew.contains(grupomuscRealizaEjercicioCollectionOldGrupomuscRealizaEjercicio)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain GrupomuscRealizaEjercicio " + grupomuscRealizaEjercicioCollectionOldGrupomuscRealizaEjercicio + " since its mruEjercicio field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<GrupomuscRealizaEjercicio> attachedGrupomuscRealizaEjercicioCollectionNew = new ArrayList<GrupomuscRealizaEjercicio>();
            for (GrupomuscRealizaEjercicio grupomuscRealizaEjercicioCollectionNewGrupomuscRealizaEjercicioToAttach : grupomuscRealizaEjercicioCollectionNew) {
                grupomuscRealizaEjercicioCollectionNewGrupomuscRealizaEjercicioToAttach = em.getReference(grupomuscRealizaEjercicioCollectionNewGrupomuscRealizaEjercicioToAttach.getClass(), grupomuscRealizaEjercicioCollectionNewGrupomuscRealizaEjercicioToAttach.getGrupomuscRealizaEjercicioPK());
                attachedGrupomuscRealizaEjercicioCollectionNew.add(grupomuscRealizaEjercicioCollectionNewGrupomuscRealizaEjercicioToAttach);
            }
            grupomuscRealizaEjercicioCollectionNew = attachedGrupomuscRealizaEjercicioCollectionNew;
            mruEjercicio.setGrupomuscRealizaEjercicioCollection(grupomuscRealizaEjercicioCollectionNew);
            mruEjercicio = em.merge(mruEjercicio);
            for (GrupomuscRealizaEjercicio grupomuscRealizaEjercicioCollectionNewGrupomuscRealizaEjercicio : grupomuscRealizaEjercicioCollectionNew) {
                if (!grupomuscRealizaEjercicioCollectionOld.contains(grupomuscRealizaEjercicioCollectionNewGrupomuscRealizaEjercicio)) {
                    MruEjercicio oldMruEjercicioOfGrupomuscRealizaEjercicioCollectionNewGrupomuscRealizaEjercicio = grupomuscRealizaEjercicioCollectionNewGrupomuscRealizaEjercicio.getMruEjercicio();
                    grupomuscRealizaEjercicioCollectionNewGrupomuscRealizaEjercicio.setMruEjercicio(mruEjercicio);
                    grupomuscRealizaEjercicioCollectionNewGrupomuscRealizaEjercicio = em.merge(grupomuscRealizaEjercicioCollectionNewGrupomuscRealizaEjercicio);
                    if (oldMruEjercicioOfGrupomuscRealizaEjercicioCollectionNewGrupomuscRealizaEjercicio != null && !oldMruEjercicioOfGrupomuscRealizaEjercicioCollectionNewGrupomuscRealizaEjercicio.equals(mruEjercicio)) {
                        oldMruEjercicioOfGrupomuscRealizaEjercicioCollectionNewGrupomuscRealizaEjercicio.getGrupomuscRealizaEjercicioCollection().remove(grupomuscRealizaEjercicioCollectionNewGrupomuscRealizaEjercicio);
                        oldMruEjercicioOfGrupomuscRealizaEjercicioCollectionNewGrupomuscRealizaEjercicio = em.merge(oldMruEjercicioOfGrupomuscRealizaEjercicioCollectionNewGrupomuscRealizaEjercicio);
                    }
                }
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = mruEjercicio.getEjId();
                if (findMruEjercicio(id) == null) {
                    throw new NonexistentEntityException("The mruEjercicio with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            MruEjercicio mruEjercicio;
            try {
                mruEjercicio = em.getReference(MruEjercicio.class, id);
                mruEjercicio.getEjId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The mruEjercicio with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<GrupomuscRealizaEjercicio> grupomuscRealizaEjercicioCollectionOrphanCheck = mruEjercicio.getGrupomuscRealizaEjercicioCollection();
            for (GrupomuscRealizaEjercicio grupomuscRealizaEjercicioCollectionOrphanCheckGrupomuscRealizaEjercicio : grupomuscRealizaEjercicioCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This MruEjercicio (" + mruEjercicio + ") cannot be destroyed since the GrupomuscRealizaEjercicio " + grupomuscRealizaEjercicioCollectionOrphanCheckGrupomuscRealizaEjercicio + " in its grupomuscRealizaEjercicioCollection field has a non-nullable mruEjercicio field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(mruEjercicio);
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

    public List<MruEjercicio> findMruEjercicioEntities() {
        return findMruEjercicioEntities(true, -1, -1);
    }

    public List<MruEjercicio> findMruEjercicioEntities(int maxResults, int firstResult) {
        return findMruEjercicioEntities(false, maxResults, firstResult);
    }

    private List<MruEjercicio> findMruEjercicioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(MruEjercicio.class));
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

    public MruEjercicio findMruEjercicio(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(MruEjercicio.class, id);
        } finally {
            em.close();
        }
    }

    public int getMruEjercicioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<MruEjercicio> rt = cq.from(MruEjercicio.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
