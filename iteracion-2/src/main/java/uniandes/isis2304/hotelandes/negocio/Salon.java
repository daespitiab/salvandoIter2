package uniandes.isis2304.hotelandes.negocio;

import java.util.ArrayList;

public class Salon {

	//Atributod
	private String id;
	private int tipo;
	private int capacidad;
	private ArrayList<String> mobiliario;
	private int reservado;
	//Constructor
	public Salon(String id, int tipo, int capacidad, ArrayList<String> mobiliario) {
		super();
		this.id = id;
		this.tipo = tipo == 1 || tipo == 2 ? tipo: -1;
		this.capacidad = capacidad;
		this.mobiliario = mobiliario;
		this.reservado = 0;
	}
	
	//Metodos
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	public ArrayList<String> getMobiliario() {
		return mobiliario;
	}
	public void setMobiliario(ArrayList<String> mobiliario) {
		this.mobiliario = mobiliario;
	}
	public int getReservado() {
		return reservado;
	}
	public void setReservado(int reservado) {
		this.reservado = reservado;
	}
	
	
}
