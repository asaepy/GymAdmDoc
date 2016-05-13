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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ricardo
 */
@Entity
@Table(name = "mv_valoracion")
@XmlRootElement
@NamedQueries({
   @NamedQuery(name = "MvValoracion.findAll", query = "SELECT m FROM MvValoracion m"),
   @NamedQuery(name = "MvValoracion.findByValId", query = "SELECT m FROM MvValoracion m WHERE m.valId = :valId"),
   @NamedQuery(name = "MvValoracion.findByUsuIdentificacion", query = "SELECT m FROM MvValoracion m WHERE m.usuIdentificacion = :usuIdentificacion"),
   @NamedQuery(name = "MvValoracion.findByResId", query = "SELECT m FROM MvValoracion m WHERE m.resId = :resId"),
   @NamedQuery(name = "MvValoracion.findByValAbdomeninferior", query = "SELECT m FROM MvValoracion m WHERE m.valAbdomeninferior = :valAbdomeninferior"),
   @NamedQuery(name = "MvValoracion.findByValAbdominal", query = "SELECT m FROM MvValoracion m WHERE m.valAbdominal = :valAbdominal"),
   @NamedQuery(name = "MvValoracion.findByValBiepicondilarfemoral", query = "SELECT m FROM MvValoracion m WHERE m.valBiepicondilarfemoral = :valBiepicondilarfemoral"),
   @NamedQuery(name = "MvValoracion.findByValBiepicondilarhumeral", query = "SELECT m FROM MvValoracion m WHERE m.valBiepicondilarhumeral = :valBiepicondilarhumeral"),
   @NamedQuery(name = "MvValoracion.findByValBiceptscontraidosizq", query = "SELECT m FROM MvValoracion m WHERE m.valBiceptscontraidosizq = :valBiceptscontraidosizq"),
   @NamedQuery(name = "MvValoracion.findByValBiceptsrelajadoizq", query = "SELECT m FROM MvValoracion m WHERE m.valBiceptsrelajadoizq = :valBiceptsrelajadoizq"),
   @NamedQuery(name = "MvValoracion.findByValCadera", query = "SELECT m FROM MvValoracion m WHERE m.valCadera = :valCadera"),
   @NamedQuery(name = "MvValoracion.findByValFrecuenciacardiacareposo", query = "SELECT m FROM MvValoracion m WHERE m.valFrecuenciacardiacareposo = :valFrecuenciacardiacareposo"),
   @NamedQuery(name = "MvValoracion.findByValMedialpierna", query = "SELECT m FROM MvValoracion m WHERE m.valMedialpierna = :valMedialpierna"),
   @NamedQuery(name = "MvValoracion.findByValMusloanterior", query = "SELECT m FROM MvValoracion m WHERE m.valMusloanterior = :valMusloanterior"),
   @NamedQuery(name = "MvValoracion.findByValMuslosuperiorizq", query = "SELECT m FROM MvValoracion m WHERE m.valMuslosuperiorizq = :valMuslosuperiorizq"),
   @NamedQuery(name = "MvValoracion.findByValPantorrillaizq", query = "SELECT m FROM MvValoracion m WHERE m.valPantorrillaizq = :valPantorrillaizq"),
   @NamedQuery(name = "MvValoracion.findByValPectoral", query = "SELECT m FROM MvValoracion m WHERE m.valPectoral = :valPectoral"),
   @NamedQuery(name = "MvValoracion.findByValPorcentajeaguacorporal", query = "SELECT m FROM MvValoracion m WHERE m.valPorcentajeaguacorporal = :valPorcentajeaguacorporal"),
   @NamedQuery(name = "MvValoracion.findByValPorcentajegrasaimpedanciometria", query = "SELECT m FROM MvValoracion m WHERE m.valPorcentajegrasaimpedanciometria = :valPorcentajegrasaimpedanciometria"),
   @NamedQuery(name = "MvValoracion.findByValRadiocubital", query = "SELECT m FROM MvValoracion m WHERE m.valRadiocubital = :valRadiocubital"),
   @NamedQuery(name = "MvValoracion.findByValSubescapular", query = "SELECT m FROM MvValoracion m WHERE m.valSubescapular = :valSubescapular"),
   @NamedQuery(name = "MvValoracion.findByValSupraiiatico", query = "SELECT m FROM MvValoracion m WHERE m.valSupraiiatico = :valSupraiiatico"),
   @NamedQuery(name = "MvValoracion.findByValTorax", query = "SELECT m FROM MvValoracion m WHERE m.valTorax = :valTorax"),
   @NamedQuery(name = "MvValoracion.findByValTricepts", query = "SELECT m FROM MvValoracion m WHERE m.valTricepts = :valTricepts"),
   @NamedQuery(name = "MvValoracion.findByValVo2max", query = "SELECT m FROM MvValoracion m WHERE m.valVo2max = :valVo2max"),
   @NamedQuery(name = "MvValoracion.findByValCliente", query = "SELECT m FROM MvValoracion m WHERE m.valCliente = :valCliente"),
   @NamedQuery(name = "MvValoracion.findByValValorador", query = "SELECT m FROM MvValoracion m WHERE m.valValorador = :valValorador"),
   @NamedQuery(name = "MvValoracion.findByValFechavaloracion", query = "SELECT m FROM MvValoracion m WHERE m.valFechavaloracion = :valFechavaloracion"),
   @NamedQuery(name = "MvValoracion.findByValEdaddecimal", query = "SELECT m FROM MvValoracion m WHERE m.valEdaddecimal = :valEdaddecimal"),
   @NamedQuery(name = "MvValoracion.findByValBicepsrelajadoder", query = "SELECT m FROM MvValoracion m WHERE m.valBicepsrelajadoder = :valBicepsrelajadoder"),
   @NamedQuery(name = "MvValoracion.findByValBicepscontraidoder", query = "SELECT m FROM MvValoracion m WHERE m.valBicepscontraidoder = :valBicepscontraidoder"),
   @NamedQuery(name = "MvValoracion.findByValMuslosuperiorder", query = "SELECT m FROM MvValoracion m WHERE m.valMuslosuperiorder = :valMuslosuperiorder"),
   @NamedQuery(name = "MvValoracion.findByValPantorrilader", query = "SELECT m FROM MvValoracion m WHERE m.valPantorrilader = :valPantorrilader")})
