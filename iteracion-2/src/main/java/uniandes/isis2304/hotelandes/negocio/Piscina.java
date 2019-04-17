package uniandes.isis2304.hotelandes.negocio;

import java.time.LocalDateTime;

public class Piscina extends Servicio
{

	//Atributos
	
	private int capacidad;
	private LocalDateTime horaIncio;
	private LocalDateTime horFinal;
	
	//Constructor
	public Piscina( int pPresentaPagoAdicional, double pPrecio, String pIdentificador,String nombre,
			int capacidad, double profundidad, LocalDateTime inicio, LocalDateTime fin) {
		super(pPresentaPagoAdicional, pPrecio, pIdentificador, null);
	}
	
	//Metodos

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}


	public LocalDateTime getHoraIncio() {
		return horaIncio;
	}

	public void setHoraIncio(LocalDateTime horaIncio) {
		this.horaIncio = horaIncio;
	}

	public LocalDateTime getHorFinal() {
		return horFinal;
	}

	public void setHorFinal(LocalDateTime horFinal) {
		this.horFinal = horFinal;
	}
	
	
	

	
	
}
