package uniandes.isis2304.hotelandes.negocio;

public class Acompañante {

	//Atributos
	private String id_cliente;
	private String  id_acomp;
	private String nombre_acomp;
	
	//Constructor
	
	public Acompañante(String id_cliente, String id_acomp, String nombre_acomp) {
		super();
		this.id_cliente = id_cliente;
		this.id_acomp = id_acomp;
		this.nombre_acomp = nombre_acomp;
	}
	//Metodos

	public String getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(String id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getId_acomp() {
		return id_acomp;
	}

	public void setId_acomp(String id_acomp) {
		this.id_acomp = id_acomp;
	}

	public String getNombre_acomp() {
		return nombre_acomp;
	}

	public void setNombre_acomp(String nombre_acomp) {
		this.nombre_acomp = nombre_acomp;
	}
	
}
