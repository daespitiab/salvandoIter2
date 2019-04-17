package uniandes.isis2304.hotelandes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import uniandes.isis2304.hotelandes.negocio.Convencion;

import uniandes.isis2304.hotelandes.negocio.Cuenta;

public class SQLCuenta{

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
	public SQLCuenta( PersistenciaHotelAndes  pp)
	{
		this.pp = pp;
	}
	
	//Adicionar cuenta
	public long adicionarCuenta (PersistenceManager pm, String pId, String id, double totalAPagar, int cantidadServicios ) 
	{
        Query q = pm.newQuery( SQL, "INSERT INTO " + pp.darTablaCuentas() + "(id, cuenta, numero_servicios) values (?, ?, ?)");
        q.setParameters( pId, totalAPagar, cantidadServicios);
        return (long) q.executeUnique();            
	}
	
	//Elimina un cuenta  
 	public long eliminarCuentaPorId (PersistenceManager pm, String idCuenta)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaCuentas() + " WHERE id = ?");
        q.setParameters(idCuenta);
        return (long) q.executeUnique();            
	}
 	
 
    //Actualizar cuenta
	public long actualizarCuenta (PersistenceManager pm, String id, float valor)
	{
		 Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaCuentas() + " SET cuenta = ? WHERE id = ?");
	     q.setParameters(valor, id);
	     return (long) q.executeUnique();    
	}
	
}
