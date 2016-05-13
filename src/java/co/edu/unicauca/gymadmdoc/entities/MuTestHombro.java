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
@Table(name = "mu_test_hombro")
@XmlRootElement
@NamedQueries({
   @NamedQuery(name = "MuTestHombro.findAll", query = "SELECT m FROM MuTestHombro m"),
   @NamedQuery(name = "MuTestHombro.findByTeshId", query = "SELECT m FROM MuTestHombro m WHERE m.teshId = :teshId"),
   @NamedQuery(name = "MuTestHombro.findByFlexId", query = "SELECT m FROM MuTestHombro m WHERE m.flexId = :flexId"),
   @NamedQuery(name = "MuTestHombro.findByTeshFlexTronco", query = "SELECT m FROM MuTestHombro m WHERE m.teshFlexTronco = :teshFlexTronco"),
   @NamedQuery(name = "MuTestHombro.findByTeshClasificacion", query = "SELECT m FROM MuTestHombro m WHERE m.teshClasificacion = :teshClasificacion")})
public class MuTestHombro implements Serializable {

   private static final long serialVersionUID = 1L;
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Basic(optional = false)
   @Column(name = "TESH_ID")
   private Integer teshId;
   @Basic(optional = false)
   @NotNull
   @Column(name = "FLEX_ID")
   private int flexId;
   @Basic(optional = false)
   @NotNull
   @Column(name = "TESH_FLEX_TRONCO")
   private float teshFlexTronco;
   @Basic(optional = false)
   @NotNull
   @Size(min = 1, max = 15)
   @Column(name = "TESH_CLASIFICACION")
   private String teshClasificacion;

   public MuTestHombro() {
   }

   public MuTestHombro(Integer teshId) {
      this.teshId = teshId;
   }

   public MuTestHombro(Integer teshId, int flexId, float teshFlexTronco, String teshClasificacion) {
      this.teshId = teshId;
      this.flexId = flexId;
      this.teshFlexTronco = teshFlexTronco;
      this.teshClasificacion = teshClasificacion;
   }

   public Integer getTeshId() {
      return teshId;
   }

   public void setTeshId(Integer teshId) {
      this.teshId = teshId;
   }

   public int getFlexId() {
      return flexId;
   }

   public void setFlexId(int flexId) {
      this.flexId = flexId;
   }

   public float getTeshFlexTronco() {
      return teshFlexTronco;
   }

   public void setTeshFlexTronco(float teshFlexTronco) {
      this.teshFlexTronco = teshFlexTronco;
   }

   public String getTeshClasificacion() {
      return teshClasificacion;
   }

   public void setTeshClasificacion(String teshClasificacion) {
      this.teshClasificacion = teshClasificacion;
   }

   @Override
   public int hashCode() {
      int hash = 0;
      hash += (teshId != null ? teshId.hashCode() : 0);
      return hash;
   }

   @Override
   public boolean equals(Object object) {
      // TODO: Warning - this method won't work in the case the id fields are not set
      if (!(object instanceof MuTestHombro)) {
         return false;
      }
      MuTestHombro other = (MuTestHombro) object;
      if ((this.teshId == null && other.teshId != null) || (this.teshId != null && !this.teshId.equals(other.teshId))) {
         return false;
      }
      return true;
   }

   @Override
   public String toString() {
      return "co.edu.unicauca.gymadmdoc.entities.MuTestHombro[ teshId=" + teshId + " ]";
   }
   
}
