package projet_agence_location.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import projet_agence_location.model.Client;
import projet_agence_location.service.impl.ManagerService;

@ManagedBean(name="manager")
@ViewScoped
public class ClientBean {
	
	private ManagerService<Client> managerServiceClient;
	
	private Client selectedClient;
	private Client client=new Client();
	
	@PostConstruct
	public void init() {
		this.managerServiceClient = new ManagerService<Client>();
	}
	
	public void save() {
		managerServiceClient.addObject(client);
	}
	
	public void suppr(Client client) {
		managerServiceClient.deleteObject(client);
	}
	
	public List<Client> getFindClients(){
		return managerServiceClient.findAll(Client.class);
	}

	public ManagerService<Client> getManagerServiceClient() {
		return managerServiceClient;
	}

	public void setManagerServiceClient(ManagerService<Client> managerServiceClient) {
		this.managerServiceClient = managerServiceClient;
	}

	public Client getSelectedClient() {
		return selectedClient;
	}

	public void setSelectedClient(Client selectedClient) {
		this.selectedClient = selectedClient;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	

	
	
	
	
	

}
