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
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "mu_usuario")
@XmlRootElement
@NamedQueries({
   @NamedQuery(name = "MuUsuario.findAll", query = "SELECT m FROM MuUsuario m"),
   @NamedQuery(name = "MuUsuario.findByUsuIdentificacion", query = "SELECT m FROM MuUsuario m WHERE m.usuIdentificacion = :usuIdentificacion"),
   @NamedQuery(name = "MuUsuario.findByFacId", query = "SELECT m FROM MuUsuario m WHERE m.facId = :facId"),
   @NamedQuery(name = "MuUsuario.findByOcuId", query = "SELECT m FROM MuUsuario m WHERE m.ocuId = :ocuId"),
   @NamedQuery(name = "MuUsuario.findByDepId", query = "SELECT m FROM MuUsuario m WHERE m.depId = :depId"),
   @NamedQuery(name = "MuUsuario.findByUsuCodigo", query = "SELECT m FROM MuUsuario m WHERE m.usuCodigo = :usuCodigo"),
   @NamedQuery(name = "MuUsuario.findByUsuNombres", query = "SELECT m FROM MuUsuario m WHERE m.usuNombres = :usuNombres"),
   @NamedQuery(name = "MuUsuario.findByUsuApellido1", query = "SELECT m FROM MuUsuario m WHERE m.usuApellido1 = :usuApellido1"),
   @NamedQuery(name = "MuUsuario.findByUsuApellido2", query = "SELECT m FROM MuUsuario m WHERE m.usuApellido2 = :usuApellido2"),
   @NamedQuery(name = "MuUsuario.findByUsuFechaNacimiento", query = "SELECT m FROM MuUsuario m WHERE m.usuFechaNacimiento = :usuFechaNacimiento"),
   @NamedQuery(name = "MuUsuario.findByUsuGenero", query = "SELECT m FROM MuUsuario m WHERE m.usuGenero = :usuGenero"),
   @NamedQuery(name = "MuUsuario.findByUsuTelefono", query = "SELECT m FROM MuUsuario m WHERE m.usuTelefono = :usuTelefono"),
   @NamedQuery(name = "MuUsuario.findByUsuCelular", query = "SELECT m FROM MuUsuario m WHERE m.usuCelular = :usuCelular"),
   @NamedQuery(name = "MuUsuario.findByUsuEmail", query = "SELECT m FROM MuUsuario m WHERE m.usuEmail = :usuEmail"),
   @NamedQuery(name = "MuUsuario.findByUsuContrasena", query = "SELECT m FROM MuUsuario m WHERE m.usuContrasena = :usuContrasena"),
   @NamedQuery(name = "MuUsuario.findByUsuNombreUsuario", query = "SELECT m FROM MuUsuario m WHERE m.usuNombreUsuario = :usuNombreUsuario"),
   @NamedQuery(name = "MuUsuario.findByUsuEstado", query = "SELECT m FROM MuUsuario m WHERE m.usuEstado = :usuEstado")})
public class MuUsuario implements Serializable {

   private static final long serialVersionUID = 1L;
   @Id
   @Basic(optional = false)
   @NotNull
   @Column(name = "USU_IDENTIFICACION")
   private Long usuIdentificacion;
   @Basic(optional = false)
   @NotNull
   @Column(name = "FAC_ID")
   private int facId;
   @Basic(optional = false)
   @NotNull
   @Column(name = "OCU_ID")
   private int ocuId;
   @Column(name = "DEP_ID")
   private Integer depId;
   @Size(max = 150)
   @Column(name = "USU_CODIGO")
   private String usuCodigo;
   @Basic(optional = false)
   @NotNull
   @Size(min = 1, max = 30)
   @Column(name = "USU_NOMBRES")
   private String usuNombres;
   @Basic(optional = false)
   @NotNull
   @Size(min = 1, max = 25)
   @Column(name = "USU_APELLIDO1")
   private String usuApellido1;
   @Basic(optional = false)
   @NotNull
   @Size(min = 1, max = 25)
   @Column(name = "USU_APELLIDO2")
   private String usuApellido2;
   @Basic(optional = false)
   @NotNull
   @Column(name = "USU_FECHA_NACIMIENTO")
   @Temporal(TemporalType.DATE)
   private Date usuFechaNacimiento;
   @Basic(optional = false)
   @NotNull
   @Size(min = 1, max = 2)
   @Column(name = "USU_GENERO")
   private String usuGenero;
   @Size(max = 15)
   @Column(name = "USU_TELEFONO")
   private String usuTelefono;
   @Column(name = "USU_CELULAR")
   private Integer usuCelular;
   @Basic(optional = false)
   @NotNull
   @Size(min = 1, max = 50)
   @Column(name = "USU_EMAIL")
   private String usuEmail;
   @Basic(optional = false)
   @NotNull
   @Lob
   @Column(name = "USU_FOTO")
   private byte[] usuFoto;
   @Basic(optional = false)
   @NotNull
   @Size(min = 1, max = 20)
   @Column(name = "USU_CONTRASENA")
   private String usuContrasena;
   @Basic(optional = false)
   @NotNull
   @Size(min = 1, max = 30)
   @Column(name = "USU_NOMBRE_USUARIO")
   private String usuNombreUsuario;
   @Basic(optional = false)
   @NotNull
   @Size(min = 1, max = 15)
   @Column(name = "USU_ESTADO")
   private String usuEstado;

