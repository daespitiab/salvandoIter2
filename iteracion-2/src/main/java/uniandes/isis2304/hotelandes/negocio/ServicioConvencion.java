package uniandes.isis2304.hotelandes.negocio;

import java.util.ArrayList;

public class ServicioConvencion {

	//Atributos
	private String id;
	private ArrayList<RestauranteBar> baresRestaurantes;
	private ArrayList<Salon> salones;
	private String idConvencion;
	
	//Constructor
	public ServicioConvencion(String idConvencion, String pId, ArrayList<RestauranteBar> baresRestaurantes, ArrayList<Salon> salones) {
		this.id = pId;
		this.baresRestaurantes = baresRestaurantes;
		this.salones = salones;
		this.idConvencion = idConvencion;
	}
	
	//Metodos
	public ArrayList<RestauranteBar> getBaresRestaurantes() {
		return baresRestaurantes;
	}
	public void setBaresRestaurantes(ArrayList<RestauranteBar> baresRestaurantes) {
		this.baresRestaurantes = baresRestaurantes;
	}
	public ArrayList<Salon> getSalones() {
		return salones;
	}
	public void setSalones(ArrayList<Salon> salones) {
		this.salones = salones;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getIdConvencion() {
		return idConvencion;
	}

	public void setIdConvencion(String idConvencion) {
		this.idConvencion = idConvencion;
	}
	
}
