package turismo;

import java.util.LinkedList;

public class PromocionAbsoluta extends Promocion {

	public PromocionAbsoluta(String tipoPromocion, String nombrePack, double precio) {
		this.tipoPromocion = tipoPromocion;
		this.nombrePack = nombrePack;
		//this.nombreAtraccion1 = nombreAtraccion1;
		//this.nombreAtraccion2 = nombreAtraccion2;
		this.precio = precio;
	}

	@Override
	public double calcularDescuento(LinkedList<Promocion> promociones) {

		return 0;
	}

	@Override
	public String toString() {
		return "PromocionAbsoluta [tipoPromocion=" + tipoPromocion + ", nombrePack=" + nombrePack
				+ ", nombreAtraccion1=" + nombreAtraccion1 + ", nombreAtraccion2=" + nombreAtraccion2 + ", precio="
				+ precio + "]";
	}


}
