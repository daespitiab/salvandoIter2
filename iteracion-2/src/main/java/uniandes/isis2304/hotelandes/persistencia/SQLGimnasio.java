package uniandes.isis2304.hotelandes.persistencia;

import java.util.List;


import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.hotelandes.negocio.Bebida;
import uniandes.isis2304.hotelandes.negocio.Empleado;
import uniandes.isis2304.hotelandes.negocio.Gimnasio;


//-------------------------------Termiando-------------------------------------
public class SQLGimnasio {

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
	public SQLGimnasio(PersistenciaHotelAndes pp)
	{
		this.pp = pp;
	}
	
	//Adiciona 
	public long adicionarGimnasio (PersistenceManager pm, String pId,  String nombre, int precio,
			int precioAdicional, String fI, String fF) 
	{
        Query q = pm.newQuery( SQL, "INSERT INTO " + pp.darTablaGimanasios() + "(id, nombre, precio, precio_adicional, hora_inicio, hora_final) values (?, ?, ?, ?, ?, ?)");
        q.setParameters( pId, nombre, precio, precioAdicional, fI, fF);
       
        return (long) q.executeUnique();            
	}
	
	//Eliminar
	public long eliminarGimnasioPorId (PersistenceManager pm, String id)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaGimanasios() + " WHERE id = ?");
        q.setParameters(id);
        return (long) q.executeUnique();            
	}
    
	//Buscar
	public Gimnasio darBebedorPorId (PersistenceManager pm, long idBebedor) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaGimanasios() + " WHERE id = ?");
		q.setResultClass(Gimnasio.class);
		q.setParameters(idBebedor);
		return (Gimnasio) q.executeUnique();
	}

	
	
	
}
