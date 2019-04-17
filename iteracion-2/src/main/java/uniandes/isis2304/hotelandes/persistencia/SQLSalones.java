package uniandes.isis2304.hotelandes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.hotelandes.negocio.Salon;

//---------------------------------Terminado------------------------------

public class SQLSalones {

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
	 * 
	 */
	public SQLSalones( PersistenciaHotelAndes  pPp) {
		this.pp = pPp;
	}

	//Adicionar
	public long adicionarSalon (PersistenceManager pm, String id, int tipo, int capacidad, String mobiliario, int reservado) 
	{
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaSalones() + "(id, tipo, capacidad, mobiliario, reservado) values (?, ?, ?, ?)");
		q.setParameters(id, tipo,capacidad, mobiliario, reservado);
		return (long) q.executeUnique();
	}
	//Eliminar
	public long eliminarSalon (PersistenceManager pm, String  id)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaSalones() + " WHERE id = ?");
		q.setParameters(id);
		return (long) q.executeUnique();            
	}
	//Listar
	public List<Salon> darSalones(PersistenceManager pm) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaSalones());
		q.setResultClass(Salon.class);
		return (List<Salon>) q.executeList();
	}


}
