package turismo;

import java.util.Comparator;

public class Comparador implements Comparator<Vendible> {
	private Tipo preferenciaUsuario;
	private double presupuesto;
	private double tiempoDisponible;

	public Comparador(Tipo preferenciaUsuario) {
		this.preferenciaUsuario = preferenciaUsuario;

	}

	@Override
	public int compare(Vendible o1, Vendible o2) {

		/*
		 * Priorizar promociones Atraccion mas cara De mayor duracion No deberan
		 * ofertarse una promocion que no se pueda pagar o tenga tiempo disponible No
		 * deberan ofertarse una atraccion que este en una promocion comprada Una vez
		 * ofertadas todas, se ofreceran atracciones que no coinciden con la preferencia
		 * del usuario Si el usuario acepta, se guarda en el itinerario y no podran
		 * cancelarse
		 *
		 */

		if (this.preferenciaUsuario == o1.getTipo() && this.preferenciaUsuario == o2.getTipo()) {
			return siNoSon(o1, o2);
		} else if (this.preferenciaUsuario != o1.getTipo()
				&& this.preferenciaUsuario != o2.getTipo()) {
			return siNoSon(o1, o2);

		}else {
			return 0;
		}
	}

	
	
	private int siNoSon(Vendible o1, Vendible o2) {
		if (o1.esPromo() && o2.esPromo()) {
			if (Double.compare(o1.getCosto(), o2.getCosto()) == 0) {
				return -Double.compare(o1.getDuracion(), o2.getDuracion());
			} else {
				return -Double.compare(o1.getCosto(), o2.getCosto());
			}
		} else {
			return -Boolean.compare(o1.esPromo(), o2.esPromo());
		}
	}
}