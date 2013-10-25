package fr.soat.hibernategwt.shared.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.google.gwt.user.client.rpc.IsSerializable;

@Entity
@Table(name = "gps", catalog = "mydb")
public class Gps implements IsSerializable {
	
	private int idGps;
	private String nom;
	private List<Consultant> consultantsList;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idGps", unique = true, nullable = false)
	public int getIdGps() {
		return idGps;
	}

	public void setIdGps(int idGps) {
		this.idGps = idGps;
	}


	@Column(name ="nom")
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}


	@OneToMany( fetch = FetchType.LAZY, mappedBy = "gps" )
	
	public List<Consultant> getConsultantsList() {
		return consultantsList;
	}

	public void setConsultantsList(List<Consultant> consultantsList) {
		this.consultantsList = consultantsList;
	}

}
