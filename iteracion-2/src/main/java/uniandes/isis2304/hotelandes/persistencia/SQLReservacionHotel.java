package uniandes.isis2304.hotelandes.persistencia;


import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.hotelandes.negocio.ReservacionHotel;


//-----------------------------------------Terminado--------------------------------------
public class SQLReservacionHotel {


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
	public SQLReservacionHotel( PersistenciaHotelAndes  pp)
	{
		this.pp = pp;
	}
	
	//Adicionar
	public long adicionarReservacion (PersistenceManager pm, String pId,  String pfechapartida, String pFechaLlegada, int numPersonas, String planPag ) 
	{
        Query q = pm.newQuery( SQL, "INSERT INTO " + pp.darTablaReservacionesHotel() + "(id, fecha_llegada, fecha_partida, num_personas, plan_pago) values (?, ?, ?, ?, ?)");
        q.setParameters( pId, pFechaLlegada,pfechapartida, numPersonas, planPag);
        return (long) q.executeUnique();            
	}
	
	//Eliminar
 	public long eliminarReservacionPorId (PersistenceManager pm, String idReservacion)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaReservacionesHotel() + " WHERE id = ?");
        q.setParameters(idReservacion);
        return (long) q.executeUnique();            
	}
    
 	//Listar
	public List<ReservacionHotel> darReservaciones (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaReservacionesHotel());
		q.setResultClass(ReservacionHotel.class);
		return (List<ReservacionHotel>) q.executeList();
	}

}
