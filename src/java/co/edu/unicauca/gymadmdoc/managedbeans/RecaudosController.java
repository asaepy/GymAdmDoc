/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicauca.gymadmdoc.managedbeans;

import co.edu.unicauca.gymadmdoc.entities.MrecRecaudo;
import co.edu.unicauca.gymadmdoc.services.DateService;
import co.edu.unicauca.gymadmdoc.services.RecaudoService;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.text.ParseException;
import java.util.Calendar;
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
      this.recaudoSelected = recaudoSelected;
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
   
   @Inject
   private RecaudoService service_recaudo;
   public void setService_recaudo(RecaudoService service_recaudo) {
      this.service_recaudo = service_recaudo;
   }
   
   
   // </editor-fold>
   
   @PostConstruct
   public void init(){
      //updateDatePicker();
      Calendar c = Calendar.getInstance();
      this.year = c.get(Calendar.YEAR);
      this.years = service_date.getYears();
      this.months = service_date.getMonths(year);
      this.month = months.get(0);
      this.day = c.get(Calendar.DATE);
      try{
         recaudos = service_recaudo.getRecaudos(year, month);
      }catch(ParseException e){
         
      }
   }
   
   public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
   
   public void onYearChange(){
      this.months = service_date.getMonths(year);
      this.month = months.get(0);
   }
   
   public void deleteRecaudo(){
      //Logica para eliminar registro de la base de datos
      int tam = recaudos.size();
      System.out.println(recaudoSelected.getFechaLimite());
      for(int i=0; i<recaudos.size(); i++){
         if(recaudos.get(i).getId() == recaudoSelected.getId()){
            recaudos.remove(i);
            break;
         }
      }
      if(recaudos.size() == (tam-1)){
         addMessage("Correcto", "El recaudo se elimino de manera correcta.");
      }else{
         addMessage("Error", "El recaudo no se pudo eliminar.");
      }
      
   }
}

