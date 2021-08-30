package turismo;

public class Usuario {
	private String nombre = "";
	private double presupuesto;
	private double tiempoDisponible;
	private TipoDeAtraccion tipoDeAtraccion;

	public Usuario(String nombre, double presupuesto, double tiempoDisponible,
			TipoDeAtraccion tipoDeAtraccion) {
		this.nombre = nombre;
		this.presupuesto = presupuesto;
		this.tiempoDisponible = tiempoDisponible;
		this.tipoDeAtraccion = tipoDeAtraccion;
	}
		
}

//public static void main(String[] args) {
//
//		String[] usuario = {"Eowyn","AVENTURA","10","8"};
//		
//		Usuario eowyn = new Usuario(usuario[0], Integer.parseInt(usuario[2]),
//				Integer.parseInt(usuario[3]));
//		
//		System.out.println(eowyn.presupuesto);
//	}






