package fr.soat.hibernategwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

import fr.soat.hibernategwt.client.views.AddToGpsView;

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

		AddToGpsView view = new AddToGpsView();
		RootPanel.get().add(view);

	}
}
