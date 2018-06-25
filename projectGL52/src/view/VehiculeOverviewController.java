package view;

import com.sun.javafx.scene.web.Debugger;

import control.MainApp;
import javafx.beans.binding.Binding;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import model.Vehicule;

public class VehiculeOverviewController {
	 @FXML
	private ListView<Vehicule> VehiculeList;
	 
	 @FXML
	private ChoiceBox<String> feux;
	 
	 @FXML
	private ChoiceBox<String> debit;
	 
	 @FXML
	private Button next;
			

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
	        alert.setTitle("Pas de sélection");
	        alert.setHeaderText("Aucun véhicule sélectionné");
	        alert.setContentText("Veuillez sélectionner un véhicule dans la liste");

	        alert.showAndWait();
	    }
	}

	@FXML
	private void handleAddVehicule() {

	}
	
	@FXML
	private void selectFeux() {
		String output = (String) feux.getValue();
		System.out.println(output);
		int outputFeux = Integer.parseInt(output);
	}
	
	@FXML
	private void selectDebit() {
		String output = (String) debit.getValue();
		System.out.println(output);
		int outputDebit = Integer.parseInt(output);
	}
	
	@FXML
	private void checkNext() {
		ObservableList<Vehicule> items = VehiculeList.getItems();

		if (items.isEmpty()) {
			Alert alert = new Alert(AlertType.WARNING);
	        alert.initOwner(mainApp.getPrimaryStage());
	        alert.setTitle("Erreur");
	        alert.setHeaderText("Aucun groupe de véhicule");
	        alert.setContentText("Veuillez en ajouter un");

	        alert.showAndWait();
		} else {
		     
		}
	}
	
	

}
