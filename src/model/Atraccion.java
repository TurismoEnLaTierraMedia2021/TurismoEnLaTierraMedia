package model;

public class Atraccion extends Vendible {
	private Integer id;
	private String nombre = "";
	private double costo;
	private double duracion;
	private Tipo tipo;
	private int cupo;

	public Atraccion(Integer id, String nombre, double costo, double duracion, Tipo tipoDeAtraccion, int cupo) {
		this.id = id;
		this.nombre = nombre;
		this.costo = costo;
		this.duracion = duracion;
		this.tipo = tipoDeAtraccion;
		this.cupo = cupo;
	}
	
	public Integer getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public double getCosto() {
		return costo;
	}

	public double getDuracion() {
		return duracion;
	}

	public int getCupo() {
		return cupo;
	}

	@Override
	public Tipo getTipo() {
		return tipo;
	}

	@Override
	public void comprar() {
		if (this.hayCupo()) {
			this.cupo -= 1;
		}
	}

	@Override
	public boolean hayCupo() {

		return (this.getCupo() != 0);
	}

	@Override
	public String toString() {
		return "Atraccion [nombre=" + nombre + ", costo=" + costo + ", duracion=" + duracion + ", tipoDeAtraccion="
				+ tipo + ", cupo=" + cupo + "]\n";
	}
	
	@Override
	public boolean esOContiene(Vendible v) {
		return this.equals(v);
	}

}
