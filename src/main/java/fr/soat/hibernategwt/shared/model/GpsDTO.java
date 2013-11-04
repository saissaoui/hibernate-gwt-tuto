package fr.soat.hibernategwt.shared.model;

import java.io.Serializable;
import java.util.List;

import fr.soat.hibernategwt.server.model.Consultant;

public class GpsDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idGps;
	private String nom;
	private List<Consultant> consultantsList;

	public GpsDTO(int idGps, String nom, List<Consultant> consultantsList) {
		super();
		this.idGps = idGps;
		this.nom = nom;
		this.consultantsList = consultantsList;
	}

	

	public GpsDTO() {
		// TODO Auto-generated constructor stub
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

	public List<Consultant> getConsultantsList() {
		return consultantsList;
	}

	public void setConsultantsList(List<Consultant> consultantsList) {
		this.consultantsList = consultantsList;
	}

}
