package uniandes.isis2304.hotelandes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.hotelandes.negocio.SupermercadoTienda;

//----------------------------Terminado-------------------------------
public class SQLSupermercadoTienda {

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
		public SQLSupermercadoTienda(PersistenciaHotelAndes pp)
		{
			this.pp = pp;
		}
	
	public long adicionarSupermercadoTienda (PersistenceManager pm, String pId,  String nom ) 
	{
        Query q = pm.newQuery( SQL, "INSERT INTO " + pp.darTablaSupermercados_Tiendas() + "(id, nombre) values (?, ?)");
        q.setParameters( pId, nom);
        return (long) q.executeUnique();            
	}
	
	//Eliminar
	public long eliminarSupermercadoTiendaPorId (PersistenceManager pm, String id)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaSupermercados_Tiendas() + " WHERE id = ?");
        q.setParameters( id);
        return (long) q.executeUnique();            
	}

	//Listar
	public List<SupermercadoTienda> darTablaSupermercadoTienda (PersistenceManager pm) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaSupermercados_Tiendas());
		q.setResultClass(SupermercadoTienda.class);
		return (List<SupermercadoTienda>) q.executeList();
	}
	
	
	
}
