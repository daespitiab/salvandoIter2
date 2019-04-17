package uniandes.isis2304.hotelandes.negocio;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Gimnasio extends Servicio{


	
	//Atributos
	
	private ArrayList<String> maquinas;
	private LocalDateTime horainicio;
	private LocalDateTime horafin;
	
	//Constructor
	public Gimnasio(int pPresentaPagoAdicional, double pPrecio, String pIdentificador, String pNombre, String id,
			 double precio, boolean precioAdicional, int capacidad, ArrayList<String> maquinas,
			LocalDateTime horainicio, LocalDateTime horafin) {
		
		super(pPresentaPagoAdicional, pPrecio, pIdentificador, pNombre);
		this.maquinas = maquinas;
		this.horainicio = horainicio;
		this.horafin = horafin;
	}
	
    //Metodos
	public ArrayList<String> getMaquinas() {
		return maquinas;
	}

	public void setMaquinas(ArrayList<String> maquinas) {
		this.maquinas = maquinas;
	}

	public LocalDateTime getHorainicio() {
		return horainicio;
	}

	public void setHorainicio(LocalDateTime horainicio) {
		this.horainicio = horainicio;
	}

	public LocalDateTime getHorafin() {
		return horafin;
	}

	public void setHorafin(LocalDateTime horafin) {
		this.horafin = horafin;
	}
	
	
	
}
