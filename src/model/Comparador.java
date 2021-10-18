package model;

import java.util.Comparator;

public class Comparador implements Comparator<Vendible> {
	private Tipo preferenciaUsuario;

	public Comparador(Tipo preferenciaUsuario) {
		this.preferenciaUsuario = preferenciaUsuario;
	}

	@Override
	public int compare(Vendible o1, Vendible o2) {

		if (this.preferenciaUsuario == o1.getTipo() && this.preferenciaUsuario != o2.getTipo()) {
			return -1;
		}
		if (this.preferenciaUsuario != o1.getTipo() && this.preferenciaUsuario == o2.getTipo()) {
			return 1;
		}
		if (o1.esPromo() && !o2.esPromo()) {
			return -1;
		}
		if (!o1.esPromo() && o2.esPromo()) {
			return 1;
		}
		if (o1.getCosto() > o2.getCosto()) {
			return -1;
		}
		if (o1.getCosto() < o2.getCosto()) {
			return 1;
		}
		if (o1.getDuracion() > o2.getDuracion()) {
			return -1;
		}
		if (o1.getDuracion() < o2.getDuracion()) {
			return 1;
		}
		return 0;

	}
}
