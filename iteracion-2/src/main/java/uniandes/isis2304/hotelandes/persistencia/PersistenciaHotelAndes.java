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

package uniandes.isis2304.hotelandes.persistencia;


import java.math.BigDecimal;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

import javax.jdo.JDODataStoreException;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import org.apache.log4j.Logger;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import uniandes.isis2304.hotelandes.negocio.Empleado;
import uniandes.isis2304.hotelandes.negocio.Habitacion;
import uniandes.isis2304.hotelandes.negocio.Hotel;
import uniandes.isis2304.hotelandes.negocio.Plan;
import uniandes.isis2304.hotelandes.negocio.ReservacionHotel;
import uniandes.isis2304.hotelandes.negocio.Rol;

import uniandes.isis2304.hotelandes.persistencia.PersistenciaHotelAndes;

/**
 * Clase para el manejador de persistencia del proyecto Parranderos
 * Traduce la información entre objetos Java y tuplas de la base de datos, en ambos sentidos
 * Sigue un patrón SINGLETON (Sólo puede haber UN objeto de esta clase) para comunicarse de manera correcta
 * con la base de datos
 * Se apoya en las clases SQLBar, SQLBebedor, SQLBebida, SQLGustan, SQLSirven, SQLTipoBebida y SQLVisitan, que son 
 * las que realizan el acceso a la base de datos
 * 
 * @author Germán Bravo
 */
public class PersistenciaHotelAndes 
{
	
	/**
	 * Logger para escribir la traza de la ejecución
	 */
	private static Logger log = Logger.getLogger(PersistenciaHotelAndes.class.getName());
	
	/**
	 * Cadena para indicar el tipo de sentencias que se va a utilizar en una consulta
	 */
	public final static String SQL = "javax.jdo.query.SQL";

	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * Atributo privado que es el único objeto de la clase - Patrón SINGLETON
	 */
	private static PersistenciaHotelAndes instance;
	
	/**
	 * Fábrica de Manejadores de persistencia, para el manejo correcto de las transacciones
	 */
	private PersistenceManagerFactory pmf;
	
	/**
	 * Arreglo de cadenas con los nombres de las tablas de la base de datos, en su orden:
	 * Secuenciador, tipoBebida, bebida, bar, bebedor, gustan, sirven y visitan
	 */
	private List <String> tablas;
	
	/**
	 * Atributo para el acceso a las sentencias SQL propias a PersistenciaParranderos
	 */
	private SQLUtil sqlUtil;
	/**
	 * Atributo para el acceso a la tabla BAR de la base de datos
	 */
	private SQLAcompañante sqlAcompañante;
	/**
	 * Atributo para el acceso a la tabla BAR de la base de datos
	 */
	/**
	 * Atributo para el acceso a la tabla BAR de la base de datos
	 */
	private SQLCliente sqlCliente;

	/**
	 * Atributo para el acceso a la tabla BAR de la base de datos
	 */
	private SQLConvenciones sqlConvenciones;
	/**
	 * Atributo para el acceso a la tabla BAR de la base de datos
	 */
	private SQLCuenta sqlCuenta;
	/**
	 * Atributo para el acceso a la tabla BAR de la base de datos
	 */
	private SQLEmpleado sqlEmpleado;
	/**
	 * Atributo para el acceso a la tabla BAR de la base de datos
	 */
	private SQLEstanMantenimiento sqlEstanMantenimiento;
	/**
	 * Atributo para el acceso a la tabla BAR de la base de datos
	 */
	private SQLGimnasio sqlGimnasio;
	/**
	 * Atributo para el acceso a la tabla BAR de la base de datos
	 */
	private SQLHabitacion sqlHabitacion;
	/**
	 * Atributo para el acceso a la tabla BAR de la base de datos
	 */
	private SQLInternet sqlInternet;
	/**
	 * Atributo para el acceso a la tabla BAR de la base de datos
	 */
	private SQLLavPlanEmb sqlLavPlanEmb;
	/**
	 * Atributo para el acceso a la tabla BAR de la base de datos
	 */
	private SQLOcupan sqlOcupan;
	/**
	 * Atributo para el acceso a la tabla BAR de la base de datos
	 */
	private SQLOfrecen sqlOfrecen;
	/**
	 * Atributo para el acceso a la tabla BAR de la base de datos
	 */
	private SQLPiscina sqlPiscina;
	/**
	 * Atributo para el acceso a la tabla BAR de la base de datos
	 */
	private SQLPlan sqlPlan;
	
