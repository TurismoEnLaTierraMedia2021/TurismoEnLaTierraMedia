package turismo;

import java.util.LinkedList;

public abstract class Promocion extends Vendible{
	protected String tipoPromocion;
	protected String nombrePack;
	protected LinkedList<Atraccion> atracciones;
	protected double porcentajeDescuento;
	protected double precio;
	
	public double calcularDescuento(LinkedList<Promocion> promociones) {
	return 0;
	}
	
	public String atraccionesAString() {
		String stringFinal = "";
		
		for (Atraccion atraccion : atracciones) {
			stringFinal += atraccion.getNombre() + ", ";
			
		}
		return stringFinal;
	}
}

