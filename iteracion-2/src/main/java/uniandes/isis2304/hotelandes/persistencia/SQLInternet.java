package uniandes.isis2304.hotelandes.persistencia;


import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.hotelandes.negocio.Internet;
import uniandes.isis2304.hotelandes.negocio.Salon;

public class SQLInternet {


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
	public SQLInternet( PersistenciaHotelAndes  pp)
	{
		this.pp = pp;
	}
	
	
	//Adicionar
	public long adicionarInternet (PersistenceManager pm, String pId,  int pcapacidad, int pagoAdicional,  double pcosto ) 
	{
        Query q = pm.newQuery( SQL, "INSERT INTO " + pp.darTablaInternet() + "(id, capacidad, precio, valor_Adicional) values (?, ?, ?, ?)");
        q.setParameters( pId, pcapacidad, pcosto, pagoAdicional);
        return (long) q.executeUnique();            
	}
	
	//Eliminar
 	public long eliminarInternetPorId (PersistenceManager pm, String idInternet)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaInternet() + " WHERE id = ?");
        q.setParameters(idInternet);
        return (long) q.executeUnique();            
	}
 	


	
	
	
}
