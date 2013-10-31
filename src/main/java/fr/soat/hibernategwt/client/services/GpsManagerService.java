package fr.soat.hibernategwt.client.services;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import fr.soat.hibernategwt.shared.model.ConsultantDTO;
import fr.soat.hibernategwt.shared.model.GpsDTO;

@RemoteServiceRelativePath("gpsService")
 

public interface GpsManagerService  extends RemoteService {
	
	public void addConsultantToGps(ConsultantDTO consultant, GpsDTO gps);
	public List<GpsDTO> getAllGps() ;
	public List<ConsultantDTO> getAllConsultants() ;
	
	

}
