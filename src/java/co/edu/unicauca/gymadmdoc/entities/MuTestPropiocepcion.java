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
@Table(name = "mu_test_propiocepcion")
@XmlRootElement
@NamedQueries({
   @NamedQuery(name = "MuTestPropiocepcion.findAll", query = "SELECT m FROM MuTestPropiocepcion m"),
   @NamedQuery(name = "MuTestPropiocepcion.findByTesproId", query = "SELECT m FROM MuTestPropiocepcion m WHERE m.tesproId = :tesproId"),
   @NamedQuery(name = "MuTestPropiocepcion.findByEvalId", query = "SELECT m FROM MuTestPropiocepcion m WHERE m.evalId = :evalId"),
   @NamedQuery(name = "MuTestPropiocepcion.findByTesproEstabilidadEstatica", query = "SELECT m FROM MuTestPropiocepcion m WHERE m.tesproEstabilidadEstatica = :tesproEstabilidadEstatica"),
   @NamedQuery(name = "MuTestPropiocepcion.findByTesproClasificacion", query = "SELECT m FROM MuTestPropiocepcion m WHERE m.tesproClasificacion = :tesproClasificacion")})
public class MuTestPropiocepcion implements Serializable {

   private static final long serialVersionUID = 1L;
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Basic(optional = false)
   @Column(name = "TESPRO_ID")
   private Integer tesproId;
   @Basic(optional = false)
   @NotNull
   @Column(name = "EVAL_ID")
   private long evalId;
   @Basic(optional = false)
   @NotNull
   @Column(name = "TESPRO_ESTABILIDAD_ESTATICA")
   private float tesproEstabilidadEstatica;
   @Basic(optional = false)
   @NotNull
   @Size(min = 1, max = 30)
   @Column(name = "TESPRO_CLASIFICACION")
   private String tesproClasificacion;

   public MuTestPropiocepcion() {
   }

   public MuTestPropiocepcion(Integer tesproId) {
      this.tesproId = tesproId;
   }

   public MuTestPropiocepcion(Integer tesproId, long evalId, float tesproEstabilidadEstatica, String tesproClasificacion) {
      this.tesproId = tesproId;
      this.evalId = evalId;
      this.tesproEstabilidadEstatica = tesproEstabilidadEstatica;
      this.tesproClasificacion = tesproClasificacion;
   }

   public Integer getTesproId() {
      return tesproId;
   }

   public void setTesproId(Integer tesproId) {
      this.tesproId = tesproId;
   }

   public long getEvalId() {
      return evalId;
   }

   public void setEvalId(long evalId) {
      this.evalId = evalId;
   }

   public float getTesproEstabilidadEstatica() {
      return tesproEstabilidadEstatica;
   }

   public void setTesproEstabilidadEstatica(float tesproEstabilidadEstatica) {
      this.tesproEstabilidadEstatica = tesproEstabilidadEstatica;
   }

   public String getTesproClasificacion() {
      return tesproClasificacion;
   }

   public void setTesproClasificacion(String tesproClasificacion) {
      this.tesproClasificacion = tesproClasificacion;
   }

   @Override
   public int hashCode() {
      int hash = 0;
      hash += (tesproId != null ? tesproId.hashCode() : 0);
      return hash;
   }

   @Override
   public boolean equals(Object object) {
      // TODO: Warning - this method won't work in the case the id fields are not set
      if (!(object instanceof MuTestPropiocepcion)) {
         return false;
      }
      MuTestPropiocepcion other = (MuTestPropiocepcion) object;
      if ((this.tesproId == null && other.tesproId != null) || (this.tesproId != null && !this.tesproId.equals(other.tesproId))) {
         return false;
      }
      return true;
   }

   @Override
   public String toString() {
      return "co.edu.unicauca.gymadmdoc.entities.MuTestPropiocepcion[ tesproId=" + tesproId + " ]";
   }
   
}
