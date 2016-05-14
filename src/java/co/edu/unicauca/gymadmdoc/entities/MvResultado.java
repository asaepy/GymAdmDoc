/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicauca.gymadmdoc.entities;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "mv_resultado")
@XmlRootElement
@NamedQueries({
   @NamedQuery(name = "MvResultado.findAll", query = "SELECT m FROM MvResultado m"),
   @NamedQuery(name = "MvResultado.findByResId", query = "SELECT m FROM MvResultado m WHERE m.resId = :resId"),
   @NamedQuery(name = "MvResultado.findByValId", query = "SELECT m FROM MvResultado m WHERE m.valId = :valId"),
   @NamedQuery(name = "MvResultado.findByUsuIdentificacion", query = "SELECT m FROM MvResultado m WHERE m.usuIdentificacion = :usuIdentificacion"),
   @NamedQuery(name = "MvResultado.findByResCaloriasrequeridadieta", query = "SELECT m FROM MvResultado m WHERE m.resCaloriasrequeridadieta = :resCaloriasrequeridadieta"),
   @NamedQuery(name = "MvResultado.findByResEctomorfia", query = "SELECT m FROM MvResultado m WHERE m.resEctomorfia = :resEctomorfia"),
   @NamedQuery(name = "MvResultado.findByResEjex", query = "SELECT m FROM MvResultado m WHERE m.resEjex = :resEjex"),
   @NamedQuery(name = "MvResultado.findByResEjey", query = "SELECT m FROM MvResultado m WHERE m.resEjey = :resEjey"),
   @NamedQuery(name = "MvResultado.findByResEndomorfia", query = "SELECT m FROM MvResultado m WHERE m.resEndomorfia = :resEndomorfia"),
   @NamedQuery(name = "MvResultado.findByResGramoproteinadia", query = "SELECT m FROM MvResultado m WHERE m.resGramoproteinadia = :resGramoproteinadia"),
   @NamedQuery(name = "MvResultado.findByResMasacorporalmagra", query = "SELECT m FROM MvResultado m WHERE m.resMasacorporalmagra = :resMasacorporalmagra"),
   @NamedQuery(name = "MvResultado.findByResMasacorporalmagraideal", query = "SELECT m FROM MvResultado m WHERE m.resMasacorporalmagraideal = :resMasacorporalmagraideal"),
   @NamedQuery(name = "MvResultado.findByResMesomorfia", query = "SELECT m FROM MvResultado m WHERE m.resMesomorfia = :resMesomorfia"),
   @NamedQuery(name = "MvResultado.findByResPesoanterior", query = "SELECT m FROM MvResultado m WHERE m.resPesoanterior = :resPesoanterior"),
   @NamedQuery(name = "MvResultado.findByResPesograso", query = "SELECT m FROM MvResultado m WHERE m.resPesograso = :resPesograso"),
   @NamedQuery(name = "MvResultado.findByResPesograsoideal", query = "SELECT m FROM MvResultado m WHERE m.resPesograsoideal = :resPesograsoideal"),
   @NamedQuery(name = "MvResultado.findByResPesoideal", query = "SELECT m FROM MvResultado m WHERE m.resPesoideal = :resPesoideal"),
   @NamedQuery(name = "MvResultado.findByResPesoidealinferior", query = "SELECT m FROM MvResultado m WHERE m.resPesoidealinferior = :resPesoidealinferior"),
   @NamedQuery(name = "MvResultado.findByResPesoideallimite", query = "SELECT m FROM MvResultado m WHERE m.resPesoideallimite = :resPesoideallimite"),
   @NamedQuery(name = "MvResultado.findByResPesomuscular", query = "SELECT m FROM MvResultado m WHERE m.resPesomuscular = :resPesomuscular"),
   @NamedQuery(name = "MvResultado.findByResPesomuscularanterior", query = "SELECT m FROM MvResultado m WHERE m.resPesomuscularanterior = :resPesomuscularanterior"),
   @NamedQuery(name = "MvResultado.findByResPesomuscularideal", query = "SELECT m FROM MvResultado m WHERE m.resPesomuscularideal = :resPesomuscularideal"),
   @NamedQuery(name = "MvResultado.findByResPesooseo", query = "SELECT m FROM MvResultado m WHERE m.resPesooseo = :resPesooseo"),
   @NamedQuery(name = "MvResultado.findByResPesoresidual", query = "SELECT m FROM MvResultado m WHERE m.resPesoresidual = :resPesoresidual"),
   @NamedQuery(name = "MvResultado.findByResPesototal", query = "SELECT m FROM MvResultado m WHERE m.resPesototal = :resPesototal"),
   @NamedQuery(name = "MvResultado.findByResPorcentajegrasaanterior", query = "SELECT m FROM MvResultado m WHERE m.resPorcentajegrasaanterior = :resPorcentajegrasaanterior"),
   @NamedQuery(name = "MvResultado.findByResPorcentajegrasacorporaltotal", query = "SELECT m FROM MvResultado m WHERE m.resPorcentajegrasacorporaltotal = :resPorcentajegrasacorporaltotal"),
   @NamedQuery(name = "MvResultado.findByResPorcentajegrasaideal", query = "SELECT m FROM MvResultado m WHERE m.resPorcentajegrasaideal = :resPorcentajegrasaideal"),
   @NamedQuery(name = "MvResultado.findByResPorcentajeoseoideal", query = "SELECT m FROM MvResultado m WHERE m.resPorcentajeoseoideal = :resPorcentajeoseoideal"),
   @NamedQuery(name = "MvResultado.findByResPorcentajepesomuscularideal", query = "SELECT m FROM MvResultado m WHERE m.resPorcentajepesomuscularideal = :resPorcentajepesomuscularideal"),
   @NamedQuery(name = "MvResultado.findByResPorcentajepesooseo", query = "SELECT m FROM MvResultado m WHERE m.resPorcentajepesooseo = :resPorcentajepesooseo"),
   @NamedQuery(name = "MvResultado.findByResPorcentajepesoresidual", query = "SELECT m FROM MvResultado m WHERE m.resPorcentajepesoresidual = :resPorcentajepesoresidual"),
   @NamedQuery(name = "MvResultado.findByResPorcentajepesomuscular", query = "SELECT m FROM MvResultado m WHERE m.resPorcentajepesomuscular = :resPorcentajepesomuscular"),
   @NamedQuery(name = "MvResultado.findByResQuemacaloriassemana", query = "SELECT m FROM MvResultado m WHERE m.resQuemacaloriassemana = :resQuemacaloriassemana"),
   @NamedQuery(name = "MvResultado.findByResRangosfreccardquemagrasamax", query = "SELECT m FROM MvResultado m WHERE m.resRangosfreccardquemagrasamax = :resRangosfreccardquemagrasamax"),
   @NamedQuery(name = "MvResultado.findByResRelacioncinturacadera", query = "SELECT m FROM MvResultado m WHERE m.resRelacioncinturacadera = :resRelacioncinturacadera"),
   @NamedQuery(name = "MvResultado.findByResSemanaprograma", query = "SELECT m FROM MvResultado m WHERE m.resSemanaprograma = :resSemanaprograma"),
   @NamedQuery(name = "MvResultado.findByResSesionessemana", query = "SELECT m FROM MvResultado m WHERE m.resSesionessemana = :resSesionessemana"),
   @NamedQuery(name = "MvResultado.findByResSumatoria6pliegues", query = "SELECT m FROM MvResultado m WHERE m.resSumatoria6pliegues = :resSumatoria6pliegues"),
   @NamedQuery(name = "MvResultado.findByResTmb1hora", query = "SELECT m FROM MvResultado m WHERE m.resTmb1hora = :resTmb1hora"),
   @NamedQuery(name = "MvResultado.findByResTmb24horas", query = "SELECT m FROM MvResultado m WHERE m.resTmb24horas = :resTmb24horas"),
   @NamedQuery(name = "MvResultado.findByResEstado", query = "SELECT m FROM MvResultado m WHERE m.resEstado = :resEstado"),
   @NamedQuery(name = "MvResultado.findByResContextura", query = "SELECT m FROM MvResultado m WHERE m.resContextura = :resContextura"),
   @NamedQuery(name = "MvResultado.findByResEnfermedadcoronaria", query = "SELECT m FROM MvResultado m WHERE m.resEnfermedadcoronaria = :resEnfermedadcoronaria"),
   @NamedQuery(name = "MvResultado.findByResHidratacion", query = "SELECT m FROM MvResultado m WHERE m.resHidratacion = :resHidratacion"),
   @NamedQuery(name = "MvResultado.findByResVo2maxextimado", query = "SELECT m FROM MvResultado m WHERE m.resVo2maxextimado = :resVo2maxextimado"),
   @NamedQuery(name = "MvResultado.findByResCapacidadfuncional", query = "SELECT m FROM MvResultado m WHERE m.resCapacidadfuncional = :resCapacidadfuncional"),
   @NamedQuery(name = "MvResultado.findByResRangosfreccardquemagrasamin", query = "SELECT m FROM MvResultado m WHERE m.resRangosfreccardquemagrasamin = :resRangosfreccardquemagrasamin"),
   @NamedQuery(name = "MvResultado.findByResQuemacaloriassesion", query = "SELECT m FROM MvResultado m WHERE m.resQuemacaloriassesion = :resQuemacaloriassesion"),
   @NamedQuery(name = "MvResultado.findByResDeficitaerobico", query = "SELECT m FROM MvResultado m WHERE m.resDeficitaerobico = :resDeficitaerobico")})
