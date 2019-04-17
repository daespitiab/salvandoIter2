package uniandes.isis2304.hotelandes.negocio;


import java.time.LocalDateTime;

public class ReservacionHotel {

	
	//Atributos
	private String id;
	private LocalDateTime  fechaIni;
	private LocalDateTime fechaF;
	private int numeroPersonas;
	private Plan plan;
	
	
	//Constructor
	public ReservacionHotel(String id, LocalDateTime fechaIni, LocalDateTime  fechaF, int numeroPersonas, Plan plan) {
		
		this.id = id;
		this.fechaIni = fechaIni;
		this.fechaF = fechaF;
		this.numeroPersonas = numeroPersonas;
		this.plan = plan;
	}
	
	//Metodos
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public LocalDateTime  getFechaIni() {
		return fechaIni;
	}
	public void setFechaIni(LocalDateTime  fechaIni) {
		this.fechaIni = fechaIni;
	}
	public LocalDateTime  getFechaF() {
		return fechaF;
	}
	public void setFechaF(LocalDateTime  fechaF) {
		this.fechaF = fechaF;
	}
	public int getNumeroPersonas() {
		return numeroPersonas;
	}
	public void setNumeroPersonas(int numeroPersonas) {
		this.numeroPersonas = numeroPersonas;
	}
	public Plan getPlan() {
		return plan;
	}
	public void setPlan(Plan plan) {
		this.plan = plan;
	}
}
