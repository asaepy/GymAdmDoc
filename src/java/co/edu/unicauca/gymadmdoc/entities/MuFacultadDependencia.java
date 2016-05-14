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
@Table(name = "mu_facultad_dependencia")
@XmlRootElement
@NamedQueries({
   @NamedQuery(name = "MuFacultadDependencia.findAll", query = "SELECT m FROM MuFacultadDependencia m"),
   @NamedQuery(name = "MuFacultadDependencia.findByFacDepId", query = "SELECT m FROM MuFacultadDependencia m WHERE m.facDepId = :facDepId"),
   @NamedQuery(name = "MuFacultadDependencia.findByFacDepNombre", query = "SELECT m FROM MuFacultadDependencia m WHERE m.facDepNombre = :facDepNombre")})
public class MuFacultadDependencia implements Serializable {

   private static final long serialVersionUID = 1L;
   @Id
   @Basic(optional = false)
   @NotNull
   @Column(name = "FAC_DEP_ID")
   private Integer facDepId;
   @Basic(optional = false)
   @NotNull
   @Size(min = 1, max = 100)
   @Column(name = "FAC_DEP_NOMBRE")
   private String facDepNombre;

   public MuFacultadDependencia() {
   }

   public MuFacultadDependencia(Integer facDepId) {
      this.facDepId = facDepId;
   }

   public MuFacultadDependencia(Integer facDepId, String facDepNombre) {
      this.facDepId = facDepId;
      this.facDepNombre = facDepNombre;
   }

   public Integer getFacDepId() {
      return facDepId;
   }

   public void setFacDepId(Integer facDepId) {
      this.facDepId = facDepId;
   }

   public String getFacDepNombre() {
      return facDepNombre;
   }

   public void setFacDepNombre(String facDepNombre) {
      this.facDepNombre = facDepNombre;
   }

   @Override
   public int hashCode() {
      int hash = 0;
      hash += (facDepId != null ? facDepId.hashCode() : 0);
      return hash;
   }

   @Override
   public boolean equals(Object object) {
      // TODO: Warning - this method won't work in the case the id fields are not set
      if (!(object instanceof MuFacultadDependencia)) {
         return false;
      }
      MuFacultadDependencia other = (MuFacultadDependencia) object;
      if ((this.facDepId == null && other.facDepId != null) || (this.facDepId != null && !this.facDepId.equals(other.facDepId))) {
         return false;
      }
      return true;
   }

   @Override
   public String toString() {
      return "co.edu.unicauca.gymadmdoc.entities.MuFacultadDependencia[ facDepId=" + facDepId + " ]";
   }
   
}
