package uniandes.isis2304.hotelandes.negocio;

public class Habitacion {

	//Constantes
	public final static int TIPO_SUITE = 1;
	public final static  int TIPO_SUITE_PRESIDENCIAL = 2;
	public final static  int TIPO_FAMILIAR = 3;
	public final static int TIPO_DOBLE = 4;
	public final static int TIPO_SENCILLA = 5;
	//Atributos
	private  int id;
	private String id_tipo;
	private int ocupada;
	private int esta_Mantenimiento;
	
	//Constructor
	public Habitacion( int idHabitacion, String id_tipo, int ocupada) {
		
		this.id = idHabitacion > 0 && idHabitacion < 6 ? idHabitacion:-1;
		this.id_tipo=id_tipo;
		//Verifica la regla de negocio
		this.ocupada=ocupada == 0 || ocupada == 1? ocupada : -1;
		this.esta_Mantenimiento = 0;//Por defecto,  las habitaciones no estan en mantenimiento
	}

   //Metodos
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getId_tipo() {
		return id_tipo;
	}


	public void setId_tipo(String id_tipo) {
		this.id_tipo = id_tipo;
	}


	public int getOcupada() {
		return ocupada;
	}


	public void setOcupada(int ocupada) {
		this.ocupada = ocupada;
	}

	public int getEstaMantenimiento() {
		return esta_Mantenimiento;
	}

	public void setEstaMantenimiento(int estaMantenimiento) {
		this.esta_Mantenimiento = estaMantenimiento;
	}
	

}
