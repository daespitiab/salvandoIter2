package uniandes.isis2304.hotelandes.negocio;

import java.util.ArrayList;

public class TiposHabitaciones {

	
	 //Atributos
	private String id;
	private ArrayList<String> itemAcomodaciones;
	//Constructor
	public TiposHabitaciones(String id, ArrayList<String> itemAcomodaciones) {
		super();
		this.id = id;
		this.itemAcomodaciones = itemAcomodaciones;
	}
	//Metodos
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public ArrayList<String> getItemAcomodaciones() {
		return itemAcomodaciones;
	}
	public void setItemAcomodaciones(ArrayList<String> itemAcomodaciones) {
		this.itemAcomodaciones = itemAcomodaciones;
	}
	
}
