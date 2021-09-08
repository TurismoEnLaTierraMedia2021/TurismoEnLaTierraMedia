package turismo;

public class Usuario {
	private String nombre = "";
	private double presupuesto;
	private double tiempoDisponible;
	private Tipo tipoDeAtraccion;

	public Usuario(String nombre, double presupuesto, double tiempoDisponible, Tipo tipoDeAtraccion) {
		this.nombre = nombre;
		this.presupuesto = presupuesto;
		this.tiempoDisponible = tiempoDisponible;
		this.tipoDeAtraccion = tipoDeAtraccion;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", presupuesto=" + presupuesto + ", tiempoDisponible=" + tiempoDisponible
				+ ", tipoDeAtraccion=" + tipoDeAtraccion + "]";
	}

	public void comprarVendible(Vendible vendible) {
		this.presupuesto -= vendible.getCosto();
		this.tiempoDisponible -= vendible.getDuracion();
		vendible.comprar();
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

}
