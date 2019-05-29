package projet_agence_location.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Personne")
@Inheritance (strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn (name= "type",discriminatorType = DiscriminatorType.STRING, length = 6)
public class Personne implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5152812111027770814L;
	private Long id_personne;
	private String nom;
	private String prenom;
	private String login;
	private String password;
	private String email;
	
	private List<Reservation> reservations = new ArrayList<>();
	
	public static Personne connectedUser;

	//CONSTRUCTEURS
	public Personne() {
		super();		
	}

	public Personne(String nom, String prenom, String login, String password, String email) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.password = password;
		this.email = email;
	}

	public Personne(Long id_personne, String nom, String prenom, String login, String password, String email) {
		super();
		this.id_personne = id_personne;
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.password = password;
		this.email = email;
	}

	//GETTER&SETTER
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	public Long getId_personne() {
		return id_personne;
	}

	public void setId_personne(Long id_personne) {
		this.id_personne = id_personne;
	}

	@Column(name="nom")
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	@Column(name="prenom")
	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	@Column(name="login")
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@Column(name="password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	@Column(name="email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@OneToMany(mappedBy="personne")
	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	//TOSTRING
	@Override
	public String toString() {
		return "Personne [id_personne=" + id_personne + ", nom=" + nom + ", prenom=" + prenom + ", login=" + login
				+ ", password=" + password + ", email=" + email + "]";
	}

}


