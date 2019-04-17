/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad	de	los	Andes	(Bogotá	- Colombia)
 * Departamento	de	Ingeniería	de	Sistemas	y	Computación
 * Licenciado	bajo	el	esquema	Academic Free License versión 2.1
 * 		
 * Curso: isis2304 - Sistemas Transaccionales
 * Proyecto: Parranderos Uniandes
 * @version 1.0
 * @author Germán Bravo
 * Julio de 2018
 * 
 * Revisado por: Claudia Jiménez, Christian Ariza
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.isis2304.hotelandes.negocio;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import com.google.gson.JsonObject;

import uniandes.isis2304.hotelandes.persistencia.PersistenciaHotelAndes;

/**
 * Clase principal del negocio
 * Sarisface todos los requerimientos funcionales del negocio
 *
 * @author Germán Bravo
 */
public class HotelAndes 
{
	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Logger para escribir la traza de la ejecución
	 */
	private static Logger log = Logger.getLogger(HotelAndes.class.getName());

	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El manejador de persistencia
	 */
	private PersistenciaHotelAndes pp;


	//Atributos
	private String id;
	private String categoria;
	private String nombre;
	private String telefono;
	private String ubicacionCiudad;
	private String direccion;
	private ArrayList<ReservacionHotel> reservaciones;
	private ArrayList<Habitacion> habitacionesLibres;
	private Hashtable<String, Habitacion> habitacionesOcupadas;
	private PersistenciaHotelAndes persistencia;
	private Hashtable<String, Cliente> clientes;

	public Hashtable<String, Servicio> serviciosDisponibles;

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * El constructor por defecto
	 */


	public HotelAndes(String id, String categoria, String nombre, String telefono, String ubicacionCiudad,String direccion) {


		this.id = id;
		this.categoria = categoria;
		this.nombre = nombre;
		this.telefono = telefono;
		this.ubicacionCiudad = ubicacionCiudad;
		this.direccion = direccion;	
		this.reservaciones = new ArrayList<ReservacionHotel>();
		this.habitacionesLibres = new ArrayList<Habitacion>(); 
		this.habitacionesOcupadas = new Hashtable<String, Habitacion> (); 
		this.clientes =  new Hashtable<String, Cliente>(); 
		pp = PersistenciaHotelAndes.getInstance ();
		serviciosDisponibles = new Hashtable<String, Servicio>();
	}
	/**
	 * El constructor qye recibe los nombres de las tablas en tableConfig
	 * @param tableConfig - Objeto Json con los nombres de las tablas y de la unidad de persistencia
	 */
	public HotelAndes (JsonObject tableConfig)
	{
		pp = PersistenciaHotelAndes.getInstance (tableConfig);
	}

	/**
	 * Cierra la conexión con la base de datos (Unidad de persistencia)
	 */
	public void cerrarUnidadPersistencia ()
	{
		pp.cerrarUnidadPersistencia ();
	}

	

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getUbicacionCiudad() {
		return ubicacionCiudad;
	}

	public void setUbicacionCiudad(String ubicacionCiudad) {
		this.ubicacionCiudad = ubicacionCiudad;
	}

	public String getDireccion() {
		return direccion;
	}
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public PersistenciaHotelAndes getPp() {
		return pp;
	}
	public void setPp(PersistenciaHotelAndes pp) {
		this.pp = pp;
	}
	public ArrayList<ReservacionHotel> getReservaciones() {
		return reservaciones;
	}
	public void setReservaciones(ArrayList<ReservacionHotel> reservaciones) {
		this.reservaciones = reservaciones;
	}
	public ArrayList<Habitacion> getHabitacionesLibres() {
		return habitacionesLibres;
	}
	public void setHabitacionesLibres(ArrayList<Habitacion> habitacionesLibres) {
		this.habitacionesLibres = habitacionesLibres;
	}

	public PersistenciaHotelAndes getPersistencia() {
		return persistencia;
	}
	public void setPersistencia(PersistenciaHotelAndes persistencia) {
		this.persistencia = persistencia;
	}
	public Hashtable<String, Cliente> getClientes() {
		return clientes;
	}
	public void setClientes(Hashtable<String, Cliente> clientes) {
		this.clientes = clientes;
	}


	/**
	 * Reuerimiento 12, reservar alojamiento y servicio para una convención
	 * @param id
	 * @param fechai
	 * @param fechaF
	 * @param cant
	 * @param plan
	 * @throws Exception
	 */
	public void reqN12(String id, LocalDateTime fechai, LocalDateTime fechaF, int cant, Plan plan) throws Exception {
		
	
	}

	/**
	 * Requerimiento 8 añadir reservacion en servicio
	 * @param id
	 * @param fecha
	 * @param tipo
	 * @throws Exception
	 */
	public void req8(String id, LocalDateTime fecha, String tipo) throws Exception {

	
	}

	/**
	 * Registra a un cliente en el hotel
	 * @param id
	 * @param tipo_id
	 * @param telefono
	 * @param correo
	 * @param id_Plan
	 * @param id_reservacion_Hotel
	 * @param id_reservacion_Servicio
	 * @param id_servicios_Hotel
	 * @param id_cuenta
	 * @param tipoHabitacion
	 * @throws Exception
	 */

	public void req9(String id, String tipo_id, int telefono, String correo, String id_Plan, String id_reservacion_Hotel,
			String id_reservacion_Servicio,  String id_servicios_Hotel,
			String id_cuenta, String tipoHabitacion) throws Exception {

		
	}

	/**
	 * Registra un consumo en la tabla de consumos
	 * @param idServicio
	 * @param idProducto
	 * @param precio
	 * @param idCliente
	 * @throws Exception
	 */

	public void reqn10(String idServicio, String idProducto, double precio, String idCliente) throws Exception {

		


	}	

	public void reqn11(String idCliente) throws Exception {
		
	}




	
	public long[] limpiarHotelAndes() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	public Rol adicionarRolDeUsuario(String nombre,String descripcion)
	{
		log.info ("Adicionando Rol de usuario: " + nombre+","+descripcion);
		Rol rolA = pp.adicionarRol(nombre, descripcion);		
		log.info ("Adicionando Rol: " + rolA);
		return rolA;
	}







}
