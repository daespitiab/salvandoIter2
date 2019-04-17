package uniandes.isis2304.hotelandes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.hotelandes.negocio.TienenMaquinas;
import uniandes.isis2304.hotelandes.negocio.TiposHabitaciones;

//----------------------Termiando--------------------------------------
public class SQLTiposHabitacion {

	
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
	public SQLTiposHabitacion(PersistenciaHotelAndes pp)
	{
		this.pp = pp;
	}

	//Adicionar
	public long adicionarTienenMaquinas (PersistenceManager pm, int  pId,  String nom ) 
	{
		Query q = pm.newQuery( SQL, "INSERT INTO " + pp.darTablaTiposHabitaciones() + "(id, item_acomodacion) values (?, ?)");
		q.setParameters( pId, nom);
		return (long) q.executeUnique();            
	}

	//Eliminar
	public long eliminarTienenMaquinasPorId (PersistenceManager pm, String id)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaTiposHabitaciones() + " WHERE id = ?");
		q.setParameters( id);
		return (long) q.executeUnique();            
	}


	//Listar
	public List<TiposHabitaciones> dartiposHabitaciones (PersistenceManager pm ) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaTiposHabitaciones());
		q.setResultClass(TiposHabitaciones.class);
		return (List<TiposHabitaciones>) q.executeList();
	}
}
