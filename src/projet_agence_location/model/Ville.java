package projet_agence_location.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Ville")
public class Ville implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3554705360331983020L;
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_ville")
	private Long id_ville;
	
	@Column(name = "nom")
	private String nom;
	
	@Column(name = "code_postale")
	private int code_postale;
	
	@OneToMany(mappedBy = "ville")
	private List<Agence> listeAgence = new ArrayList<>();
	
	//////////////// Constructeurs ////////////////////////////////
	
	public Ville() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ville(Long id_ville, String nom, int code_postale) {
		super();
		this.id_ville = id_ville;
		this.nom = nom;
		this.code_postale = code_postale;
	}
	
	public Ville(String nom, int code_postale) {
		super();
		this.nom = nom;
		this.code_postale = code_postale;
	}
	
	//////////////// Getter Setter ////////////////////////////////

	/**
	 * @return the id_ville
	 */
	public Long getId_ville() {
		return id_ville;
	}

	/**
	 * @param id_ville the id_ville to set
	 */
	public void setId_ville(Long id_ville) {
		this.id_ville = id_ville;
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
	 * @return the code_postale
	 */
	public int getCode_postale() {
		return code_postale;
	}

	/**
	 * @param code_postale the code_postale to set
	 */
	public void setCode_postale(int code_postale) {
		this.code_postale = code_postale;
	}

	/**
	 * @return the listeAgence
	 */
	public List<Agence> getListeAgence() {
		return listeAgence;
	}

	/**
	 * @param listeAgence the listeAgence to set
	 */
	public void setListeAgence(List<Agence> listeAgence) {
		this.listeAgence = listeAgence;
	}
	
	
	
	//////////////// toString ////////////////////////////////


	@Override
	public String toString() {
		return "Ville [id_ville=" + id_ville + ", nom=" + nom + ", code_postale=" + code_postale + ", listeAgence="
				+ listeAgence + "]";
	}
	
	

	

}
