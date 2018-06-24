package view;

import com.sun.javafx.scene.web.Debugger;

import control.MainApp;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import model.Vehicule;

public class VehiculeOverviewController {
	 @FXML
	private ListView<Vehicule> VehiculeList;
		

	MainApp mainApp;

	public VehiculeOverviewController() {

    }

	@FXML
    private void initialize() {

		VehiculeList.setCellFactory(new Callback<ListView<Vehicule>, ListCell<Vehicule>>(){

            @Override
            public ListCell<Vehicule> call(ListView<Vehicule> p) {

                ListCell<Vehicule> cell = new ListCell<Vehicule>(){

                    @Override
                    protected void updateItem(Vehicule t, boolean bln) {
                        super.updateItem(t, bln);
                        if (t != null) {
                            setText(t.getName());
                        }
                        else { this.setText(null); }
                    }

                };

                return cell;
            }
        });

    }

	public void setMainApp(MainApp mainApp)
	{
		this.mainApp = mainApp;
		if(mainApp.getVehiculeData().isEmpty()){
			System.out.println("vide");
		}
		VehiculeList.setItems(mainApp.getVehiculeData());
	}

	@FXML
	private void handleDeleteVehicule() {
	    int selectedIndex = VehiculeList.getSelectionModel().getSelectedIndex();
	    if (selectedIndex >= 0) {
	    	VehiculeList.getItems().remove(selectedIndex);




	    } else {
	        // Nothing selected.
	        Alert alert = new Alert(AlertType.WARNING);
	        alert.initOwner(mainApp.getPrimaryStage());
	        alert.setTitle("No Selection");
	        alert.setHeaderText("No vehicule Selected");
	        alert.setContentText("Please select a vehicule in the list.");

	        alert.showAndWait();
	    }
	}

	@FXML
	private void handleAddVehicule() {

	}

}
