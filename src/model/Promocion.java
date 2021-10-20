package model;

import java.util.LinkedList;

public abstract class Promocion extends Vendible {
	protected Integer id;
	protected Tipo tipo;
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

	public String getTipoPromocion() {
		return tipoPromocion;
	}

	public Integer getId() {
		return id;
	}
	
	public String getNombrePack() {
		return nombrePack;
	}

	@Override
	public LinkedList<Atraccion> getAtracciones() {
		return atracciones;
	}

	public double getPorcentajeDescuento() {
		return porcentajeDescuento;
	}

	public double getPrecio() {
		return precio;
	}

	public String atraccionesAString() {
		String stringFinal = "";

		for (Atraccion atraccion : atracciones) {
			if (atraccion == atracciones.get(atracciones.size() - 1)) {
				stringFinal += atraccion.getNombre();
			} else {
				stringFinal += atraccion.getNombre() + ", ";
			}
		}
		return stringFinal;
	}

	@Override
	public void comprar() {
		for (Atraccion atraccion : atracciones) {
			atraccion.comprar();
		}
	}

	@Override
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

	@Override
	public int getCupo() {
		int cupo = 0;
		for (Atraccion atraccionActual : this.atracciones) {
			cupo += atraccionActual.getCupo();
		}
		return cupo;
	}

	@Override
	public boolean esPromo() {
		return true;
	}

	@Override
	public Tipo getTipo() {
		return tipo;
	}

	@Override
	public String toString() {
		return "Promocion " + tipo + " [Valor: " + this.getCosto() + ", Tiempo necesario: " + this.getDuracion()
				+ ", Tipo de promocion:" + tipoPromocion + ", Nombre del pack: " + nombrePack + ",\n\t Atracciones:"
				+ this.atraccionesAString() + "]\n";
	}
	
	@Override
	public boolean esOContiene(Vendible v) {
		for(Atraccion a : this.atracciones) {
			if(v.esOContiene(a)) {
				return true;
			}	
		}
		return false;
	}
}
