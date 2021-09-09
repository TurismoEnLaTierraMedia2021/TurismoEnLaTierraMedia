package turismo;

import java.util.LinkedList;

public class Usuario {
	private String nombre = "";
	private double presupuesto;
	private double tiempoDisponible;
	private Tipo tipoDeAtraccion;
	LinkedList<Vendible> vendiblesComprados = new LinkedList<Vendible>();

	public Usuario(String nombre, double presupuesto, double tiempoDisponible, Tipo tipoDeAtraccion) {
		this.nombre = nombre;
		this.presupuesto = presupuesto;
		this.tiempoDisponible = tiempoDisponible;
		this.tipoDeAtraccion = tipoDeAtraccion;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", presupuesto=" + presupuesto + ", tiempoDisponible=" + tiempoDisponible
				+ ", tipoDeAtraccion=" + tipoDeAtraccion + "]\n";
	}

	public void comprarVendible(Vendible vendible) {
		
		this.presupuesto -= vendible.getCosto();
		this.tiempoDisponible -= vendible.getDuracion();
		vendible.comprar();
		vendiblesComprados.add(vendible);
	}
//Para borrar	
//	public void comprarAtraccion(Atraccion atraccion) {
//		this.presupuesto -= atraccion.getCosto();
//		this.tiempoDisponible -= atraccion.getDuracion();
//		atraccion.comprar();
//	}
//	
//	public void comprarPromocion(Promocion promocion) {
//		this.presupuesto -= promocion.getCosto();
//		this.tiempoDisponible -= promocion.getDuracion();
//		promocion.comprar();
//	}

	public String getNombre() {
		return nombre;
	}

	public double getPresupuesto() {
		return presupuesto;
	}

	public double getTiempoDisponible() {
		return tiempoDisponible;
	}

	public Tipo getTipoDeAtraccion() {
		return tipoDeAtraccion;
	}

	public void ofertarVendible(Vendible v) {
		if(puedeComprar(v)) {
			this.comprarVendible(v);
		}	
		
	}

	public boolean puedeComprar(Vendible v) {
		return v.getCosto() <= this.getPresupuesto() && v.getDuracion() <= this.getTiempoDisponible();
	}

	public boolean yaLoCompro(Vendible v) {
		return false;
	}
}
