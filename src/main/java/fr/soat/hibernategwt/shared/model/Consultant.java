package fr.soat.hibernategwt.shared.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "consultant", catalog = "mydb")
public class Consultant {

	private int idConsultant;
	private String nom;
	private Gps gps;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idConsultant", unique = true, nullable = false)
	public int getIdConsultant() {
		return idConsultant;
	}

	public void setIdConsultant(int idConsultant) {
		this.idConsultant = idConsultant;
	}

	@Column(name = "nom")
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@ManyToOne
	public Gps getGps() {
		return gps;
	}

	public void setGps(Gps gps) {
		this.gps = gps;
	}

}
