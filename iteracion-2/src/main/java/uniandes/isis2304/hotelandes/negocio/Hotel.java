package uniandes.isis2304.hotelandes.negocio;

public class Hotel {
	private Long id;
	private String nombre;
	private String ubicacion;
	private String categoria;
	private int telefono;
	
	public Hotel(long idP, String nombreP, String ubicacionP, String categoriaP, int telefonoP){
		id = idP;
		nombre = nombreP;
		ubicacion = ubicacionP;
		categoria = categoriaP;
		telefono = telefonoP;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
}
