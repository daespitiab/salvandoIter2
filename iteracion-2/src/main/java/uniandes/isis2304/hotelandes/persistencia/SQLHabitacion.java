package uniandes.isis2304.hotelandes.persistencia;


import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.hotelandes.negocio.Habitacion;
import uniandes.isis2304.hotelandes.negocio.Salon;

public class SQLHabitacion {



	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Cadena que representa el tipo de consulta que se va a realizar en las sentencias de acceso a la base de datos
	 * Se renombra ac� para facilitar la escritura de las sentencias
	 */
	private final static String SQL =  PersistenciaHotelAndes .SQL;
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
	public SQLHabitacion( PersistenciaHotelAndes  pp)
	{
		this.pp = pp;
	}

	//Adicionar

	public long adicionarHabitacion (PersistenceManager pm, String pId, String tipo, int ocupada, int mant) 
	{
		Query q = pm.newQuery( SQL, "INSERT INTO " + pp.darTablaHabitaciones() + "(id, id_tipo, reservada, esta_mantenimiento) values (?, ?, ?, ?)");
		q.setParameters( pId, tipo, tipo, ocupada, mant);
		return (long) q.executeUnique();            
	}


	//Eliminar
	public long eliminarHabitacionPorId (PersistenceManager pm, String idHabitacion)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaHabitaciones() + " WHERE id = ?");
		q.setParameters(idHabitacion);
		return (long) q.executeUnique();            
	}

	//Busca todas las habitaciones
	public List<Habitacion> darHabitaciones (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaHabitaciones());
		q.setResultClass(Habitacion.class);
		return (List<Habitacion>) q.executeList();
	}

	//Actualiza el estado de reserva
	public long actualizarReserva (PersistenceManager pm, String id, int reservada)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaCuentas() + " SET reservada = ? WHERE id = ?");
		q.setParameters(reservada, id);
		return (long) q.executeUnique();    
	}
	
	//Actualiza el estado de mantenimiento
	//Actualizar cuenta
		public long actualizarMantenimiento (PersistenceManager pm, String id, int valor)
		{
			 Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaCuentas() + " SET esta_mantenimiento = ? WHERE id = ?");
		     q.setParameters(valor, id);
		     return (long) q.executeUnique();    
		}
		

}
