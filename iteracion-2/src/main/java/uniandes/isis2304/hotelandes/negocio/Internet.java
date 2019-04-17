package uniandes.isis2304.hotelandes.negocio;

public class Internet extends Servicio{

	
	
	//Atributos
	private int capacidad;
	
	
	//Constructor
	public Internet( int pPresentaPagoAdicional, double pPrecio,int pCapacidad, String pIdentificador) {
		super(pPresentaPagoAdicional, pPrecio, pIdentificador, null);
		capacidad = pCapacidad;
		
	}

	//Metodos 
	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}


}
