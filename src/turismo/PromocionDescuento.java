package turismo;

import java.util.LinkedList;
import java.util.Objects;

public class PromocionDescuento extends Promocion {

	public PromocionDescuento(String nombrePack, String nombreAtraccion1, String nombreAtraccion2,
			double porcentajeDescuento) {
		this.nombrePack = nombrePack;
		this.nombreAtraccion1 = nombreAtraccion1;
		this.nombreAtraccion2 = nombreAtraccion2;
		this.porcentajeDescuento = porcentajeDescuento;
	}

	@Override
	public double calcularDescuento(LinkedList<Promocion> promociones) {

		return 0;
	}

	@Override
	public String toString() {
		return "PromocionDescuento [nombrePack=" + nombrePack + ", nombreAtraccion1=" + nombreAtraccion1
				+ ", nombreAtraccion2=" + nombreAtraccion2 + ", porcentajeDescuento=" + porcentajeDescuento + "]";
	}

}
