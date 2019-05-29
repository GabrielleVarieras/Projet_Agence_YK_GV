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

import projet_agence_location.model.Ville;

@Entity
@Table(name="Agence")
public class Agence implements Serializable {


	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1186112605375998507L;

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_agence")
	private Long id_agence;
	
	@Column(name = "nom")
	private String nom;
	
	@Column(name = "adresse")
	private String adresse;
	
	@Column(name = "nbre_employe")
	private int nbre_employe;
	
	private boolean editable;
	
	@OneToMany(mappedBy = "agence")
	private List<Voiture> listeVoiture = new ArrayList<>();
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_ville")
	private Ville ville;

	
	//////////////// Constructeurs ////////////////////////////////
	
	public Agence() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Agence(String nom, String adresse, int nbre_employe, Ville ville) {
		super();
		this.nom = nom;
		this.adresse = adresse;
		this.nbre_employe = nbre_employe;
		this.ville = ville;
	}


	public Agence(Long id_agence, String nom, String adresse, int nbre_employe, List<Voiture> listeVoiture) {
		super();
		this.id_agence = id_agence;
		this.nom = nom;
		this.adresse = adresse;
		this.nbre_employe = nbre_employe;
		listeVoiture = listeVoiture;
	}
	
	public Agence(String nom, String adresse, int nbre_employe, List<Voiture> listeVoiture) {
		super();
		this.nom = nom;
		this.adresse = adresse;
		this.nbre_employe = nbre_employe;
		listeVoiture = listeVoiture;
	}
	
	//////////////// Getter Setter ////////////////////////////////

	/**
	 * @return the id_agence
	 */
	public Long getId_agence() {
		return id_agence;
	}


	/**
	 * @param id_agence the id_agence to set
	 */
	public void setId_agence(Long id_agence) {
		this.id_agence = id_agence;
	}


	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}


	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}


	/**
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}


	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	/**
	 * @return the nbre_employe
	 */
	public int getNbre_employe() {
		return nbre_employe;
	}


	/**
	 * @param nbre_employe the nbre_employe to set
	 */
	public void setNbre_employe(int nbre_employe) {
		this.nbre_employe = nbre_employe;
	}


	/**
	 * @return the listeVoiture
	 */
	public List<Voiture> getListeVoiture() {
		return listeVoiture;
	}


	/**
	 * @param listeVoiture the listeVoiture to set
	 */
	public void setListeVoiture(List<Voiture> listeVoiture) {
		listeVoiture = listeVoiture;
	}


	/**
	 * @return the ville
	 */
	public Ville getVille() {
		return ville;
	}


	/**
	 * @param ville the ville to set
	 */
	public void setVille(Ville ville) {
		this.ville = ville;
	}

	
	//////////////// toString ////////////////////////////////

	public boolean isEditable() {
		return editable;
	}


	public void setEditable(boolean editable) {
		this.editable = editable;
	}


	@Override
	public String toString() {
		return "Agence [id_agence=" + id_agence + ", nom=" + nom + ", adresse=" + adresse + ", nbre_employe="
				+ nbre_employe + ", ListeVoiture=" + listeVoiture + ", ville=" + ville + "]";
	}	
	
	

	
}
