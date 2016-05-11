/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicauca.gymadmdoc.jpaControllers;

import co.edu.unicauca.gymadmdoc.entities.MruDia;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import co.edu.unicauca.gymadmdoc.entities.MruRutina;
import co.edu.unicauca.gymadmdoc.entities.MruGrupomuscular;
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
public class MruDiaJpaController implements Serializable {

    public MruDiaJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(MruDia mruDia) throws PreexistingEntityException, RollbackFailureException, Exception {
        if (mruDia.getMruGrupomuscularCollection() == null) {
            mruDia.setMruGrupomuscularCollection(new ArrayList<MruGrupomuscular>());
        }
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            MruRutina ruId = mruDia.getRuId();
            if (ruId != null) {
                ruId = em.getReference(ruId.getClass(), ruId.getRuId());
                mruDia.setRuId(ruId);
            }
            Collection<MruGrupomuscular> attachedMruGrupomuscularCollection = new ArrayList<MruGrupomuscular>();
            for (MruGrupomuscular mruGrupomuscularCollectionMruGrupomuscularToAttach : mruDia.getMruGrupomuscularCollection()) {
                mruGrupomuscularCollectionMruGrupomuscularToAttach = em.getReference(mruGrupomuscularCollectionMruGrupomuscularToAttach.getClass(), mruGrupomuscularCollectionMruGrupomuscularToAttach.getGmId());
                attachedMruGrupomuscularCollection.add(mruGrupomuscularCollectionMruGrupomuscularToAttach);
            }
            mruDia.setMruGrupomuscularCollection(attachedMruGrupomuscularCollection);
            em.persist(mruDia);
            if (ruId != null) {
                ruId.getMruDiaCollection().add(mruDia);
                ruId = em.merge(ruId);
            }
            for (MruGrupomuscular mruGrupomuscularCollectionMruGrupomuscular : mruDia.getMruGrupomuscularCollection()) {
                MruDia oldDiaIdOfMruGrupomuscularCollectionMruGrupomuscular = mruGrupomuscularCollectionMruGrupomuscular.getDiaId();
                mruGrupomuscularCollectionMruGrupomuscular.setDiaId(mruDia);
                mruGrupomuscularCollectionMruGrupomuscular = em.merge(mruGrupomuscularCollectionMruGrupomuscular);
                if (oldDiaIdOfMruGrupomuscularCollectionMruGrupomuscular != null) {
                    oldDiaIdOfMruGrupomuscularCollectionMruGrupomuscular.getMruGrupomuscularCollection().remove(mruGrupomuscularCollectionMruGrupomuscular);
                    oldDiaIdOfMruGrupomuscularCollectionMruGrupomuscular = em.merge(oldDiaIdOfMruGrupomuscularCollectionMruGrupomuscular);
                }
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findMruDia(mruDia.getDiaId()) != null) {
                throw new PreexistingEntityException("MruDia " + mruDia + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(MruDia mruDia) throws IllegalOrphanException, NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            MruDia persistentMruDia = em.find(MruDia.class, mruDia.getDiaId());
            MruRutina ruIdOld = persistentMruDia.getRuId();
            MruRutina ruIdNew = mruDia.getRuId();
            Collection<MruGrupomuscular> mruGrupomuscularCollectionOld = persistentMruDia.getMruGrupomuscularCollection();
            Collection<MruGrupomuscular> mruGrupomuscularCollectionNew = mruDia.getMruGrupomuscularCollection();
            List<String> illegalOrphanMessages = null;
            for (MruGrupomuscular mruGrupomuscularCollectionOldMruGrupomuscular : mruGrupomuscularCollectionOld) {
                if (!mruGrupomuscularCollectionNew.contains(mruGrupomuscularCollectionOldMruGrupomuscular)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain MruGrupomuscular " + mruGrupomuscularCollectionOldMruGrupomuscular + " since its diaId field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (ruIdNew != null) {
                ruIdNew = em.getReference(ruIdNew.getClass(), ruIdNew.getRuId());
                mruDia.setRuId(ruIdNew);
            }
            Collection<MruGrupomuscular> attachedMruGrupomuscularCollectionNew = new ArrayList<MruGrupomuscular>();
            for (MruGrupomuscular mruGrupomuscularCollectionNewMruGrupomuscularToAttach : mruGrupomuscularCollectionNew) {
                mruGrupomuscularCollectionNewMruGrupomuscularToAttach = em.getReference(mruGrupomuscularCollectionNewMruGrupomuscularToAttach.getClass(), mruGrupomuscularCollectionNewMruGrupomuscularToAttach.getGmId());
                attachedMruGrupomuscularCollectionNew.add(mruGrupomuscularCollectionNewMruGrupomuscularToAttach);
            }
            mruGrupomuscularCollectionNew = attachedMruGrupomuscularCollectionNew;
            mruDia.setMruGrupomuscularCollection(mruGrupomuscularCollectionNew);
            mruDia = em.merge(mruDia);
            if (ruIdOld != null && !ruIdOld.equals(ruIdNew)) {
                ruIdOld.getMruDiaCollection().remove(mruDia);
                ruIdOld = em.merge(ruIdOld);
            }
            if (ruIdNew != null && !ruIdNew.equals(ruIdOld)) {
                ruIdNew.getMruDiaCollection().add(mruDia);
                ruIdNew = em.merge(ruIdNew);
            }
            for (MruGrupomuscular mruGrupomuscularCollectionNewMruGrupomuscular : mruGrupomuscularCollectionNew) {
                if (!mruGrupomuscularCollectionOld.contains(mruGrupomuscularCollectionNewMruGrupomuscular)) {
                    MruDia oldDiaIdOfMruGrupomuscularCollectionNewMruGrupomuscular = mruGrupomuscularCollectionNewMruGrupomuscular.getDiaId();
                    mruGrupomuscularCollectionNewMruGrupomuscular.setDiaId(mruDia);
                    mruGrupomuscularCollectionNewMruGrupomuscular = em.merge(mruGrupomuscularCollectionNewMruGrupomuscular);
                    if (oldDiaIdOfMruGrupomuscularCollectionNewMruGrupomuscular != null && !oldDiaIdOfMruGrupomuscularCollectionNewMruGrupomuscular.equals(mruDia)) {
                        oldDiaIdOfMruGrupomuscularCollectionNewMruGrupomuscular.getMruGrupomuscularCollection().remove(mruGrupomuscularCollectionNewMruGrupomuscular);
                        oldDiaIdOfMruGrupomuscularCollectionNewMruGrupomuscular = em.merge(oldDiaIdOfMruGrupomuscularCollectionNewMruGrupomuscular);
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
                Integer id = mruDia.getDiaId();
                if (findMruDia(id) == null) {
                    throw new NonexistentEntityException("The mruDia with id " + id + " no longer exists.");
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
            MruDia mruDia;
            try {
                mruDia = em.getReference(MruDia.class, id);
                mruDia.getDiaId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The mruDia with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<MruGrupomuscular> mruGrupomuscularCollectionOrphanCheck = mruDia.getMruGrupomuscularCollection();
            for (MruGrupomuscular mruGrupomuscularCollectionOrphanCheckMruGrupomuscular : mruGrupomuscularCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This MruDia (" + mruDia + ") cannot be destroyed since the MruGrupomuscular " + mruGrupomuscularCollectionOrphanCheckMruGrupomuscular + " in its mruGrupomuscularCollection field has a non-nullable diaId field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            MruRutina ruId = mruDia.getRuId();
            if (ruId != null) {
                ruId.getMruDiaCollection().remove(mruDia);
                ruId = em.merge(ruId);
            }
            em.remove(mruDia);
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

    public List<MruDia> findMruDiaEntities() {
        return findMruDiaEntities(true, -1, -1);
    }

    public List<MruDia> findMruDiaEntities(int maxResults, int firstResult) {
        return findMruDiaEntities(false, maxResults, firstResult);
    }

    private List<MruDia> findMruDiaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(MruDia.class));
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

    public MruDia findMruDia(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(MruDia.class, id);
        } finally {
            em.close();
        }
    }

    public int getMruDiaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<MruDia> rt = cq.from(MruDia.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
