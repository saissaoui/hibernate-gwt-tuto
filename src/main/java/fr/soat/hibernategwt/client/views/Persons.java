package fr.soat.hibernategwt.client.views;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

import fr.soat.hibernategwt.shared.model.Person;

public class Persons extends Composite implements HasText {

	private static PersonsUiBinder uiBinder = GWT.create(PersonsUiBinder.class);

	interface PersonsUiBinder extends UiBinder<Widget, Persons> {
	}

	public Persons() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiField
	Grid personList;

	public Persons(List<Person> persons) {
		initWidget(uiBinder.createAndBindUi(this));
		for (Person person : persons) {
			personList.insertRow(1);
			personList.setWidget(1, 0, new Label("" + person.getIdPerson()));
			personList.setWidget(1, 1, new Label("" + person.getName()));
			personList.setWidget(1, 2, new Label("" + person.getAge()));
		}
		

	}

	public String getText() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setText(String text) {
		// TODO Auto-generated method stub

	}

}