public class MvResultado implements Serializable {

   private static final long serialVersionUID = 1L;
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Basic(optional = false)
   @Column(name = "RES_ID")
   private Integer resId;
   @Basic(optional = false)
   @NotNull
   @Column(name = "VAL_ID")
   private int valId;
   @Column(name = "USU_IDENTIFICACION")
   private BigInteger usuIdentificacion;
   // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
   @Column(name = "RES_CALORIASREQUERIDADIETA")
   private Double resCaloriasrequeridadieta;
   @Column(name = "RES_ECTOMORFIA")
   private Double resEctomorfia;
   @Column(name = "RES_EJEX")
   private Double resEjex;
   @Column(name = "RES_EJEY")
   private Double resEjey;
   @Column(name = "RES_ENDOMORFIA")
   private Double resEndomorfia;
   @Column(name = "RES_GRAMOPROTEINADIA")
   private Double resGramoproteinadia;
   @Column(name = "RES_MASACORPORALMAGRA")
   private Double resMasacorporalmagra;
   @Column(name = "RES_MASACORPORALMAGRAIDEAL")
   private Double resMasacorporalmagraideal;
   @Column(name = "RES_MESOMORFIA")
   private Double resMesomorfia;
   @Column(name = "RES_PESOANTERIOR")
   private Double resPesoanterior;
   @Column(name = "RES_PESOGRASO")
   private Double resPesograso;
   @Column(name = "RES_PESOGRASOIDEAL")
   private Double resPesograsoideal;
   @Column(name = "RES_PESOIDEAL")
   private Double resPesoideal;
   @Column(name = "RES_PESOIDEALINFERIOR")
   private Double resPesoidealinferior;
   @Column(name = "RES_PESOIDEALLIMITE")
   private Double resPesoideallimite;
   @Column(name = "RES_PESOMUSCULAR")
   private Double resPesomuscular;
   @Size(max = 2)
   @Column(name = "RES_PESOMUSCULARANTERIOR")
   private String resPesomuscularanterior;
   @Column(name = "RES_PESOMUSCULARIDEAL")
   private Double resPesomuscularideal;
   @Column(name = "RES_PESOOSEO")
   private Double resPesooseo;
   @Column(name = "RES_PESORESIDUAL")
   private Double resPesoresidual;
   @Column(name = "RES_PESOTOTAL")
   private Double resPesototal;
   @Column(name = "RES_PORCENTAJEGRASAANTERIOR")
   private Double resPorcentajegrasaanterior;
   @Column(name = "RES_PORCENTAJEGRASACORPORALTOTAL")
   private Double resPorcentajegrasacorporaltotal;
   @Column(name = "RES_PORCENTAJEGRASAIDEAL")
   private Double resPorcentajegrasaideal;
   @Column(name = "RES_PORCENTAJEOSEOIDEAL")
   private Double resPorcentajeoseoideal;
   @Column(name = "RES_PORCENTAJEPESOMUSCULARIDEAL")
   private Double resPorcentajepesomuscularideal;
   @Column(name = "RES_PORCENTAJEPESOOSEO")
   private Double resPorcentajepesooseo;
   @Column(name = "RES_PORCENTAJEPESORESIDUAL")
   private Double resPorcentajepesoresidual;
   @Column(name = "RES_PORCENTAJEPESOMUSCULAR")
   private Double resPorcentajepesomuscular;
   @Column(name = "RES_QUEMACALORIASSEMANA")
   private Double resQuemacaloriassemana;
   @Column(name = "RES_RANGOSFRECCARDQUEMAGRASAMAX")
   private Double resRangosfreccardquemagrasamax;
   @Column(name = "RES_RELACIONCINTURACADERA")
   private Double resRelacioncinturacadera;
   @Column(name = "RES_SEMANAPROGRAMA")
   private Double resSemanaprograma;
   @Column(name = "RES_SESIONESSEMANA")
   private Double resSesionessemana;
   @Column(name = "RES_SUMATORIA6PLIEGUES")
   private Double resSumatoria6pliegues;
   @Column(name = "RES_TMB1HORA")
   private Double resTmb1hora;
   @Column(name = "RES_TMB24HORAS")
   private Double resTmb24horas;
   @Size(max = 20)
   @Column(name = "RES_ESTADO")
   private String resEstado;
   @Size(max = 20)
   @Column(name = "RES_CONTEXTURA")
   private String resContextura;
   @Size(max = 20)
   @Column(name = "RES_ENFERMEDADCORONARIA")
   private String resEnfermedadcoronaria;
   @Size(max = 20)
   @Column(name = "RES_HIDRATACION")
   private String resHidratacion;
   @Column(name = "RES_VO2MAXEXTIMADO")
   private Double resVo2maxextimado;
   @Size(max = 20)
   @Column(name = "RES_CAPACIDADFUNCIONAL")
   private String resCapacidadfuncional;
   @Column(name = "RES_RANGOSFRECCARDQUEMAGRASAMIN")
   private Double resRangosfreccardquemagrasamin;
   @Lob
   @Size(max = 65535)
   @Column(name = "RES_RECOMENDACIONES")
   private String resRecomendaciones;
   @Column(name = "RES_QUEMACALORIASSESION")
   private Double resQuemacaloriassesion;
   @Column(name = "RES_DEFICITAEROBICO")
   private Double resDeficitaerobico;

