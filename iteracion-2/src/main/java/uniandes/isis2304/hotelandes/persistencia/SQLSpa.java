package uniandes.isis2304.hotelandes.persistencia;

import java.util.List;


import javax.jdo.PersistenceManager;
import javax.jdo.Query;


import uniandes.isis2304.hotelandes.negocio.Spa;
import uniandes.isis2304.hotelandes.persistencia.PersistenciaHotelAndes;

class SQLSpa {

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
	public SQLSpa (PersistenciaHotelAndes pp)
	{
		this.pp = pp;
	}
	
	
   //Adicionar
	public long adicionarSpa (PersistenceManager pm, long idSpa, String nombre, int precio, int pagoAdicional) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaSPAS() + "(id, nombre, precio, pago_adicional) values (?, ?, ?, ?)");
        q.setParameters(idSpa, nombre, precio,pagoAdicional);
        return (long) q.executeUnique();            
	}

	//Eliminar
	public long eliminarBebidaPorNombre (PersistenceManager pm, String id)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaSPAS () + " WHERE id = ?");
        q.setParameters(id);
        return (long) q.executeUnique();            
	}



	public Spa darTipoBebidaPorId (PersistenceManager pm, long id) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaSPAS () + " WHERE id = ?");
		q.setResultClass(Spa.class);
		q.setParameters(id);
		return (Spa) q.executeUnique();
	}

	
    //listar
	public List<Spa> darBebidas (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaSPAS ());
		q.setResultClass(Spa.class);
		return (List<Spa>) q.executeList();
	}


	
}
