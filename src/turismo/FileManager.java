package turismo;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class FileManager {

	public static LinkedList<Usuario> getUsuarios() {
		LinkedList<Usuario> usuarios = new LinkedList<Usuario>();
		Scanner sc = null;
		try {
			sc = new Scanner(new File("Usuarios"));

			while (sc.hasNext()) {
				String linea = sc.nextLine();
				String datos[] = linea.split("-");

				String nombre = datos[0];
				Tipo tipo = Tipo.valueOf(datos[1]);
				double presupuesto = Double.parseDouble(datos[2]);
				double tiempoDisponible = Double.parseDouble(datos[3]);

				Usuario u = new Usuario(nombre, presupuesto, tiempoDisponible, tipo);

				if (!usuarios.contains(u))
					usuarios.add(u);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		sc.close();

		return usuarios;
	}

	public static LinkedList<Atraccion> getAtracciones() {
		LinkedList<Atraccion> atracciones = new LinkedList<Atraccion>();
		Scanner sc = null;
		try {
			sc = new Scanner(new File("Atracciones"));

			while (sc.hasNext()) {
				String linea = sc.nextLine();
				String datos[] = linea.split("-");

				String nombre = datos[0];
				double costo = Double.parseDouble(datos[1]);
				double duracion = Double.parseDouble(datos[2]);
				int cupo = Integer.parseInt(datos[3]);
				Tipo tipo = Tipo.valueOf(datos[4]);

				Atraccion a = new Atraccion(nombre, costo, duracion, tipo, cupo);

				if (!atracciones.contains(a))
					atracciones.add(a);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		sc.close();

		return atracciones;
	}

	public static LinkedList<Promocion> getPromociones(List<Atraccion> atracciones) {
		LinkedList<Promocion> promociones = new LinkedList<Promocion>();

		Scanner sc = null;

		try {
			sc = new Scanner(new File("Promociones"));

			while (sc.hasNext()) {
				String linea = sc.nextLine();
				String datos[] = linea.split("-");
				String tipoPromocion = datos[1];

				if (tipoPromocion.equals("Descuento")) {
					Tipo tipo = Tipo.valueOf(datos[0]);
					String nombrePack = datos[2];
					double porcentajeDescuento = Double.parseDouble(datos[3]);
					int cantAtracciones = Integer.parseInt(datos[4]);

					LinkedList<Atraccion> atraccionesDescuento = new LinkedList<Atraccion>();

					for (int i = 0; i < cantAtracciones; i++) {

						String nombreAtraccion = datos[5 + i];

						for (Atraccion atraccionActual : atracciones) {
							if (atraccionActual.getNombre().equals(nombreAtraccion)) {
								atraccionesDescuento.add(atraccionActual);
							}
						}
					}

					PromocionDescuento pd = new PromocionDescuento(tipo, tipoPromocion, nombrePack, atraccionesDescuento,
							porcentajeDescuento);

					if (!promociones.contains(pd))
						promociones.add(pd);

				} else if (tipoPromocion.equals("Absoluta")) {
					Tipo tipo = Tipo.valueOf(datos[0]);
					String nombrePack = datos[2];
					double precio = Double.parseDouble(datos[3]);
					int cantAtracciones = Integer.parseInt(datos[4]);

					LinkedList<Atraccion> atraccionesAbsolutas = new LinkedList<Atraccion>();

					for (int i = 0; i < cantAtracciones; i++) {

						String nombreAtraccion = datos[5 + i];

						for (Atraccion atraccionActual : atracciones) {
							if (atraccionActual.getNombre().equals(nombreAtraccion)) {
								atraccionesAbsolutas.add(atraccionActual);
							}
						}
					}

					PromocionAbsoluta pa = new PromocionAbsoluta(tipo, tipoPromocion, nombrePack, atraccionesAbsolutas,
							precio);

					if (!promociones.contains(pa))
						promociones.add(pa);

				} else {
					Tipo tipo = Tipo.valueOf(datos[0]);
					String nombrePack = datos[2];
					int cantAtracciones = Integer.parseInt(datos[4]);

					LinkedList<Atraccion> atraccionesAxB = new LinkedList<Atraccion>();

					for (int i = 0; i < cantAtracciones; i++) {

						String nombreAtraccion = datos[5 + i];

						for (Atraccion atraccionActual : atracciones) {
							if (atraccionActual.getNombre().equals(nombreAtraccion)) {
								atraccionesAxB.add(atraccionActual);
							}

						}
					}

					PromocionAxB pp = new PromocionAxB(tipo, tipoPromocion, nombrePack, atraccionesAxB);

					if (!promociones.contains(pp))
						promociones.add(pp);
				}

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		sc.close();

		return promociones;
	}

	public static LinkedList<Vendible> getVendibles() {
		List<Atraccion> atracciones = FileManager.getAtracciones();
		List<Promocion> promociones = FileManager.getPromociones(atracciones);
		LinkedList<Vendible> vendibles = new LinkedList<Vendible>();
		vendibles.addAll(atracciones);
		vendibles.addAll(promociones);
		return vendibles;
	}
}