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
   @Basic(optional = false)
   @NotNull
   @Column(name = "RES_ID")
   private Integer resId;
   @Basic(optional = false)
   @NotNull
   @Column(name = "VAL_ID")
   private int valId;
   @Column(name = "RES_CALORIASREQUERIDADIETA")
   private Long resCaloriasrequeridadieta;
   @Column(name = "RES_ECTOMORFIA")
   private Long resEctomorfia;
   @Column(name = "RES_EJEX")
   private Long resEjex;
   @Column(name = "RES_EJEY")
   private Long resEjey;
   @Column(name = "RES_ENDOMORFIA")
   private Long resEndomorfia;
   @Column(name = "RES_GRAMOPROTEINADIA")
   private Long resGramoproteinadia;
   @Column(name = "RES_MASACORPORALMAGRA")
   private Long resMasacorporalmagra;
   @Column(name = "RES_MASACORPORALMAGRAIDEAL")
   private Long resMasacorporalmagraideal;
   @Column(name = "RES_MESOMORFIA")
   private Long resMesomorfia;
   @Size(max = 2)
   @Column(name = "RES_PESOANTERIOR")
   private String resPesoanterior;
   @Column(name = "RES_PESOGRASO")
   private Long resPesograso;
   @Column(name = "RES_PESOGRASOIDEAL")
   private Long resPesograsoideal;
   @Column(name = "RES_PESOIDEAL")
   private Long resPesoideal;
   @Column(name = "RES_PESOIDEALINFERIOR")
   private Long resPesoidealinferior;
   @Column(name = "RES_PESOIDEALLIMITE")
   private Long resPesoideallimite;
   @Column(name = "RES_PESOMUSCULAR")
   private Long resPesomuscular;
   @Size(max = 2)
   @Column(name = "RES_PESOMUSCULARANTERIOR")
   private String resPesomuscularanterior;
   @Column(name = "RES_PESOMUSCULARIDEAL")
   private Long resPesomuscularideal;
   @Column(name = "RES_PESOOSEO")
   private Long resPesooseo;
   @Column(name = "RES_PESORESIDUAL")
   private Long resPesoresidual;
   @Column(name = "RES_PESOTOTAL")
   private Long resPesototal;
   @Size(max = 2)
   @Column(name = "RES_PORCENTAJEGRASAANTERIOR")
   private String resPorcentajegrasaanterior;
   @Column(name = "RES_PORCENTAJEGRASACORPORALTOTAL")
   private Long resPorcentajegrasacorporaltotal;
   @Column(name = "RES_PORCENTAJEGRASAIDEAL")
   private Long resPorcentajegrasaideal;
   @Column(name = "RES_PORCENTAJEOSEOIDEAL")
   private Long resPorcentajeoseoideal;
   @Column(name = "RES_PORCENTAJEPESOMUSCULARIDEAL")
   private Long resPorcentajepesomuscularideal;
   @Column(name = "RES_PORCENTAJEPESOOSEO")
   private Long resPorcentajepesooseo;
   @Column(name = "RES_PORCENTAJEPESORESIDUAL")
   private Long resPorcentajepesoresidual;
   @Column(name = "RES_PORCENTAJEPESOMUSCULAR")
   private Long resPorcentajepesomuscular;
   @Column(name = "RES_QUEMACALORIASSEMANA")
   private Long resQuemacaloriassemana;
   @Column(name = "RES_RANGOSFRECCARDQUEMAGRASAMAX")
   private Long resRangosfreccardquemagrasamax;
   @Column(name = "RES_RELACIONCINTURACADERA")
   private Long resRelacioncinturacadera;
   @Column(name = "RES_SEMANAPROGRAMA")
   private Long resSemanaprograma;
   @Column(name = "RES_SESIONESSEMANA")
   private Long resSesionessemana;
   @Column(name = "RES_SUMATORIA6PLIEGUES")
   private Long resSumatoria6pliegues;
   @Column(name = "RES_TMB1HORA")
   private Long resTmb1hora;
   @Column(name = "RES_TMB24HORAS")
   private Long resTmb24horas;
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
   private Long resVo2maxextimado;
   @Size(max = 20)
   @Column(name = "RES_CAPACIDADFUNCIONAL")
   private String resCapacidadfuncional;
   @Column(name = "RES_RANGOSFRECCARDQUEMAGRASAMIN")
   private Long resRangosfreccardquemagrasamin;
   @Lob
   @Size(max = 65535)
   @Column(name = "RES_RECOMENDACIONES")
   private String resRecomendaciones;
   @Column(name = "RES_QUEMACALORIASSESION")
   private Long resQuemacaloriassesion;
   @Column(name = "RES_DEFICITAEROBICO")
   private Long resDeficitaerobico;

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

   public Long getResCaloriasrequeridadieta() {
      return resCaloriasrequeridadieta;
   }

   public void setResCaloriasrequeridadieta(Long resCaloriasrequeridadieta) {
      this.resCaloriasrequeridadieta = resCaloriasrequeridadieta;
   }

   public Long getResEctomorfia() {
      return resEctomorfia;
   }

   public void setResEctomorfia(Long resEctomorfia) {
      this.resEctomorfia = resEctomorfia;
   }

   public Long getResEjex() {
      return resEjex;
   }

   public void setResEjex(Long resEjex) {
      this.resEjex = resEjex;
   }

   public Long getResEjey() {
      return resEjey;
   }

   public void setResEjey(Long resEjey) {
      this.resEjey = resEjey;
   }

   public Long getResEndomorfia() {
      return resEndomorfia;
   }

   public void setResEndomorfia(Long resEndomorfia) {
      this.resEndomorfia = resEndomorfia;
   }

   public Long getResGramoproteinadia() {
      return resGramoproteinadia;
   }

   public void setResGramoproteinadia(Long resGramoproteinadia) {
      this.resGramoproteinadia = resGramoproteinadia;
   }

   public Long getResMasacorporalmagra() {
      return resMasacorporalmagra;
   }

   public void setResMasacorporalmagra(Long resMasacorporalmagra) {
      this.resMasacorporalmagra = resMasacorporalmagra;
   }

   public Long getResMasacorporalmagraideal() {
      return resMasacorporalmagraideal;
   }

   public void setResMasacorporalmagraideal(Long resMasacorporalmagraideal) {
      this.resMasacorporalmagraideal = resMasacorporalmagraideal;
   }

   public Long getResMesomorfia() {
      return resMesomorfia;
   }

   public void setResMesomorfia(Long resMesomorfia) {
      this.resMesomorfia = resMesomorfia;
   }

   public String getResPesoanterior() {
      return resPesoanterior;
   }

   public void setResPesoanterior(String resPesoanterior) {
      this.resPesoanterior = resPesoanterior;
   }

   public Long getResPesograso() {
      return resPesograso;
   }

   public void setResPesograso(Long resPesograso) {
      this.resPesograso = resPesograso;
   }

   public Long getResPesograsoideal() {
      return resPesograsoideal;
   }

   public void setResPesograsoideal(Long resPesograsoideal) {
      this.resPesograsoideal = resPesograsoideal;
   }

   public Long getResPesoideal() {
      return resPesoideal;
   }

   public void setResPesoideal(Long resPesoideal) {
      this.resPesoideal = resPesoideal;
   }

   public Long getResPesoidealinferior() {
      return resPesoidealinferior;
   }

   public void setResPesoidealinferior(Long resPesoidealinferior) {
      this.resPesoidealinferior = resPesoidealinferior;
   }

   public Long getResPesoideallimite() {
      return resPesoideallimite;
   }

   public void setResPesoideallimite(Long resPesoideallimite) {
      this.resPesoideallimite = resPesoideallimite;
   }

   public Long getResPesomuscular() {
      return resPesomuscular;
   }

   public void setResPesomuscular(Long resPesomuscular) {
      this.resPesomuscular = resPesomuscular;
   }

   public String getResPesomuscularanterior() {
      return resPesomuscularanterior;
   }

   public void setResPesomuscularanterior(String resPesomuscularanterior) {
      this.resPesomuscularanterior = resPesomuscularanterior;
   }

   public Long getResPesomuscularideal() {
      return resPesomuscularideal;
   }

   public void setResPesomuscularideal(Long resPesomuscularideal) {
      this.resPesomuscularideal = resPesomuscularideal;
   }

   public Long getResPesooseo() {
      return resPesooseo;
   }

   public void setResPesooseo(Long resPesooseo) {
      this.resPesooseo = resPesooseo;
   }

   public Long getResPesoresidual() {
      return resPesoresidual;
   }

   public void setResPesoresidual(Long resPesoresidual) {
      this.resPesoresidual = resPesoresidual;
   }

   public Long getResPesototal() {
      return resPesototal;
   }

   public void setResPesototal(Long resPesototal) {
      this.resPesototal = resPesototal;
   }

   public String getResPorcentajegrasaanterior() {
      return resPorcentajegrasaanterior;
   }

   public void setResPorcentajegrasaanterior(String resPorcentajegrasaanterior) {
      this.resPorcentajegrasaanterior = resPorcentajegrasaanterior;
   }

   public Long getResPorcentajegrasacorporaltotal() {
      return resPorcentajegrasacorporaltotal;
   }

   public void setResPorcentajegrasacorporaltotal(Long resPorcentajegrasacorporaltotal) {
      this.resPorcentajegrasacorporaltotal = resPorcentajegrasacorporaltotal;
   }

   public Long getResPorcentajegrasaideal() {
      return resPorcentajegrasaideal;
   }

   public void setResPorcentajegrasaideal(Long resPorcentajegrasaideal) {
      this.resPorcentajegrasaideal = resPorcentajegrasaideal;
   }

   public Long getResPorcentajeoseoideal() {
      return resPorcentajeoseoideal;
   }

   public void setResPorcentajeoseoideal(Long resPorcentajeoseoideal) {
      this.resPorcentajeoseoideal = resPorcentajeoseoideal;
   }

   public Long getResPorcentajepesomuscularideal() {
      return resPorcentajepesomuscularideal;
   }

   public void setResPorcentajepesomuscularideal(Long resPorcentajepesomuscularideal) {
      this.resPorcentajepesomuscularideal = resPorcentajepesomuscularideal;
   }

   public Long getResPorcentajepesooseo() {
      return resPorcentajepesooseo;
   }

   public void setResPorcentajepesooseo(Long resPorcentajepesooseo) {
      this.resPorcentajepesooseo = resPorcentajepesooseo;
   }

   public Long getResPorcentajepesoresidual() {
      return resPorcentajepesoresidual;
   }

   public void setResPorcentajepesoresidual(Long resPorcentajepesoresidual) {
      this.resPorcentajepesoresidual = resPorcentajepesoresidual;
   }

   public Long getResPorcentajepesomuscular() {
      return resPorcentajepesomuscular;
   }

   public void setResPorcentajepesomuscular(Long resPorcentajepesomuscular) {
      this.resPorcentajepesomuscular = resPorcentajepesomuscular;
   }

   public Long getResQuemacaloriassemana() {
      return resQuemacaloriassemana;
   }

   public void setResQuemacaloriassemana(Long resQuemacaloriassemana) {
      this.resQuemacaloriassemana = resQuemacaloriassemana;
   }

   public Long getResRangosfreccardquemagrasamax() {
      return resRangosfreccardquemagrasamax;
   }

   public void setResRangosfreccardquemagrasamax(Long resRangosfreccardquemagrasamax) {
      this.resRangosfreccardquemagrasamax = resRangosfreccardquemagrasamax;
   }

   public Long getResRelacioncinturacadera() {
      return resRelacioncinturacadera;
   }

   public void setResRelacioncinturacadera(Long resRelacioncinturacadera) {
      this.resRelacioncinturacadera = resRelacioncinturacadera;
   }

   public Long getResSemanaprograma() {
      return resSemanaprograma;
   }

   public void setResSemanaprograma(Long resSemanaprograma) {
      this.resSemanaprograma = resSemanaprograma;
   }

   public Long getResSesionessemana() {
      return resSesionessemana;
   }

   public void setResSesionessemana(Long resSesionessemana) {
      this.resSesionessemana = resSesionessemana;
   }

   public Long getResSumatoria6pliegues() {
      return resSumatoria6pliegues;
   }

   public void setResSumatoria6pliegues(Long resSumatoria6pliegues) {
      this.resSumatoria6pliegues = resSumatoria6pliegues;
   }

   public Long getResTmb1hora() {
      return resTmb1hora;
   }

   public void setResTmb1hora(Long resTmb1hora) {
      this.resTmb1hora = resTmb1hora;
   }

   public Long getResTmb24horas() {
      return resTmb24horas;
   }

   public void setResTmb24horas(Long resTmb24horas) {
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

   public Long getResVo2maxextimado() {
      return resVo2maxextimado;
   }

   public void setResVo2maxextimado(Long resVo2maxextimado) {
      this.resVo2maxextimado = resVo2maxextimado;
   }

   public String getResCapacidadfuncional() {
      return resCapacidadfuncional;
   }

   public void setResCapacidadfuncional(String resCapacidadfuncional) {
      this.resCapacidadfuncional = resCapacidadfuncional;
   }

   public Long getResRangosfreccardquemagrasamin() {
      return resRangosfreccardquemagrasamin;
   }

   public void setResRangosfreccardquemagrasamin(Long resRangosfreccardquemagrasamin) {
      this.resRangosfreccardquemagrasamin = resRangosfreccardquemagrasamin;
   }

   public String getResRecomendaciones() {
      return resRecomendaciones;
   }

   public void setResRecomendaciones(String resRecomendaciones) {
      this.resRecomendaciones = resRecomendaciones;
   }

   public Long getResQuemacaloriassesion() {
      return resQuemacaloriassesion;
   }

   public void setResQuemacaloriassesion(Long resQuemacaloriassesion) {
      this.resQuemacaloriassesion = resQuemacaloriassesion;
   }

   public Long getResDeficitaerobico() {
      return resDeficitaerobico;
   }

   public void setResDeficitaerobico(Long resDeficitaerobico) {
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
