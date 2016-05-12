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
        this.ruta = "/moduloRutinas/nuevaRutina.xhtml";
    }

    public void goToUsuario() {
        this.ruta = "/administrador/mrec/main_recaudos.xhtml";
    }

    public void goToPrueba() {
        this.ruta = "/administrador/mu/prueba.xhtml";
    }

    public void goToRutinas() {
        this.ruta = "/moduloRutinas/nuevaRutina.xhtml";
    }
}
