package uniandes.isis2304.hotelandes.persistencia;

import javax.jdo.Query;

import uniandes.isis2304.hotelandes.negocio.PrestamoSalones;
import uniandes.isis2304.hotelandes.negocio.Salon;

import java.util.List;

import javax.jdo.PersistenceManager;

//_-----------------------Terminado-----------------------------------
public class SQLPrestamo_Salones
{

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
	public SQLPrestamo_Salones ( PersistenciaHotelAndes  pp)
	{
		this.pp = pp;
	}
	
	//Adicionar
	public long adicionarServPrestamoSalones (PersistenceManager pm, String pId, String idS, String idC  ) 
	{
        Query q = pm.newQuery( SQL, "INSERT INTO " + pp.darTablaPrestamoSalones() + "(id,id_salon, id_cliente) values (?, ?, ?)");
        q.setParameters( pId, idS, idC);
        return (long) q.executeUnique();            
	}
	
	//Eliminar
 	public long eliminarSalonPorId (PersistenceManager pm, String id, String idSalon)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaPrestamoSalones() + " WHERE id = ? AND id_salon =?");
        q.setParameters(id, idSalon);
        return (long) q.executeUnique();            
	}
 	//Buscar
 	public PrestamoSalones darPrestamoPorId (PersistenceManager pm, String id, String idS) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaPrestamoSalones() + " WHERE id = ? and id_salon = ?");
		q.setResultClass( PrestamoSalones.class);
		q.setParameters(id, idS);
		return ( PrestamoSalones) q.executeUnique();
	}
 
 	
	
	
	
	
	
	

	
}