	private SQLHotel sqlHotel;

	/**
	 * Atributo para el acceso a la tabla BAR de la base de datos
	 */
	private SQLPrestamo_Salones sqlPrestamoSalones;
	/**
	 * Atributo para el acceso a la tabla BAR de la base de datos
	 */
	private SQLPrestamosUtencilios sqlPrestamoUtencilios;
	/**
	 * Atributo para el acceso a la tabla BAR de la base de datos
	 */

	/**
	 * Atributo para el acceso a la tabla BAR de la base de datos
	 */
	private SQLReservacionHotel sqlReservacionHotel;
	/**
	 * Atributo para el acceso a la tabla BAR de la base de datos
	 */
	
	/**
	 * Atributo para el acceso a la tabla BAR de la base de datos
	 */
	private SQLRestauranteBar sqlRestauranteBar;
	/**
	 * Atributo para el acceso a la tabla BAR de la base de datos
	 */
	private SQLRol sqlRol;
	/**
	 * Atributo para el acceso a la tabla BAR de la base de datos
	 */
	private SQLSalones sqlSalones;
	/**
	 * Atributo para el acceso a la tabla BAR de la base de datos
	 */
	private SQLServicioLimpieza sqlServicioLimpieza;

	
	/**
	 * Atributo para el acceso a la tabla BAR de la base de datos
	 */
	private SQLServiciosHotel sqlServiciosHotel;
	
	/**
	 * Atributo para el acceso a la tabla BAR de la base de datos
	 */
	private SQLSpa sqlSpa;
	/**
	 * Atributo para el acceso a la tabla BAR de la base de datos
	 */
	private SQLSupermercadoTienda sqlSupermercadoTienda;
	/**
	 * Atributo para el acceso a la tabla BAR de la base de datos
	 */
	private SQLTienenMaquinas sqlTienenMaquinas;
	/**
	 * Atributo para el acceso a la tabla BAR de la base de datos
	 */
	private SQLTiposHabitacion sqlTiposHabitacion;
	/**
	 * Atributo para el acceso a la tabla BAR de la base de datos
	 */
	private SQLUtencilios sqlUtencilios;

	
	
	
	
	/* ****************************************************************
	 * 			Métodos del MANEJADOR DE PERSISTENCIA
	 *****************************************************************/

	/**
	 * Constructor privado con valores por defecto - Patrón SINGLETON
	 */
	private PersistenciaHotelAndes ()
	{
		pmf = JDOHelper.getPersistenceManagerFactory("HotelAndes");		
		crearClasesSQL ();
		
		// Define los nombres por defecto de las tablas de la base de datos
		tablas = new LinkedList<String> ();
		tablas.add ("hoteles_sequence");
		tablas.add("H_ACOMPAÑANTES");//1
		tablas.add("H_ASISTENTES_CONVENCION");//2
		tablas.add("H_CLIENTES");//3
		tablas.add("H_CONSUMEN");//4
		tablas.add("H_CONVENCIONES");//5
		tablas.add("H_CUENTES");//6
		tablas.add("H_EMPLEADOS");//7
		tablas.add("H_ESTAN_MANTENIMIENTO");//8
		tablas.add("H_GIMANSIOS");//9
		tablas.add("H_HABITACIONES");//10
		tablas.add("H_HOTELES");//11
		tablas.add("H_INTERNET");//12
		tablas.add("H_LIMPIEZA");//13
		tablas.add("H_OCUPAN");//14
		tablas.add("H_OFRECEN");//15
		tablas.add("H_PISCINAS");//16
		tablas.add("H_PLANES");//17
		tablas.add("H_PRESENTAN_FALLOS");//18
		tablas.add("H_PRESTAMO_UTENCILIOS");//19
		tablas.add("H_PRODUCTOS_INSTALACIONES");//20
		tablas.add("H_RESERVACIONES_HOTEL");//21
		tablas.add("H_RESERVAS_SALONES_SPA");//22
		tablas.add("H_RESTAURANTES_BAR");//23
		tablas.add("H_ROLES");//24
		tablas.add("H_SALONES");//25
		tablas.add("H_SERVICIOS_CONVENCIONES");//28
		tablas.add("H_SERVICIOS_HOTEL");//27
		tablas.add("H_SERVICIOS_LIMPIEZA");//28
		tablas.add("H_SPAS");//29
		tablas.add("H_SUPERMERCADOS_TIENDAS");//30
		tablas.add("H_TIENENMAQUINAS");//31
		tablas.add("H_TIPOS_HABITACIONES");//32
		tablas.add("H_UTENCILIOS");//33	
		tablas.add("H_PRESTAMO_SALONES");//34
		
		
}

