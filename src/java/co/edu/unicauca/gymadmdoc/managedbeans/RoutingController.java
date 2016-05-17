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
        this.ruta = "/administrador/mu/prueba.xhtml";
    }

    public void goToUsuario() {
        this.ruta = "/administrador/mrec/main_recaudos.xhtml";
    }

    public void goToPrueba() {
        this.ruta = "/administrador/mu/prueba.xhtml";
    }

    public void goToNuevaRutina() {
        this.ruta = "/moduloRutinas/nuevaRutina.xhtml";
    }
    
    public void goToUsuarios_Rutinas() {
        this.ruta = "/moduloRutinas/muUsuario/List.xhtml";
    }
    public void goToVerRutinasDeUsuario() {
        this.ruta = "/moduloRutinas/ListarRutinas.xhtml";
    }
    public void goToEjercicios() {
        this.ruta = "/moduloRutinas/mruEjercicio/ListEjercicio.xhtml";
    }
}
