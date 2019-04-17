package uniandes.isis2304.hotelandes.negocio;

public class TienenMaquinas {

	//Atributos
	private String idGim;
	private String nombreMaquina;
	//Constructor
	public TienenMaquinas(String idGim, String nombreMaquina) {
		super();
		this.idGim = idGim;
		this.nombreMaquina = nombreMaquina;
	}
	
	//Metodos
	public String getIdGim() {
		return idGim;
	}
	public void setIdGim(String idGim) {
		this.idGim = idGim;
	}
	public String getNombreMaquina() {
		return nombreMaquina;
	}
	public void setNombreMaquina(String nombreMaquina) {
		this.nombreMaquina = nombreMaquina;
	}
	
	
	
	
	
}
