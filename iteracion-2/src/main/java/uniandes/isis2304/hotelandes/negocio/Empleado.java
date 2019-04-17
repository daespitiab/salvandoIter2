package uniandes.isis2304.hotelandes.negocio;

public class Empleado {

	//Constantes
	public final static int ROL_GERENTE = 1;
	public final static int ROL_DATOS = 2;
	public final static int ROL_RECEPCIONISTA = 3;
	public final static int ROL_SERVICIOS = 4;
	// El organizador de eventos se registra en las tablas como un empleado
	//normal 
	public final static int ROL_EVENTOS = 5;
	//Atributos
	private String id;
	private String nombre;
	private int rol;
	
	
	//Constructor



	public Empleado(String id, String nombre, int  id_tipo) {
	


		this.id = id;
		//Verifica las reglas de negocio
		this.rol = id_tipo > 0 && id_tipo < 6 ? id_tipo:-1;
		this.nombre = nombre;
	}
	

	//Metodos
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


	public int getRol() {
		return rol;
	}

	public void setRol(int rol) {
		this.rol = rol;
	}
	
	
}