public class MvValoracion implements Serializable {

   private static final long serialVersionUID = 1L;
   @Id
   @Basic(optional = false)
   @NotNull
   @Column(name = "VAL_ID")
   private Integer valId;
   @Basic(optional = false)
   @NotNull
   @Column(name = "USU_IDENTIFICACION")
   private long usuIdentificacion;
   @Column(name = "RES_ID")
   private Integer resId;
   @Column(name = "VAL_ABDOMENINFERIOR")
   private Long valAbdomeninferior;
   @Column(name = "VAL_ABDOMINAL")
   private Long valAbdominal;
   @Column(name = "VAL_BIEPICONDILARFEMORAL")
   private Long valBiepicondilarfemoral;
   @Column(name = "VAL_BIEPICONDILARHUMERAL")
   private Long valBiepicondilarhumeral;
   @Column(name = "VAL_BICEPTSCONTRAIDOSIZQ")
   private Long valBiceptscontraidosizq;
   @Column(name = "VAL_BICEPTSRELAJADOIZQ")
   private Long valBiceptsrelajadoizq;
   @Column(name = "VAL_CADERA")
   private Long valCadera;
   @Column(name = "VAL_FRECUENCIACARDIACAREPOSO")
   private Long valFrecuenciacardiacareposo;
   @Column(name = "VAL_MEDIALPIERNA")
   private Long valMedialpierna;
   @Column(name = "VAL_MUSLOANTERIOR")
   private Long valMusloanterior;
   @Column(name = "VAL_MUSLOSUPERIORIZQ")
   private Long valMuslosuperiorizq;
   @Column(name = "VAL_PANTORRILLAIZQ")
   private Long valPantorrillaizq;
   @Column(name = "VAL_PECTORAL")
   private Long valPectoral;
   @Column(name = "VAL_PORCENTAJEAGUACORPORAL")
   private Long valPorcentajeaguacorporal;
   @Column(name = "VAL_PORCENTAJEGRASAIMPEDANCIOMETRIA")
   private Long valPorcentajegrasaimpedanciometria;
   @Column(name = "VAL_RADIOCUBITAL")
   private Long valRadiocubital;
   @Column(name = "VAL_SUBESCAPULAR")
   private Long valSubescapular;
   @Column(name = "VAL_SUPRAIIATICO")
   private Long valSupraiiatico;
   @Column(name = "VAL_TORAX")
   private Long valTorax;
   @Column(name = "VAL_TRICEPTS")
   private Long valTricepts;
   @Column(name = "VAL_VO2MAX")
   private Long valVo2max;
   @Basic(optional = false)
   @NotNull
   @Column(name = "VAL_CLIENTE")
   private long valCliente;
   @Basic(optional = false)
   @NotNull
   @Column(name = "VAL_VALORADOR")
   private long valValorador;
   @Column(name = "VAL_FECHAVALORACION")
   private Long valFechavaloracion;
   @Column(name = "VAL_EDADDECIMAL")
   private Long valEdaddecimal;
   @Column(name = "VAL_BICEPSRELAJADODER")
   private Long valBicepsrelajadoder;
   @Column(name = "VAL_BICEPSCONTRAIDODER")
   private Long valBicepscontraidoder;
   @Column(name = "VAL_MUSLOSUPERIORDER")
   private Long valMuslosuperiorder;
   @Column(name = "VAL_PANTORRILADER")
   private Long valPantorrilader;