	/**
	 * Constructor privado, que recibe los nombres de las tablas en un objeto Json - Patrón SINGLETON
	 * @param tableConfig - Objeto Json que contiene los nombres de las tablas y de la unidad de persistencia a manejar
	 */
	private PersistenciaHotelAndes (JsonObject tableConfig)
	{
		crearClasesSQL ();
		tablas = leerNombresTablas (tableConfig);
		
		String unidadPersistencia = tableConfig.get ("unidadPersistencia").getAsString ();
		log.trace ("Accediendo unidad de persistencia: " + unidadPersistencia);
		pmf = JDOHelper.getPersistenceManagerFactory (unidadPersistencia);
	}

	/**
	 * @return Retorna el único objeto PersistenciaParranderos existente - Patrón SINGLETON
	 */
	public static PersistenciaHotelAndes getInstance ()
	{
		if (instance == null)
		{
			instance = new PersistenciaHotelAndes ();
		}
		return instance;
	}
	
	/**
	 * Constructor que toma los nombres de las tablas de la base de datos del objeto tableConfig
	 * @param tableConfig - El objeto JSON con los nombres de las tablas
	 * @return Retorna el único objeto PersistenciaParranderos existente - Patrón SINGLETON
	 */
	public static PersistenciaHotelAndes getInstance (JsonObject tableConfig)
	{
		if (instance == null)
		{
			instance = new PersistenciaHotelAndes (tableConfig);
		}
		return instance;
	}

	/**
	 * Cierra la conexión con la base de datos
	 */
	public void cerrarUnidadPersistencia ()
	{
		pmf.close ();
		instance = null;
	}
	
	/**
	 * Genera una lista con los nombres de las tablas de la base de datos
	 * @param tableConfig - El objeto Json con los nombres de las tablas
	 * @return La lista con los nombres del secuenciador y de las tablas
	 */
	private List <String> leerNombresTablas (JsonObject tableConfig)
	{
		JsonArray nombres = tableConfig.getAsJsonArray("tablas") ;

		List <String> resp = new LinkedList <String> ();
		for (JsonElement nom : nombres)
		{
			resp.add (nom.getAsString ());
		}
		
		return resp;
	}
	
	/**
	 * Crea los atributos de clases de apoyo SQL
	 */
	private void crearClasesSQL ()
	{

		sqlAcompañante = new SQLAcompañante(this);
		sqlCliente = new SQLCliente(this);   
        sqlConvenciones = new SQLConvenciones(this);
        sqlCuenta = new SQLCuenta(this);
        sqlEmpleado = new SQLEmpleado(this);
        sqlEstanMantenimiento = new SQLEstanMantenimiento(this);
        sqlGimnasio = new SQLGimnasio(this);
        sqlHabitacion = new SQLHabitacion(this);
        sqlInternet = new SQLInternet(this);
        sqlLavPlanEmb = new SQLLavPlanEmb(this);
        sqlOcupan = new SQLOcupan(this);
        sqlOfrecen = new SQLOfrecen(this);
        sqlPiscina = new SQLPiscina(this);
        sqlPlan = new SQLPlan(this);
        sqlHotel = new SQLHotel(this);
        
        sqlPrestamoSalones = new SQLPrestamo_Salones( this);
        sqlPrestamoUtencilios = new SQLPrestamosUtencilios(this);

        sqlReservacionHotel = new SQLReservacionHotel(this);

        sqlRestauranteBar = new SQLRestauranteBar(this);
        sqlRol = new SQLRol(this);
        sqlSalones = new SQLSalones(this);
        sqlServicioLimpieza = new SQLServicioLimpieza(this);
 
        sqlServiciosHotel = new SQLServiciosHotel(this);
        sqlSpa = new SQLSpa(this);
        sqlSupermercadoTienda = new SQLSupermercadoTienda(this);
        sqlTiposHabitacion = new SQLTiposHabitacion(this);
        sqlUtencilios = new SQLUtencilios(this);
        sqlUtil = new SQLUtil(this);

		
     
	}

