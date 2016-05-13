/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicauca.gymadmdoc.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ricardo
 */
@Entity
@Table(name = "mu_antecedente_salud")
@XmlRootElement
@NamedQueries({
   @NamedQuery(name = "MuAntecedenteSalud.findAll", query = "SELECT m FROM MuAntecedenteSalud m"),
   @NamedQuery(name = "MuAntecedenteSalud.findByAnsaId", query = "SELECT m FROM MuAntecedenteSalud m WHERE m.ansaId = :ansaId"),
   @NamedQuery(name = "MuAntecedenteSalud.findByUsuIdentificacion", query = "SELECT m FROM MuAntecedenteSalud m WHERE m.usuIdentificacion = :usuIdentificacion")})
public class MuAntecedenteSalud implements Serializable {

   private static final long serialVersionUID = 1L;
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Basic(optional = false)
   @Column(name = "ANSA_ID")
   private Integer ansaId;
   @Basic(optional = false)
   @NotNull
   @Column(name = "USU_IDENTIFICACION")
   private long usuIdentificacion;

   public MuAntecedenteSalud() {
   }

   public MuAntecedenteSalud(Integer ansaId) {
      this.ansaId = ansaId;
   }

   public MuAntecedenteSalud(Integer ansaId, long usuIdentificacion) {
      this.ansaId = ansaId;
      this.usuIdentificacion = usuIdentificacion;
   }

   public Integer getAnsaId() {
      return ansaId;
   }

   public void setAnsaId(Integer ansaId) {
      this.ansaId = ansaId;
   }

   public long getUsuIdentificacion() {
      return usuIdentificacion;
   }

   public void setUsuIdentificacion(long usuIdentificacion) {
      this.usuIdentificacion = usuIdentificacion;
   }

   @Override
   public int hashCode() {
      int hash = 0;
      hash += (ansaId != null ? ansaId.hashCode() : 0);
      return hash;
   }

   @Override
   public boolean equals(Object object) {
      // TODO: Warning - this method won't work in the case the id fields are not set
      if (!(object instanceof MuAntecedenteSalud)) {
         return false;
      }
      MuAntecedenteSalud other = (MuAntecedenteSalud) object;
      if ((this.ansaId == null && other.ansaId != null) || (this.ansaId != null && !this.ansaId.equals(other.ansaId))) {
         return false;
      }
      return true;
   }

   @Override
   public String toString() {
      return "co.edu.unicauca.gymadmdoc.entities.MuAntecedenteSalud[ ansaId=" + ansaId + " ]";
   }
   
}
