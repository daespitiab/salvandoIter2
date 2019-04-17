package uniandes.isis2304.hotelandes.negocio;

public class Ofrecen {

	private String idRestaurante;
	private String idProducto;
	
	//COnstructor
	
	public Ofrecen(String idRestaurante, String idProducto) {
		super();
		this.idRestaurante = idRestaurante;
		this.idProducto = idProducto;
	}
	
	
	//Metdos
	public String getIdRestaurante() {
		return idRestaurante;
	}
	public void setIdRestaurante(String idRestaurante) {
		this.idRestaurante = idRestaurante;
	}
	public String getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}
	
	
}
