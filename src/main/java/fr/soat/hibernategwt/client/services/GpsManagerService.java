package fr.soat.hibernategwt.client.services;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import fr.soat.hibernategwt.shared.model.Consultant;
import fr.soat.hibernategwt.shared.model.Gps;

@RemoteServiceRelativePath("gpsService")
 

public interface GpsManagerService  extends RemoteService {
	
	public void addConsultantToGps(Consultant consultant, Gps gps);
	public List<Gps> getAllGps() ;
	public List<Consultant> getAllConsultants() ;
	
	

}
