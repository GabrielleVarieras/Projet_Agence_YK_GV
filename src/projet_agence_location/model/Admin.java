package projet_agence_location.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Admin")
public class Admin extends Personne implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private boolean admin;

	// CONSTRCTEURS
	public Admin() {
		super();
	}

	public Admin(String nom, String prenom, String login, String password, String email) {
		super(nom, prenom, login, password, email);

	}

	public Admin(boolean admin) {
		super();
		this.admin = admin;
	}

	//GETTER&SETTER
	@Column (name="admin")
	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	//TOSTRING
	@Override
	public String toString() {
		return "Admin [admin=" + admin + "]";
	}



}
