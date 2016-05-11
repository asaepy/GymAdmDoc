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
import co.edu.unicauca.gymadmdoc.entities.MruDia;
import co.edu.unicauca.gymadmdoc.entities.MruRutina;
import co.edu.unicauca.gymadmdoc.jpaControllers.exceptions.IllegalOrphanException;
import co.edu.unicauca.gymadmdoc.jpaControllers.exceptions.NonexistentEntityException;
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
public class MruRutinaJpaController implements Serializable {

    public MruRutinaJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(MruRutina mruRutina) throws RollbackFailureException, Exception {
        if (mruRutina.getMruDiaCollection() == null) {
            mruRutina.setMruDiaCollection(new ArrayList<MruDia>());
        }
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Collection<MruDia> attachedMruDiaCollection = new ArrayList<MruDia>();
            for (MruDia mruDiaCollectionMruDiaToAttach : mruRutina.getMruDiaCollection()) {
                mruDiaCollectionMruDiaToAttach = em.getReference(mruDiaCollectionMruDiaToAttach.getClass(), mruDiaCollectionMruDiaToAttach.getDiaId());
                attachedMruDiaCollection.add(mruDiaCollectionMruDiaToAttach);
            }
            mruRutina.setMruDiaCollection(attachedMruDiaCollection);
            em.persist(mruRutina);
            for (MruDia mruDiaCollectionMruDia : mruRutina.getMruDiaCollection()) {
                MruRutina oldRuIdOfMruDiaCollectionMruDia = mruDiaCollectionMruDia.getRuId();
                mruDiaCollectionMruDia.setRuId(mruRutina);
                mruDiaCollectionMruDia = em.merge(mruDiaCollectionMruDia);
                if (oldRuIdOfMruDiaCollectionMruDia != null) {
                    oldRuIdOfMruDiaCollectionMruDia.getMruDiaCollection().remove(mruDiaCollectionMruDia);
                    oldRuIdOfMruDiaCollectionMruDia = em.merge(oldRuIdOfMruDiaCollectionMruDia);
                }
            }
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

    public void edit(MruRutina mruRutina) throws IllegalOrphanException, NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            MruRutina persistentMruRutina = em.find(MruRutina.class, mruRutina.getRuId());
            Collection<MruDia> mruDiaCollectionOld = persistentMruRutina.getMruDiaCollection();
            Collection<MruDia> mruDiaCollectionNew = mruRutina.getMruDiaCollection();
            List<String> illegalOrphanMessages = null;
            for (MruDia mruDiaCollectionOldMruDia : mruDiaCollectionOld) {
                if (!mruDiaCollectionNew.contains(mruDiaCollectionOldMruDia)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain MruDia " + mruDiaCollectionOldMruDia + " since its ruId field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<MruDia> attachedMruDiaCollectionNew = new ArrayList<MruDia>();
            for (MruDia mruDiaCollectionNewMruDiaToAttach : mruDiaCollectionNew) {
                mruDiaCollectionNewMruDiaToAttach = em.getReference(mruDiaCollectionNewMruDiaToAttach.getClass(), mruDiaCollectionNewMruDiaToAttach.getDiaId());
                attachedMruDiaCollectionNew.add(mruDiaCollectionNewMruDiaToAttach);
            }
            mruDiaCollectionNew = attachedMruDiaCollectionNew;
            mruRutina.setMruDiaCollection(mruDiaCollectionNew);
            mruRutina = em.merge(mruRutina);
            for (MruDia mruDiaCollectionNewMruDia : mruDiaCollectionNew) {
                if (!mruDiaCollectionOld.contains(mruDiaCollectionNewMruDia)) {
                    MruRutina oldRuIdOfMruDiaCollectionNewMruDia = mruDiaCollectionNewMruDia.getRuId();
                    mruDiaCollectionNewMruDia.setRuId(mruRutina);
                    mruDiaCollectionNewMruDia = em.merge(mruDiaCollectionNewMruDia);
                    if (oldRuIdOfMruDiaCollectionNewMruDia != null && !oldRuIdOfMruDiaCollectionNewMruDia.equals(mruRutina)) {
                        oldRuIdOfMruDiaCollectionNewMruDia.getMruDiaCollection().remove(mruDiaCollectionNewMruDia);
                        oldRuIdOfMruDiaCollectionNewMruDia = em.merge(oldRuIdOfMruDiaCollectionNewMruDia);
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
                Integer id = mruRutina.getRuId();
                if (findMruRutina(id) == null) {
                    throw new NonexistentEntityException("The mruRutina with id " + id + " no longer exists.");
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
            MruRutina mruRutina;
            try {
                mruRutina = em.getReference(MruRutina.class, id);
                mruRutina.getRuId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The mruRutina with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<MruDia> mruDiaCollectionOrphanCheck = mruRutina.getMruDiaCollection();
            for (MruDia mruDiaCollectionOrphanCheckMruDia : mruDiaCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This MruRutina (" + mruRutina + ") cannot be destroyed since the MruDia " + mruDiaCollectionOrphanCheckMruDia + " in its mruDiaCollection field has a non-nullable ruId field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(mruRutina);
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

    public List<MruRutina> findMruRutinaEntities() {
        return findMruRutinaEntities(true, -1, -1);
    }

    public List<MruRutina> findMruRutinaEntities(int maxResults, int firstResult) {
        return findMruRutinaEntities(false, maxResults, firstResult);
    }

    private List<MruRutina> findMruRutinaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(MruRutina.class));
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

    public MruRutina findMruRutina(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(MruRutina.class, id);
        } finally {
            em.close();
        }
    }

    public int getMruRutinaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<MruRutina> rt = cq.from(MruRutina.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
