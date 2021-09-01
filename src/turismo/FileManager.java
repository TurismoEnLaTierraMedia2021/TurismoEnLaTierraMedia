package turismo;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class FileManager {

	public static LinkedList<Usuario> getUsuarios(String archivo) {
		LinkedList<Usuario> usuarios = new LinkedList<Usuario>();
		Scanner sc = null;
		try {
			sc = new Scanner(new File(archivo));

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

	public static LinkedList<Atraccion> getAtracciones(String archivo) {
		LinkedList<Atraccion> atracciones = new LinkedList<Atraccion>();
		Scanner sc = null;
		try {
			sc = new Scanner(new File(archivo));

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

	public static LinkedList<Promocion> getPromociones(String archivo) {
		LinkedList<Promocion> promociones = new LinkedList<Promocion>();
		Scanner sc = null;

		try {
			sc = new Scanner(new File(archivo));

			while (sc.hasNext()) {
				String linea = sc.nextLine();
				String datos[] = linea.split("-");
				String tipoPromocion = datos[0];

				if (tipoPromocion.equals("Descuento")) {
					String nombrePack = datos[1];
					double porcentajeDescuento = Double.parseDouble(datos[2]);
					int cantAtracciones = Integer.parseInt(datos[3]);
					List<Atraccion> atraccionesParaPromocion = FileManager.getAtracciones("Atracciones");
					String[] nombreAtraccion = new String[cantAtracciones];
					Atraccion[] atraccionesParaPromocionar = new Atraccion[cantAtracciones];
					for (int i = 0; i < cantAtracciones; i++) {
						if(atracciones.)){
							
						}
						nombreAtraccion[i] = (datos[4 + i]);

					}
					
					

					System.out.println(Arrays.toString(nombreAtraccion));
					System.out.println();
//					PromocionDescuento pa = new PromocionDescuento(tipoPromocion, nombrePack, porcentajeDescuento);
//
//					if (!promociones.contains(pa))
//						promociones.add(pa);

//				} else if (tipoPromocion.equals("Absoluta")) {
//					String nombrePack = datos[1];
//					String nombreAtraccion1 = datos[2];
//					String nombreAtraccion2 = datos[3];
//					double precio = Double.parseDouble(datos[4]);
//
//					PromocionAbsoluta pa = new PromocionAbsoluta(tipoPromocion, nombrePack, nombreAtraccion1, nombreAtraccion2,
//							precio);
//
//					if (!promociones.contains(pa))
//						promociones.add(pa);
//
//				} else {
//					String nombrePack = datos[1];
//					String nombreAtraccion1 = datos[2];
//					String nombreAtraccion2 = datos[3];
//					String nombreAtraccion3 = datos[4];
//
//					PromocionAxB pa = new PromocionAxB(tipoPromocion, nombrePack, nombreAtraccion1, nombreAtraccion2,
//							nombreAtraccion3);
//
//					if (!promociones.contains(pa))
//						promociones.add(pa);
//
//				}

				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		sc.close();

		return promociones;
	}
}

//
//}
//if(nombrePack == "Pack degustacion") {
//String nombreAtraccion1 = datos[1];
//String nombreAtraccion2 = datos[2];
//double precio = Double.parseDouble(datos[3]);
//
//}
//if(nombrePack == "Pack degustacion") {
//String nombreAtraccion1 = datos[1];
//String nombreAtraccion2 = datos[2];
//String nombreAtraccion3 = datos[3];
//
//}
//
//			
//if(!promociones.contains(p))
//promociones.add(p);

//public static void leerArchivo(String archivo) throws IOException {
//	if (archivo == "Usuarios") {
//		FileReader fr = null;
//		BufferedReader br = null;
//
//		fr = new FileReader("Usuarios");
//		br = new BufferedReader(fr);
//		String linea;
//
//		while ((linea = br.readLine()) != null) {
//
//			String[] datosUsuarios = linea.split("-");
//			String name = datosUsuarios[0];
//			TipoDeAtraccion tipo = TipoDeAtraccion.valueOf(datosUsuarios[1]);
//			double presupuesto = Double.parseDouble(datosUsuarios[2]);
//			double tiempoDisponible = Double.parseDouble(datosUsuarios[3]);
//
//			Usuario usuarios = new Usuario(name, presupuesto, tiempoDisponible, tipo);
//			System.out.println(usuarios);
//		}
//		br.close();
//	}
//	if (archivo == "Atracciones") {
//		
//	}
//}