   public MuUsuario() {
   }

   public MuUsuario(Long usuIdentificacion) {
      this.usuIdentificacion = usuIdentificacion;
   }

   public MuUsuario(Long usuIdentificacion, int facId, int ocuId, String usuNombres, String usuApellido1, String usuApellido2, Date usuFechaNacimiento, String usuGenero, String usuEmail, byte[] usuFoto, String usuContrasena, String usuNombreUsuario, String usuEstado) {
      this.usuIdentificacion = usuIdentificacion;
      this.facId = facId;
      this.ocuId = ocuId;
      this.usuNombres = usuNombres;
      this.usuApellido1 = usuApellido1;
      this.usuApellido2 = usuApellido2;
      this.usuFechaNacimiento = usuFechaNacimiento;
      this.usuGenero = usuGenero;
      this.usuEmail = usuEmail;
      this.usuFoto = usuFoto;
      this.usuContrasena = usuContrasena;
      this.usuNombreUsuario = usuNombreUsuario;
      this.usuEstado = usuEstado;
   }

   public Long getUsuIdentificacion() {
      return usuIdentificacion;
   }

   public void setUsuIdentificacion(Long usuIdentificacion) {
      this.usuIdentificacion = usuIdentificacion;
   }

   public int getFacId() {
      return facId;
   }

   public void setFacId(int facId) {
      this.facId = facId;
   }

   public int getOcuId() {
      return ocuId;
   }

   public void setOcuId(int ocuId) {
      this.ocuId = ocuId;
   }

   public Integer getDepId() {
      return depId;
   }

   public void setDepId(Integer depId) {
      this.depId = depId;
   }

   public String getUsuCodigo() {
      return usuCodigo;
   }

   public void setUsuCodigo(String usuCodigo) {
      this.usuCodigo = usuCodigo;
   }

   public String getUsuNombres() {
      return usuNombres;
   }

   public void setUsuNombres(String usuNombres) {
      this.usuNombres = usuNombres;
   }

   public String getUsuApellido1() {
      return usuApellido1;
   }

   public void setUsuApellido1(String usuApellido1) {
      this.usuApellido1 = usuApellido1;
   }

   public String getUsuApellido2() {
      return usuApellido2;
   }

   public void setUsuApellido2(String usuApellido2) {
      this.usuApellido2 = usuApellido2;
   }

   public Date getUsuFechaNacimiento() {
      return usuFechaNacimiento;
   }

   public void setUsuFechaNacimiento(Date usuFechaNacimiento) {
      this.usuFechaNacimiento = usuFechaNacimiento;
   }

   public String getUsuGenero() {
      return usuGenero;
   }

   public void setUsuGenero(String usuGenero) {
      this.usuGenero = usuGenero;
   }

   public String getUsuTelefono() {
      return usuTelefono;
   }

   public void setUsuTelefono(String usuTelefono) {
      this.usuTelefono = usuTelefono;
   }

   public Integer getUsuCelular() {
      return usuCelular;
   }

   public void setUsuCelular(Integer usuCelular) {
      this.usuCelular = usuCelular;
   }

   public String getUsuEmail() {
      return usuEmail;
   }

   public void setUsuEmail(String usuEmail) {
      this.usuEmail = usuEmail;
   }

   public byte[] getUsuFoto() {
      return usuFoto;
   }

   public void setUsuFoto(byte[] usuFoto) {
      this.usuFoto = usuFoto;
   }

   public String getUsuContrasena() {
      return usuContrasena;
   }

   public void setUsuContrasena(String usuContrasena) {
      this.usuContrasena = usuContrasena;
   }

   public String getUsuNombreUsuario() {
      return usuNombreUsuario;
   }

   public void setUsuNombreUsuario(String usuNombreUsuario) {
      this.usuNombreUsuario = usuNombreUsuario;
   }

   public String getUsuEstado() {
      return usuEstado;
   }

   public void setUsuEstado(String usuEstado) {
      this.usuEstado = usuEstado;
   }

   @Override
   public int hashCode() {
      int hash = 0;
      hash += (usuIdentificacion != null ? usuIdentificacion.hashCode() : 0);
      return hash;
   }

   @Override
   public boolean equals(Object object) {
      // TODO: Warning - this method won't work in the case the id fields are not set
      if (!(object instanceof MuUsuario)) {
         return false;
      }
      MuUsuario other = (MuUsuario) object;
      if ((this.usuIdentificacion == null && other.usuIdentificacion != null) || (this.usuIdentificacion != null && !this.usuIdentificacion.equals(other.usuIdentificacion))) {
         return false;
      }
      return true;
   }

   @Override
   public String toString() {
      return "co.edu.unicauca.gymadmdoc.entities.MuUsuario[ usuIdentificacion=" + usuIdentificacion + " ]";
   }
   
}
