package projet_agence_location.bean;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.event.RowEditEvent;

import javafx.scene.control.TableColumn.CellEditEvent;
import projet_agence_location.model.Agence;
import projet_agence_location.service.IManagerService;
import projet_agence_location.service.impl.ManagerService;

@ManagedBean(name = "managerAgence")
public class AgenceBean {

	private IManagerService<Agence> serviceAgence;

	private Agence selectedAgence;
	private Agence agence;
	private List<Agence> listeAgence;

	@PostConstruct
	public void init() {
		serviceAgence = new ManagerService<Agence>();
		agence= new Agence();
		listeAgence=serviceAgence.findAll(Agence.class);
	}

	public void save() {
		serviceAgence.addObject(agence);
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        try {
			ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void suppr(Agence agence) {
		serviceAgence.deleteObject(agence);
	}

	public List<Agence> getFindAgence() {
		return serviceAgence.findAll(Agence.class);
	}

	public void saveAction() {
		for (Agence agence : serviceAgence.findAll(Agence.class)) {
			agence.setEditable(false);
		}
	}

	public void editAgence(Agence agence) {
		agence.setEditable(true);
	}

	public IManagerService<Agence> getServiceAgence() {
		return serviceAgence;
	}

	public void setServiceAgence(IManagerService<Agence> serviceAgence) {
		this.serviceAgence = serviceAgence;
	}

	public Agence getSelectedAgence() {
		return selectedAgence;
	}

	public void setSelectedAgence(Agence selectedAgence) {
		this.selectedAgence = selectedAgence;
	}

	public Agence getAgence() {
		return agence;
	}

	public void setAgence(Agence agence) {
		this.agence = agence;
	}

	public List<Agence> getListeAgence() {
		return listeAgence;
	}

	public void setListeAgence(List<Agence> listeAgence) {
		this.listeAgence = listeAgence;
	}

	public void onRowEdit(RowEditEvent event) {
		serviceAgence.updateObject((Agence) event.getObject());
		FacesMessage msg = new FacesMessage("Car Edited", ((Agence) event.getObject()).getId_agence().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void onRowCancel(RowEditEvent event) {
    	serviceAgence.deleteObject((Agence) event.getObject());
        FacesMessage msg = new FacesMessage("Edit Cancelled", ((Agence) event.getObject()).getId_agence().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
        
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        try {
			ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
     
    public void onCellEdit(@SuppressWarnings("rawtypes") CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
         
        if(newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

}