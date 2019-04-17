package uniandes.isis2304.hotelandes.negocio;


import java.util.Hashtable;

public class RestauranteBar extends Servicio {

	//Atributos
	private int capacidad;
	private String estilo;
	private Hashtable<String, Integer> cartaProductos;
	private int reservado;
	
	//Constructor
	public RestauranteBar(int pReservado,boolean pPresentaPagoAdicional, double pPrecio, 
			String pIdentificador, int pCapacidad, 
			String pEstilo, String nombre) 
	{
		super(0 , 0, pIdentificador, nombre);
		capacidad = pCapacidad;
	    estilo = pEstilo;
	    reservado = pReservado == 0 || pReservado == 1? pReservado:-1;
	    cartaProductos = new  Hashtable(); 
	}
	
	
	//Metodos
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	public String getEstilo() {
		return estilo;
	}
	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}
	public Hashtable<String, Integer> getCartaProductos() {
		return cartaProductos;
	}
	public void setCartaProductos(Hashtable<String, Integer> cartaProductos) {
		this.cartaProductos = cartaProductos;
	}
	public int isReservado() {
		return reservado;
	}
	public void setReservado(int reservado) {
		this.reservado = reservado;
	}	
}
