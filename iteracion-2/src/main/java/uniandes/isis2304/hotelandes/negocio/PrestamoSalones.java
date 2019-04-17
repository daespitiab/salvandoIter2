package uniandes.isis2304.hotelandes.negocio;

import java.util.ArrayList;

public class PrestamoSalones {

	
	//Atributos
	private String id;
	private ArrayList<Salon> salones;
	private String idCliente;
	//Constructor
	public PrestamoSalones(String id, ArrayList<Salon> salones, String idc) {
		super();
		this.id = id;
		this.salones = salones;
		idCliente = idc;
	}
	
	//Metdos
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public ArrayList<Salon> getSalones() {
		return salones;
	}
	public void setSalones(ArrayList<Salon> salones) {
		this.salones = salones;
	}

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}
	
	
	
}
