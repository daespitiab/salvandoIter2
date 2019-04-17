package uniandes.isis2304.hotelandes.persistencia;


import java.util.List;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import uniandes.isis2304.hotelandes.negocio.Empleado;

//-------------------Termiando-----------------------------

public class SQLEmpleado {


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
	public SQLEmpleado( PersistenciaHotelAndes  pp)
	{
		this.pp = pp;
	}

	//Agregar empleado
	public long adicionarEmpleado (PersistenceManager pm, String pId,  String pnombre, String prol ) 
	{
		Query q = pm.newQuery( SQL, "INSERT INTO " + pp.darTablaEmpleados() + "(id, nombre, rol) values (?, ?, ?)");
		q.setParameters( pId, pnombre, prol);
		return (long) q.executeUnique();            
	}

	//Elimina un empleado
	public long eliminarEmpleadoPorId (PersistenceManager pm, String idEmpleado)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaEmpleados() + " WHERE id = ?");
		q.setParameters(idEmpleado);
		return (long) q.executeUnique();    
	}

	//Retorna la lista de empleados
	public List<Empleado> darEmpleados (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaEmpleados());
		q.setResultClass(Empleado.class);
		return (List<Empleado>) q.executeList();
	}

	//Actualizar empleado
	public long actualizarEmpleado (PersistenceManager pm, String id, String r )
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaCuentas() + " SET rol = ? WHERE id = ?");
		q.setParameters(r, id);
		return (long) q.executeUnique();    
	}
}
