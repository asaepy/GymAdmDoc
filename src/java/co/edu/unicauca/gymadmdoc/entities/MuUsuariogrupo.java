/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicauca.gymadmdoc.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "mu_usuariogrupo")
@XmlRootElement
@NamedQueries({
   @NamedQuery(name = "MuUsuariogrupo.findAll", query = "SELECT m FROM MuUsuariogrupo m"),
   @NamedQuery(name = "MuUsuariogrupo.findByGruId", query = "SELECT m FROM MuUsuariogrupo m WHERE m.muUsuariogrupoPK.gruId = :gruId"),
   @NamedQuery(name = "MuUsuariogrupo.findByUsuIdentificacion", query = "SELECT m FROM MuUsuariogrupo m WHERE m.muUsuariogrupoPK.usuIdentificacion = :usuIdentificacion"),
   @NamedQuery(name = "MuUsuariogrupo.findByUsuNombre", query = "SELECT m FROM MuUsuariogrupo m WHERE m.usuNombre = :usuNombre")})
public class MuUsuariogrupo implements Serializable {

   private static final long serialVersionUID = 1L;
   @EmbeddedId
   protected MuUsuariogrupoPK muUsuariogrupoPK;
   @Basic(optional = false)
   @NotNull
   @Size(min = 1, max = 30)
   @Column(name = "USU_NOMBRE")
   private String usuNombre;

   public MuUsuariogrupo() {
   }

   public MuUsuariogrupo(MuUsuariogrupoPK muUsuariogrupoPK) {
      this.muUsuariogrupoPK = muUsuariogrupoPK;
   }

   public MuUsuariogrupo(MuUsuariogrupoPK muUsuariogrupoPK, String usuNombre) {
      this.muUsuariogrupoPK = muUsuariogrupoPK;
      this.usuNombre = usuNombre;
   }

   public MuUsuariogrupo(long gruId, long usuIdentificacion) {
      this.muUsuariogrupoPK = new MuUsuariogrupoPK(gruId, usuIdentificacion);
   }

   public MuUsuariogrupoPK getMuUsuariogrupoPK() {
      return muUsuariogrupoPK;
   }

   public void setMuUsuariogrupoPK(MuUsuariogrupoPK muUsuariogrupoPK) {
      this.muUsuariogrupoPK = muUsuariogrupoPK;
   }

   public String getUsuNombre() {
      return usuNombre;
   }

   public void setUsuNombre(String usuNombre) {
      this.usuNombre = usuNombre;
   }

   @Override
   public int hashCode() {
      int hash = 0;
      hash += (muUsuariogrupoPK != null ? muUsuariogrupoPK.hashCode() : 0);
      return hash;
   }

   @Override
   public boolean equals(Object object) {
      // TODO: Warning - this method won't work in the case the id fields are not set
      if (!(object instanceof MuUsuariogrupo)) {
         return false;
      }
      MuUsuariogrupo other = (MuUsuariogrupo) object;
      if ((this.muUsuariogrupoPK == null && other.muUsuariogrupoPK != null) || (this.muUsuariogrupoPK != null && !this.muUsuariogrupoPK.equals(other.muUsuariogrupoPK))) {
         return false;
      }
      return true;
   }

   @Override
   public String toString() {
      return "co.edu.unicauca.gymadmdoc.entities.MuUsuariogrupo[ muUsuariogrupoPK=" + muUsuariogrupoPK + " ]";
   }
   
}
