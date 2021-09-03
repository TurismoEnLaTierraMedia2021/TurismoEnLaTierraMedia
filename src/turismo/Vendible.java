package turismo;

public abstract class Vendible {
	protected String nombre = "";
	protected double costo;
	protected double duracion;
	protected TipoDeAtraccion tipoDeAtraccion;
	protected int cupo;

	public boolean hayCupo() {
		return false;
	}

	public double getTiempo() {
		return 0;
	}

	public double getCosto() {
		return 0;
	}

	public String getNombre() {
		return nombre;
	}

	public double getDuracion() {
		return duracion;
	}

	public TipoDeAtraccion getTipoDeAtraccion() {
		return tipoDeAtraccion;
	}

	public int getCupo() {
		return cupo;
	}

	
	
}
