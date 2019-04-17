package uniandes.isis2304.hotelandes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.hotelandes.negocio.Acompañante;

//----------------------Terminado------------------------------
public class SQLAcompañante {

	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Cadena que representa el tipo de consulta que se va a realizar en las sentencias de acceso a la base de datos
	 * Se renombra acá para facilitar la escritura de las sentencias
	 */
	private final static String SQL = PersistenciaHotelAndes.SQL;

	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El manejador de persistencia general de la aplicación
	 */
	private PersistenciaHotelAndes pp;

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor
	 * @param pp - El Manejador de persistencia de la aplicación
	 */
	public SQLAcompañante (PersistenciaHotelAndes pp)
	{
		this.pp = pp;
	}
	
	//Adicionar
	public long adicionarAcompañante (PersistenceManager pm, String id , String idA,  String nombreA) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaAcompañantes() + "(id_cliente, id_acomp, nombre_acom) values (?, ?, ?)");
        q.setParameters(id, idA, nombreA);
        return (long) q.executeUnique();
	}
	
	//Eliminar acompañante
	public long eliminarBebedorPorNombre (PersistenceManager pm, String id)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaAcompañantes() + " WHERE id_cliente = ?");
        q.setParameters(id);
        return (long) q.executeUnique();            
	}
	
	//Buscar
	public Acompañante darAcompañantePorId (PersistenceManager pm, long id) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaAcompañantes() + " WHERE id_acomp = ?");
		q.setResultClass(Acompañante.class);
		q.setParameters(id);
		return (Acompañante) q.executeUnique();
	}
	//Buscar todos acompañantes
	public List<Acompañante> darBebedoresPorNombre (PersistenceManager pm, String id) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaAcompañantes() + " WHERE id_cliente = ?");
		q.setResultClass(Acompañante.class);
		q.setParameters(id);
		return (List<Acompañante>) q.executeList();
	}
	
	

}
