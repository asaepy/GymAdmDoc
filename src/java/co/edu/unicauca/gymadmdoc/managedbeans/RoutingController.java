/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicauca.gymadmdoc.managedbeans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author Ricardo
 */
@Named(value = "routingController")
@SessionScoped
public class RoutingController implements Serializable {
   
   private String ruta;
   public String getRuta() {
      return ruta;
   }
   
   public RoutingController() {
      this.ruta = "/administrador/mrec/reporte_mensual.xhtml";
   }
   
   
   public void goToReporteMensualMREC(){
      this.ruta = "/administrador/mrec/reporte_mensual.xhtml";
   }
   
   public void goToNuevoRecaudoMREC(){
      this.ruta = "/administrador/mrec/nuevo_recaudo.xhtml";
   }
   
   public void goToEstadisticasMREC(){
      this.ruta = "/administrador/mrec/estadisticas.xhtml";
   }
}
