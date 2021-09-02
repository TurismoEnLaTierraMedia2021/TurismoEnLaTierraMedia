package turismo;

import java.util.LinkedList;

public class PromocionAxB extends Promocion {

	public PromocionAxB(String tipoPromocion, String nombrePack, LinkedList<Atraccion> atracciones) {
		this.tipoPromocion = tipoPromocion;
		this.nombrePack = nombrePack;
		this.atracciones = atracciones;
	}

	@Override
	public double calcularDescuento(LinkedList<Promocion> promociones) {

		return 0;
	}

	@Override
	public String toString() {
		return "PromocionAxB [tipoPromocion=" + tipoPromocion + ", nombrePack=" + nombrePack + ", Atracciones=" + this.atraccionesAString() + "]";
	}
	
}
