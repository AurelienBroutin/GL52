package view;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.*;
import java.awt.Color;

public class AddVehicleController {
	@FXML
	private Button closeButton;

	@FXML
	private Button addButton;

	@FXML
	private TextField nameField;

	@FXML
	private Spinner<Integer> maxSpeedSpin;

	@FXML
	private Spinner<Integer> maxAccelSpin;

	@FXML
	private ComboBox<String> typeBox;

	@FXML
	private ColorPicker colorBox;

	@FXML
	private void initialize() {
		Vehicule v = new Vehicule();
		vehicleToFields(v);
	}

	private VehiculeOverviewController mainWindow;

	private void vehicleToFields(Vehicule v) {
		nameField.setText(v.getName());

		SpinnerValueFactory<Integer> speedValFact = new SpinnerValueFactory.IntegerSpinnerValueFactory(10, 250, v.getSpeed(), 10);
		maxSpeedSpin.setValueFactory(speedValFact);

		SpinnerValueFactory<Integer> accelValFact = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100, v.getAccel(), 5);
		maxAccelSpin.setValueFactory(accelValFact);

		typeBox.getItems().clear();
		for (Type t : Type.values())
		{
			typeBox.getItems().add(t.name());
		}
		if (typeBox.getItems().size() > 0)
		{
			typeBox.setValue(typeBox.getItems().get(0));
		}

		colorBox.setValue(AwtToJavaFX(v.getColor()));
	}

	private Vehicule fieldsToVehicle() {
		String name = nameField.getText();
		int speed = maxSpeedSpin.getValue();
		int accel = maxAccelSpin.getValue();
		Type type = Type.valueOf(Type.class, typeBox.getValue());
		java.awt.Color color = JavaFXToAwt(colorBox.getValue());

		return new Vehicule(name, speed, accel, type, color);
	}

	@FXML
	private void closeWindow() {
		Stage stage = (Stage) closeButton.getScene().getWindow();
		stage.close();
	}

	@FXML
	private void addVehicle() {
		mainWindow.addVehicle(fieldsToVehicle());
		closeWindow();
	}

	private javafx.scene.paint.Color AwtToJavaFX(java.awt.Color color) {
		return new javafx.scene.paint.Color((double)(color.getRed()) / 255., (double)(color.getGreen()) / 255., (double)(color.getBlue()) / 255., 1.);
	}

	private java.awt.Color JavaFXToAwt(javafx.scene.paint.Color color) {
		return new java.awt.Color((int)color.getRed() * 255, (int)color.getGreen() * 255, (int)color.getBlue() * 255);
	}

	public void setMainWindow(VehiculeOverviewController w)
	{
		mainWindow = w;
	}
}
