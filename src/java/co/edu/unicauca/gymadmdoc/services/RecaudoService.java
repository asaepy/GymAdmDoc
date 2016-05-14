/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicauca.gymadmdoc.services;

import co.edu.unicauca.gymadmdoc.entities.MrecRecaudo;
import co.edu.unicauca.gymadmdoc.entities.MrecReciboPago;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author Ricardo
 */
@Named(value = "recaudoService")
@ApplicationScoped
public class RecaudoService {
   
   public RecaudoService() {
   }
   
   public List<MrecRecaudo> getRecaudos(int year, String month) throws ParseException{
      List<MrecRecaudo> data = new ArrayList<>();
      
      //Logica para traer los datos desde la base de datos
      
      /*
      SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

      MrecReciboPago recibo1 = new MrecReciboPago((long) 263876324, format.parse("10-05-2016"), true, 3, 34000);
      MrecRecaudo r1 = new MrecRecaudo(1, 10661303, "Pagado", new Date(), recibo1);
      MrecRecaudo r2 = new MrecRecaudo(2, 34544458, "Sin recibo", format.parse("03-05-2016"), null);
      MrecReciboPago recibo2 = new MrecReciboPago((long) 912355321, format.parse("10-05-2016"), true, 3, 34000);
      MrecRecaudo r3 = new MrecRecaudo(3, 1061756381, "Pagado", format.parse("05-05-2016"), recibo2);
      MrecReciboPago recibo3 = new MrecReciboPago((long) 534878234, format.parse("11-05-2016"), true, 3, 34000);
      MrecRecaudo r4 = new MrecRecaudo(4, 1061755406, "Por pagar", format.parse("12-05-2016"), recibo3);

      data.add(r1);
      data.add(r2);
      data.add(r3);
      data.add(r4);
      */
      
      return data;
   }
}
