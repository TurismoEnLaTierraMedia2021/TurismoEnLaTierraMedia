package turismo;

import java.util.Iterator;
import java.util.LinkedList;

public class Usuario {
	private String nombre = "";
	private double presupuesto;
	private double montoTotal;
	private double tiempoDisponible;
	private double tiempoTotal;
	private Tipo tipoDeAtraccion;
	LinkedList<Vendible> vendiblesComprados = new LinkedList<Vendible>();

	public Usuario(String nombre, double presupuesto, double tiempoDisponible, Tipo tipoDeAtraccion) {
		this.nombre = nombre;
		this.presupuesto = presupuesto;
		this.tiempoDisponible = tiempoDisponible;
		this.tipoDeAtraccion = tipoDeAtraccion;
	}


	public String getNombre() {
		return nombre;
	}

	public double getPresupuesto() {
		return presupuesto;
	}

	public double getTiempoDisponible() {
		return tiempoDisponible;
	}
	
	public double getMontoTotal() {
		return montoTotal;
	}

	public double getTiempoTotal() {
		return tiempoTotal;
	}

	public Tipo getTipoDeAtraccion() {
		return tipoDeAtraccion;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", presupuesto=" + presupuesto + ", tiempoDisponible=" + tiempoDisponible
				+ ", tipoDeAtraccion=" + tipoDeAtraccion + "]\n";
	}
	
	
	public boolean puedeComprar(Vendible v) {
		return (v.getCosto() <= this.getPresupuesto() && v.getDuracion() <= this.getTiempoDisponible()
				&& v.hayCupo() == true && yaLoCompro(v) == false);
	}
	
	public void comprarVendible(Vendible vendible) {
		this.presupuesto -= vendible.getCosto();
		this.montoTotal += vendible.getCosto();
		this.tiempoDisponible -= vendible.getDuracion();
		this.tiempoTotal += vendible.getDuracion();
		vendible.comprar();
		vendiblesComprados.add(vendible);
	}
	
	public boolean yaLoCompro(Vendible v) {
		boolean compro = false;
		if (v.esPromo()) {
			for (Vendible vendible : v.getAtracciones() ) {
				if (vendiblesComprados.contains(vendible)) {
					compro = true;
					break;
				}
				for(Vendible vendibleComp : vendiblesComprados) {
					if(vendibleComp.esPromo()) {
						if (vendibleComp.getAtracciones().contains(vendible)) {
							compro = true;
							break;
						}
					}
				}
			}			
		}else {
			for (Vendible vendible : vendiblesComprados) {
				if (vendible.esPromo()) {
					if (vendible.getAtracciones().contains(v)) {
						compro = true;
						break;
					}
				}else if (vendible == v ) {
					compro = true;
				}
			}
		}
		return compro;
	}
	
	public LinkedList<Vendible> getVendiblesComprados(){
		return vendiblesComprados;
	}

}
