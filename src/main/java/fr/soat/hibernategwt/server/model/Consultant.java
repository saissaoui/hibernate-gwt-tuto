package fr.soat.hibernategwt.server.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.google.gwt.user.client.rpc.IsSerializable;

import fr.soat.hibernategwt.shared.model.ConsultantDTO;

@Entity
@Table(name = "consultant", catalog = "mytutodb")
public class Consultant implements IsSerializable {

	private int idConsultant;
	private String nom;
	private Gps gps;
	
	
	
	

	public Consultant() {
		
	}

	public Consultant(ConsultantDTO cDTO) {

		idConsultant = cDTO.getIdConsultant();
		nom = cDTO.getNom();
		if(cDTO.getGps()!=null)
		gps = new Gps(cDTO.getGps());

	}

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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idGps", nullable = false)
	public Gps getGps() {
		return gps;
	}

	public void setGps(Gps gps) {
		this.gps = gps;
	}

}
