package fr.soat.hibernategwt.shared.model;

import java.io.Serializable;

public class ConsultantDTO implements Serializable {


	private static final long serialVersionUID = 1L;
	private int idConsultant;
	private String nom;
	private GpsDTO gps;

	public ConsultantDTO(int idConsultant, String nom, GpsDTO gps) {
		super();
		this.idConsultant = idConsultant;
		this.nom = nom;
		this.gps = gps;
	}

	public ConsultantDTO() {
		
	}

	public int getIdConsultant() {
		return idConsultant;
	}

	public void setIdConsultant(int idConsultant) {
		this.idConsultant = idConsultant;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public GpsDTO getGps() {
		return gps;
	}

	public void setGps(GpsDTO gps) {
		this.gps = gps;
	}

}
