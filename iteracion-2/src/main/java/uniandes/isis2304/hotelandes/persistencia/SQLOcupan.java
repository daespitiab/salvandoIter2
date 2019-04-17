package uniandes.isis2304.hotelandes.persistencia;

import java.sql.Timestamp;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.hotelandes.negocio.Empleado;
import uniandes.isis2304.hotelandes.negocio.Ocupan;

//--------------------------Terminado------------------
public class SQLOcupan {

	
	
	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Cadena que representa el tipo de consulta que se va a realizar en las sentencias de acceso a la base de datos
	 * Se renombra acá para facilitar la escritura de las sentencias
	 */
	private final static String SQL =  PersistenciaHotelAndes .SQL;

	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El manejador de persistencia general de la aplicación
	 */
	private  PersistenciaHotelAndes  pp;

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor
	 * @param pp - El Manejador de persistencia de la aplicación
	 */
	public SQLOcupan ( PersistenciaHotelAndes  pp)
	{
		this.pp = pp;
	}
	
	//Adicionar
	public long adicionarVisitan (PersistenceManager pm, String idHabitacion, String idCliente) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaOcupan()+ "(id_cliente, id_habitacion) values (?, ?)");
        q.setParameters(idCliente, idHabitacion);
        return (long) q.executeUnique();
}
	
	//Eliminar
 	public long eliminarEmpleadoPorId (PersistenceManager pm, String idOcupan)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaOcupan()+ " WHERE id_cliente = ?");
        q.setParameters(idOcupan);
        return (long) q.executeUnique();    
	}
 	
 	//Busqueda por id
 	public Ocupan darOcupanId(PersistenceManager pm, String id) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaOcupan()+ " WHERE id_cliente = ?");
		q.setResultClass(Ocupan.class);
		q.setParameters(id);
		return (Ocupan) q.executeUnique();
	}
 	
 	
    //Buscar
	public List<Ocupan> darOcupan (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaOcupan());
		q.setResultClass(Ocupan.class);
		return (List<Ocupan>) q.executeList();
	}

}
