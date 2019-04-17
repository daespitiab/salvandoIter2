package uniandes.isis2304.hotelandes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.hotelandes.negocio.Ofrecen;
import uniandes.isis2304.hotelandes.negocio.ReservacionHotel;

//--------------------------------Terminado------------------------------
public class SQLOfrecen {

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
	public SQLOfrecen( PersistenciaHotelAndes  pp)
	{
		this.pp = pp;
	}
	
	//Adicionar
	
	public long adicionarOfrecen (PersistenceManager pm, String pId, String idP ) 
	{
        Query q = pm.newQuery( SQL, "INSERT INTO " + pp.darTablaOfrecen()+ "(id_servicio, id_producto) values (?, ?, ?, ?, ?)");
        q.setParameters( pId, idP);
        return (long) q.executeUnique();            
	}
	
	//Eliminar
 	public long eliminarOfrecenPorId (PersistenceManager pm, String id)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaOfrecen() + " WHERE id_servicio = ?");
        q.setParameters(id);
        return (long) q.executeUnique();            
	}
 	
   //Listar
	public List<Ofrecen> darReservaciones (PersistenceManager pm, String id)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaOfrecen() + " WHERE id_servicio = ?");
		q.setResultClass(Ofrecen.class);
		q.setParameters( id);
		return (List<Ofrecen>) q.executeList();
	}
	
}
