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
@Table(name = "mu_dependencia")
@XmlRootElement
@NamedQueries({
   @NamedQuery(name = "MuDependencia.findAll", query = "SELECT m FROM MuDependencia m"),
   @NamedQuery(name = "MuDependencia.findByDepId", query = "SELECT m FROM MuDependencia m WHERE m.depId = :depId"),
   @NamedQuery(name = "MuDependencia.findByDepNombre", query = "SELECT m FROM MuDependencia m WHERE m.depNombre = :depNombre")})
public class MuDependencia implements Serializable {

   private static final long serialVersionUID = 1L;
   @Id
   @Basic(optional = false)
   @NotNull
   @Column(name = "DEP_ID")
   private Integer depId;
   @Basic(optional = false)
   @NotNull
   @Size(min = 1, max = 50)
   @Column(name = "DEP_NOMBRE")
   private String depNombre;

   public MuDependencia() {
   }

   public MuDependencia(Integer depId) {
      this.depId = depId;
   }

   public MuDependencia(Integer depId, String depNombre) {
      this.depId = depId;
      this.depNombre = depNombre;
   }

   public Integer getDepId() {
      return depId;
   }

   public void setDepId(Integer depId) {
      this.depId = depId;
   }

   public String getDepNombre() {
      return depNombre;
   }

   public void setDepNombre(String depNombre) {
      this.depNombre = depNombre;
   }

   @Override
   public int hashCode() {
      int hash = 0;
      hash += (depId != null ? depId.hashCode() : 0);
      return hash;
   }

   @Override
   public boolean equals(Object object) {
      // TODO: Warning - this method won't work in the case the id fields are not set
      if (!(object instanceof MuDependencia)) {
         return false;
      }
      MuDependencia other = (MuDependencia) object;
      if ((this.depId == null && other.depId != null) || (this.depId != null && !this.depId.equals(other.depId))) {
         return false;
      }
      return true;
   }

   @Override
   public String toString() {
      return "co.edu.unicauca.gymadmdoc.entities.MuDependencia[ depId=" + depId + " ]";
   }
   
}
