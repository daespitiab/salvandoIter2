package uniandes.isis2304.hotelandes.persistencia;


import java.util.List;


import javax.jdo.PersistenceManager;
import javax.jdo.Query;
//-----------------------Terminado------------------
public class SQLLavPlanEmb {

	
	
	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Cadena que representa el tipo de consulta que se va a realizar en las sentencias de acceso a la base de datos
	 * Se renombra ac� para facilitar la escritura de las sentencias
	 */
	 private final static String SQL =  PersistenciaHotelAndes .SQL;
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
	 * 
	 */
	 public SQLLavPlanEmb ( PersistenciaHotelAndes  pPp) {
		 this.pp = pPp;
	 }
	 
	//Adicionar
	 public long adicionarSerLimplieza(PersistenceManager pm, String pId, String idS, int pcosto ) 
		{
	        Query q = pm.newQuery( SQL, "INSERT INTO " + pp.darTablaLimpieza() + "(id, id_servicio, precio ) values (?, ?, ?, ?)");
	        q.setParameters( pId, idS, pcosto );
	        return (long) q.executeUnique();            
		}
	 
	 //buscar
	 public List buscarSerLimpliezaPorId(PersistenceManager pm, String pId)
	 {
	        Query q = pm.newQuery( SQL, "SELECT * FROM " + pp.darTablaLimpieza() + " WHERE id = ?");
	        q.setParameters( pId );
	        return  q.executeList();           
		}
		
		//Eliminar
	 	public long eliminarServicioLimpPorId (PersistenceManager pm, String idServicio)
		{
	 		
	        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaLimpieza() + " WHERE id = ?");
	        q.setParameters(idServicio);
	        return (long) q.executeUnique();            
		}
	 	
}	 