/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicauca.gymadmdoc.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Ricardo
 */
public class MrecRecaudo {
   
   SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy");
   
   private long id;
   private MuUsuario usuario;
   private String estado;
   private Date fechaLimite;
   private String strFechaLimite;
   private MrecReciboPago recibo;

   public MrecRecaudo() {
   }

   
   public MrecRecaudo(long id, MuUsuario usuario, String estado, Date fechaLimite, MrecReciboPago recibo) {
      this.id = id;
      this.usuario = usuario;
      this.estado = estado;
      this.fechaLimite = fechaLimite;
      this.strFechaLimite = formateador.format(fechaLimite);
      this.recibo = recibo;
   }

   public long getId() {
      return id;
   }

   public void setId(long id) {
      this.id = id;
   }

   public MuUsuario getUsuario() {
      return usuario;
   }

   public void setUsuario(MuUsuario usuario) {
      this.usuario = usuario;
   }

   public String getEstado() {
      return estado;
   }

   public void setEstado(String estado) {
      this.estado = estado;
   }

   public Date getFechaLimite() {
      return fechaLimite;
   }

   public void setFechaLimite(Date fechaLimite) {
      this.fechaLimite = fechaLimite;
      this.strFechaLimite = formateador.format(fechaLimite);
   }

   public MrecReciboPago getRecibo() {
      return recibo;
   }

   public void setRecibo(MrecReciboPago recibo) {
      this.recibo = recibo;
   }

   public String getStrFechaLimite() {
      return strFechaLimite;
   }
}