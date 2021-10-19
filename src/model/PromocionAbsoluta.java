package model;

import java.util.LinkedList;

public class PromocionAbsoluta extends Promocion {

	public PromocionAbsoluta(Tipo tipo, String tipoPromocion, String nombrePack, LinkedList<Atraccion> atracciones,
			double precio) {
		this.tipo = tipo;
		this.tipoPromocion = tipoPromocion;
		this.nombrePack = nombrePack;
		this.atracciones = atracciones;
		this.precio = precio;
	}

	@Override
	public double calcularDescuento() {

		return this.getPrecio();

	}

}