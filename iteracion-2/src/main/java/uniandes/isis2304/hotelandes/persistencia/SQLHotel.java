package uniandes.isis2304.hotelandes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.hotelandes.negocio.Hotel;


public class SQLHotel {
	private final static String SQL = PersistenciaHotelAndes.SQL;
	private PersistenciaHotelAndes pp;
	public SQLHotel (PersistenciaHotelAndes pp)
	{
		this.pp = pp;
	}
	
	public List<Hotel> darHoteles (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM H_HOTELES");
		q.setResultClass(Hotel.class);
		return (List<Hotel>) q.executeList();
	}
}
