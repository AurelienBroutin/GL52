package model;
import java.time.LocalDate;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Vehicule {



	private String name;
	private int speed;
	private Type type;

	public Vehicule() {
		name= "Undefined";
		speed= 50;
		type = Type.Leger;
	}

	public Vehicule(String a_name,int a_speed, Type a_type) {
		this.name = a_name;
		this.speed = a_speed;
		this.type = a_type;
	}

	public String getName() {
        return name;
    }

	public int getSpeed() {
        return speed;
    }


}
