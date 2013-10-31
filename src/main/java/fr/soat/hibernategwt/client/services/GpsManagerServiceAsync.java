package fr.soat.hibernategwt.client.services;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

import fr.soat.hibernategwt.shared.model.ConsultantDTO;
import fr.soat.hibernategwt.shared.model.GpsDTO;

public interface GpsManagerServiceAsync {

	void addConsultantToGps(ConsultantDTO consultant, GpsDTO gps,
			AsyncCallback<Void> callback);

	void getAllGps(AsyncCallback<List<GpsDTO>> callback);

	void getAllConsultants(AsyncCallback<List<ConsultantDTO>> callback);

}
