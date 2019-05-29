package projet_agence_location.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Voiture")
public class Voiture implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2516964334692482574L;

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_voiture")
	private Long id_voiture;
	
//	private String id=id_voiture.toString();
//	
	@Column(name = "marque")
	private String marque;
	
	@Column(name = "immatriculation")
	private String immatriculation;
	
	@Column(name = "categorie_vehicule")
	private String categorie_vehicule;
	
	@Column(name = "etat_voiture")
	private boolean etat_voiture;
	
	@Column(name = "nombre_de_place")
	private int nombre_de_place;
	
	@Column(name = "couleur")
	private String couleur;
	
	@Column(name = "disponibilite")
	private boolean disponibilite;
	
	@Column(name = "kilometrage")
	private int kilometrage;
	
	@Column(name = "prix_location")
	private double prix_location;
	
	private boolean editable;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_agence")
	private Agence agence;
	
	@OneToMany(mappedBy = "voiture")
	private List<Reservation> ListeReservation = new ArrayList<>();
	
	//////////////// Constructeurs ////////////////////////////////

	public Voiture() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Voiture(Long id_voiture, String marque, String immatriculation, String categorie_vehicule,
			boolean etat_voiture, int nombre_de_place, String couleur, boolean disponibilite, int kilometrage,
			double prix_location, Agence agence) {
		super();
		this.id_voiture = id_voiture;
		this.marque = marque;
		this.immatriculation = immatriculation;
		this.categorie_vehicule = categorie_vehicule;
		this.etat_voiture = etat_voiture;
		this.nombre_de_place = nombre_de_place;
		this.couleur = couleur;
		this.disponibilite = disponibilite;
		this.kilometrage = kilometrage;
		this.prix_location = prix_location;
		this.agence = agence;
	}
	
	public Voiture(String marque, String immatriculation, String categorie_vehicule,
			boolean etat_voiture, int nombre_de_place, String couleur, boolean disponibilite, int kilometrage,
			double prix_location, Agence agencen) {
		super();
		this.marque = marque;
		this.immatriculation = immatriculation;
		this.categorie_vehicule = categorie_vehicule;
		this.etat_voiture = etat_voiture;
		this.nombre_de_place = nombre_de_place;
		this.couleur = couleur;
		this.disponibilite = disponibilite;
		this.kilometrage = kilometrage;
		this.prix_location = prix_location;
		this.agence = agence;
	}
	
	//////////////// Getter Setter ////////////////////////////////
	
	
	/**
	 * @return the id_voiture
	 */
	public Long getId_voiture() {
		return id_voiture;
	}

	/**
	 * @param id_voiture the id_voiture to set
	 */
	public void setId_voiture(Long id_voiture) {
		this.id_voiture = id_voiture;
	}

	/**
	 * @return the marque
	 */
	public String getMarque() {
		return marque;
	}

	/**
	 * @param marque the marque to set
	 */
	public void setMarque(String marque) {
		this.marque = marque;
	}

	/**
	 * @return the immatriculation
	 */
	public String getImmatriculation() {
		return immatriculation;
	}

	/**
	 * @param immatriculation the immatriculation to set
	 */
	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}

	/**
	 * @return the categorie_vehicule
	 */
	public String getCategorie_vehicule() {
		return categorie_vehicule;
	}

	/**
	 * @param categorie_vehicule the categorie_vehicule to set
	 */
	public void setCategorie_vehicule(String categorie_vehicule) {
		this.categorie_vehicule = categorie_vehicule;
	}

	/**
	 * @return the etat_voiture
	 */
	public boolean isEtat_voiture() {
		return etat_voiture;
	}

	/**
	 * @param etat_voiture the etat_voiture to set
	 */
	public void setEtat_voiture(boolean etat_voiture) {
		this.etat_voiture = etat_voiture;
	}

	/**
	 * @return the nombre_de_place
	 */
	public int getNombre_de_place() {
		return nombre_de_place;
	}

	/**
	 * @param nombre_de_place the nombre_de_place to set
	 */
	public void setNombre_de_place(int nombre_de_place) {
		this.nombre_de_place = nombre_de_place;
	}

	/**
	 * @return the couleur
	 */
	public String getCouleur() {
		return couleur;
	}

	/**
	 * @param couleur the couleur to set
	 */
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	/**
	 * @return the disponibilite
	 */
	public boolean isDisponibilite() {
		return disponibilite;
	}

	/**
	 * @param disponibilite the disponibilite to set
	 */
	public void setDisponibilite(boolean disponibilite) {
		this.disponibilite = disponibilite;
	}

	/**
	 * @return the kilometrage
	 */
	public int getKilometrage() {
		return kilometrage;
	}

	/**
	 * @param kilometrage the kilometrage to set
	 */
	public void setKilometrage(int kilometrage) {
		this.kilometrage = kilometrage;
	}

	/**
	 * @return the prix_location
	 */
	public double getPrix_location() {
		return prix_location;
	}

	/**
	 * @param prix_location the prix_location to set
	 */
	public void setPrix_location(double prix_location) {
		this.prix_location = prix_location;
	}

	/**
	 * @return the agence
	 */
	public Agence getAgence() {
		return agence;
	}

	/**
	 * @param agence the agence to set
	 */
	public void setAgence(Agence agence) {
		this.agence = agence;
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	/**
	 * @return the listeReservation
	 */
//	public List<Reservation> getListeReservation() {
//		return ListeReservation;
//	}
//
//	/**
//	 * @param listeReservation the listeReservation to set
//	 */
//	public void setListeReservation(List<Reservation> listeReservation) {
//		ListeReservation = listeReservation;
//	}
	
	
	
	
	//////////////// toString ////////////////////////////////


	@Override
	public String toString() {
		return "Voiture [id_voiture=" + id_voiture + ", marque=" + marque + ", immatriculation=" + immatriculation
				+ ", categorie_vehicule=" + categorie_vehicule + ", etat_voiture=" + etat_voiture + ", nombre_de_place="
				+ nombre_de_place + ", couleur=" + couleur + ", disponibilite=" + disponibilite + ", kilometrage="
				+ kilometrage + ", prix_location=" + prix_location + ", agence=" + agence + /*", ListeReservation=" + ListeReservation + */"]";
	}

//	public String getId() {
//		return id;
//	}
//
//	public void setId(String id) {
//		this.id = id;
//	}
//	
	

}
