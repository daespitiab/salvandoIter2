package uniandes.isis2304.hotelandes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.hotelandes.negocio.Gimnasio;
import uniandes.isis2304.hotelandes.negocio.RestauranteBar;

//--------------------------Terminado----------------------------------
public class SQLRestauranteBar {


	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Cadena que representa el tipo de consulta que se va a realizar en las sentencias de acceso a la base de datos
	 * Se renombra ac� para facilitar la escritura de las sentencias
	 */
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
	public SQLRestauranteBar(PersistenciaHotelAndes pp)
	{
		this.pp = pp;
	}
	 
     //Adicion
	public long adicionarRestauranteBar (PersistenceManager pm, String pId,  int capacidad , String tematica, int reservado) 
	{
        Query q = pm.newQuery( SQL, "INSERT INTO " + pp.darTablaORestaurantesBar() + "(id, capacidad, tematica, reservado) values (?, ?, ?, ?)");
        q.setParameters( pId, capacidad, tematica, reservado);
        return (long) q.executeUnique();            
	}
    
	//Eliminar
	public long eliminarRestauranteBarPorId (PersistenceManager pm,String id)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaORestaurantesBar()+ " WHERE id = ?");
        q.setParameters(id);
        return (long) q.executeUnique();            
	}
	//Buscar
	public RestauranteBar darBebedorPorId (PersistenceManager pm, String idBebedor) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaORestaurantesBar() + " WHERE id = ?");
		q.setResultClass(RestauranteBar.class);
		q.setParameters(idBebedor);
		return (RestauranteBar) q.executeUnique();
	}

	//Listar
	public List<RestauranteBar> darBebedoresPorNombre (PersistenceManager pm, String id) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaORestaurantesBar() + " WHERE id = ?");
		q.setResultClass(RestauranteBar.class);
		q.setParameters(id);
		return (List<RestauranteBar>) q.executeList();
	}

	
}
