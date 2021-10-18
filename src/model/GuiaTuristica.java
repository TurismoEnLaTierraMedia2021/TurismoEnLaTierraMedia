package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class GuiaTuristica {
	LinkedList<Usuario> usuarios;
	LinkedList<Vendible> vendibles;
	LinkedList<Vendible> vendiblesAOfertar;
	int i;

	public GuiaTuristica(LinkedList<Usuario> usuarios, LinkedList<Vendible> vendibles) {
		this.usuarios = usuarios;
		this.vendibles = vendibles;
	}

	public void ofertarVendibles() throws IOException {
		for (Usuario u : usuarios) {
			System.out.println(u.getNombre() + " :");
			System.out.println("\n");
			this.ofertarSinParar(u);
			System.out.println("Itinerario:");
			System.out.println(u.getVendiblesComprados());
			System.out.println("Monedas Gastadas : " + u.getMontoTotal());
			System.out.println("Tiempo Necesario : " + u.getTiempoTotal());
			System.out.println("\n");
			System.out.println(" ----------------------- ");
			System.out.println("\n");
		}

	}

	public void ofertarSinParar(Usuario usuario) throws IOException {

		vendibles.sort(new Comparador(usuario.getTipoDeAtraccion()));

		for (Vendible v : vendibles) {
			if (usuario.puedeComprar(v)) {
				System.out.println("Monedas disponibles: " + usuario.getPresupuesto() + "\n");
				System.out.println("Tiempo disponibles: " + usuario.getTiempoDisponible() + "\n");
				System.out.println("Desea comprar? \"y\" para si, \"n\" para no");
				System.out.println(v);

				InputStreamReader capturarTeclado = new InputStreamReader(System.in);
				BufferedReader buffer = new BufferedReader(capturarTeclado);
				String respuesta = buffer.readLine();

				if (respuesta.equals("y")) {
					usuario.comprarVendible(v);
				}

			}
		}

	}

}
