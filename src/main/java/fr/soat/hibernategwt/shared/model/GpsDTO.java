package fr.soat.hibernategwt.shared.model;

import java.io.Serializable;

public class GpsDTO implements Serializable {


	private static final long serialVersionUID = 1L;
	private int idGps;
	private String nom;

	public GpsDTO(int idGps, String nom) {
		this.idGps = idGps;
		this.nom = nom;

	}

	public GpsDTO() {
		
	}

	public int getIdGps() {
		return idGps;
	}

	public void setIdGps(int idGps) {
		this.idGps = idGps;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}
