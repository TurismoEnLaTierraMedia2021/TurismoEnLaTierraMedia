package turismo;

import java.util.LinkedList;

public abstract class Promocion extends Vendible{
	protected String nombrePack;
	protected String nombreAtraccion1;
	protected String nombreAtraccion2;
	protected String nombreAtraccion3;
	protected double porcentajeDescuento;
	protected double precio;
	
	public double calcularDescuento(LinkedList<Promocion> promociones) {
	return 0;
	}
}
