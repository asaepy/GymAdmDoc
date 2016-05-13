/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicauca.gymadmdoc.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Ricardo
 */
@Embeddable
public class MuUsuariogrupoPK implements Serializable {

   @Basic(optional = false)
   @NotNull
   @Column(name = "GRU_ID")
   private long gruId;
   @Basic(optional = false)
   @NotNull
   @Column(name = "USU_IDENTIFICACION")
   private long usuIdentificacion;

   public MuUsuariogrupoPK() {
   }

   public MuUsuariogrupoPK(long gruId, long usuIdentificacion) {
      this.gruId = gruId;
      this.usuIdentificacion = usuIdentificacion;
   }

   public long getGruId() {
      return gruId;
   }

   public void setGruId(long gruId) {
      this.gruId = gruId;
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
      hash += (int) gruId;
      hash += (int) usuIdentificacion;
      return hash;
   }

   @Override
   public boolean equals(Object object) {
      // TODO: Warning - this method won't work in the case the id fields are not set
      if (!(object instanceof MuUsuariogrupoPK)) {
         return false;
      }
      MuUsuariogrupoPK other = (MuUsuariogrupoPK) object;
      if (this.gruId != other.gruId) {
         return false;
      }
      if (this.usuIdentificacion != other.usuIdentificacion) {
         return false;
      }
      return true;
   }

   @Override
   public String toString() {
      return "co.edu.unicauca.gymadmdoc.entities.MuUsuariogrupoPK[ gruId=" + gruId + ", usuIdentificacion=" + usuIdentificacion + " ]";
   }
   
}
