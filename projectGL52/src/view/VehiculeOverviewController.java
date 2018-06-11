package view;

import control.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import model.Vehicule;

public class VehiculeOverviewController {
	private TableView<Vehicule> VehiculeTable;
	MainApp mainApp;

	public VehiculeOverviewController() {
    }

	@FXML
    private void initialize() {


    }

	public void setMainApp(MainApp mainApp)
	{
		this.mainApp = mainApp;
		VehiculeTable.setItems(mainApp.getVehiculeData());
	}

}