   public MvResultado() {
   }

   public MvResultado(Integer resId) {
      this.resId = resId;
   }

   public MvResultado(Integer resId, int valId) {
      this.resId = resId;
      this.valId = valId;
   }

   public Integer getResId() {
      return resId;
   }

   public void setResId(Integer resId) {
      this.resId = resId;
   }

   public int getValId() {
      return valId;
   }

   public void setValId(int valId) {
      this.valId = valId;
   }

   public BigInteger getUsuIdentificacion() {
      return usuIdentificacion;
   }

   public void setUsuIdentificacion(BigInteger usuIdentificacion) {
      this.usuIdentificacion = usuIdentificacion;
   }

   public Double getResCaloriasrequeridadieta() {
      return resCaloriasrequeridadieta;
   }

   public void setResCaloriasrequeridadieta(Double resCaloriasrequeridadieta) {
      this.resCaloriasrequeridadieta = resCaloriasrequeridadieta;
   }

   public Double getResEctomorfia() {
      return resEctomorfia;
   }

   public void setResEctomorfia(Double resEctomorfia) {
      this.resEctomorfia = resEctomorfia;
   }

   public Double getResEjex() {
      return resEjex;
   }

   public void setResEjex(Double resEjex) {
      this.resEjex = resEjex;
   }

