package turismo;

import java.util.LinkedList;

public class PromocionDescuento extends Promocion {

	public PromocionDescuento(Tipo tipo, String tipoPromocion, String nombrePack, LinkedList<Atraccion> atracciones,
			double porcentajeDescuento) {
		this.tipo = tipo;
		this.tipoPromocion = tipoPromocion;
		this.nombrePack = nombrePack;
		this.atracciones = atracciones;
		this.porcentajeDescuento = porcentajeDescuento;
	}

	@Override
	public double calcularDescuento() {
		Double total = 0.00;

		for (Atraccion atraccionActual : this.atracciones) {
			total += atraccionActual.getCosto();

		}

		return (total * (1 - this.getPorcentajeDescuento() / 100));
	}

	@Override
	public String toString() {
		return "PromocionDescuento [Valor= " + this.getCosto() + ", " + tipo + ", tipoPromocion=" + tipoPromocion + ", nombrePack=" + nombrePack + ", Atracciones="
				+ this.atraccionesAString() + "porcentajeDescuento=" + porcentajeDescuento + "]\n";
	}

}
