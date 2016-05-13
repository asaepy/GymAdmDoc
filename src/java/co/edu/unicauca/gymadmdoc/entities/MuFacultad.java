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
@Table(name = "mu_facultad")
@XmlRootElement
@NamedQueries({
   @NamedQuery(name = "MuFacultad.findAll", query = "SELECT m FROM MuFacultad m"),
   @NamedQuery(name = "MuFacultad.findByFacId", query = "SELECT m FROM MuFacultad m WHERE m.facId = :facId"),
   @NamedQuery(name = "MuFacultad.findByFacNombre", query = "SELECT m FROM MuFacultad m WHERE m.facNombre = :facNombre")})
public class MuFacultad implements Serializable {

   private static final long serialVersionUID = 1L;
   @Id
   @Basic(optional = false)
   @NotNull
   @Column(name = "FAC_ID")
   private Integer facId;
   @Basic(optional = false)
   @NotNull
   @Size(min = 1, max = 50)
   @Column(name = "FAC_NOMBRE")
   private String facNombre;

   public MuFacultad() {
   }

   public MuFacultad(Integer facId) {
      this.facId = facId;
   }

   public MuFacultad(Integer facId, String facNombre) {
      this.facId = facId;
      this.facNombre = facNombre;
   }

   public Integer getFacId() {
      return facId;
   }

   public void setFacId(Integer facId) {
      this.facId = facId;
   }

   public String getFacNombre() {
      return facNombre;
   }

   public void setFacNombre(String facNombre) {
      this.facNombre = facNombre;
   }

   @Override
   public int hashCode() {
      int hash = 0;
      hash += (facId != null ? facId.hashCode() : 0);
      return hash;
   }

   @Override
   public boolean equals(Object object) {
      // TODO: Warning - this method won't work in the case the id fields are not set
      if (!(object instanceof MuFacultad)) {
         return false;
      }
      MuFacultad other = (MuFacultad) object;
      if ((this.facId == null && other.facId != null) || (this.facId != null && !this.facId.equals(other.facId))) {
         return false;
      }
      return true;
   }

   @Override
   public String toString() {
      return "co.edu.unicauca.gymadmdoc.entities.MuFacultad[ facId=" + facId + " ]";
   }
   
}
