package turismo;

public class Atraccion extends Vendible {
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

	
	
	@Override
	public String toString() {
		return "Atraccion [nombre=" + nombre + ", costo=" + costo + ", duracion=" + duracion + ", tipoDeAtraccion="
				+ tipoDeAtraccion + ", cupo=" + cupo + "]";
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public double getCosto() {
		return costo;
	}



	public void setCosto(double costo) {
		this.costo = costo;
	}



	public double getDuracion() {
		return duracion;
	}



	public void setDuracion(double duracion) {
		this.duracion = duracion;
	}



	public TipoDeAtraccion getTipoDeAtraccion() {
		return tipoDeAtraccion;
	}



	public void setTipoDeAtraccion(TipoDeAtraccion tipoDeAtraccion) {
		this.tipoDeAtraccion = tipoDeAtraccion;
	}



	public int getCupo() {
		return cupo;
	}



	public void setCupo(int cupo) {
		this.cupo = cupo;
	}

}
