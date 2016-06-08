/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicauca.gymadmdoc.managedbeans;

import com.unicauca.gymadmdoc.entities.MuAntecedenteSalud;
import com.unicauca.gymadmdoc.entities.MuDiagnosticoMedico;
import com.unicauca.gymadmdoc.entities.MuExamenFisico;
import com.unicauca.gymadmdoc.entities.MuUsuario;
import com.unicauca.gymadmdoc.sessionbeans.MuExamenFisicoFacade;
import com.unicauca.gymadmdoc.sessionbeans.MuUsuarioFacade;
import com.unicauca.gymadmdoc.sessionbeans.MuAntecedenteSaludFacade;
import com.unicauca.gymadmdoc.sessionbeans.MuDiagnosticoMedicoFacade;
import com.unicauca.gymadmdoc.sessionbeans.MuEvaluacionFacade;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.application.ViewHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

@ManagedBean
@ViewScoped
public class RegistrarDatosIngresoController implements Serializable {

    @EJB
    private MuUsuarioFacade usuarioEJB;
    @EJB
    private MuDiagnosticoMedicoFacade diagnosticoMedicoEJB;
    @EJB
    private MuExamenFisicoFacade examenFisicoEJB;
    @EJB
    private MuAntecedenteSaludFacade antecedentesSaludEJB;
    @EJB
    private MuEvaluacionFacade evaluacionEJB;

    private boolean consumeMedicamentos;
    private float peso;
    private float talla;
    private float fc;
    private float fcm;
    private float ta;
    private float fr;
    private float imc;
    private float icc;
    private Date fecha;
    private String medicamentos;
    private MuUsuario usuario;
    private MuExamenFisico examenFisico;
    private MuDiagnosticoMedico diagnosticoMedico;
    private String numeroIdentificacion;
    private List<MuUsuario> listaFuncionarios;
    private String nombreOApellidos;
    private boolean usuarioSeleccionado;
    private boolean tieneAntecedentesDeSalud;
    private boolean tieneExamenFisico;
    private boolean tieneDiagnosticoMedico;
    private boolean tieneEvaluacion;
    private String descripcionDiagnostico;

    public RegistrarDatosIngresoController() {
        this.inicializarCamposUsuarioEspecificos();
        this.usuario = new MuUsuario();
        this.diagnosticoMedico = new MuDiagnosticoMedico();
        this.examenFisico= new MuExamenFisico();

    }

    @PostConstruct
    private void init() {
        asignarFecha();

    }

    public String getNombreOApellidos() {
        return nombreOApellidos;
    }

    public void setNombreOApellidos(String nombreOApellidos) {
        this.nombreOApellidos = nombreOApellidos;
    }

    public boolean isUsuarioSeleccionado() {
        return usuarioSeleccionado;
    }

