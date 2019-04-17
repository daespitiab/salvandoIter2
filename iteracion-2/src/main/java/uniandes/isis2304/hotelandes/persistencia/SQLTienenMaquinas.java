package uniandes.isis2304.hotelandes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.hotelandes.negocio.TienenMaquinas;

public class SQLTienenMaquinas {


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
	public SQLTienenMaquinas(PersistenciaHotelAndes pp)
	{
		this.pp = pp;
	}

	//Adicionar
	public long adicionarTienenMaquinas (PersistenceManager pm, String pId,  String nom ) 
	{
		Query q = pm.newQuery( SQL, "INSERT INTO " + pp.darTablaTienenMaquinas() + "(id_gim, nombre_maquina) values (?, ?)");
		q.setParameters( pId, nom);
		return (long) q.executeUnique();            
	}

	//Eliminar
	public long eliminarTienenMaquinasPorId (PersistenceManager pm, String id)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaTienenMaquinas() + " WHERE id = ?");
		q.setParameters( id);
		return (long) q.executeUnique();            
	}


	//Listar
	public List<TienenMaquinas> darTienenMaquinas (PersistenceManager pm , String id) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaTienenMaquinas()+ " WHERE id = ?");
		q.setResultClass(TienenMaquinas.class);
		q.setParameters( id);
		return (List<TienenMaquinas>) q.executeList();
	}



}
