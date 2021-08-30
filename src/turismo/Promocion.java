package turismo;

import java.util.LinkedList;

public abstract class Promocion extends Vendible{
	protected Atraccion[] atracciones;

	public double calcularDescuento(LinkedList<Atraccion> atracciones) {
		return 0;
	}
}
