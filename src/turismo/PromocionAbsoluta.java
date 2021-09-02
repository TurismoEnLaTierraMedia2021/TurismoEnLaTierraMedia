package turismo;

import java.util.LinkedList;

public class PromocionAbsoluta extends Promocion {

	public PromocionAbsoluta(String tipoPromocion, String nombrePack, LinkedList<Atraccion> atracciones, double precio) {
		this.tipoPromocion = tipoPromocion;
		this.nombrePack = nombrePack;
		this.atracciones = atracciones;
		this.precio = precio;
	}

	@Override
	public double calcularDescuento(LinkedList<Promocion> promociones) {

		return 0;
	}

	@Override
	public String toString() {
		return "PromocionAbsoluta [tipoPromocion=" + tipoPromocion + ", nombrePack=" + nombrePack
				+ ", Atracciones=" + this.atraccionesAString() + "precio="
				+ precio + "]";
	}


}
