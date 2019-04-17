package uniandes.isis2304.hotelandes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.hotelandes.negocio.Convencion;
//----------------------Clase terminada----------------
public class SQLConvenciones {

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
	public SQLConvenciones (PersistenciaHotelAndes pp)
	{
		this.pp = pp;
	}
	
	//Adiciona una convencion a la tabla de convenciones
	public long adicionarConvencion (PersistenceManager pm, String id, String tematica, double precio, int nP, String sC, int estado) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaConvenciones() + "(id, tematica, precio, numero_personas, servicios_convencion, estado) values (?, ?, ?, ?, ?, ?)");
        q.setParameters(id, tematica, precio, nP, sC, estado);
        return (long) q.executeUnique();
	}
	//Elimina una convencion 
	public long eliminarBebedorPorId (PersistenceManager pm, String id)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaConvenciones() + " WHERE id = ?");
        q.setParameters(id);
        return (long) q.executeUnique();            
	}
	//Cambia el  estado  de una convencion 
	public long cambiarEstado (PersistenceManager pm, String id, int estado)
	{
		 Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaConvenciones() + " SET estado = ? WHERE id = ?");
	     q.setParameters(estado, id);
	     return (long) q.executeUnique();            
	}
	//Busca una convencion dado su id
	public Convencion darConvencionPorId (PersistenceManager pm, String id) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaConvenciones() + " WHERE id = ?");
		q.setResultClass(Convencion.class);
		q.setParameters(id);
		return (Convencion) q.executeUnique();
	}
	//Retorna  las convenciones
	public List<Convencion> darBebedoresPorNombre (PersistenceManager pm, int pEstado) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaConvenciones() + " WHERE estado = ?");
		q.setResultClass(Convencion.class);
		q.setParameters(pEstado);
		return (List<Convencion>) q.executeList();
	}	
}
