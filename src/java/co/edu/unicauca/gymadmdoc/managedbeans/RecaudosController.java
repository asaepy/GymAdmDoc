/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicauca.gymadmdoc.managedbeans;

import co.edu.unicauca.gymadmdoc.services.DateService;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedProperty;
import javax.inject.Inject;

/**
 *
 * @author Ricardo
 */
@Named(value = "recaudosController")
@SessionScoped
public class RecaudosController implements Serializable {

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
      
   @PostConstruct
   public void init(){
      //updateDatePicker();
      Calendar c = Calendar.getInstance();
      this.year = c.get(Calendar.YEAR);
      this.years = service_date.getYears();
      this.months = service_date.getMonths(year);
      this.month = months.get(0);
   }
   
   public void onYearChange(){
      this.months = service_date.getMonths(year);
      this.month = months.get(0);
   }
}