   public Double getResEjey() {
      return resEjey;
   }

   public void setResEjey(Double resEjey) {
      this.resEjey = resEjey;
   }

   public Double getResEndomorfia() {
      return resEndomorfia;
   }

   public void setResEndomorfia(Double resEndomorfia) {
      this.resEndomorfia = resEndomorfia;
   }

   public Double getResGramoproteinadia() {
      return resGramoproteinadia;
   }

   public void setResGramoproteinadia(Double resGramoproteinadia) {
      this.resGramoproteinadia = resGramoproteinadia;
   }

   public Double getResMasacorporalmagra() {
      return resMasacorporalmagra;
   }

   public void setResMasacorporalmagra(Double resMasacorporalmagra) {
      this.resMasacorporalmagra = resMasacorporalmagra;
   }

   public Double getResMasacorporalmagraideal() {
      return resMasacorporalmagraideal;
   }

   public void setResMasacorporalmagraideal(Double resMasacorporalmagraideal) {
      this.resMasacorporalmagraideal = resMasacorporalmagraideal;
   }

   public Double getResMesomorfia() {
      return resMesomorfia;
   }

   public void setResMesomorfia(Double resMesomorfia) {
      this.resMesomorfia = resMesomorfia;
   }

   public Double getResPesoanterior() {
      return resPesoanterior;
   }

   public void setResPesoanterior(Double resPesoanterior) {
      this.resPesoanterior = resPesoanterior;
   }

   public Double getResPesograso() {
      return resPesograso;
   }

   public void setResPesograso(Double resPesograso) {
      this.resPesograso = resPesograso;
   }

