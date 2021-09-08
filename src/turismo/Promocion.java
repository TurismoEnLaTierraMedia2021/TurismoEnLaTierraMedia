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

	public double getCosto() {
		return this.calcularDescuento();
	}

	public String atraccionesAString() {
		String stringFinal = "";

		for (Atraccion atraccion : atracciones) {
			stringFinal += atraccion.getNombre() + ", ";
		}
		return stringFinal;
	}

	@Override
	public void comprar() {
		for (Atraccion atraccion : atracciones) {
			atraccion.comprar();
		}
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

	@Override
	public double getDuracion() {
		Double duracionTotal = 0.00;
		for (Atraccion atraccionActual : this.atracciones) {
			duracionTotal += atraccionActual.getDuracion();
		}
		return duracionTotal;
	}

	@Override
	public boolean hayCupo() {
		boolean hayLugar = true;
		for (Atraccion atraccionActual : this.atracciones) {
			atraccionActual.hayCupo();
			if (atraccionActual.hayCupo() == false) {
				hayLugar = false;
			}
		}
		return hayLugar;
	}

	public TipoDeAtraccion getTipoDeAtraccion() {
		return tipoDeAtraccion;
	}

	@Override
	public int getCupo() {
		int cupo = 0;
		for (Atraccion atraccionActual : this.atracciones) {
			cupo += atraccionActual.getCupo();
		}
		return cupo;
	}

	public boolean esPromo() {
		return true;
	}
}
