package fr.soat.hibernategwt.client.services;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

import fr.soat.hibernategwt.shared.model.Person;

public interface PersonServiceAsync {

	void getAll(AsyncCallback<List<Person>> callback);

	void add(Person person, AsyncCallback<Void> callback);

}