   public Double getResPesograsoideal() {
      return resPesograsoideal;
   }

   public void setResPesograsoideal(Double resPesograsoideal) {
      this.resPesograsoideal = resPesograsoideal;
   }

   public Double getResPesoideal() {
      return resPesoideal;
   }

   public void setResPesoideal(Double resPesoideal) {
      this.resPesoideal = resPesoideal;
   }

   public Double getResPesoidealinferior() {
      return resPesoidealinferior;
   }

   public void setResPesoidealinferior(Double resPesoidealinferior) {
      this.resPesoidealinferior = resPesoidealinferior;
   }

   public Double getResPesoideallimite() {
      return resPesoideallimite;
   }

   public void setResPesoideallimite(Double resPesoideallimite) {
      this.resPesoideallimite = resPesoideallimite;
   }

   public Double getResPesomuscular() {
      return resPesomuscular;
   }

   public void setResPesomuscular(Double resPesomuscular) {
      this.resPesomuscular = resPesomuscular;
   }

   public String getResPesomuscularanterior() {
      return resPesomuscularanterior;
   }

   public void setResPesomuscularanterior(String resPesomuscularanterior) {
      this.resPesomuscularanterior = resPesomuscularanterior;
   }

   public Double getResPesomuscularideal() {
      return resPesomuscularideal;
   }

   public void setResPesomuscularideal(Double resPesomuscularideal) {
      this.resPesomuscularideal = resPesomuscularideal;
   }

   public Double getResPesooseo() {
      return resPesooseo;
   }

   public void setResPesooseo(Double resPesooseo) {
      this.resPesooseo = resPesooseo;
   }

   public Double getResPesoresidual() {
      return resPesoresidual;
   }

   public void setResPesoresidual(Double resPesoresidual) {
      this.resPesoresidual = resPesoresidual;
   }

   public Double getResPesototal() {
      return resPesototal;
   }

   public void setResPesototal(Double resPesototal) {
      this.resPesototal = resPesototal;
   }

   public Double getResPorcentajegrasaanterior() {
      return resPorcentajegrasaanterior;
   }

   public void setResPorcentajegrasaanterior(Double resPorcentajegrasaanterior) {
      this.resPorcentajegrasaanterior = resPorcentajegrasaanterior;
   }

   public Double getResPorcentajegrasacorporaltotal() {
      return resPorcentajegrasacorporaltotal;
   }

   public void setResPorcentajegrasacorporaltotal(Double resPorcentajegrasacorporaltotal) {
      this.resPorcentajegrasacorporaltotal = resPorcentajegrasacorporaltotal;
   }

   public Double getResPorcentajegrasaideal() {
      return resPorcentajegrasaideal;
   }

   public void setResPorcentajegrasaideal(Double resPorcentajegrasaideal) {
      this.resPorcentajegrasaideal = resPorcentajegrasaideal;
   }

   public Double getResPorcentajeoseoideal() {
      return resPorcentajeoseoideal;
   }

   public void setResPorcentajeoseoideal(Double resPorcentajeoseoideal) {
      this.resPorcentajeoseoideal = resPorcentajeoseoideal;
   }

   public Double getResPorcentajepesomuscularideal() {
      return resPorcentajepesomuscularideal;
   }

   public void setResPorcentajepesomuscularideal(Double resPorcentajepesomuscularideal) {
      this.resPorcentajepesomuscularideal = resPorcentajepesomuscularideal;
   }

   public Double getResPorcentajepesooseo() {
      return resPorcentajepesooseo;
   }

   public void setResPorcentajepesooseo(Double resPorcentajepesooseo) {
      this.resPorcentajepesooseo = resPorcentajepesooseo;
   }

   public Double getResPorcentajepesoresidual() {
      return resPorcentajepesoresidual;
   }

   public void setResPorcentajepesoresidual(Double resPorcentajepesoresidual) {
      this.resPorcentajepesoresidual = resPorcentajepesoresidual;
   }

   public Double getResPorcentajepesomuscular() {
      return resPorcentajepesomuscular;
   }

   public void setResPorcentajepesomuscular(Double resPorcentajepesomuscular) {
      this.resPorcentajepesomuscular = resPorcentajepesomuscular;
   }

   public Double getResQuemacaloriassemana() {
      return resQuemacaloriassemana;
   }

   public void setResQuemacaloriassemana(Double resQuemacaloriassemana) {
      this.resQuemacaloriassemana = resQuemacaloriassemana;
   }

