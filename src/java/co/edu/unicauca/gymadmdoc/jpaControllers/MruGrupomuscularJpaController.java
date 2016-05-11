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
import co.edu.unicauca.gymadmdoc.entities.GrupomuscRealizaEjercicio;
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
public class MruGrupomuscularJpaController implements Serializable {

    public MruGrupomuscularJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(MruGrupomuscular mruGrupomuscular) throws PreexistingEntityException, RollbackFailureException, Exception {
        if (mruGrupomuscular.getGrupomuscRealizaEjercicioCollection() == null) {
            mruGrupomuscular.setGrupomuscRealizaEjercicioCollection(new ArrayList<GrupomuscRealizaEjercicio>());
        }
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            MruDia diaId = mruGrupomuscular.getDiaId();
            if (diaId != null) {
                diaId = em.getReference(diaId.getClass(), diaId.getDiaId());
                mruGrupomuscular.setDiaId(diaId);
            }
            Collection<GrupomuscRealizaEjercicio> attachedGrupomuscRealizaEjercicioCollection = new ArrayList<GrupomuscRealizaEjercicio>();
            for (GrupomuscRealizaEjercicio grupomuscRealizaEjercicioCollectionGrupomuscRealizaEjercicioToAttach : mruGrupomuscular.getGrupomuscRealizaEjercicioCollection()) {
                grupomuscRealizaEjercicioCollectionGrupomuscRealizaEjercicioToAttach = em.getReference(grupomuscRealizaEjercicioCollectionGrupomuscRealizaEjercicioToAttach.getClass(), grupomuscRealizaEjercicioCollectionGrupomuscRealizaEjercicioToAttach.getGrupomuscRealizaEjercicioPK());
                attachedGrupomuscRealizaEjercicioCollection.add(grupomuscRealizaEjercicioCollectionGrupomuscRealizaEjercicioToAttach);
            }
            mruGrupomuscular.setGrupomuscRealizaEjercicioCollection(attachedGrupomuscRealizaEjercicioCollection);
            em.persist(mruGrupomuscular);
            if (diaId != null) {
                diaId.getMruGrupomuscularCollection().add(mruGrupomuscular);
                diaId = em.merge(diaId);
            }
            for (GrupomuscRealizaEjercicio grupomuscRealizaEjercicioCollectionGrupomuscRealizaEjercicio : mruGrupomuscular.getGrupomuscRealizaEjercicioCollection()) {
                MruGrupomuscular oldMruGrupomuscularOfGrupomuscRealizaEjercicioCollectionGrupomuscRealizaEjercicio = grupomuscRealizaEjercicioCollectionGrupomuscRealizaEjercicio.getMruGrupomuscular();
                grupomuscRealizaEjercicioCollectionGrupomuscRealizaEjercicio.setMruGrupomuscular(mruGrupomuscular);
                grupomuscRealizaEjercicioCollectionGrupomuscRealizaEjercicio = em.merge(grupomuscRealizaEjercicioCollectionGrupomuscRealizaEjercicio);
                if (oldMruGrupomuscularOfGrupomuscRealizaEjercicioCollectionGrupomuscRealizaEjercicio != null) {
                    oldMruGrupomuscularOfGrupomuscRealizaEjercicioCollectionGrupomuscRealizaEjercicio.getGrupomuscRealizaEjercicioCollection().remove(grupomuscRealizaEjercicioCollectionGrupomuscRealizaEjercicio);
                    oldMruGrupomuscularOfGrupomuscRealizaEjercicioCollectionGrupomuscRealizaEjercicio = em.merge(oldMruGrupomuscularOfGrupomuscRealizaEjercicioCollectionGrupomuscRealizaEjercicio);
                }
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findMruGrupomuscular(mruGrupomuscular.getGmId()) != null) {
                throw new PreexistingEntityException("MruGrupomuscular " + mruGrupomuscular + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(MruGrupomuscular mruGrupomuscular) throws IllegalOrphanException, NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            MruGrupomuscular persistentMruGrupomuscular = em.find(MruGrupomuscular.class, mruGrupomuscular.getGmId());
            MruDia diaIdOld = persistentMruGrupomuscular.getDiaId();
            MruDia diaIdNew = mruGrupomuscular.getDiaId();
            Collection<GrupomuscRealizaEjercicio> grupomuscRealizaEjercicioCollectionOld = persistentMruGrupomuscular.getGrupomuscRealizaEjercicioCollection();
            Collection<GrupomuscRealizaEjercicio> grupomuscRealizaEjercicioCollectionNew = mruGrupomuscular.getGrupomuscRealizaEjercicioCollection();
            List<String> illegalOrphanMessages = null;
            for (GrupomuscRealizaEjercicio grupomuscRealizaEjercicioCollectionOldGrupomuscRealizaEjercicio : grupomuscRealizaEjercicioCollectionOld) {
                if (!grupomuscRealizaEjercicioCollectionNew.contains(grupomuscRealizaEjercicioCollectionOldGrupomuscRealizaEjercicio)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain GrupomuscRealizaEjercicio " + grupomuscRealizaEjercicioCollectionOldGrupomuscRealizaEjercicio + " since its mruGrupomuscular field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (diaIdNew != null) {
                diaIdNew = em.getReference(diaIdNew.getClass(), diaIdNew.getDiaId());
                mruGrupomuscular.setDiaId(diaIdNew);
            }
            Collection<GrupomuscRealizaEjercicio> attachedGrupomuscRealizaEjercicioCollectionNew = new ArrayList<GrupomuscRealizaEjercicio>();
            for (GrupomuscRealizaEjercicio grupomuscRealizaEjercicioCollectionNewGrupomuscRealizaEjercicioToAttach : grupomuscRealizaEjercicioCollectionNew) {
                grupomuscRealizaEjercicioCollectionNewGrupomuscRealizaEjercicioToAttach = em.getReference(grupomuscRealizaEjercicioCollectionNewGrupomuscRealizaEjercicioToAttach.getClass(), grupomuscRealizaEjercicioCollectionNewGrupomuscRealizaEjercicioToAttach.getGrupomuscRealizaEjercicioPK());
                attachedGrupomuscRealizaEjercicioCollectionNew.add(grupomuscRealizaEjercicioCollectionNewGrupomuscRealizaEjercicioToAttach);
            }
            grupomuscRealizaEjercicioCollectionNew = attachedGrupomuscRealizaEjercicioCollectionNew;
            mruGrupomuscular.setGrupomuscRealizaEjercicioCollection(grupomuscRealizaEjercicioCollectionNew);
            mruGrupomuscular = em.merge(mruGrupomuscular);
            if (diaIdOld != null && !diaIdOld.equals(diaIdNew)) {
                diaIdOld.getMruGrupomuscularCollection().remove(mruGrupomuscular);
                diaIdOld = em.merge(diaIdOld);
            }
            if (diaIdNew != null && !diaIdNew.equals(diaIdOld)) {
                diaIdNew.getMruGrupomuscularCollection().add(mruGrupomuscular);
                diaIdNew = em.merge(diaIdNew);
            }
            for (GrupomuscRealizaEjercicio grupomuscRealizaEjercicioCollectionNewGrupomuscRealizaEjercicio : grupomuscRealizaEjercicioCollectionNew) {
                if (!grupomuscRealizaEjercicioCollectionOld.contains(grupomuscRealizaEjercicioCollectionNewGrupomuscRealizaEjercicio)) {
                    MruGrupomuscular oldMruGrupomuscularOfGrupomuscRealizaEjercicioCollectionNewGrupomuscRealizaEjercicio = grupomuscRealizaEjercicioCollectionNewGrupomuscRealizaEjercicio.getMruGrupomuscular();
                    grupomuscRealizaEjercicioCollectionNewGrupomuscRealizaEjercicio.setMruGrupomuscular(mruGrupomuscular);
                    grupomuscRealizaEjercicioCollectionNewGrupomuscRealizaEjercicio = em.merge(grupomuscRealizaEjercicioCollectionNewGrupomuscRealizaEjercicio);
                    if (oldMruGrupomuscularOfGrupomuscRealizaEjercicioCollectionNewGrupomuscRealizaEjercicio != null && !oldMruGrupomuscularOfGrupomuscRealizaEjercicioCollectionNewGrupomuscRealizaEjercicio.equals(mruGrupomuscular)) {
                        oldMruGrupomuscularOfGrupomuscRealizaEjercicioCollectionNewGrupomuscRealizaEjercicio.getGrupomuscRealizaEjercicioCollection().remove(grupomuscRealizaEjercicioCollectionNewGrupomuscRealizaEjercicio);
                        oldMruGrupomuscularOfGrupomuscRealizaEjercicioCollectionNewGrupomuscRealizaEjercicio = em.merge(oldMruGrupomuscularOfGrupomuscRealizaEjercicioCollectionNewGrupomuscRealizaEjercicio);
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
                Integer id = mruGrupomuscular.getGmId();
                if (findMruGrupomuscular(id) == null) {
                    throw new NonexistentEntityException("The mruGrupomuscular with id " + id + " no longer exists.");
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
            MruGrupomuscular mruGrupomuscular;
            try {
                mruGrupomuscular = em.getReference(MruGrupomuscular.class, id);
                mruGrupomuscular.getGmId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The mruGrupomuscular with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<GrupomuscRealizaEjercicio> grupomuscRealizaEjercicioCollectionOrphanCheck = mruGrupomuscular.getGrupomuscRealizaEjercicioCollection();
            for (GrupomuscRealizaEjercicio grupomuscRealizaEjercicioCollectionOrphanCheckGrupomuscRealizaEjercicio : grupomuscRealizaEjercicioCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This MruGrupomuscular (" + mruGrupomuscular + ") cannot be destroyed since the GrupomuscRealizaEjercicio " + grupomuscRealizaEjercicioCollectionOrphanCheckGrupomuscRealizaEjercicio + " in its grupomuscRealizaEjercicioCollection field has a non-nullable mruGrupomuscular field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            MruDia diaId = mruGrupomuscular.getDiaId();
            if (diaId != null) {
                diaId.getMruGrupomuscularCollection().remove(mruGrupomuscular);
                diaId = em.merge(diaId);
            }
            em.remove(mruGrupomuscular);
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

    public List<MruGrupomuscular> findMruGrupomuscularEntities() {
        return findMruGrupomuscularEntities(true, -1, -1);
    }

    public List<MruGrupomuscular> findMruGrupomuscularEntities(int maxResults, int firstResult) {
        return findMruGrupomuscularEntities(false, maxResults, firstResult);
    }

    private List<MruGrupomuscular> findMruGrupomuscularEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(MruGrupomuscular.class));
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

    public MruGrupomuscular findMruGrupomuscular(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(MruGrupomuscular.class, id);
        } finally {
            em.close();
        }
    }

    public int getMruGrupomuscularCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<MruGrupomuscular> rt = cq.from(MruGrupomuscular.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
