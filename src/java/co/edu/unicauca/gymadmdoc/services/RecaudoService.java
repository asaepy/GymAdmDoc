/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicauca.gymadmdoc.services;

import co.edu.unicauca.gymadmdoc.entities.MrecInformacionRecaudo;
import co.edu.unicauca.gymadmdoc.entities.MrecRecaudo;
import co.edu.unicauca.gymadmdoc.entities.MrecReciboPago;
import co.edu.unicauca.gymadmdoc.entities.MuUsuario;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import co.edu.unicauca.gymadmdoc.sessionbeans.MrecInformacionRecaudoFacade;
import co.edu.unicauca.gymadmdoc.sessionbeans.MrecReciboPagoFacade;
import co.edu.unicauca.gymadmdoc.sessionbeans.MuUsuarioFacade;
import java.math.BigInteger;
import java.util.Calendar;
import javax.ejb.EJBException;

/**
 *
 * @author Ricardo
 */
@Named(value = "recaudoService")
@ApplicationScoped
public class RecaudoService {
   
   @EJB
   private MrecInformacionRecaudoFacade ejbInfoRecaudo;
   @EJB
   private MrecReciboPagoFacade ejbReciboPago;
   @EJB
   private MuUsuarioFacade ejbUsuario;
   
   String[] months = {"Enero", "Febrero", "Marzo", 
                      "Abril", "Mayo", "Junio",
                      "Julio", "Agosto", "Septiembre", 
                      "Octubre", "Noviembre", "Diciembre"};
   
   public RecaudoService() {
   }
   
   public List<MrecRecaudo> getRecaudos(int year, String month) throws ParseException{
      
      List<MrecInformacionRecaudo> lstInfoRecaudo = ejbInfoRecaudo.findAll();
      List<MrecRecaudo> data = new ArrayList<>();
      
      lstInfoRecaudo.stream().forEach((ir) -> {
         String m = months[ir.getIrecMes()-1];
         int y = ir.getIrecAnio();
         if(y == year && m.equals(month)){
            MrecRecaudo r = new MrecRecaudo();
            r.setId(ir.getIrecId());
            r.setAnio(ir.getIrecAnio());
            r.setMes(ir.getIrecMes());
            r.setFechaLimite(ir.getIrecFechaLimite());
            BigInteger ref = ir.getRpagReferencia();
            if(ref != null){
               MrecReciboPago rp = ejbReciboPago.find(ref.longValue());
               r.setRecibo(rp);
            }
            MuUsuario u = ejbUsuario.find(ir.getUsuIdentificacion());
            r.setUsuario(u);
            r.setEstado(ir.getIrecEstadoRecaudo());
            data.add(r);
         }
      });
      return data;
   }
   
   public String getNombreUsuario(long id){
      MuUsuario u = ejbUsuario.find(id);
      String result = "";
      if(u!=null){
         result += u.getUsuNombres()+" "+u.getUsuApellido1()+" "+u.getUsuApellido2();
      }
      return result;
   }
   
   public void registrarRecaudo(long usr, MrecReciboPago rp){
      ejbReciboPago.create(rp);
      MrecInformacionRecaudo ir = new MrecInformacionRecaudo();
      BigInteger ref = BigInteger.valueOf(rp.getRpagReferencia());
      ir.setRpagReferencia(ref);
      ir.setUsuIdentificacion(usr);
      ir.setIrecEstadoRecaudo("Por pagar");
      Calendar c = Calendar.getInstance();
      ir.setIrecMes(c.get(Calendar.MONTH)+1);
      ir.setIrecAnio(c.get(Calendar.YEAR));
      c.setTime(rp.getRpagFechaExpedicion());
      c.add(Calendar.DAY_OF_YEAR, 2);
      ir.setIrecFechaLimite(c.getTime());
      ejbInfoRecaudo.create(ir);
   }

   public void eliminarRecaudo(MrecRecaudo r){
      MrecReciboPago rp = r.getRecibo();
      ejbReciboPago.remove(rp);
      MrecInformacionRecaudo ir = putInfo(r);
      ejbInfoRecaudo.remove(ir);
   }
   
   public void registrarPago(MrecRecaudo r){
      MrecInformacionRecaudo ir = putInfo(r);
      ir.setIrecEstadoRecaudo("Pagado");
      ejbInfoRecaudo.edit(ir);
   }
   
   public void generarRecibo(MrecRecaudo r, MrecReciboPago rp){
      MrecInformacionRecaudo ir = putInfo(r);
      ejbReciboPago.create(rp);
      BigInteger ref = BigInteger.valueOf(rp.getRpagReferencia());
      ir.setRpagReferencia(ref);
      ir.setIrecEstadoRecaudo("Por pagar");
      ejbInfoRecaudo.edit(ir);
   }
  
   private MrecInformacionRecaudo putInfo(MrecRecaudo r){
      MrecInformacionRecaudo ir = new MrecInformacionRecaudo();
      ir.setIrecId(r.getId());
      if(r.getRecibo()!=null){
         BigInteger ref = BigInteger.valueOf(r.getRecibo().getRpagReferencia());
         ir.setRpagReferencia(ref);
      }
      ir.setUsuIdentificacion(r.getUsuario().getUsuIdentificacion());
      ir.setIrecEstadoRecaudo(r.getEstado());
      ir.setIrecAnio(r.getAnio());
      ir.setIrecMes(r.getMes());
      ir.setIrecFechaLimite(r.getFechaLimite());
      return ir;
   }

   
}
