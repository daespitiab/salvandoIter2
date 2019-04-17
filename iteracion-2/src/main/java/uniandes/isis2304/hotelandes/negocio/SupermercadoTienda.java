package uniandes.isis2304.hotelandes.negocio;

import java.util.Hashtable;

public class SupermercadoTienda extends Servicio{

private Hashtable<String, Integer> productos;
	
	public SupermercadoTienda( double pPrecio, String pIdentificador, String pNombre) {
		
		super(1, pPrecio, pIdentificador, pNombre);
		// TODO Auto-generated constructor stub
		productos = new Hashtable<String, Integer>();
	}

	public Hashtable<String, Integer> getProductos() {
		return productos;
	}

	public void setProductos(Hashtable<String, Integer> productos) {
		this.productos = productos;
	}
	
}
