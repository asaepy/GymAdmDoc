/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicauca.gymadmdoc.managedbeans;

import co.edu.unicauca.gymadmdoc.entities.MrecRecaudo;
import co.edu.unicauca.gymadmdoc.entities.MrecReciboPago;
import co.edu.unicauca.gymadmdoc.entities.MuUsuario;
import co.edu.unicauca.gymadmdoc.services.DateService;
import co.edu.unicauca.gymadmdoc.services.RecaudoService;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author Ricardo
 */
@Named(value = "recaudosController")
@SessionScoped
public class RecaudosController implements Serializable {

   // <editor-fold defaultstate="collapsed" desc="Atributos para el manejo de la fecha">

   private int year;
   public int getYear() {
      return year;
   }
   public void setYear(int year) {
      this.year = year;
   }
   private String month;
   public String getMonth() {
      return month;
   }
   public void setMonth(String month) {
      this.month = month;
   }
   private int day;
   public int getDay() {
      return day;
   }
   public void setDay(int day) {
      this.day = day;
   }
   private List<Integer> years;
   public List<Integer> getYears() {
      return years;
   }
   private List<String> months;
   public List<String> getMonths() {
      return months;
   }

   @Inject
   private DateService service_date;
   public void setService_date(DateService service_date) {
      this.service_date = service_date;
   }
   
   // </editor-fold>
   
   // <editor-fold defaultstate="collapsed" desc="Atributos para el manejo de los recaudos">
   
   MrecRecaudo recaudoSelected;
   public MrecRecaudo getRecaudoSelected() {
      return recaudoSelected;
   }
   public void setRecaudoSelected(MrecRecaudo recaudoSelected) {
      this.usuarioInfo = null;
      this.reciboInfo = null;
      this.recaudoSelected = recaudoSelected;
      if(recaudoSelected.getUsuario()!=null)
         this.usuarioInfo = recaudoSelected.getUsuario();
      if(recaudoSelected.getRecibo()!=null)
         this.reciboInfo = recaudoSelected.getRecibo();
   }
   
   List<MrecRecaudo> recaudos;
   public List<MrecRecaudo> getRecaudos() {
      return recaudos;
   }
   
   List<MrecRecaudo> recaudosFiltered;
   public List<MrecRecaudo> getRecaudosFiltered() {
      return recaudosFiltered;
   }
   public void setRecaudosFiltered(List<MrecRecaudo> recaudosFiltered) {
      this.recaudosFiltered = recaudosFiltered;
   }
   
   private MuUsuario usuarioInfo;
   public MuUsuario getUsuarioInfo() {
      return usuarioInfo;
   }
   
   private MrecReciboPago reciboInfo;
   public MrecReciboPago getReciboInfo() {
      return reciboInfo;
   }
   
   @Inject
   private RecaudoService service_recaudo;
   public void setService_recaudo(RecaudoService service_recaudo) {
      this.service_recaudo = service_recaudo;
   }
   
   
   // </editor-fold>
   
   // <editor-fold defaultstate="collapsed" desc="Atributos para el manejo del Registro de recaudo">
   
   private long idUsuario;
   public long getIdUsuario() {
      return idUsuario;
   }
   public void setIdUsuario(long idUsuario) {
      this.idUsuario = idUsuario;
   }
   
   private String nombreUsuario;
   public String getNombreUsuario() {
      return nombreUsuario;
   }

   private String ocupacionUsuario;
   public String getOcupacionUsuario() {
      return ocupacionUsuario;
   }
   
   private long referencia;
   public long getReferencia() {
      return referencia;
   }
   public void setReferencia(long referencia) {
      this.referencia = referencia;
   }
   
   private Date fechaEspedicion;
   public Date getFechaEspedicion() {
      return fechaEspedicion;
   }
   public void setFechaEspedicion(Date fechaEspedicion) {
      this.fechaEspedicion = fechaEspedicion;
   }
   
   private int sesiones;
   public int getSesiones() {
      return sesiones;
   }
   public void setSesiones(int sesiones) {
      this.sesiones = sesiones;
   }
   
   
   private boolean mensualidad;
   public boolean isMensualidad() {
      return mensualidad;
   }
   public void setMensualidad(boolean mensualidad) {
      this.mensualidad = mensualidad;
   }
   
   // </editor-fold>
   
   public RecaudosController(){}
   
   @PostConstruct
   public void init(){
      //updateDatePicker();
      Calendar c = Calendar.getInstance();
      this.year = c.get(Calendar.YEAR);
      this.years = service_date.getYears();
      this.months = service_date.getMonths(year);
      this.month = months.get(0);
      this.day = c.get(Calendar.DATE);
      loadTableInfo();
      loadInfoRecibo();
   }
   
   public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
   
   public void onYearChange(){
      this.months = service_date.getMonths(year);
      this.month = months.get(0);
      loadTableInfo();
   }
   
   public void onMonthChange(){
      loadTableInfo();
   }
   
   public void deleteRecaudo(){
      //Logica para eliminar registro de la base de datos
      service_recaudo.eliminarRecaudo(recaudoSelected);
      addMessage("Correcto", "El recaudo se eliminó de manera correcta.");
   }
   
   public void handleKeyEvent(){
      this.nombreUsuario = service_recaudo.getNombreUsuario(idUsuario);
   }
   
   public void registrarRecaudo(){
      MrecReciboPago rp = buildRecibo();
      service_recaudo.registrarRecaudo(idUsuario, rp);
   }

   public void registrarPago(){
      service_recaudo.registrarPago(recaudoSelected);
      loadTableInfo();
      addMessage("Correcto", "El pago se registró de manera correcta.");
   }
   
   public void generarRecibo(){
      MrecReciboPago rp = buildRecibo();
      service_recaudo.generarRecibo(recaudoSelected, rp);
      loadTableInfo();
      addMessage("Correcto", "El recibo se generó de manera correcta.");
   }
   
   public void prepareRecaudoView(){
      if(recaudoSelected.getUsuario()!=null)
         this.usuarioInfo = recaudoSelected.getUsuario();
      if(recaudoSelected.getRecibo()!=null)
         this.reciboInfo = recaudoSelected.getRecibo();
   }
   
   private void loadTableInfo(){
      try{
         recaudos = service_recaudo.getRecaudos(year, month);
      }catch(ParseException e){}
   }
   
   public void loadInfoRecibo(){
      this.sesiones = 0;
      this.fechaEspedicion = new Date();
      this.mensualidad = true;
   }

   private MrecReciboPago buildRecibo(){
      MrecReciboPago rp = new MrecReciboPago();
      rp.setRpagReferencia(referencia);
      rp.setRpagFechaExpedicion(fechaEspedicion);
      rp.setRpagNumeroSesiones(sesiones);
      rp.setRpagMensualidad(mensualidad);
      long total = 2000 * sesiones;
      if(mensualidad){
         total+=28000;
      }
      rp.setRpagTotalRecibo(total);
      return rp;
   }
}

