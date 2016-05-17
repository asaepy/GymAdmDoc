/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicauca.gymadmdoc.services;

import co.edu.unicauca.gymadmdoc.entities.MrecInformacionRecaudo;
import co.edu.unicauca.gymadmdoc.entities.MrecRecaudo;
import co.edu.unicauca.gymadmdoc.entities.MrecReciboPago;
import co.edu.unicauca.gymadmdoc.entities.MuOcupacion;
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
import co.edu.unicauca.gymadmdoc.sessionbeans.MuOcupacionFacade;
import co.edu.unicauca.gymadmdoc.sessionbeans.MuUsuarioFacade;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.ejb.EJBException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.primefaces.model.chart.DonutChartModel;

/**
 *
 * @author Ricardo
 */
@Named(value = "recaudoService")
@ApplicationScoped
public class RecaudoService {
   
   @PersistenceContext(unitName = "Gym_Adm_DocPU")
   private EntityManager em;
   @EJB
   private MrecInformacionRecaudoFacade ejbInfoRecaudo;
   @EJB
   private MrecReciboPagoFacade ejbReciboPago;
   @EJB
   private MuUsuarioFacade ejbUsuario;
   @EJB
   private MuOcupacionFacade ejbOcupacion;
   
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

   public List<String> getOcupaciones(){
      List<String> data = new ArrayList<>();
      
      List<MuOcupacion> rta = ejbOcupacion.findAll();
      rta.stream().forEach((o) -> {
         data.add(o.getOcuDescripcion());
      });
      
      return data;
   }
   
   public DonutChartModel getDonut(Date ini, Date fin, boolean mensualidad, boolean sesiones,
                                   String[] ocupaciones){
      DonutChartModel donut = new DonutChartModel();
      
      Map<String, Number> hombres = new LinkedHashMap<>();
      Map<String, Number> mujeres = new LinkedHashMap<>();
      
      for (String o : ocupaciones) {
         
         String query = "SELECT u.usu_genero, COUNT(rp.rpag_referencia) "
                     + "FROM mrec_informacion_recaudo AS ir, mrec_recibo_pago AS rp, "
                          + "mu_usuario AS u, mu_ocupacion AS o "
                     + "WHERE ir.rpag_referencia = rp.rpag_referencia AND "
                           + "ir.usu_identificacion = u.usu_identificacion AND "
                           + "u.ocu_id = o.ocu_id AND o.ocu_descripcion = "+o
                    + " GROUP BY u.usu_genero "
                     + "ORDER BY u.usu_genero ASC";

         List<Object[]> rta = em.createQuery(query).getResultList();
         mujeres.put(o, ((Number)rta.get(0)[1]).intValue());
         hombres.put(o, ((Number)rta.get(1)[1]).intValue());
         
      }
      donut.addCircle(mujeres);
      donut.addCircle(hombres);
      
      donut.setTitle("Donut Chart");
      donut.setLegendPosition("e");
      donut.setSliceMargin(5);
      donut.setShowDataLabels(true);
      donut.setDataFormat("value");
      
      return donut;
   }
   
}