   public MvValoracion() {
   }

   public MvValoracion(Integer valId) {
      this.valId = valId;
   }

   public MvValoracion(Integer valId, long usuIdentificacion, long valCliente, long valValorador) {
      this.valId = valId;
      this.usuIdentificacion = usuIdentificacion;
      this.valCliente = valCliente;
      this.valValorador = valValorador;
   }

   public Integer getValId() {
      return valId;
   }

   public void setValId(Integer valId) {
      this.valId = valId;
   }

   public long getUsuIdentificacion() {
      return usuIdentificacion;
   }

   public void setUsuIdentificacion(long usuIdentificacion) {
      this.usuIdentificacion = usuIdentificacion;
   }

   public Integer getResId() {
      return resId;
   }

   public void setResId(Integer resId) {
      this.resId = resId;
   }

   public Long getValAbdomeninferior() {
      return valAbdomeninferior;
   }

   public void setValAbdomeninferior(Long valAbdomeninferior) {
      this.valAbdomeninferior = valAbdomeninferior;
   }

   public Long getValAbdominal() {
      return valAbdominal;
   }

   public void setValAbdominal(Long valAbdominal) {
      this.valAbdominal = valAbdominal;
   }

   public Long getValBiepicondilarfemoral() {
      return valBiepicondilarfemoral;
   }

   public void setValBiepicondilarfemoral(Long valBiepicondilarfemoral) {
      this.valBiepicondilarfemoral = valBiepicondilarfemoral;
   }

   public Long getValBiepicondilarhumeral() {
      return valBiepicondilarhumeral;
   }

   public void setValBiepicondilarhumeral(Long valBiepicondilarhumeral) {
      this.valBiepicondilarhumeral = valBiepicondilarhumeral;
   }

   public Long getValBiceptscontraidosizq() {
      return valBiceptscontraidosizq;
   }

   public void setValBiceptscontraidosizq(Long valBiceptscontraidosizq) {
      this.valBiceptscontraidosizq = valBiceptscontraidosizq;
   }

   public Long getValBiceptsrelajadoizq() {
      return valBiceptsrelajadoizq;
   }

   public void setValBiceptsrelajadoizq(Long valBiceptsrelajadoizq) {
      this.valBiceptsrelajadoizq = valBiceptsrelajadoizq;
   }

   public Long getValCadera() {
      return valCadera;
   }

   public void setValCadera(Long valCadera) {
      this.valCadera = valCadera;
   }

   public Long getValFrecuenciacardiacareposo() {
      return valFrecuenciacardiacareposo;
   }

   public void setValFrecuenciacardiacareposo(Long valFrecuenciacardiacareposo) {
      this.valFrecuenciacardiacareposo = valFrecuenciacardiacareposo;
   }

   public Long getValMedialpierna() {
      return valMedialpierna;
   }

   public void setValMedialpierna(Long valMedialpierna) {
      this.valMedialpierna = valMedialpierna;
   }

   public Long getValMusloanterior() {
      return valMusloanterior;
   }

   public void setValMusloanterior(Long valMusloanterior) {
      this.valMusloanterior = valMusloanterior;
   }

   public Long getValMuslosuperiorizq() {
      return valMuslosuperiorizq;
   }

   public void setValMuslosuperiorizq(Long valMuslosuperiorizq) {
      this.valMuslosuperiorizq = valMuslosuperiorizq;
   }

