package uniandes.isis2304.hotelandes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.hotelandes.negocio.Gimnasio;
import uniandes.isis2304.hotelandes.negocio.Piscina;

//-------------------------------------Terminado--------------------------------------
public class SQLPiscina {

	
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
	public SQLPiscina(PersistenciaHotelAndes pp)
	{
		this.pp = pp;
	}
	

	//Adicionar
	public long adicionarPiscina (PersistenceManager pm, String pId,  int precio,
			int pA, int capa, String fI, String fF) 
	{
        Query q = pm.newQuery( SQL, "INSERT INTO " + pp.darTablaPiscinas() + "(id, precio, pago_adicional, capacidad, horario_inicial, horario_final) values (?, ?, ?, ?, ? , ?)");
        q.setParameters( pId, precio, pA, capa, fI, fF);
        return (long) q.executeUnique();            
	}
	
	//Eliminar
	public long eliminarPiscinaPorId (PersistenceManager pm, long id)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaPiscinas () + " WHERE id = ?");
        q.setParameters( id);
        return (long) q.executeUnique();            
	}


	//Listar
	public List<Piscina> darPiscinas (PersistenceManager pm) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaPiscinas());
		q.setResultClass(Piscina.class);
		return (List<Piscina>) q.executeList();
	}
	
	
}
