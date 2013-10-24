package fr.soat.hibernategwt.client.views;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.ListDataProvider;

import fr.soat.hibernategwt.client.services.PersonService;
import fr.soat.hibernategwt.client.services.PersonServiceAsync;
import fr.soat.hibernategwt.shared.model.Person;

public class Persons extends Composite implements HasText {
	interface PersonsUiBinder extends UiBinder<Widget, Persons> {
	}

	private static PersonsUiBinder uiBinder = GWT.create(PersonsUiBinder.class);
	private final PersonServiceAsync personService = GWT
			.create(PersonService.class);

	@UiField
	CellTable<Person> personList;
	
	TextColumn<Person> idColumn, nameColumn, ageColumn;

	@UiField
	TextBox nom, age;

	@UiField
	Button addButton;
	ListDataProvider<Person> dataProvider;

	public Persons() {
		initWidget(uiBinder.createAndBindUi(this));
		nameColumn = new TextColumn<Person>() {
			@Override
			public String getValue(Person person) {
				return person.getName();
			}
		};
		idColumn = new TextColumn<Person>() {
			@Override
			public String getValue(Person person) {
				return person.getIdPerson() + "";
			}
		};
		ageColumn = new TextColumn<Person>() {
			@Override
			public String getValue(Person person) {
				return person.getAge() + "";
			}
		};

		personList.addColumn(idColumn, "id");
		personList.addColumn(nameColumn, "nom");
		personList.addColumn(ageColumn, "age");
		dataProvider = new ListDataProvider<Person>();
		dataProvider.addDataDisplay(personList);
		refrechList();
	}

	// public Persons(List<Person> persons) {
	//
	// initWidget(uiBinder.createAndBindUi(this));
	//
	//
	// }

	public void populate(List<Person> persons) {

		List<Person> plist = dataProvider.getList();
		for (Person person : persons) {
			plist.add(person);
		}

	}

	public String getText() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setText(String text) {
		// TODO Auto-generated method stub

	}

	@UiHandler("addButton")
	public void addPerson(ClickEvent event) {

		String _nom = nom.getText();
		int _age = Integer.parseInt(age.getText());
		Person personToAdd = new Person(_nom, _age);

		personService.add(personToAdd, new AsyncCallback<Void>() {

			public void onSuccess(Void result) {
				refrechList();

			}

			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub

			}
		});

		System.out.println(_nom + " " + _age);

	}

	private void refrechList() {

		dataProvider.getList().clear();
		personService.getAll(new AsyncCallback<List<Person>>() {

			public void onSuccess(List<Person> result) {

				populate(result);
			}

			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub

			}
		});
	}
}
