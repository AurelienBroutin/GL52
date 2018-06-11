package model;



public class Vehicule {



	private String name;
	private int speed;
	private Type type;

	public Vehicule() {
		name="nouveau";
		speed=50;
		type = Type.Leger;
	}

	public Vehicule(String a_name,int a_speed, Type a_type) {
		this.name = a_name;
		this.speed = a_speed;
		this.type = a_type;
	}


}
