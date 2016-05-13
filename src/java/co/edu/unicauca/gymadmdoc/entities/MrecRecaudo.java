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
   private long usuario_id;
   private String estado;
   private Date fechaLimite;
   private String strFechaLimite;
   private MrecReciboPago recibo;

   public MrecRecaudo() {
   }

   
   public MrecRecaudo(long id, long usuario_id, String estado, Date fechaLimite, MrecReciboPago recibo) {
      this.id = id;
      this.usuario_id = usuario_id;
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

   public long getUsuario_id() {
      return usuario_id;
   }

   public void setUsuario_id(long usuario_id) {
      this.usuario_id = usuario_id;
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
