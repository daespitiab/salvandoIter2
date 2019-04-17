package uniandes.isis2304.hotelandes.negocio;

public class ServicioLimpieza {


	//Atributos
	private String id;
	private double precio;
	
	
	//Constructor
	public ServicioLimpieza(String id, double precio) {
		super();
		this.id = id; 
		this.precio = precio;
	}
	//Metodos
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	
}
