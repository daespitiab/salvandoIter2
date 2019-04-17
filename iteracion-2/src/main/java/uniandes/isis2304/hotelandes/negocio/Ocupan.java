package uniandes.isis2304.hotelandes.negocio;

public class Ocupan {

	//Atributos
	private String idCliente;
	private String idHabitacion;
	//Constructor
	public Ocupan(String idCliente, String idHabitacion) {
		super();
		this.idCliente = idCliente;
		this.idHabitacion = idHabitacion;
	}
	//Metodos
	public String getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}
	public String getIdHabitacion() {
		return idHabitacion;
	}
	public void setIdHabitacion(String idHabitacion) {
		this.idHabitacion = idHabitacion;
	}
	
	
}
