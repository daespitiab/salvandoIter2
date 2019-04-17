package uniandes.isis2304.hotelandes.negocio;

public class Rol implements VORol {

	//Atributos
	private long id;
	private String nombre;
	private String descripcion;

	//Constructor
	public Rol(long id, String nombre, String descripcion) {
//		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	//Metodos
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
