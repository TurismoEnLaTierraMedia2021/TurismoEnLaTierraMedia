package turismo;

import java.util.LinkedList;

public class PromocionAxB extends Promocion {
	private Atraccion regalo;

	public PromocionAxB(String tipoPromocion, String nombrePack, LinkedList<Atraccion> atracciones, Atraccion regalo) {
		this.tipoPromocion = tipoPromocion;
		this.nombrePack = nombrePack;
		this.atracciones = atracciones;
		this.regalo = regalo;
	}

	@Override
	public double calcularDescuento(LinkedList<Promocion> promociones) {

		return 0;
	}

	@Override
	public String toString() {
		return "PromocionAxB [tipoPromocion=" + tipoPromocion + ", nombrePack=" + nombrePack + ", Atracciones=" + this.atraccionesAString() + "gratis=" + regalo.getNombre() + "]";
	}
	
}
