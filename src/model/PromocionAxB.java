package model;

import java.util.LinkedList;

public class PromocionAxB extends Promocion {

	public PromocionAxB(Integer id,Tipo tipo, String tipoPromocion, String nombrePack, LinkedList<Atraccion> atracciones) {
		this.id = id;
		this.tipo = tipo;
		this.tipoPromocion = tipoPromocion;
		this.nombrePack = nombrePack;
		this.atracciones = atracciones;

	}

	@Override
	public double calcularDescuento() {
		Double total = 0.00;
		Atraccion gratis = atracciones.get(atracciones.size() - 1);
		for (Atraccion atraccionActual : this.atracciones) {
			total += atraccionActual.getCosto();
		}

		return total - gratis.getCosto();

	}

	@Override
	public String toString() {
		return super.toString() + "\t [Atraccion gratis: " + atracciones.get(atracciones.size() - 1).getNombre()
				+ "]\n";
	}

}
