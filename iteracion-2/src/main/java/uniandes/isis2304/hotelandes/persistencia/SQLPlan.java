package uniandes.isis2304.hotelandes.persistencia;


import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.hotelandes.negocio.Plan;
import uniandes.isis2304.hotelandes.negocio.Salon;

public class SQLPlan {

	
	
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
	public SQLPlan ( PersistenciaHotelAndes  pp)
	{
		this.pp = pp;
	}
	
	//Adicionar
	public long adicionarPlan (PersistenceManager pm, String pId, String nombre, double pdescuento, int pcantidadNoches ) 
	{
        Query q = pm.newQuery( SQL, "INSERT INTO " + pp.darTablaPlanes()+ "(id, nombre , descuento, num_noches) values (?, ?, ?, ?)");
        q.setParameters( pId, nombre, pdescuento, pcantidadNoches);
        return (long) q.executeUnique();            
	}
	
	//Eliminar
 	public long eliminarPlanPorId (PersistenceManager pm, String idPlan)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaPlanes() + " WHERE id = ?");
        q.setParameters(idPlan);
        return (long) q.executeUnique();            
	}
 	

 	//Listar 
	public List<Plan> darSalones (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaPlanes());
		q.setResultClass(Plan.class);
		return (List<Plan>) q.executeList();
	}
	
	//Actualizar descuento
	//Actualizar numero noches
	
	

	
	
	
}
