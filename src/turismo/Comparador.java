package turismo;

import java.util.Comparator;

public class Comparador implements Comparator<Vendible> {
	private TipoDeAtraccion preferenciaUsuario;
	private double presupuesto;
	private double tiempoDisponible;

	public Comparador(double presupuesto, double tiempoDisponible, TipoDeAtraccion preferenciaUsuario) {
		this.preferenciaUsuario = preferenciaUsuario;
		this.presupuesto = presupuesto;
		this.tiempoDisponible = tiempoDisponible;
				
	}

	@Override
	public int compare(Vendible o1, Vendible o2) {
	/*
	 * 0 -> son iguales en prioridad
	 * > 0 -> tiene menor prioridad
	 * < 0 -> tiene mayor prioridad
	 * preferencia = AUTO
	 */		
		
	/*Priorizar promociones
	 *Atraccion mas cara
	 *De mayor duracion
	 *No deberan ofertarse una promocion que no se pueda pagar o tenga tiempo disponible 
	 *No deberan ofertarse una atraccion que este en una promocion comprada
	 *Una vez ofertadas todas, se ofreceran atracciones que no coinciden con la preferencia del usuario
	 *Si el usuario acepta, se guarda en el itinerario y no podran cancelarse
	 *
	 */
		
		if(this.preferenciaUsuario == o1.getTipoDeAtraccion() 
				&& this.preferencia != v2.getTipo()) 
			return -1;
		else if(this.preferencia != v1.getTipo() 
				&& this.preferencia == v2.getTipo()) 
			return 1;
		else {
			if(v1.getPrecio() > v2.getPrecio()) //return -1*Double.compare(v1.getPrecio(), v2.getPrecio());
				return -1;
			else if(v1.getPrecio() < v2.getPrecio()) 
				return 1;
			else 
				return v1.getColor().compareTo(v2.getColor());	
		}
	}
	
}