	/**
	 * @return La cadena de caracteres con el nombre del secuenciador de hotel andes
	 */
	public String darSeqHotelAndes ()
	{
		return tablas.get (0);
	}

	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Bar de parranderos
	 */
	public String darTablaAcompañantes ()
	{
		return tablas.get (1);
	}

	
	/**
	 * @return La cadena de caracteres con el nombre de la tabla de TipoBebida de parranderos
	 */
	public String darTablaAsistentesConvencion ()
	{
		return tablas.get (2);
	}
	
	
	/**
	 * @return La cadena de caracteres con el nombre de la tabla de TipoBebida de parranderos
	 */
	public String darTablaClientes ()
	{
		return tablas.get (3);
	}
	
	
	/**
	 * @return La cadena de caracteres con el nombre de la tabla de TipoBebida de parranderos
	 */
	public String darTablaConsumen ()
	{
		return tablas.get (4);
	}
	
	
	/**
	 * @return La cadena de caracteres con el nombre de la tabla de TipoBebida de parranderos
	 */
	public String darTablaConvenciones ()
	{
		return tablas.get (5);
	}
	
	
	
	/**
	 * @return La cadena de caracteres con el nombre de la tabla de TipoBebida de parranderos
	 */
	public String darTablaCuentas ()
	{
		return tablas.get (6);
	}
	
	/**
	 * @return La cadena de caracteres con el nombre de la tabla de TipoBebida de parranderos
	 */
	public String darTablaEmpleados ()
	{
		return tablas.get (7);
	}


	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Bebida de parranderos
	 */
	public String darTablaEstanMantenimiento ()
	{
		return tablas.get (8);
	}

	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Bar de parranderos
	 */
	public String darTablaGimanasios ()
	{
		return tablas.get (9);
	}
	
	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Bar de parranderos
	 */
	public String darTablaHabitaciones()
	{
		return tablas.get (10);
	}
	
	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Bar de parranderos
	 */
	public String darTablaHoteles()
	{
		return tablas.get (11);
	}


	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Gustan de parranderos
	 */
	public String darTablaInternet ()
	{
		return tablas.get (12);
	}

	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Sirven de parranderos
	 */
	public String darTablaLimpieza ()
	{
		return tablas.get (13);
	}

	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Visitan de parranderos
	 */
	public String darTablaOcupan ()
	{
		return tablas.get (14);
	}
	
	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Visitan de parranderos
	 */
	public String darTablaOfrecen ()
	{
		return tablas.get (15);
	}
	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Visitan de parranderos
	 */
	public String darTablaPiscinas ()
	{
		return tablas.get (16);
	}
	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Visitan de parranderos
	 */
	public String darTablaPlanes ()
	{
		return tablas.get (17);
	}
	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Visitan de parranderos
	 */
	public String darTablaPresentanFallos ()
	{
		return tablas.get (18);
	}
	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Visitan de parranderos
	 */
	public String darTablaPrestamoUtencilios ()
	{
		return tablas.get (19);
	}
	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Visitan de parranderos
	 */
	public String darTablaProductosInstalaciones ()
	{
		return tablas.get (20);
	}
	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Visitan de parranderos
	 */
	public String darTablaReservacionesHotel ()
	{
		return tablas.get (21);
	}
	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Visitan de parranderos
	 */
	public String darTablaReservacionServ ()
	{
		return tablas.get (22);
	}
	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Visitan de parranderos
	 */
	public String darTablaORestaurantesBar ()
	{
		return tablas.get (23);
	}
	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Visitan de parranderos
	 */
	public String darTablaRoles ()
	{
		return tablas.get (24);
	}
	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Visitan de parranderos
	 */
	public String darTablaSalones ()
	{
		return tablas.get(25);
	}
	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Visitan de parranderos
	 */
	public String darTablaServiciosConvenciones ()
	{
		return tablas.get (26);
	}
	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Visitan de parranderos
	 */
	public String darTablaServiciosHotel ()
	{
		return tablas.get (27);
	}
	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Visitan de parranderos
	 */
	public String darTablaServiciosLimpieza ()
	{
		return tablas.get (28);
	}
	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Visitan de parranderos
	 */
	public String darTablaSPAS ()
	{
		return tablas.get (29);
	}/**
	 * @return La cadena de caracteres con el nombre de la tabla de Visitan de parranderos
	 */
	public String darTablaSupermercados_Tiendas ()
	{
		return tablas.get (30);
	}/**
	 * @return La cadena de caracteres con el nombre de la tabla de Visitan de parranderos
	 */
	public String darTablaTienenMaquinas ()
	{
		return tablas.get (31);
	}/**
	 * @return La cadena de caracteres con el nombre de la tabla de Visitan de parranderos
	 */
	public String darTablaTiposHabitaciones()
	{
		return tablas.get (32);
	}/**
	 * @return La cadena de caracteres con el nombre de la tabla de Visitan de parranderos
	 */
	public String darTablaUtencilios ()
	{
		return tablas.get (33);
	}/**
	 * @return La cadena de caracteres con el nombre de la tabla de Visitan de parranderos
	 */
	public String darTablaPrestamoSalones ()
	{
		return tablas.get (34);
	}

	
	/**
	 * Transacción para el generador de secuencia de Parranderos
	 * Adiciona entradas al log de la aplicación
	 * @return El siguiente número del secuenciador de Parranderos
	 */
	private long nextval ()
	{
        long resp = sqlUtil.nextval (pmf.getPersistenceManager());
        log.trace ("Generando secuencia: " + resp);
        return resp;
    }
	
