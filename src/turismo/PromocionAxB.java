package turismo;

import java.util.LinkedList;

public class PromocionAxB extends Promocion {

	public PromocionAxB(String nombrePack, String nombreAtraccion1, String nombreAtraccion2, String nombreAtraccion3) {
		this.nombrePack = nombrePack;
		this.nombreAtraccion1 = nombreAtraccion1;
		this.nombreAtraccion2 = nombreAtraccion2;
		this.nombreAtraccion3 = nombreAtraccion3;
	}

	@Override
	public double calcularDescuento(LinkedList<Promocion> promociones) {

		return 0;
	}

	@Override
	public String toString() {
		return "PromocionAxB [nombrePack=" + nombrePack + ", nombreAtraccion1=" + nombreAtraccion1
				+ ", nombreAtraccion2=" + nombreAtraccion2 + ", nombreAtraccion3=" + nombreAtraccion3 + "]";
	}

}
