package turismo;

import java.util.LinkedList;

public class PromocionAxB extends Promocion {
	private Atraccion regalo;

	public PromocionAxB(Tipo tipo, String tipoPromocion, String nombrePack, LinkedList<Atraccion> atracciones) {
		this.tipo = tipo;
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
		return "PromocionAxB [Valor= " + this.getCosto() + ", " + tipo + ", tipoPromocion=" + tipoPromocion + ", nombrePack=" + nombrePack + ", Atracciones=" + this.atraccionesAString() + "gratis= "+ atracciones.get(atracciones.size()-1).getNombre() + "]\n";
	}
	
}
