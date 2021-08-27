package turismo;

public class Atraccion {
	private String nombre = "";
	private double costo;
	private double duracion;
	private TipoDeAtraccion tipoDeAtraccion;
	private int cupo;
	public Atraccion(String nombre, double costo, double duracion,
			TipoDeAtraccion tipoDeAtraccion, int cupo) {
	
		this.nombre = nombre;
		this.costo = costo;
		this.duracion = duracion;
		this.tipoDeAtraccion = tipoDeAtraccion;
		this.cupo = cupo;
	}
	
	
}
