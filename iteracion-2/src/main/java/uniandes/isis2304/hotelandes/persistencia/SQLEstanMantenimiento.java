package uniandes.isis2304.hotelandes.persistencia;


import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.hotelandes.negocio.EstanMantenimiento;

//----------------------------------Terminado--------------------------------

public class SQLEstanMantenimiento {

	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Cadena que representa el tipo de consulta que se va a realizar en las sentencias de acceso a la base de datos
	 * Se renombra ac� para facilitar la escritura de las sentencias
	 */
	private final static String SQL =  PersistenciaHotelAndes.SQL;
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El manejador de persistencia general de la aplicaci�n
	 */
	private  PersistenciaHotelAndes  pp;

	/* ****************************************************************
	 * 			M�todos
	 *****************************************************************/
	/**
	 * Constructor
	 * @param pp - El Manejador de persistencia de la aplicaci�n
	 */
	public SQLEstanMantenimiento( PersistenciaHotelAndes  pp)
	{
		this.pp = pp;
	}

	//Adiciona una habitacion a mantenimiento
	public long agregarMantenimiento (PersistenceManager pm, String id,  String estado)
	{
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaEstanMantenimiento() + "(id, estado) values (?, ?)");
		q.setParameters(id, estado);
		return (long) q.executeUnique();          
	}
	//Elimiar Mantenimiento
	public long eliminarMantenimiento (PersistenceManager pm, long id)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaEstanMantenimiento() + " WHERE id = ?");
		q.setParameters(id);
		return (long) q.executeUnique();            
	}

	//Buscar un mantenimiento

//	public Bebedor darBebedorPorId (PersistenceManager pm, long idBebedor) 
//	{
//		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaBebedor () + " WHERE id = ?");
//		q.setResultClass(Bebedor.class);
//		q.setParameters(idBebedor);
//		return (Bebedor) q.executeUnique();
//	}
	
	

	public EstanMantenimiento darMantenimientoPorId (PersistenceManager pm, String id) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaEstanMantenimiento() + " WHERE id = ?");
		q.setResultClass( EstanMantenimiento .class);
		q.setParameters(id);
		return ( EstanMantenimiento ) q.executeUnique();
	}


	//Actualizar Mantenimiento
	public long actualizarEstadoM (PersistenceManager pm, String id, int est)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaEstanMantenimiento() + " SET estado = ? WHERE id = ?");
		q.setParameters(est, id);
		return (long) q.executeUnique();    
	}
}