	/**
	 * Extrae el mensaje de la exception JDODataStoreException embebido en la Exception e, que da el detalle específico del problema encontrado
	 * @param e - La excepción que ocurrio
	 * @return El mensaje de la excepción JDO
	 */
	private String darDetalleException(Exception e) 
	{
		String resp = "";
		if (e.getClass().getName().equals("javax.jdo.JDODataStoreException"))
		{
			JDODataStoreException je = (javax.jdo.JDODataStoreException) e;
			return je.getNestedExceptions() [0].getMessage();
		}
		return resp;
	}

//	/* ****************************************************************
//	 * 			Métodos para manejar los REQUERIMIENTOS 
//	 *****************************************************************/
	
//	/**
//	 * Método que inserta, de manera transaccional, un tipo de usuario
//	 * Adiciona entradas al log de la aplicación
//	 * @param nombre - El nombre de la bebida
//	 * @param idTipoBebida - El identificador del tipo de bebida (Debe existir en la tabla TipoBebida)
//	 * @param gradoAlcohol - El grado de alcohol de la bebida (mayor que 0)
//	 * @return El objeto Rol adicionado. null si ocurre alguna Excepción
//	 */
	public Rol adicionarRol(String nombre, String descripcion) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
       Transaction tx=pm.currentTransaction();
       try
       {
           tx.begin();            
           long idRolLong = nextval ();          
           long tuplasInsertadas = sqlRol.adicionarRol(pm, idRolLong, nombre,descripcion);
           tx.commit();
           
           log.trace ("Inserción rol: " + nombre + ": " + tuplasInsertadas + " tuplas insertadas");
           return new Rol(idRolLong,nombre, descripcion);
       }
       catch (Exception e)
       {
       	e.printStackTrace();
       	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
       	return null;
       }
       finally
       {
           if (tx.isActive())
           {
               tx.rollback();
           }
           pm.close();
       }
	}
	
	public List<ReservacionHotel> RF12 (String[][] habTipoNum, String[][] ServCapHorario){
		
		List<Hotel> hoteles = sqlHotel.darHoteles(pmf.getPersistenceManager());
		for (int i = 0; i < hoteles.size(); i++) {
			for (int j = 0; j < habTipoNum.length; j++) {
				Query q = pmf.getPersistenceManager().newQuery(SQL, "SELECT COUNT(*) FROM H_HABITACIONES HAB"
						+ " INNER JOIN	H_TIPO_HABITACIONES TIPO ON HAB.ID_TIPO = TIPO.ID "
						+ "WHERE TIPO.NOMBRE = "+habTipoNum[j][0]+" AND HAB.ID_HOTEL = "+i+" "
								+ "AND HAB.RESERVADA = 0;");
				int numHabHotel = (int)q.executeUnique();
				if(numHabHotel < Integer.parseInt(habTipoNum[j][1])){
					return null;
				}
			}
			for (int j = 0; j < ServCapHorario.length; j++) {
				if(ServCapHorario[j][0].equals("Gimnasio")){
					Query q = pmf.getPersistenceManager().newQuery(SQL, "SELECT ID_GIMNASIO FROM H_SERVICIOS_HOTEL "
							+ "WHERE IDHOTEL = "+i+" AND ID_GIMNASIO IS NOT NULL;");
					List<Integer> idServicios = (List<Integer>) q.executeList();
					boolean encontre = false;
					for (int k = 0; k < ServCapHorario.length && !encontre; k++) {
						q = pmf.getPersistenceManager().newQuery(SQL, "SELECT CAPACIDAD FROM H_GIMNASIOS "
								+ "WHERE ID = "+idServicios.get(k)+";");
						if(Integer.parseInt(ServCapHorario[j][1]) <= (Integer) q.executeUnique()){
							Query inicioR = pmf.getPersistenceManager().newQuery(SQL, "SELECT H_RESERVACIONES_HOTEL FROM H_GIMNASIOS "
									+ "WHERE ID = "+idServicios.get(k)+";");
							
							LocalDateTime inicio = LocalDateTime.parse("", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
							//if(){
								
							//}
							encontre = true;
						}
					}
					
				}
			}
		}
		
		
		return null;
	}
	
//	/**
//	 * Método que inserta, de manera transaccional, un tipo de usuario
//	 * Adiciona entradas al log de la aplicación
//	 * @param nombre - El nombre de la bebida
//	 * @param idTipoBebida - El identificador del tipo de bebida (Debe existir en la tabla TipoBebida)
//	 * @param gradoAlcohol - El grado de alcohol de la bebida (mayor que 0)
//	 * @return El objeto Rol adicionado. null si ocurre alguna Excepción
//	 */

//	public Empleado adicionarEmpleado(String nombre, int id_rol) 
//	{
//		PersistenceManager pm = pmf.getPersistenceManager();
//      Transaction tx=pm.currentTransaction();
//      try
//      {
//          tx.begin();            
//          long idlong = nextval ();
//          String idEmpleado=String.valueOf(idlong);
//          long tuplasInsertadas = sqlEmpleado.adicionarEmpleado(pm, idEmpleado, nombre,id_rol);
//          tx.commit();
//          
//          log.trace ("Inserción rol: " + nombre + ": " + tuplasInsertadas + " tuplas insertadas");
//          return new Empleado(idEmpleado,nombre,id_rol);
//      }
//      catch (Exception e)
//      {
//////      	e.printStackTrace();
//      	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
//      	return null;
//      }
//      finally
//      {
//          if (tx.isActive())
//          {
//              tx.rollback();
//          }
//          pm.close();
//      }
//	}
//	
//	

//	public Empleado adicionarEmpleado(String nombre, int id_rol) 
//	{
//		PersistenceManager pm = pmf.getPersistenceManager();
//      Transaction tx=pm.currentTransaction();
//      try
//      {
//          tx.begin();            
//          long idlong = nextval ();
//          String idEmpleado=String.valueOf(idlong);
//          long tuplasInsertadas = sqlEmpleado.adicionarEmpleado(pm, idEmpleado, nombre,id_rol);
//          tx.commit();
//          
//          log.trace ("Inserción rol: " + nombre + ": " + tuplasInsertadas + " tuplas insertadas");
//          return new Empleado(idEmpleado,nombre,id_rol);
//      }
//      catch (Exception e)
//      {
//////      	e.printStackTrace();
//      	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
//      	return null;
//      }
//      finally
//      {
//          if (tx.isActive())
//          {
//              tx.rollback();
//          }
//          pm.close();
//      }
//	}
//	
//	/**
//	 * Método que inserta, de manera transaccional, un tipo de usuario
//	 * Adiciona entradas al log de la aplicación
//	 * @param nombre - El nombre de la bebida
//	 * @param idTipoBebida - El identificador del tipo de bebida (Debe existir en la tabla TipoBebida)
//	 * @param gradoAlcohol - El grado de alcohol de la bebida (mayor que 0)
//	 * @return El objeto Rol adicionado. null si ocurre alguna Excepción
//	 */
//	public Empleado adicionarTipoHabitacion(String nombre,List<String> items) 
//	{
//		PersistenceManager pm = pmf.getPersistenceManager();
//     Transaction tx=pm.currentTransaction();
//     try
//     {
//         tx.begin();            
//         long idlong = nextval ();
//         String idEmpleado=String.valueOf(idlong);
//         long tuplasInsertadas = sqlEmpleado.adicionarEmpleado(pm, idEmpleado, nombre,id_rol);
//         tx.commit();
//         
//         log.trace ("Inserción rol: " + nombre + ": " + tuplasInsertadas + " tuplas insertadas");
//         return new Empleado(idEmpleado,nombre,id_rol);
//     }
//     catch (Exception e)
//     {
//////     	e.printStackTrace();
//     	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
//     	return null;
//     }
//     finally
//     {
//         if (tx.isActive())
//         {
//             tx.rollback();
//         }
//         pm.close();
//     }
//	}
	
	
	
//	/**
//	 * Método que inserta, de manera transaccional, un tipo de usuario
//	 * Adiciona entradas al log de la aplicación
//	 * @param nombre - El nombre de la bebida
//	 * @param idTipoBebida - El identificador del tipo de bebida (Debe existir en la tabla TipoBebida)
//	 * @param gradoAlcohol - El grado de alcohol de la bebida (mayor que 0)
//	 * @return El objeto Rol adicionado. null si ocurre alguna Excepción
//	 */
//	public Habitacion adicionarHabitacion(String id_tipo,int ocupada) 
//	{
//		PersistenceManager pm = pmf.getPersistenceManager();
//    Transaction tx=pm.currentTransaction();
//    try
//    {
//        tx.begin();            
//        long idlong = nextval ();
//        String idHabitacion=String.valueOf(idlong);
//        long tuplasInsertadas = sqlHabitaciones.adicionarHabitacion(pm, idHabitacion,id_tipo, ocupada);
//        tx.commit();
//        
////        log.trace ("Inserción rol: " + nombre + ": " + tuplasInsertadas + " tuplas insertadas");
//        return new Habitacion(idHabitacion,id_tipo,ocupada);
//    }
//    catch (Exception e)
//    {
//////    	e.printStackTrace();
//    	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
//    	return null;
//    }
//    finally
//    {
//        if (tx.isActive())
//        {
//            tx.rollback();
//        }
//        pm.close();
//    }
//	}
	
	
	
//	/**
//	 * Método que inserta, de manera transaccional, un tipo de usuario
//	 * Adiciona entradas al log de la aplicación
//	 * @param nombre - El nombre de la bebida
//	 * @param idTipoBebida - El identificador del tipo de bebida (Debe existir en la tabla TipoBebida)
//	 * @param gradoAlcohol - El grado de alcohol de la bebida (mayor que 0)
//	 * @return El objeto Rol adicionado. null si ocurre alguna Excepción
//	 */
//	public ServiciosHotelActual  adicionaServicioHotel(long idHotel, String nombre_servicio) 
//	{
//		PersistenceManager pm = pmf.getPersistenceManager();
//      Transaction tx=pm.currentTransaction();
//      try
//      {
//          tx.begin();            
//          long idServicio = nextval ();
//          long tuplasInsertadas = sqlServiciosHotel.adicionarServicios(pm, idHotel, idServicio,nombre_servicio);
//          tx.commit();
//          
//     
//          return new ServiciosHotelActual(idHotel,idServicio,nombre_servicio);
//      }
//      catch (Exception e)
//      {
//////      	e.printStackTrace();
//      	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
//      	return null;
//      }
//      finally
//      {
//          if (tx.isActive())
//          {
//              tx.rollback();
//          }
//          pm.close();
//      }
//	}
	

//	/**
//	 * Método que inserta, de manera transaccional, un tipo de usuario
//	 * Adiciona entradas al log de la aplicación
//	 * @param nombre - El nombre de la bebida
//	 * @param idTipoBebida - El identificador del tipo de bebida (Debe existir en la tabla TipoBebida)
//	 * @param gradoAlcohol - El grado de alcohol de la bebida (mayor que 0)
//	 * @return El objeto Rol adicionado. null si ocurre alguna Excepción
//	 */
//	public Plan adicionaPlanConsumo( String tipo, double descuento, int cant_noches ) 
//	{
//		PersistenceManager pm = pmf.getPersistenceManager();
//      Transaction tx=pm.currentTransaction();
//      try
//      {
//          tx.begin();            
//          long idlong = nextval ();
//          String idPlan=String.valueOf(idlong);
//          long tuplasInsertadas = sqlPlanes.adicionarPlan(pm, idPlan, tipo, descuento, cant_noches);
//          tx.commit();
//          
//          return new Plan(idPlan,tipo ,descuento, (int) cant_noches);
//      }
//      catch (Exception e)
//      {
//////      	e.printStackTrace();
//      	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
//      	return null;
//      }
//      finally
//      {
//          if (tx.isActive())
//          {
//              tx.rollback();
//          }
//          pm.close();
//      }
//	}
	
//	
////	/**
////	 * Método que inserta, de manera transaccional, un tipo de usuario
////	 * Adiciona entradas al log de la aplicación
////	 * @param nombre - El nombre de la bebida
////	 * @param idTipoBebida - El identificador del tipo de bebida (Debe existir en la tabla TipoBebida)
////	 * @param gradoAlcohol - El grado de alcohol de la bebida (mayor que 0)
////	 * @return El objeto Rol adicionado. null si ocurre alguna Excepción
////	 */
//	public Plan adicionaPlanConsumo( String tipo, double descuento, int cant_noches ) 
//	{
//		PersistenceManager pm = pmf.getPersistenceManager();
//     Transaction tx=pm.currentTransaction();
//     try
//     {
//         tx.begin();            
//         long idlong = nextval ();
//         String idPlan=String.valueOf(idlong);
//         long tuplasInsertadas = sqlPlanes.adicionarPlan(pm, idPlan,tipo,descuento,cant_noches);
//         tx.commit();
//         
//         return new Plan(idPlan,tipo,descuento,cant_noches);
//     }
//     catch (Exception e)
//     {
//////     	e.printStackTrace();
//     	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
//     	return null;
//     }
//     finally
//     {
//         if (tx.isActive())
//         {
//             tx.rollback();
//         }
//         pm.close();
//     }
//	}
//	
	
	
	
	///Requerimiento 7
	
//	public void registrarReserva(String id, String fi, String ff, int cant, int num) {
//		
//		try {
//		PersistenceManager pm = pmf.getPersistenceManager();
//		sqlReservacionesH.adicionarReservacion(pm, id, fi,ff,cant,num);
//		
//		}
//		catch(Exception e){
//			System.out.println("No se guardo correctamente la reserva en la base de datos");
//		}
		
		
		
//		public void requerocho() 
//		{
//			
//			try {
//				PersistenceManager pm = pmf.getPersistenceManager();
//				//sqlRestauranteBar.
//				
//				}
//				catch(Exception e){
//					System.out.println("No se guardo correctamente la reserva en la base de datos");
//				}
//				
//		}
		
//	}
	//requerimiento 9
//	public void registrarCliente(String idCliente,String tipoId, String nombre, int telefono, String correo,long id_Plan,long id_reservacion_Hotel,long id_reserva_servicios, long id_cuenta) {
//		try {
//			PersistenceManager pm = pmf.getPersistenceManager();
//			sqlCliente.adicionarCliente(pm, idCliente, tipoId, nombre, telefono, correo, id_Plan, id_reservacion_Hotel, id_reserva_servicios, id_cuenta);
//			
//			}
//			catch(Exception e){
//				System.out.println("No se guardo correctamente la reserva en la base de datos");
//			}
//			
//		
//	
//	}
//	
	
	
	//requerimiento 10
//	public void removerCliente(long id) {
//	
//		try {
//			PersistenceManager pm = pmf.getPersistenceManager();
//			sqlCliente.eliminarBebedorPorId(pm, id);
//			
//			}
//			catch(Exception e){
//				System.out.println("No se guardo correctamente la reserva en la base de datos");
//			}
//	}
	
	
	
	public int darDineroRecolectado(PersistenceManager pm,Date fi, Date ff)
	{
		return sqlServiciosHotel.darDineroRecolectado(pm, fi, ff);
	}

	public List<String> darServiciosMasPopulares(PersistenceManager pm)
	{
		return sqlServiciosHotel.darServiciosMasPopulares(pm);
	}
		
	
	
	
}
	
	
	
	
	


	







	
	

 
