package uniandes.isis2304.hotelandes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.hotelandes.negocio.Gimnasio;

public class SQLSalon {

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
	public SQLSalon(PersistenciaHotelAndes pp)
	{
		this.pp = pp;
	}
	
	/**
	 * Permite adicionar una nueva sala a lista de salas
	 * @param pm
	 * @param pId
	 * @param pTipo esta restringifo  unicamente a dos tipos diferentes:
	 * @param pcapacidad
	 * @param preservada entra un entero  cuyo valor puede ser unicamente 0 o uno
	 * @param pfecha
	 * @param pcosto
	 * @return
	 */
	
//	public long adicionarSalon (PersistenceManager pm, String pId,  String capacidad ) 
//	{
//        Query q = pm.newQuery( SQL, "INSERT INTO " + pp.darTablaSalon() + "(id, nombre, rol) values (?, ?, ?)");
//        q.setParameters( pId, capacidad);
//        return (long) q.executeUnique();            
//	}
//	/**
//	 * Crea y ejecuta la sentencia SQL para eliminar BEBIDAS de la base de datos de Parranderos, por su identificador
//	 * @param pm - El manejador de persistencia
//	 * @param idSpa - El identificador de la bebida
//	 * @return EL número de tuplas eliminadas
//	 */
//	public long eliminarPiscinaPorId (PersistenceManager pm, long id)
//	{
//        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaSalon () + " WHERE id = ?");
//   
//        return (long) q.executeUnique();            
//	}


	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de BEBIDAS de la 
	 * base de datos de Parranderos, por su nombre
	 * @param pm - El manejador de persistencia
	 * @param nombreBebida - El nombre de la bebida
	 * @return Una lista de objetos BEBIDA que tienen el nombre dado
	 */
//	public List<Gimnasio> darPiscinas (PersistenceManager pm) 
//	{
//		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaPiscina());
//		q.setResultClass(Gimnasio.class);
//		return (List<Gimnasio>) q.executeList();
//	}
//	
	
	
}
