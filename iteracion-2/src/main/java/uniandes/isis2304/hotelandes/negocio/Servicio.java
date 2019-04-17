package uniandes.isis2304.hotelandes.negocio;

import java.util.Hashtable;

public class Servicio {

	
	//Atributos
	private int presentaPagoAdicional;
	private double precio;
	private String identificador;
	private Hashtable<String, Cliente> clientes;
	private String nombre;
	private int estaMantenimiento;
	
	
	//Construtor
	public Servicio( int pPresentaPagoAdicional, double pPrecio, String pIdentificador, String pNombre) {
		presentaPagoAdicional = pPresentaPagoAdicional == 0 ||  pPresentaPagoAdicional == 1?  pPresentaPagoAdicional: -1;
		precio = pPrecio;
		identificador = pIdentificador;
		nombre = pNombre;
		clientes = new Hashtable<String, Cliente>();
		estaMantenimiento = 0;//no esta en mantenimiento
	}
	
	//Metodos - 
     /**
	 * Metodo para adquirir un servicio
	 * @param id
	 * @param servicio
	 */
	public void  adquirirServicio(String id, String nombre, double valor) 
	{
		Cliente cliente = clientes.get(id);		
	cliente.getServicios().put(nombre, valor);	}

	
	
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPresentaPagoAdicional() {
		return presentaPagoAdicional;
	}

	public void setPresentaPagoAdicional(int  presentaPagoAdicional) {
		this.presentaPagoAdicional = presentaPagoAdicional;
	}

	public double getPrecio() {
		return precio;
	}
	

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public Hashtable<String, Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(Hashtable<String, Cliente> clientes) {
		this.clientes = clientes;
	}

	public int getEstaMantenimiento() {
		return estaMantenimiento;
	}

	public void setEstaMantenimiento(int estaMantenimiento) {
		this.estaMantenimiento = estaMantenimiento;
	}
	
	
	
	

}