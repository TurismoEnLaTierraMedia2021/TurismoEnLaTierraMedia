package turismo;

import java.util.LinkedList;

public abstract class Promocion extends Vendible {
	protected String tipoPromocion;
	protected String nombrePack;
	protected LinkedList<Atraccion> atracciones;
	protected double porcentajeDescuento;
	protected double precio;

	public double calcularDescuento() {
		return 0;
	}

	public String atraccionesAString() {
		String stringFinal = "";

		for (Atraccion atraccion : atracciones) {
			stringFinal += atraccion.getNombre() + ", ";
		}
		return stringFinal;
	}

	public String getTipoPromocion() {
		return tipoPromocion;
	}

	public String getNombrePack() {
		return nombrePack;
	}

	public LinkedList<Atraccion> getAtracciones() {
		return atracciones;
	}

	public double getPorcentajeDescuento() {
		return porcentajeDescuento;
	}

	public double getPrecio() {
		return precio;
	}

	public String getNombre() {
		return nombre;
	}

	public double getCosto() {
		return costo;
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
