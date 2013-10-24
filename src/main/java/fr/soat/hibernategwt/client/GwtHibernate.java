package fr.soat.hibernategwt.client;

import java.util.List;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.RootPanel;

import fr.soat.hibernategwt.client.services.PersonService;
import fr.soat.hibernategwt.client.services.PersonServiceAsync;
import fr.soat.hibernategwt.client.views.Persons;
import fr.soat.hibernategwt.shared.model.Person;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class GwtHibernate implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";

	/**
	 * Create a remote service proxy to talk to the server-side Greeting
	 * service.
	 */


	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {

		Persons personsView = new Persons();
		RootPanel.get().add(personsView);

	}
}
