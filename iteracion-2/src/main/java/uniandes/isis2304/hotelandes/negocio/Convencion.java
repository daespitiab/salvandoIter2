package uniandes.isis2304.hotelandes.negocio;

import java.util.ArrayList;

public class Convencion {

	//Constantes
	public final static int ESTADO_TERMIANDO = 1;
	public final static int ESTADO_EN_PROCESO = 0;

	
	//Atributos
	private String id;
	private int numPersonas;
	private String tematica;
	private double precio;
	private int estado;
	
	private ArrayList<Cliente> clientes;
	private ServicioConvencion servsConvencion;
	//Constructor
	
	
	
	public Convencion(int numPersonas, String tematica, double precio, ArrayList<Cliente> clientes,
			int estado,String pId,ServicioConvencion servsConvencion) {
		super();
		this.id = pId;
		this.numPersonas = numPersonas;
		this.tematica = tematica;
		this.precio = precio;
		this.clientes = clientes;
		this.servsConvencion = servsConvencion;
		//Verifica que el estado cumpla las reglas de negocio
		this.estado = estado == 1 || estado ==  0 ? estado : -1 ;
	}



	//Metodos
	
	public int getEstado() {
		return estado;
	}



	public void setEstado(int estado) {
		this.estado = estado;
	}

	public int getNumPersonas() {
		return numPersonas;
	}

	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public ServicioConvencion getServsConvencion() {
		return servsConvencion;
	}


	public void setServsConvencion(ServicioConvencion servsConvencion) {
		this.servsConvencion = servsConvencion;
	}


	public void setNumPersonas(int numPersonas) {
		this.numPersonas = numPersonas;
	}
	public String getTematica() {
		return tematica;
	}
	public void setTematica(String tematica) {
		this.tematica = tematica;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public ArrayList<Cliente> getClientes() {
		return clientes;
	}
	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}

	
	
	
	
	
}