   public Double getResRangosfreccardquemagrasamax() {
      return resRangosfreccardquemagrasamax;
   }

   public void setResRangosfreccardquemagrasamax(Double resRangosfreccardquemagrasamax) {
      this.resRangosfreccardquemagrasamax = resRangosfreccardquemagrasamax;
   }

   public Double getResRelacioncinturacadera() {
      return resRelacioncinturacadera;
   }

   public void setResRelacioncinturacadera(Double resRelacioncinturacadera) {
      this.resRelacioncinturacadera = resRelacioncinturacadera;
   }

   public Double getResSemanaprograma() {
      return resSemanaprograma;
   }

   public void setResSemanaprograma(Double resSemanaprograma) {
      this.resSemanaprograma = resSemanaprograma;
   }

   public Double getResSesionessemana() {
      return resSesionessemana;
   }

   public void setResSesionessemana(Double resSesionessemana) {
      this.resSesionessemana = resSesionessemana;
   }

   public Double getResSumatoria6pliegues() {
      return resSumatoria6pliegues;
   }

   public void setResSumatoria6pliegues(Double resSumatoria6pliegues) {
      this.resSumatoria6pliegues = resSumatoria6pliegues;
   }

   public Double getResTmb1hora() {
      return resTmb1hora;
   }

   public void setResTmb1hora(Double resTmb1hora) {
      this.resTmb1hora = resTmb1hora;
   }

   public Double getResTmb24horas() {
      return resTmb24horas;
   }

   public void setResTmb24horas(Double resTmb24horas) {
      this.resTmb24horas = resTmb24horas;
   }

   public String getResEstado() {
      return resEstado;
   }

   public void setResEstado(String resEstado) {
      this.resEstado = resEstado;
   }

   public String getResContextura() {
      return resContextura;
   }

   public void setResContextura(String resContextura) {
      this.resContextura = resContextura;
   }

   public String getResEnfermedadcoronaria() {
      return resEnfermedadcoronaria;
   }

   public void setResEnfermedadcoronaria(String resEnfermedadcoronaria) {
      this.resEnfermedadcoronaria = resEnfermedadcoronaria;
   }

   public String getResHidratacion() {
      return resHidratacion;
   }

   public void setResHidratacion(String resHidratacion) {
      this.resHidratacion = resHidratacion;
   }

   public Double getResVo2maxextimado() {
      return resVo2maxextimado;
   }

   public void setResVo2maxextimado(Double resVo2maxextimado) {
      this.resVo2maxextimado = resVo2maxextimado;
   }

   public String getResCapacidadfuncional() {
      return resCapacidadfuncional;
   }

   public void setResCapacidadfuncional(String resCapacidadfuncional) {
      this.resCapacidadfuncional = resCapacidadfuncional;
   }

   public Double getResRangosfreccardquemagrasamin() {
      return resRangosfreccardquemagrasamin;
   }

   public void setResRangosfreccardquemagrasamin(Double resRangosfreccardquemagrasamin) {
      this.resRangosfreccardquemagrasamin = resRangosfreccardquemagrasamin;
   }

   public String getResRecomendaciones() {
      return resRecomendaciones;
   }

   public void setResRecomendaciones(String resRecomendaciones) {
      this.resRecomendaciones = resRecomendaciones;
   }

   public Double getResQuemacaloriassesion() {
      return resQuemacaloriassesion;
   }

   public void setResQuemacaloriassesion(Double resQuemacaloriassesion) {
      this.resQuemacaloriassesion = resQuemacaloriassesion;
   }

   public Double getResDeficitaerobico() {
      return resDeficitaerobico;
   }

   public void setResDeficitaerobico(Double resDeficitaerobico) {
      this.resDeficitaerobico = resDeficitaerobico;
   }

   @Override
   public int hashCode() {
      int hash = 0;
      hash += (resId != null ? resId.hashCode() : 0);
      return hash;
   }

   @Override
   public boolean equals(Object object) {
      // TODO: Warning - this method won't work in the case the id fields are not set
      if (!(object instanceof MvResultado)) {
         return false;
      }
      MvResultado other = (MvResultado) object;
      if ((this.resId == null && other.resId != null) || (this.resId != null && !this.resId.equals(other.resId))) {
         return false;
      }
      return true;
   }

   @Override
   public String toString() {
      return "co.edu.unicauca.gymadmdoc.entities.MvResultado[ resId=" + resId + " ]";
   }
   
}
