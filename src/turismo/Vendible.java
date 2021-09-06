package turismo;

import java.util.LinkedList;

public abstract class Vendible {
	protected String nombre = "";
	protected double costo;
	protected double duracion;
	protected TipoDeAtraccion tipoDeAtraccion;
	protected int cupo;
	protected LinkedList<Atraccion> atracciones;

	public boolean hayCupo() {
		return false;		
	}
	public void comprar() {
		
	}

	public double getDuracion() {
		return 0;
	}

	public double getCosto() {
		return 0;
	}

	public String getNombre() {
		return nombre;
	}

		public TipoDeAtraccion getTipoDeAtraccion() {
		return tipoDeAtraccion;
	}

	public int getCupo() {
		return cupo;
	}

	
	
}
