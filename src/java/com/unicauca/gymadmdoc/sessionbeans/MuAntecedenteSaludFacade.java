/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicauca.gymadmdoc.sessionbeans;

import com.unicauca.gymadmdoc.entities.MuAntecedenteSalud;
import com.unicauca.gymadmdoc.entities.MuUsuario;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author ROED26
 */
@Stateless
public class MuAntecedenteSaludFacade extends AbstractFacade<MuAntecedenteSalud> {

    @PersistenceContext(unitName = "Gym_Adm_DocPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MuAntecedenteSaludFacade() {
        super(MuAntecedenteSalud.class);
    }

    public List<MuAntecedenteSalud> buscarAntecedentesSalud(MuUsuario usuIdentificacion) {
        Query query = getEntityManager().createNamedQuery("MuAntecedenteSalud.findByusuIdentificacion");
        query.setParameter("id", usuIdentificacion);
        List<MuAntecedenteSalud> resultList = query.getResultList();
        return resultList;
        
    
        
    }
    
    
}
