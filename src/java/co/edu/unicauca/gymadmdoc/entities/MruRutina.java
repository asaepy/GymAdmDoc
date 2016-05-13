/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicauca.gymadmdoc.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ricardo
 */
@Entity
@Table(name = "mru_rutina")
@XmlRootElement
@NamedQueries({
   @NamedQuery(name = "MruRutina.findAll", query = "SELECT m FROM MruRutina m"),
   @NamedQuery(name = "MruRutina.findByRuId", query = "SELECT m FROM MruRutina m WHERE m.ruId = :ruId"),
   @NamedQuery(name = "MruRutina.findByUsuIdentificacion", query = "SELECT m FROM MruRutina m WHERE m.usuIdentificacion = :usuIdentificacion"),
   @NamedQuery(name = "MruRutina.findByRuUsuIdentificacion", query = "SELECT m FROM MruRutina m WHERE m.ruUsuIdentificacion = :ruUsuIdentificacion"),
   @NamedQuery(name = "MruRutina.findByRuFechaini", query = "SELECT m FROM MruRutina m WHERE m.ruFechaini = :ruFechaini"),
   @NamedQuery(name = "MruRutina.findByRuFechafin", query = "SELECT m FROM MruRutina m WHERE m.ruFechafin = :ruFechafin"),
   @NamedQuery(name = "MruRutina.findByRuPeso", query = "SELECT m FROM MruRutina m WHERE m.ruPeso = :ruPeso"),
   @NamedQuery(name = "MruRutina.findByRuTalla", query = "SELECT m FROM MruRutina m WHERE m.ruTalla = :ruTalla"),
   @NamedQuery(name = "MruRutina.findByRuImc", query = "SELECT m FROM MruRutina m WHERE m.ruImc = :ruImc"),
   @NamedQuery(name = "MruRutina.findByRuObservaciones", query = "SELECT m FROM MruRutina m WHERE m.ruObservaciones = :ruObservaciones")})
public class MruRutina implements Serializable {

   private static final long serialVersionUID = 1L;
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Basic(optional = false)
   @Column(name = "RU_ID")
   private Integer ruId;
   @Basic(optional = false)
   @NotNull
   @Column(name = "USU_IDENTIFICACION")
   private long usuIdentificacion;
   @Basic(optional = false)
   @NotNull
   @Column(name = "RU_USU_IDENTIFICACION")
   private long ruUsuIdentificacion;
   @Basic(optional = false)
   @NotNull
   @Column(name = "RU_FECHAINI")
   @Temporal(TemporalType.DATE)
   private Date ruFechaini;
   @Basic(optional = false)
   @NotNull
   @Column(name = "RU_FECHAFIN")
   @Temporal(TemporalType.DATE)
   private Date ruFechafin;
   @Basic(optional = false)
   @NotNull
   @Column(name = "RU_PESO")
   private float ruPeso;
   @Basic(optional = false)
   @NotNull
   @Column(name = "RU_TALLA")
   private float ruTalla;
   @Basic(optional = false)
   @NotNull
   @Column(name = "RU_IMC")
   private float ruImc;
   @Size(max = 1000)
   @Column(name = "RU_OBSERVACIONES")
   private String ruObservaciones;

   public MruRutina() {
   }

   public MruRutina(Integer ruId) {
      this.ruId = ruId;
   }

   public MruRutina(Integer ruId, long usuIdentificacion, long ruUsuIdentificacion, Date ruFechaini, Date ruFechafin, float ruPeso, float ruTalla, float ruImc) {
      this.ruId = ruId;
      this.usuIdentificacion = usuIdentificacion;
      this.ruUsuIdentificacion = ruUsuIdentificacion;
      this.ruFechaini = ruFechaini;
      this.ruFechafin = ruFechafin;
      this.ruPeso = ruPeso;
      this.ruTalla = ruTalla;
      this.ruImc = ruImc;
   }

   public Integer getRuId() {
      return ruId;
   }

   public void setRuId(Integer ruId) {
      this.ruId = ruId;
   }

   public long getUsuIdentificacion() {
      return usuIdentificacion;
   }

   public void setUsuIdentificacion(long usuIdentificacion) {
      this.usuIdentificacion = usuIdentificacion;
   }

   public long getRuUsuIdentificacion() {
      return ruUsuIdentificacion;
   }

   public void setRuUsuIdentificacion(long ruUsuIdentificacion) {
      this.ruUsuIdentificacion = ruUsuIdentificacion;
   }

   public Date getRuFechaini() {
      return ruFechaini;
   }

   public void setRuFechaini(Date ruFechaini) {
      this.ruFechaini = ruFechaini;
   }

   public Date getRuFechafin() {
      return ruFechafin;
   }

   public void setRuFechafin(Date ruFechafin) {
      this.ruFechafin = ruFechafin;
   }

   public float getRuPeso() {
      return ruPeso;
   }

   public void setRuPeso(float ruPeso) {
      this.ruPeso = ruPeso;
   }

   public float getRuTalla() {
      return ruTalla;
   }

   public void setRuTalla(float ruTalla) {
      this.ruTalla = ruTalla;
   }

   public float getRuImc() {
      return ruImc;
   }

   public void setRuImc(float ruImc) {
      this.ruImc = ruImc;
   }

   public String getRuObservaciones() {
      return ruObservaciones;
   }

   public void setRuObservaciones(String ruObservaciones) {
      this.ruObservaciones = ruObservaciones;
   }

   @Override
   public int hashCode() {
      int hash = 0;
      hash += (ruId != null ? ruId.hashCode() : 0);
      return hash;
   }

   @Override
   public boolean equals(Object object) {
      // TODO: Warning - this method won't work in the case the id fields are not set
      if (!(object instanceof MruRutina)) {
         return false;
      }
      MruRutina other = (MruRutina) object;
      if ((this.ruId == null && other.ruId != null) || (this.ruId != null && !this.ruId.equals(other.ruId))) {
         return false;
      }
      return true;
   }

   @Override
   public String toString() {
      return "co.edu.unicauca.gymadmdoc.entities.MruRutina[ ruId=" + ruId + " ]";
   }
   
}
