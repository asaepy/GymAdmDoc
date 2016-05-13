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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ricardo
 */
@Entity
@Table(name = "mu_evaluacion")
@XmlRootElement
@NamedQueries({
   @NamedQuery(name = "MuEvaluacion.findAll", query = "SELECT m FROM MuEvaluacion m"),
   @NamedQuery(name = "MuEvaluacion.findByEvalId", query = "SELECT m FROM MuEvaluacion m WHERE m.evalId = :evalId"),
   @NamedQuery(name = "MuEvaluacion.findByUsuIdentificacion", query = "SELECT m FROM MuEvaluacion m WHERE m.usuIdentificacion = :usuIdentificacion"),
   @NamedQuery(name = "MuEvaluacion.findByEvalObservacion", query = "SELECT m FROM MuEvaluacion m WHERE m.evalObservacion = :evalObservacion")})
public class MuEvaluacion implements Serializable {

   private static final long serialVersionUID = 1L;
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Basic(optional = false)
   @Column(name = "EVAL_ID")
   private Long evalId;
   @Basic(optional = false)
   @NotNull
   @Column(name = "USU_IDENTIFICACION")
   private long usuIdentificacion;
   @Basic(optional = false)
   @NotNull
   @Size(min = 1, max = 250)
   @Column(name = "EVAL_OBSERVACION")
   private String evalObservacion;

   public MuEvaluacion() {
   }

   public MuEvaluacion(Long evalId) {
      this.evalId = evalId;
   }

   public MuEvaluacion(Long evalId, long usuIdentificacion, String evalObservacion) {
      this.evalId = evalId;
      this.usuIdentificacion = usuIdentificacion;
      this.evalObservacion = evalObservacion;
   }

   public Long getEvalId() {
      return evalId;
   }

   public void setEvalId(Long evalId) {
      this.evalId = evalId;
   }

   public long getUsuIdentificacion() {
      return usuIdentificacion;
   }

   public void setUsuIdentificacion(long usuIdentificacion) {
      this.usuIdentificacion = usuIdentificacion;
   }

   public String getEvalObservacion() {
      return evalObservacion;
   }

   public void setEvalObservacion(String evalObservacion) {
      this.evalObservacion = evalObservacion;
   }

   @Override
   public int hashCode() {
      int hash = 0;
      hash += (evalId != null ? evalId.hashCode() : 0);
      return hash;
   }

   @Override
   public boolean equals(Object object) {
      // TODO: Warning - this method won't work in the case the id fields are not set
      if (!(object instanceof MuEvaluacion)) {
         return false;
      }
      MuEvaluacion other = (MuEvaluacion) object;
      if ((this.evalId == null && other.evalId != null) || (this.evalId != null && !this.evalId.equals(other.evalId))) {
         return false;
      }
      return true;
   }

   @Override
   public String toString() {
      return "co.edu.unicauca.gymadmdoc.entities.MuEvaluacion[ evalId=" + evalId + " ]";
   }
   
}
