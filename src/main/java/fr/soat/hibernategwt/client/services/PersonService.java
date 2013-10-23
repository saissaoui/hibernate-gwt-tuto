package fr.soat.hibernategwt.client.services;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import fr.soat.hibernategwt.shared.model.Person;




@RemoteServiceRelativePath("personService")
public interface PersonService extends RemoteService {

	public List<Person> getAll();

	public void add(Person person);

}
