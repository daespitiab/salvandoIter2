package uniandes.isis2304.hotelandes.negocio;

public class Utencilio {

	//Constructor
	public  final static int  ESTADO_BUENO = 0;
	public final static int  ESTADO_MALO = 1;
	
	//Atributos
	private int prestado;
	private int  estado;
	private double precio;
	private String id;
	private String nombre;

	//Constructor
	public Utencilio(String pNombre, int  pPrestado, int stado,double pPrecio, String pId) {
		prestado = 0; // No esta prestado
		estado = ESTADO_BUENO;
		precio = pPrecio;
		id = pId;
		nombre = pNombre;
	}

	//Metodos
	public int getPrestado() {
		return prestado;
	}

	public void setPrestado(int prestado) {
		this.prestado = prestado;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
