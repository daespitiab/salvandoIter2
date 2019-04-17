package uniandes.isis2304.hotelandes.persistencia;


import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

//-----------------------------------------Terminado-----------------------------

public class SQLPrestamosUtencilios {

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
	 public SQLPrestamosUtencilios( PersistenciaHotelAndes  pPp) {
		 this.pp = pPp;
	 }
	 

	 //Adicionar
	 public long adicionarPrestamoUtensilios (PersistenceManager pm, String pId,String idO) 
		{
	        Query q = pm.newQuery( SQL, "INSERT INTO " + pp.darTablaPrestamoUtencilios() + "(id, id_onjeto) values (?, ?)");
	        q.setParameters(  pId, idO );
	        return (long) q.executeUnique();            
		}
		
	 
		
	 	
		
	
	
	
	
}
