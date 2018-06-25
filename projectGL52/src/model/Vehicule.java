package model;
import java.time.LocalDate;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import java.awt.Color;

public class Vehicule {
	private String name;
	private int speed;
	private int accel;
	private Type type;
	private Color color;

	private static Color defaultColor = new Color(255, 0, 0);
	private static int counter = 0;

	public Vehicule() {
		this("La voiture de l'ambiance #" + counter, 50, 10, Type.Leger, defaultColor);
	}

	public Vehicule(String a_name, int a_speed, int a_accel, Type a_type) {
		this(a_name, a_speed, a_accel, a_type, defaultColor);
	}

	public Vehicule(String a_name, int a_speed, int a_accel, Type a_type, Color a_color) {
		this.name = a_name;
		this.speed = a_speed;
		this.type = a_type;
		this.color = a_color;
		counter++;
	}

	public String getName() {
        return name;
    }

	public int getSpeed() {
        return speed;
    }

	public int getAccel() {
		return accel;
	}

	public Type getType() {
		return type;
	}

	public Color getColor() {
		return color;
	}

	public void setName(String name) {
        this.name = name;
    }

	public void setSpeed(int speed) {
        this.speed = speed;
    }

	public void setAccel(int accel) {
		this.accel = accel;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public void setColor(Color color) {
		this.color = color;
	}
}
