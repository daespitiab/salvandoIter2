package uniandes.isis2304.hotelandes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.hotelandes.negocio.TiposHabitaciones;
import uniandes.isis2304.hotelandes.negocio.Utencilio;

//----------------Terminado-------------------
public class SQLUtencilios {

	private final static String SQL = PersistenciaHotelAndes.SQL;
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El manejador de persistencia general de la aplicaci�n
	 */
	private PersistenciaHotelAndes pp;

	/* ****************************************************************
	 * 			M�todos
	 *****************************************************************/
	/**
	 * Constructor
	 * @param pp - El Manejador de persistencia de la aplicaci�n
	 */
	public SQLUtencilios(PersistenciaHotelAndes pp)
	{
		this.pp = pp;
	}

	//Adicionar
	public long adicionarUtencilio (PersistenceManager pm, String id, double precio, String estado, int pre, String nom ) 
	{
		Query q = pm.newQuery( SQL, "INSERT INTO " + pp.darTablaUtencilios() + "(id, precio, estado, prestado, nombre) values (?, ?, ? , ?, ?)");
		q.setParameters( id,precio,estado, pre, nom);
		return (long) q.executeUnique();            
	}

	//Eliminar
	public long eliminarUtencilio (PersistenceManager pm, String id)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaUtencilios()  + " WHERE id = ?");
		q.setParameters( id);
		return (long) q.executeUnique();            
	}


	//Listar
	public List<Utencilio> darUtencilios (PersistenceManager pm ) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaUtencilios() );
		q.setResultClass(Utencilio.class);
		return (List<Utencilio>) q.executeList();
	}
}
