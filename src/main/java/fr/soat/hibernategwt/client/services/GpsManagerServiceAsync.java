package fr.soat.hibernategwt.client.services;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

import fr.soat.hibernategwt.shared.model.Consultant;
import fr.soat.hibernategwt.shared.model.Gps;

public interface GpsManagerServiceAsync {

	void addConsultantToGps(Consultant consultant, Gps gps,
			AsyncCallback<Void> callback);

	void getAllGps(AsyncCallback<List<Gps>> callback);

	void getAllConsultants(AsyncCallback<List<Consultant>> callback);

}
