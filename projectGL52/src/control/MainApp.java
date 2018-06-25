package control;



import java.io.Console;
import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import view.VehiculeOverviewController;
import model.*;


public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    private ObservableList<Vehicule> vehiculeData = FXCollections.observableArrayList();

    public MainApp() {
        // Add some sample data
    	vehiculeData.add(new Vehicule());
    	vehiculeData.add(new Vehicule("Lourd", 90, 10, Type.Lourd));
    	vehiculeData.addListener((ListChangeListener.Change<? extends Vehicule> change) -> {
    	    while(change.next()){
    	        if(change.wasUpdated()){
    	            System.out.println("Update detected");
    	        }
    	        else if(change.wasPermutated()){

    	        }
    	        else{
    	            for (Vehicule remitem : change.getRemoved()) {
    	                //do things
    	            	System.out.println("Update detected");
    	            }
    	            for (Vehicule additem : change.getAddedSubList()) {
    	                //do things
    	            	System.out.println("Update detected");
    	            }
    	        }
    	    }
    	});
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Traffic Simulation");

        initRootLayout();

        showVehiculeOverview();
    }

    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("../view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Shows the Vehicule overview inside the root layout.
     */
    public void showVehiculeOverview() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("../view/vehiculeOverview.fxml"));
            AnchorPane vehiculeOverview = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(vehiculeOverview);

         // Give the controller access to the main app.
            VehiculeOverviewController controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }

    public ObservableList<Vehicule> getVehiculeData() {
        return vehiculeData;
    }
    public void removeAtVehiculeData(int index) {
        vehiculeData.remove(index);
    }
}
