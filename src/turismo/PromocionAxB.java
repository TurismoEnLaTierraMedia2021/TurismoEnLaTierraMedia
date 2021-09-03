package turismo;

import java.util.LinkedList;

public class PromocionAxB extends Promocion {
	private Atraccion regalo;

	public PromocionAxB(String tipoPromocion, String nombrePack, LinkedList<Atraccion> atracciones) {
		this.tipoPromocion = tipoPromocion;
		this.nombrePack = nombrePack;
		this.atracciones = atracciones;
		
	}

	@Override
	public double calcularDescuento() {
		Double total = 0.00;
		Atraccion gratis = atracciones.get(atracciones.size()-1);
		for (Atraccion atraccionActual : this.atracciones) {
			total += atraccionActual.getCosto();
		}
		
		return total - gratis.getCosto();
		
	}

	@Override
	public String toString() {
		return "PromocionAxB [tipoPromocion=" + tipoPromocion + ", nombrePack=" + nombrePack + ", Atracciones=" + this.atraccionesAString() + "gratis= "+ atracciones.get(atracciones.size()-1).getNombre() + "]";
	}
	
}
