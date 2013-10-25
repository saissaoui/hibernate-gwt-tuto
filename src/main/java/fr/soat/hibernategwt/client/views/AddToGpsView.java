package fr.soat.hibernategwt.client.views;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.ListDataProvider;
import fr.soat.hibernategwt.client.services.GpsManagerService;
import fr.soat.hibernategwt.client.services.GpsManagerServiceAsync;
import fr.soat.hibernategwt.shared.model.Consultant;
import fr.soat.hibernategwt.shared.model.Gps;

public class AddToGpsView extends Composite implements HasText {
	@UiField
	CellTable<Consultant> consultantsList;

	TextColumn<Consultant> idColumn, nameColumn, gpsColumn;
	@UiField
	TextBox nom;

	@UiField
	ListBox gpsListBox;

	@UiField
	Button addButton;
	private final GpsManagerServiceAsync gpsService = GWT
			.create(GpsManagerService.class);
	ListDataProvider<Consultant> dataProvider;
	private static AddToGpsViewUiBinder uiBinder = GWT
			.create(AddToGpsViewUiBinder.class);

	interface AddToGpsViewUiBinder extends UiBinder<Widget, AddToGpsView> {
	}

	public AddToGpsView() {
		initWidget(uiBinder.createAndBindUi(this));

		prepareColumns();
		populateConsultantsList();
		populateGpsList();

	}

	

	@UiHandler("addButton")
	void onClick(ClickEvent e) {
		
		Consultant newConsultant =  new Consultant();
		newConsultant.setNom(nom.getText());
		Gps gps = new Gps();
		
		gps.setIdGps(Integer.parseInt(gpsListBox.getValue(gpsListBox.getSelectedIndex())));
		
		gpsService.addConsultantToGps(newConsultant, gps, new AsyncCallback<Void>() {
			
			public void onSuccess(Void result) {
			refrechConsultantsList();	
			}
			
			public void onFailure(Throwable caught) {
				Window.alert("Erreur d'ajout du consultant au GPS");
			}
		});
		
	}

	public void setText(String text) {

	}

	public String getText() {
		return null;
	}

	private void prepareColumns() {

		nameColumn = new TextColumn<Consultant>() {
			@Override
			public String getValue(Consultant consultant) {
				return consultant.getNom();
			}
		};
		idColumn = new TextColumn<Consultant>() {
			@Override
			public String getValue(Consultant consultant) {
				return consultant.getIdConsultant() + "";
			}
		};
		gpsColumn = new TextColumn<Consultant>() {
			@Override
			public String getValue(Consultant consultant) {
				return consultant.getGps().getNom();
			}
		};

		consultantsList.addColumn(idColumn, "Id");
		consultantsList.addColumn(nameColumn, "Nom");
		consultantsList.addColumn(gpsColumn, "Gps");
		dataProvider = new ListDataProvider<Consultant>();
		dataProvider.addDataDisplay(consultantsList);
	}

	private void refrechConsultantsList() {

		dataProvider.getList().clear();
		populateConsultantsList();

	}

	private void populateConsultantsList() {

		gpsService.getAllConsultants(new AsyncCallback<List<Consultant>>() {

			public void onSuccess(List<Consultant> result) {
				List<Consultant> cList = dataProvider.getList();
				for (Consultant consultant : result) {
					cList.add(consultant);
				}

			}

			public void onFailure(Throwable caught) {
				Window.alert("Erreur de chargement de la liste des consultants");

			}
		});

	}

	private void populateGpsList() {
		gpsService.getAllGps(new AsyncCallback<List<Gps>>() {

			public void onSuccess(List<Gps> result) {
				for (Gps gps : result)
					gpsListBox.addItem(gps.getNom(), gps.getIdGps() + "");

			}

			public void onFailure(Throwable caught) {
				Window.alert("Erreur de chargement de la liste des Gps");

			}
		});

	}
}
