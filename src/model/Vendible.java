package model;

import java.util.LinkedList;

public abstract class Vendible {
	protected String nombre = "";
	protected double costo;
	protected double duracion;
	protected Tipo tipo;
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

	public Tipo getTipo() {
		return tipo;
	}

	public int getCupo() {
		return cupo;
	}

	public boolean esPromo() {
		return false;
	}
	
	public LinkedList<Atraccion> getAtracciones() {
		return atracciones;
	}
	
	public boolean esOContiene(Vendible v) {
		return false;
	}

}
