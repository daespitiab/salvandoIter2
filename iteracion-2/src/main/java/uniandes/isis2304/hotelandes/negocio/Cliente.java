package uniandes.isis2304.hotelandes.negocio;

import java.util.Hashtable;
import java.util.List;

public class Cliente {

	
	private String id;
	private String tipo_id;
	private int telefono;
	private String nombre;
	private String correo;
	private String id_Plan;
	private String id_reservacion_Hotel;

	private Hashtable<String, Double>  servicios;
	private String id_servicios_Hotel;
	private String id_cuenta;
	
	
	
	public Cliente(String id, String tipo_id, int telefono, String correo, String id_Plan, String id_reservacion_Hotel,
			 String id_servicios_Hotel,String id_cuenta, String pCliente) 
	{
		this.nombre = pCliente;
		this.id = id;
		this.tipo_id = tipo_id;
		this.telefono = telefono;
		this.correo = correo;
		this.id_Plan = id_Plan;
		this.id_reservacion_Hotel = id_reservacion_Hotel;
		
		this.servicios = new Hashtable<String, Double>();
		this.id_servicios_Hotel = id_servicios_Hotel;
		this.id_cuenta = id_cuenta;
	}
	
	
	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Hashtable<String, Double> getServicios() {
		return servicios;
	}
	public void setServicios(Hashtable<String, Double> servicios) {
		this.servicios = servicios;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTipo_id() {
		return tipo_id;
	}
	public void setTipo_id(String tipo_id) {
		this.tipo_id = tipo_id;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getId_Plan() {
		return id_Plan;
	}
	public void setId_Plan(String id_Plan) {
		this.id_Plan = id_Plan;
	}
	public String getId_reservacion_Hotel() {
		return id_reservacion_Hotel;
	}
	public void setId_reservacion_Hotel(String id_reservacion_Hotel) {
		this.id_reservacion_Hotel = id_reservacion_Hotel;
	}
	
	public String getId_servicios_Hotel() {
		return id_servicios_Hotel;
	}
	public void setId_servicios_Hotel(String id_servicios_Hotel) {
		this.id_servicios_Hotel = id_servicios_Hotel;
	}
	public String getId_cuenta() {
		return id_cuenta;
	}
	public void setId_cuenta(String id_cuenta) {
		this.id_cuenta = id_cuenta;
	}
	
	
	
}