    public void setUsuarioSeleccionado(boolean usuarioSeleccionado) {
        this.usuarioSeleccionado = usuarioSeleccionado;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public boolean isTieneExamenFisico() {
        return tieneExamenFisico;
    }

    public void setTieneExamenFisico(boolean tieneExamenFisico) {
        this.tieneExamenFisico = tieneExamenFisico;
    }

    public boolean isTieneDiagnosticoMedico() {
        return tieneDiagnosticoMedico;
    }

    public void setTieneDiagnosticoMedico(boolean tieneDiagnosticoMedico) {
        this.tieneDiagnosticoMedico = tieneDiagnosticoMedico;
    }

    public boolean isTieneEvaluacion() {
        return tieneEvaluacion;
    }

    public void setTieneEvaluacion(boolean tieneEvaluacion) {
        this.tieneEvaluacion = tieneEvaluacion;
    }

    public boolean isTieneAntecedentesDeSalud() {
        return tieneAntecedentesDeSalud;
    }

    public void setTieneAntecedentesDeSalud(boolean tieneAntecedentesDeSalud) {
        this.tieneAntecedentesDeSalud = tieneAntecedentesDeSalud;
    }

    public String getDescripcionDiagnostico() {
        return descripcionDiagnostico;
    }

    public void setDescripcionDiagnostico(String descripcionDiagnostico) {
        this.descripcionDiagnostico = descripcionDiagnostico;
    }

    public float getTalla() {
        return talla;
    }

    public void setTalla(float talla) {
        this.talla = talla;
    }

    public float getFc() {
        return fc;
    }

    public void setFc(float fc) {
        this.fc = fc;
    }

    public float getFcm() {
        return fcm;
    }

    public void setFcm(float fcm) {
        this.fcm = fcm;
    }

    public float getTa() {
        return ta;
    }

    public void setTa(float ta) {
        this.ta = ta;
    }

    public float getFr() {
        return fr;
    }

    public void setFr(float fr) {
        this.fr = fr;
    }

    public float getImc() {
        return imc;
    }

    public void setImc(float imc) {
        this.imc = imc;
    }

    public float getIcc() {
        return icc;
    }

    public void setIcc(float icc) {
        this.icc = icc;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public boolean isConsumeMedicamentos() {
        return consumeMedicamentos;
    }

    public void setConsumeMedicamentos(boolean consumeMedicamentos) {
        this.consumeMedicamentos = consumeMedicamentos;
    }

    public String getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(String medicamentos) {
        this.medicamentos = medicamentos;
    }

    public List<MuUsuario> getListaFuncionarios() {
        return listaFuncionarios;
    }

    public void setListaFuncionarios(List<MuUsuario> listaFuncionarios) {
        this.listaFuncionarios = listaFuncionarios;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public MuUsuario getUsuario() {
        return usuario;
    }

    public void setUsuario(MuUsuario usuario) {
        this.usuario = usuario;
    }

    private void inicializarCamposUsuarioEspecificos() {
        this.usuarioSeleccionado = false;
        this.consumeMedicamentos = false;
    }

    public void respuesta(ValueChangeEvent e) {
        if (e.getNewValue().equals("Si")) {
            consumeMedicamentos = true;
        } else {
            consumeMedicamentos = false;
        }

    }

    public void abrirVentanaExamenFisico() {
        RequestContext requestContext = RequestContext.getCurrentInstance();
        FacesContext context = FacesContext.getCurrentInstance();
        Application application = context.getApplication();
        ViewHandler viewHandler = application.getViewHandler();
        UIViewRoot viewRoot = viewHandler.createView(context, context.getViewRoot().getViewId());
        context.setViewRoot(viewRoot);
        context.renderResponse();
        requestContext.update("form:panel");
        requestContext.update("form");
        requestContext.execute("PF('RegistrarExamenFisico').show()");
    }

    public void abrirVentanaDiagnosticoMedico() {
        RequestContext requestContext = RequestContext.getCurrentInstance();
        FacesContext context = FacesContext.getCurrentInstance();
        Application application = context.getApplication();
        ViewHandler viewHandler = application.getViewHandler();
        UIViewRoot viewRoot = viewHandler.createView(context, context.getViewRoot().getViewId());
        context.setViewRoot(viewRoot);
        context.renderResponse();
        requestContext.update("form:panel");
        requestContext.update("form");
        requestContext.execute("PF('RegistrarDiagnosticoMedico').show()");
    }

    public void abrirVentanaEvaluacion() {
        RequestContext requestContext = RequestContext.getCurrentInstance();
        FacesContext context = FacesContext.getCurrentInstance();
        Application application = context.getApplication();
        ViewHandler viewHandler = application.getViewHandler();
        UIViewRoot viewRoot = viewHandler.createView(context, context.getViewRoot().getViewId());
        context.setViewRoot(viewRoot);
        context.renderResponse();
        requestContext.update("form:panel");
        requestContext.update("form");
        requestContext.execute("PF('RegistrarEvaluacion').show()");
    }

    public void buscarPorNombreFuncionario() {

        this.listaFuncionarios = usuarioEJB.busacarPorNombreFuncionario(this.nombreOApellidos.toLowerCase());

    }

    public void seleccionarUsuario(MuUsuario usuario) {
        RequestContext requestContext = RequestContext.getCurrentInstance();
        requestContext.execute("PF('seleccionarUsuario').hide()");
        this.usuario = usuario;
        this.usuarioSeleccionado = true;
        cambiarEstadoAntecedentes(usuario);
        requestContext.update("usuarioSeleccionado");
        requestContext.update("datosIngreso");
        requestContext.update("registroDatosIngreso");

    }

    public void registrarExamenFisico() {
               
        this.examenFisico.setEfisFecha(fecha);
        this.examenFisico.setEfisPeso(peso);
        this.examenFisico.setEfisTalla(talla);
        this.examenFisico.setEfisFc(fc);
        this.examenFisico.setEfisFcm(fcm);
        this.examenFisico.setEfisTa(ta);
        this.examenFisico.setEfisFr(fr);
        this.examenFisico.setEfisIcc(icc);
        this.examenFisico.setEfisImc(imc);
        this.examenFisico.setUsuIdentificacion(usuario);
        this.examenFisicoEJB.create(examenFisico);       

        RequestContext requestContext = RequestContext.getCurrentInstance();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Registro Exitoso."));
        requestContext.execute("PF('mensajeRegistroExitoso').show()");
        cambiarEstadoAntecedentes(usuario);
        reinicarDatos();
        requestContext.update("usuarioSeleccionado");
        requestContext.update("datosIngreso");
        requestContext.update("registroDatosIngreso");
        
    }
    
    public void registrarDiagnosticoMedico() {

        if (medicamentos != null) {
            this.diagnosticoMedico.setDimedMedicamentos(medicamentos);
        }
        this.diagnosticoMedico.setDimedDescripcion(descripcionDiagnostico);
        this.diagnosticoMedico.setUsuIdentificacion(usuario);
        this.diagnosticoMedicoEJB.create(diagnosticoMedico);

        RequestContext requestContext = RequestContext.getCurrentInstance();
        requestContext.execute("PF('RegistrarDiagnosticoMedico').hide()");
        cambiarEstadoAntecedentes(usuario);
        requestContext.update("usuarioSeleccionado");
        requestContext.update("datosIngreso");
        requestContext.update("registroDatosIngreso");

    }

    private void cambiarEstadoAntecedentes(MuUsuario usuario) {

        if (this.antecedentesSaludEJB.buscarAntecedentesSalud(usuario).size() > 0) {
            tieneAntecedentesDeSalud = true;
        } else {
            tieneAntecedentesDeSalud = false;
        }

        if (this.diagnosticoMedicoEJB.buscarDiagnosticoMedico(usuario).size() > 0) {
            tieneDiagnosticoMedico = true;
        } else {
            tieneDiagnosticoMedico = false;
        }

        if (this.examenFisicoEJB.buscarExamenFisico(usuario).size() > 0) {
            tieneExamenFisico = true;
        } else {
            tieneExamenFisico = false;
        }

        if (this.evaluacionEJB.buscarEvaluacion(usuario).size() > 0) {
            tieneEvaluacion = true;
        } else {
            tieneEvaluacion = false;
        }

    }

    
    public void eliminarDiagnosticoMedico() {
        diagnosticoMedicoEJB.remove(diagnosticoMedicoEJB.buscarDiagnosticoMedico(usuario).get(0));
        RequestContext requestContext = RequestContext.getCurrentInstance();
        requestContext.execute("PF('eliminarDiagnostico').hide()");
        cambiarEstadoAntecedentes(usuario);        
        requestContext.update("usuarioSeleccionado");
        requestContext.update("datosIngreso");
        requestContext.update("registroDatosIngreso");
        
        
    }
    public void eliminarExamenFisico() {
        examenFisicoEJB.remove(examenFisicoEJB.buscarExamenFisico(usuario).get(0));
        RequestContext requestContext = RequestContext.getCurrentInstance();
        requestContext.execute("PF('eliminarExamenFisico').hide()");
        cambiarEstadoAntecedentes(usuario);        
        requestContext.update("usuarioSeleccionado");
        requestContext.update("datosIngreso");
        requestContext.update("registroDatosIngreso");   
        
    }
    public void subirImagenFrente(FileUploadEvent event) {
        UploadedFile file  = event.getFile();
        examenFisico.setEfisFotoCuerpoCompletoFrente(inputStreamToByteArray(file));
    }
    public void subirImagenEspalda(FileUploadEvent event) {
        UploadedFile file  = event.getFile();
        examenFisico.setEfisFotoCuerpoCompletoEspalda(inputStreamToByteArray(file));
    }
    public void subirImagenPerfilIzq(FileUploadEvent event) {
        UploadedFile file  = event.getFile();
        examenFisico.setEfisFotoCuerpoCompletoPerfilIzq(inputStreamToByteArray(file));
    }
    public void subirImagenPerfilDer(FileUploadEvent event) {
        UploadedFile file  = event.getFile();
        examenFisico.setEfisFotoCuerpoCompletoPerfilDer(inputStreamToByteArray(file));
    }
    private byte[] inputStreamToByteArray(UploadedFile file) {
        byte[] imagen = null;
        if(file != null) {
            try {
                ByteArrayOutputStream output;
                try (InputStream input = file.getInputstream()) {
                    byte[] buffer = new byte[1024];
                    int length;
                    output = new ByteArrayOutputStream();
                    while ((length = input.read(buffer)) != -1) output.write(buffer, 0, length);
                }
                imagen = output.toByteArray();
            } catch (Exception ex) {}
        }
        return imagen;
    }
    private void asignarFecha() {
        GregorianCalendar c = new GregorianCalendar();
        fecha = c.getTime();
    }

    private void reinicarDatos() {
        this.examenFisico= new MuExamenFisico();
        this.peso=0;
        this.talla=0;
        this.fc=0;
        this.fcm=0;
        this.ta=0;
        this.fr=0;
        this.icc=0;
        this.imc=0;
    }

}
