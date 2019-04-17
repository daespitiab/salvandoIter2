package uniandes.isis2304.hotelandes.negocio;

public interface VOCliente {

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * @return El id del bebedor
	 */
	public long getId();

	/**
	 * @return El nombre del bebedor
	 */
	public String getNombre();

	/**
	 * @return La ciudad del bebedor
	 */
	public String getTelefono();

	public String getIdPlan();
	
	public String getIdReservacionHotel();
	
	public String getIdReservacionServicios();
	
	public String getIdCuenta();
	
}
