package fr.soat.hibernategwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

import fr.soat.hibernategwt.client.views.AddToGpsView;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class GwtHibernate implements EntryPoint {
	
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {

		AddToGpsView view = new AddToGpsView();
		RootPanel.get().add(view);

	}
}
