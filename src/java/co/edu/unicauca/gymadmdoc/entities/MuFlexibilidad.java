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
@Table(name = "mu_flexibilidad")
@XmlRootElement
@NamedQueries({
   @NamedQuery(name = "MuFlexibilidad.findAll", query = "SELECT m FROM MuFlexibilidad m"),
   @NamedQuery(name = "MuFlexibilidad.findByFlexId", query = "SELECT m FROM MuFlexibilidad m WHERE m.flexId = :flexId"),
   @NamedQuery(name = "MuFlexibilidad.findByEvalId", query = "SELECT m FROM MuFlexibilidad m WHERE m.evalId = :evalId")})
public class MuFlexibilidad implements Serializable {

   private static final long serialVersionUID = 1L;
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Basic(optional = false)
   @Column(name = "FLEX_ID")
   private Integer flexId;
   @Basic(optional = false)
   @NotNull
   @Column(name = "EVAL_ID")
   private long evalId;

   public MuFlexibilidad() {
   }

   public MuFlexibilidad(Integer flexId) {
      this.flexId = flexId;
   }

   public MuFlexibilidad(Integer flexId, long evalId) {
      this.flexId = flexId;
      this.evalId = evalId;
   }

   public Integer getFlexId() {
      return flexId;
   }

   public void setFlexId(Integer flexId) {
      this.flexId = flexId;
   }

   public long getEvalId() {
      return evalId;
   }

   public void setEvalId(long evalId) {
      this.evalId = evalId;
   }

   @Override
   public int hashCode() {
      int hash = 0;
      hash += (flexId != null ? flexId.hashCode() : 0);
      return hash;
   }

   @Override
   public boolean equals(Object object) {
      // TODO: Warning - this method won't work in the case the id fields are not set
      if (!(object instanceof MuFlexibilidad)) {
         return false;
      }
      MuFlexibilidad other = (MuFlexibilidad) object;
      if ((this.flexId == null && other.flexId != null) || (this.flexId != null && !this.flexId.equals(other.flexId))) {
         return false;
      }
      return true;
   }

   @Override
   public String toString() {
      return "co.edu.unicauca.gymadmdoc.entities.MuFlexibilidad[ flexId=" + flexId + " ]";
   }
   
}
