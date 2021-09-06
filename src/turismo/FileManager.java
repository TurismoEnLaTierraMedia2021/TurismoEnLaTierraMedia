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
				TipoDeAtraccion tipo = TipoDeAtraccion.valueOf(datos[1]);
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
				TipoDeAtraccion tipo = TipoDeAtraccion.valueOf(datos[4]);

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
				String tipoPromocion = datos[0];

				if (tipoPromocion.equals("Descuento")) {
					String nombrePack = datos[1];
					double porcentajeDescuento = Double.parseDouble(datos[2]);
					int cantAtracciones = Integer.parseInt(datos[3]);

					LinkedList<Atraccion> atraccionesDescuento = new LinkedList<Atraccion>();

					for (int i = 0; i < cantAtracciones; i++) {

						String nombreAtraccion = datos[4 + i];

						for (Atraccion atraccionActual : atracciones) {
							if (atraccionActual.getNombre().equals(nombreAtraccion)) {
								atraccionesDescuento.add(atraccionActual);
							}
						}
					}

					PromocionDescuento pd = new PromocionDescuento(tipoPromocion, nombrePack, atraccionesDescuento,
							porcentajeDescuento);

					if (!promociones.contains(pd))
						promociones.add(pd);

				} else if (tipoPromocion.equals("Absoluta")) {
					String nombrePack = datos[1];
					double precio = Double.parseDouble(datos[2]);
					int cantAtracciones = Integer.parseInt(datos[3]);

					LinkedList<Atraccion> atraccionesAbsolutas = new LinkedList<Atraccion>();

					for (int i = 0; i < cantAtracciones; i++) {

						String nombreAtraccion = datos[4 + i];

						for (Atraccion atraccionActual : atracciones) {
							if (atraccionActual.getNombre().equals(nombreAtraccion)) {
								atraccionesAbsolutas.add(atraccionActual);
							}
						}
					}

					PromocionAbsoluta pa = new PromocionAbsoluta(tipoPromocion, nombrePack, atraccionesAbsolutas,
							precio);

					if (!promociones.contains(pa))
						promociones.add(pa);

				} else {
					String nombrePack = datos[1];
					int cantAtracciones = Integer.parseInt(datos[3]);

					LinkedList<Atraccion> atraccionesAxB = new LinkedList<Atraccion>();

					for (int i = 0; i < cantAtracciones; i++) {

						String nombreAtraccion = datos[4 + i];

						for (Atraccion atraccionActual : atracciones) {
							if (atraccionActual.getNombre().equals(nombreAtraccion)) {
								atraccionesAxB.add(atraccionActual);
							}

						}
					}

					PromocionAxB pp = new PromocionAxB(tipoPromocion, nombrePack, atraccionesAxB);

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

}