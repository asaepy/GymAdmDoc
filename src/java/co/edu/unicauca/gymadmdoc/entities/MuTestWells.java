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
@Table(name = "mu_test_wells")
@XmlRootElement
@NamedQueries({
   @NamedQuery(name = "MuTestWells.findAll", query = "SELECT m FROM MuTestWells m"),
   @NamedQuery(name = "MuTestWells.findByTeswId", query = "SELECT m FROM MuTestWells m WHERE m.teswId = :teswId"),
   @NamedQuery(name = "MuTestWells.findByFlexId", query = "SELECT m FROM MuTestWells m WHERE m.flexId = :flexId"),
   @NamedQuery(name = "MuTestWells.findByTeswFlexionTronco", query = "SELECT m FROM MuTestWells m WHERE m.teswFlexionTronco = :teswFlexionTronco"),
   @NamedQuery(name = "MuTestWells.findByTeswClasificacion", query = "SELECT m FROM MuTestWells m WHERE m.teswClasificacion = :teswClasificacion")})
public class MuTestWells implements Serializable {

   private static final long serialVersionUID = 1L;
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Basic(optional = false)
   @Column(name = "TESW_ID")
   private Integer teswId;
   @Basic(optional = false)
   @NotNull
   @Column(name = "FLEX_ID")
   private int flexId;
   @Basic(optional = false)
   @NotNull
   @Column(name = "TESW_FLEXION_TRONCO")
   private float teswFlexionTronco;
   @Basic(optional = false)
   @NotNull
   @Size(min = 1, max = 15)
   @Column(name = "TESW_CLASIFICACION")
   private String teswClasificacion;

   public MuTestWells() {
   }

   public MuTestWells(Integer teswId) {
      this.teswId = teswId;
   }

   public MuTestWells(Integer teswId, int flexId, float teswFlexionTronco, String teswClasificacion) {
      this.teswId = teswId;
      this.flexId = flexId;
      this.teswFlexionTronco = teswFlexionTronco;
      this.teswClasificacion = teswClasificacion;
   }

   public Integer getTeswId() {
      return teswId;
   }

   public void setTeswId(Integer teswId) {
      this.teswId = teswId;
   }

   public int getFlexId() {
      return flexId;
   }

   public void setFlexId(int flexId) {
      this.flexId = flexId;
   }

   public float getTeswFlexionTronco() {
      return teswFlexionTronco;
   }

   public void setTeswFlexionTronco(float teswFlexionTronco) {
      this.teswFlexionTronco = teswFlexionTronco;
   }

   public String getTeswClasificacion() {
      return teswClasificacion;
   }

   public void setTeswClasificacion(String teswClasificacion) {
      this.teswClasificacion = teswClasificacion;
   }

   @Override
   public int hashCode() {
      int hash = 0;
      hash += (teswId != null ? teswId.hashCode() : 0);
      return hash;
   }

   @Override
   public boolean equals(Object object) {
      // TODO: Warning - this method won't work in the case the id fields are not set
      if (!(object instanceof MuTestWells)) {
         return false;
      }
      MuTestWells other = (MuTestWells) object;
      if ((this.teswId == null && other.teswId != null) || (this.teswId != null && !this.teswId.equals(other.teswId))) {
         return false;
      }
      return true;
   }

   @Override
   public String toString() {
      return "co.edu.unicauca.gymadmdoc.entities.MuTestWells[ teswId=" + teswId + " ]";
   }
   
}
