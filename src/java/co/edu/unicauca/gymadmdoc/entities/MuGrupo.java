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
@Table(name = "mu_grupo")
@XmlRootElement
@NamedQueries({
   @NamedQuery(name = "MuGrupo.findAll", query = "SELECT m FROM MuGrupo m"),
   @NamedQuery(name = "MuGrupo.findByGruId", query = "SELECT m FROM MuGrupo m WHERE m.gruId = :gruId"),
   @NamedQuery(name = "MuGrupo.findByGruDescripcion", query = "SELECT m FROM MuGrupo m WHERE m.gruDescripcion = :gruDescripcion")})
public class MuGrupo implements Serializable {

   private static final long serialVersionUID = 1L;
   @Id
   @Basic(optional = false)
   @NotNull
   @Column(name = "GRU_ID")
   private Long gruId;
   @Basic(optional = false)
   @NotNull
   @Size(min = 1, max = 200)
   @Column(name = "GRU_DESCRIPCION")
   private String gruDescripcion;

   public MuGrupo() {
   }

   public MuGrupo(Long gruId) {
      this.gruId = gruId;
   }

   public MuGrupo(Long gruId, String gruDescripcion) {
      this.gruId = gruId;
      this.gruDescripcion = gruDescripcion;
   }

   public Long getGruId() {
      return gruId;
   }

   public void setGruId(Long gruId) {
      this.gruId = gruId;
   }

   public String getGruDescripcion() {
      return gruDescripcion;
   }

   public void setGruDescripcion(String gruDescripcion) {
      this.gruDescripcion = gruDescripcion;
   }

   @Override
   public int hashCode() {
      int hash = 0;
      hash += (gruId != null ? gruId.hashCode() : 0);
      return hash;
   }

   @Override
   public boolean equals(Object object) {
      // TODO: Warning - this method won't work in the case the id fields are not set
      if (!(object instanceof MuGrupo)) {
         return false;
      }
      MuGrupo other = (MuGrupo) object;
      if ((this.gruId == null && other.gruId != null) || (this.gruId != null && !this.gruId.equals(other.gruId))) {
         return false;
      }
      return true;
   }

   @Override
   public String toString() {
      return "co.edu.unicauca.gymadmdoc.entities.MuGrupo[ gruId=" + gruId + " ]";
   }
   
}
