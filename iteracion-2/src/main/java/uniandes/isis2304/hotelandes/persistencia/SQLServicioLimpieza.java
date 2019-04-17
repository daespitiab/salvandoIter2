package uniandes.isis2304.hotelandes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.hotelandes.negocio.ServicioConvencion;
import uniandes.isis2304.hotelandes.negocio.ServicioLimpieza;


//----------------------------------Terminado------------------------

public class SQLServicioLimpieza {

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
	public SQLServicioLimpieza(PersistenciaHotelAndes pp)
	{
		this.pp = pp;
	}
	
	//Adicionar
		public long adicionarServicioLimp(PersistenceManager pm, String id, double precio) 
		{
	        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaServiciosLimpieza()+ "(id, precio) values (?, ?)");
	        q.setParameters(id, precio);
	        return (long) q.executeUnique();
		}
		
		public long eliminarBebedorPorId (PersistenceManager pm, String id)
		{
	        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaServiciosLimpieza() + " WHERE id = ?");
	        q.setParameters(id);
	        return (long) q.executeUnique();            
		}
		//Listar
		public List<ServicioLimpieza> darServiciosConvencion (PersistenceManager pm)
		{
			Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaServiciosLimpieza());
			q.setResultClass(ServicioLimpieza.class);
			return (List<ServicioLimpieza>) q.executeList();
		}

}