   public Long getValPantorrillaizq() {
      return valPantorrillaizq;
   }

   public void setValPantorrillaizq(Long valPantorrillaizq) {
      this.valPantorrillaizq = valPantorrillaizq;
   }

   public Long getValPectoral() {
      return valPectoral;
   }

   public void setValPectoral(Long valPectoral) {
      this.valPectoral = valPectoral;
   }

   public Long getValPorcentajeaguacorporal() {
      return valPorcentajeaguacorporal;
   }

   public void setValPorcentajeaguacorporal(Long valPorcentajeaguacorporal) {
      this.valPorcentajeaguacorporal = valPorcentajeaguacorporal;
   }

   public Long getValPorcentajegrasaimpedanciometria() {
      return valPorcentajegrasaimpedanciometria;
   }

   public void setValPorcentajegrasaimpedanciometria(Long valPorcentajegrasaimpedanciometria) {
      this.valPorcentajegrasaimpedanciometria = valPorcentajegrasaimpedanciometria;
   }

   public Long getValRadiocubital() {
      return valRadiocubital;
   }

   public void setValRadiocubital(Long valRadiocubital) {
      this.valRadiocubital = valRadiocubital;
   }

   public Long getValSubescapular() {
      return valSubescapular;
   }

   public void setValSubescapular(Long valSubescapular) {
      this.valSubescapular = valSubescapular;
   }

   public Long getValSupraiiatico() {
      return valSupraiiatico;
   }

   public void setValSupraiiatico(Long valSupraiiatico) {
      this.valSupraiiatico = valSupraiiatico;
   }

   public Long getValTorax() {
      return valTorax;
   }

   public void setValTorax(Long valTorax) {
      this.valTorax = valTorax;
   }

   public Long getValTricepts() {
      return valTricepts;
   }

   public void setValTricepts(Long valTricepts) {
      this.valTricepts = valTricepts;
   }

   public Long getValVo2max() {
      return valVo2max;
   }

   public void setValVo2max(Long valVo2max) {
      this.valVo2max = valVo2max;
   }

   public long getValCliente() {
      return valCliente;
   }

   public void setValCliente(long valCliente) {
      this.valCliente = valCliente;
   }

   public long getValValorador() {
      return valValorador;
   }

   public void setValValorador(long valValorador) {
      this.valValorador = valValorador;
   }

   public Long getValFechavaloracion() {
      return valFechavaloracion;
   }

   public void setValFechavaloracion(Long valFechavaloracion) {
      this.valFechavaloracion = valFechavaloracion;
   }

   public Long getValEdaddecimal() {
      return valEdaddecimal;
   }

   public void setValEdaddecimal(Long valEdaddecimal) {
      this.valEdaddecimal = valEdaddecimal;
   }

   public Long getValBicepsrelajadoder() {
      return valBicepsrelajadoder;
   }

   public void setValBicepsrelajadoder(Long valBicepsrelajadoder) {
      this.valBicepsrelajadoder = valBicepsrelajadoder;
   }

   public Long getValBicepscontraidoder() {
      return valBicepscontraidoder;
   }

   public void setValBicepscontraidoder(Long valBicepscontraidoder) {
      this.valBicepscontraidoder = valBicepscontraidoder;
   }

   public Long getValMuslosuperiorder() {
      return valMuslosuperiorder;
   }

   public void setValMuslosuperiorder(Long valMuslosuperiorder) {
      this.valMuslosuperiorder = valMuslosuperiorder;
   }

   public Long getValPantorrilader() {
      return valPantorrilader;
   }

   public void setValPantorrilader(Long valPantorrilader) {
      this.valPantorrilader = valPantorrilader;
   }

   @Override
   public int hashCode() {
      int hash = 0;
      hash += (valId != null ? valId.hashCode() : 0);
      return hash;
   }

   @Override
   public boolean equals(Object object) {
      // TODO: Warning - this method won't work in the case the id fields are not set
      if (!(object instanceof MvValoracion)) {
         return false;
      }
      MvValoracion other = (MvValoracion) object;
      if ((this.valId == null && other.valId != null) || (this.valId != null && !this.valId.equals(other.valId))) {
         return false;
      }
      return true;
   }

   @Override
   public String toString() {
      return "co.edu.unicauca.gymadmdoc.entities.MvValoracion[ valId=" + valId + " ]";
   }
   
}
