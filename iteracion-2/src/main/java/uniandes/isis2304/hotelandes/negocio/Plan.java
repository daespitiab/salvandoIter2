 package uniandes.isis2304.hotelandes.negocio;
 
public class Plan {

	
	//Constantes
	public final static int PLAN_LARGA_DURACION = 1;
	public final static int PLA_TIMEPO_COMPARTIDO= 2;
	public final static  int PLAN_TODO_INCLUIDO = 3;
	public final static  int PLA_OTRA_PROMOCION = 4;
	public final static  int  PLAN_CONVENCION= 5;

	//Atributos
	
	//Este es el  id
	private int tipo;
	private double descuento;
	private int numeroNoches;
	private String nombre;
	
	//Constructor
	public Plan(  int idPlan, double tipo2, double descuento2,int cant_noches) {
	
		this.tipo = idPlan > 0 && idPlan < 6 ? idPlan:-1;
		this.descuento = tipo2;
//		this.numeroNoches = descuento2;
//		this.nombre = cant_noches;
	}
	
	//Metodos
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public double getDescuento() {
		return descuento;
	}
	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}
	public int getNumeroNoches() {
		return numeroNoches;
	}
	public void setNumeroNoches(int numeroNoches) {
		this.numeroNoches = numeroNoches;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}	
}
