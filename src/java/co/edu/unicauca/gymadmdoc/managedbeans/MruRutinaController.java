package co.edu.unicauca.gymadmdoc.managedbeans;

import co.edu.unicauca.gymadmdoc.entities.MruRutina;
import co.edu.unicauca.gymadmdoc.util.JsfUtil;
import co.edu.unicauca.gymadmdoc.util.JsfUtil.PersistAction;
import co.edu.unicauca.gymadmdoc.sessionBeans.MruRutinaFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("mruRutinaController")
@SessionScoped
public class MruRutinaController implements Serializable {

    @EJB
    private MruRutinaFacade ejbFacade;
    private List<MruRutina> items = null;
    private MruRutina selected;

    public MruRutinaController() {
        this.prepareCreate();
    }

    public MruRutina getSelected() {
        return selected;
    }

    public void setSelected(MruRutina selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private MruRutinaFacade getFacade() {
        return ejbFacade;
    }

    public MruRutina prepareCreate() {
        selected = new MruRutina();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {

        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("MruRutinaCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
       }       
    }
    
    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("MruRutinaUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("MruRutinaDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<MruRutina> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public MruRutina getMruRutina(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<MruRutina> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<MruRutina> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = MruRutina.class)
    public static class MruRutinaControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            MruRutinaController controller = (MruRutinaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "mruRutinaController");
            return controller.getMruRutina(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof MruRutina) {
                MruRutina o = (MruRutina) object;
                return getStringKey(o.getRuId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), MruRutina.class.getName()});
                return null;
            }
        }

    }

}
