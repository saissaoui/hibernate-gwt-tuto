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
import fr.soat.hibernategwt.shared.model.ConsultantDTO;
import fr.soat.hibernategwt.shared.model.GpsDTO;

/*
 * La classe definnissant les composants et evenements de la page principale de l'exemple, contenant la liste des 
 * consultants ainsi que le formulaire d'ajout
 */
public class AddToGpsView extends Composite implements HasText {
	@UiField
	CellTable<ConsultantDTO> consultantsList;

	TextColumn<ConsultantDTO> idColumn, nameColumn, gpsColumn;
	@UiField
	TextBox nom;

	@UiField
	ListBox gpsListBox;

	@UiField
	Button addButton;
	private final GpsManagerServiceAsync gpsService = GWT
			.create(GpsManagerService.class);
	ListDataProvider<ConsultantDTO> dataProvider;
	private static AddToGpsViewUiBinder uiBinder = GWT
			.create(AddToGpsViewUiBinder.class);

	interface AddToGpsViewUiBinder extends UiBinder<Widget, AddToGpsView> {
	}

	public AddToGpsView() {
		initWidget(uiBinder.createAndBindUi(this));

		prepareColumns();
		populateConsultantsList(false);

	}

	@UiHandler("addButton")
	void onClick(ClickEvent e) {

		ConsultantDTO newConsultant = new ConsultantDTO();
		newConsultant.setNom(nom.getText());
		GpsDTO gps = new GpsDTO();

		gps.setIdGps(Integer.parseInt(gpsListBox.getValue(gpsListBox
				.getSelectedIndex())));

		gpsService.addConsultantToGps(newConsultant, gps,
				new AsyncCallback<Void>() {

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

		nameColumn = new TextColumn<ConsultantDTO>() {
			@Override
			public String getValue(ConsultantDTO consultant) {
				return consultant.getNom();
			}
		};
		idColumn = new TextColumn<ConsultantDTO>() {
			@Override
			public String getValue(ConsultantDTO consultant) {
				return consultant.getIdConsultant() + "";
			}
		};
		gpsColumn = new TextColumn<ConsultantDTO>() {
			@Override
			public String getValue(ConsultantDTO consultant) {
				return consultant.getGps().getNom();
			}
		};

		consultantsList.addColumn(idColumn, "Id");
		consultantsList.addColumn(nameColumn, "Nom");
		consultantsList.addColumn(gpsColumn, "Gps");
		dataProvider = new ListDataProvider<ConsultantDTO>();
		dataProvider.addDataDisplay(consultantsList);
	}

	private void refrechConsultantsList() {

		dataProvider.getList().clear();
		populateConsultantsList(true);

	}

	private void populateConsultantsList(final boolean isRefresh) {

		gpsService.getAllConsultants(new AsyncCallback<List<ConsultantDTO>>() {

			public void onSuccess(List<ConsultantDTO> result) {
				List<ConsultantDTO> cList = dataProvider.getList();
				for (ConsultantDTO consultant : result) {
					cList.add(new ConsultantDTO(consultant.getIdConsultant(),
							consultant.getNom(), consultant.getGps()));
				}
				if (!isRefresh)
					populateGpsList();

			}

			public void onFailure(Throwable caught) {
				Window.alert("Erreur de chargement de la liste des consultants");

			}
		});

	}

	private void populateGpsList() {
		gpsService.getAllGps(new AsyncCallback<List<GpsDTO>>() {

			public void onSuccess(List<GpsDTO> result) {
				for (GpsDTO gps : result)
					gpsListBox.addItem(gps.getNom(), gps.getIdGps() + "");

			}

			public void onFailure(Throwable caught) {
				Window.alert("Erreur de chargement de la liste des Gps");

			}
		});

	}
}
