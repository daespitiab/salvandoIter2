package uniandes.isis2304.hotelandes.persistencia;

import java.sql.Date;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;


import uniandes.isis2304.hotelandes.persistencia.PersistenciaHotelAndes;

/**
 * Clase que encapsula los métodos que hacen acceso a la base de datos para el concepto GUSTAN de Parranderos
 * Nótese que es una clase que es sólo conocida en el paquete de persistencia
 * 
 *
 */
//--------------------------------Terminado-----------------------------------
class SQLServiciosHotel
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
	public SQLServiciosHotel (PersistenciaHotelAndes pp)
	{
		this.pp = pp;
	}
	
	//Adicionar
	public long adicionarServicios(PersistenceManager pm, String idH, String idS, String idRB, String idSt, String idP, String
			idG, String idPS, String IdI, String idL, String idPU) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaServiciosHotel() + "(id, id_Spa, id_restaurante_bar, id_supermercado_tienda, id_piscina, id_gimnasio, id_prestamo_salon, id_internet, id_lav_plan_emb, id_prestamo_utencilios) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
        q.setParameters(idH, idS, idRB, idSt, idP,idG, idPS, IdI, idL, idPU);
        return (long) q.executeUnique();
	}

	

	//Metodo x
	public int darDineroRecolectado(PersistenceManager pm,Date fi, Date ff)
	{
		 Query q = pm.newQuery(SQL, "SELECT SUM(total) FROM  " + pp.darTablaServiciosHotel() + " WHERE fecha_inicial>= ? AND fecha_final = ?");
	        q.setParameters(fi, ff);
	        return (int) q.executeUnique();
	}

	public List<String> darServiciosMasPopulares(PersistenceManager pm) {
		 Query q = pm.newQuery(SQL, "SELECT COUNT(id_servicio) cont ,id_servicio FROM " + pp.darTablaServiciosHotel() + "GROUP BY id_servicio, ORDER BY cont DESC FETCH FIRST 20 ROWS ONLY");
	     
	        return (List<String>) q.executeUnique();
	}
}

