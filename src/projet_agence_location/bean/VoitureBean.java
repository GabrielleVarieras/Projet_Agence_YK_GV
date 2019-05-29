package projet_agence_location.bean;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.event.RowEditEvent;

import javafx.scene.control.TableColumn.CellEditEvent;
import projet_agence_location.model.Voiture;
import projet_agence_location.service.impl.ManagerService;

@ManagedBean(name="managerVoiture")
@ViewScoped
public class VoitureBean {
	
	private ManagerService<Voiture> managerVoiture;
	
	private Voiture selectedVoiture;
	private Voiture voiture;
	private List<Voiture> listeVoiture;
	
	@PostConstruct
	public void init() {
		this.managerVoiture=new ManagerService<Voiture>();
		this.voiture=new Voiture();
		this.setListeVoiture(managerVoiture.findAll(Voiture.class));
	}
	
	public void save() {
		managerVoiture.addObject(voiture);
		 ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
	        try {
				ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public void suppr(Voiture voiture) {
		managerVoiture.deleteObject(voiture);
	}
	
	
	public void saveAction() {
		for(Voiture v : managerVoiture.findAll(Voiture.class)) {
			v.setEditable(false);
		}
		
	}
	
	public void editVoiture(Voiture voiture) {
		voiture.setEditable(true);
	}
	
	public List<Voiture> getFindVoitures(){
		return managerVoiture.findAll(Voiture.class);
	}
	
	//getters && setters
	public ManagerService<Voiture> getManagerVoiture() {
		return managerVoiture;
	}
	public void setManagerVoiture(ManagerService<Voiture> managerVoiture) {
		this.managerVoiture = managerVoiture;
	}
	public Voiture getSelectedVoiture() {
		return selectedVoiture;
	}
	public void setSelectedVoiture(Voiture selectedVoiture) {
		this.selectedVoiture = selectedVoiture;
	}
	public Voiture getVoiture() {
		return voiture;
	}
	public void setVoiture(Voiture voiture) {
		this.voiture = voiture;
	}

	public List<Voiture> getListeVoiture() {
		return listeVoiture;
	}

	public void setListeVoiture(List<Voiture> listeVoiture) {
		this.listeVoiture = listeVoiture;
	}
	
	
	public void onRowEdit(RowEditEvent event) {
		managerVoiture.updateObject((Voiture) event.getObject());
		FacesMessage msg = new FacesMessage("Car Edited", ((Voiture) event.getObject()).getId_voiture().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
 
       
    }
     
    public void onRowCancel(RowEditEvent event) {
    	managerVoiture.deleteObject((Voiture) event.getObject());
        FacesMessage msg = new FacesMessage("Edit Cancelled", ((Voiture) event.getObject()).getId_voiture().toString());
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
