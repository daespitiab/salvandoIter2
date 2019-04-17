package uniandes.isis2304.hotelandes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.hotelandes.negocio.Bebida;
import uniandes.isis2304.hotelandes.negocio.Rol;

//-----------------------Terminado--------------------------------

public class SQLRol {
	

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
	public SQLRol (PersistenciaHotelAndes pp)
	{
		this.pp = pp;
	}
	
    //Adicionar
	public long adicionarRol (PersistenceManager pm, long idRol, String nombre,String descripcion) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + "H_ROLES" + "(id, nombre_rol, descripcion) values (?, ?, ?)");
        q.setParameters(idRol, nombre,descripcion);
        return (long) q.executeUnique();            
	}

    //Eliminar
	public long eliminarRol(PersistenceManager pm, String id)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaRoles() + " WHERE id  = ?");
        q.setParameters(id);
        return (long) q.executeUnique();            
	}

	//Listar
	public List<Rol> darBebidas (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaRoles());
		q.setResultClass(Rol.class);
		return (List<Rol>) q.executeList();
	}

}
