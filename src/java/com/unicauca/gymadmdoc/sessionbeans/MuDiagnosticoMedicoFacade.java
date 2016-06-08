/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicauca.gymadmdoc.sessionbeans;

import com.unicauca.gymadmdoc.entities.MuAntecedenteSalud;
import com.unicauca.gymadmdoc.entities.MuDiagnosticoMedico;
import com.unicauca.gymadmdoc.entities.MuUsuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author ROED26
 */
@Stateless
public class MuDiagnosticoMedicoFacade extends AbstractFacade<MuDiagnosticoMedico> {

    @PersistenceContext(unitName = "Gym_Adm_DocPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MuDiagnosticoMedicoFacade() {
        super(MuDiagnosticoMedico.class);
    }

    public List<MuDiagnosticoMedico> buscarDiagnosticoMedico(MuUsuario usuario) {
        Query query = getEntityManager().createNamedQuery("MuDiagnosticoMedico.findByusuIdentificacion");
        query.setParameter("id", usuario);
        List<MuDiagnosticoMedico> resultList = query.getResultList();
        return resultList;
    }
    
}
