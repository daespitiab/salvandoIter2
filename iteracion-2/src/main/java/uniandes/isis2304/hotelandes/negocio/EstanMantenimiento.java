package uniandes.isis2304.hotelandes.negocio;

public class EstanMantenimiento {

	//Atributos
	private String id;
	private String estado;
	
	//Constructor
	public EstanMantenimiento(String id, String estado) {
		super();
		this.id = id;
		this.estado = estado;
	}
	
	//Metodos
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
}
