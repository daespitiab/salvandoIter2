package uniandes.isis2304.hotelandes.persistencia;


import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.hotelandes.negocio.Cliente;



//------------------------------Clase Terminada------------------------

class SQLCliente 
{
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
	public SQLCliente (PersistenciaHotelAndes pp)
	{
		this.pp = pp;
	}
	
	
	
	/**
	 * Crea un cliente
	 * 
	 */
	public long adicionarCliente (PersistenceManager pm, String idCliente, String nombre, int telefono, String correo,String id_Plan,String id_reservacion_Hotel, String id_cuenta, int estado, String tipo_id) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaClientes() + "(id, nombre, telefono, correo, id_plan, id_reservacion_Hotel, id_cuenta, estado, tipo_id) values (?,?,?,?,?,?,?,?,?)");
        q.setParameters(idCliente,nombre, telefono,correo,id_Plan,id_reservacion_Hotel,id_cuenta, estado, tipo_id);
        return (long) q.executeUnique();
	}
	
    //Elimina un cliente por id
	public long eliminarBebedorPorId (PersistenceManager pm, String idC)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaClientes () + " WHERE id = ?");
        q.setParameters(idC);
        return (long) q.executeUnique();            
	}
	
    //Retorna un cliente dado su id
	public Cliente darClientePorId (PersistenceManager pm, String idCliente) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaClientes () + " WHERE id = ?");
		q.setResultClass(Cliente .class);
		q.setParameters(idCliente);
		return (Cliente) q.executeUnique();
	}


	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de LOS BEBEDORES de la 
	 * base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos BEBEDOR
	 */
	public List<Cliente> darClientes (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaClientes ());
		q.setResultClass(Cliente.class);
		return (List<Cliente>) q.executeList();
	}

	
	
	
}

