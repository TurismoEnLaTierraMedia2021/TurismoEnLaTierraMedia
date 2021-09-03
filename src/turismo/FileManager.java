package turismo;

import java.io.*;
import java.util.LinkedList;
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

	public static LinkedList<Promocion> getPromociones() {
		LinkedList<Promocion> promociones = new LinkedList<Promocion>();
		// Esto esta duplicado para probar
		LinkedList<Atraccion> atracciones = FileManager.getAtracciones();
		
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

/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {

	public static void main(String[] args) throws IOException {
		 // Con este codigo pedimos un número
        System.out.println("Ingrese el monto del capital:");
        Integer numero1 = cargarNumero();
        
        System.out.println("Ingrese la tasa de interes:");
        Integer numero2 = cargarNumero();
        
        System.out.println("Ingrese la cantidad de meses:");
        Integer numero3 = cargarNumero();
        
        System.out.println("Desea invertir el monto todos los meses? 1 para si, 2 para no:");
        Integer numero4 = cargarNumero();
          
        calculoIntereses(numero1, numero2, numero3, numero4);
       
    }
    
    
     
      //@return 
      //@throws IOException 
     
    private static Integer cargarNumero() throws IOException {
        InputStreamReader capturarTeclado = new InputStreamReader(System.in);
        BufferedReader buffer = new BufferedReader(capturarTeclado);
        String strNumero = buffer.readLine();
        Integer numero = Integer.parseInt(strNumero);
        return numero;
    }
        
    private static double calculoIntereses(double numero1 , double numero2 , int numero3,int numero4) {
		double interesAnual = numero2/100;
		double montoInvertir =numero1;
		if(numero4 == 1) {
		for (int i = 0; i < numero3; i++) {
			if(i == 0) {
				montoInvertir = numero1 + numero1 * interesAnual / 12;	
			} else {
			montoInvertir = numero1 + montoInvertir + ((numero1 + montoInvertir) * interesAnual / 12);
			}
		}
		System.out.println("El capital final es: ");
		System.out.println(Math.round(montoInvertir));
		return montoInvertir;
		}

		if(numero4 == 2) {
			for (int i = 0; i < numero3; i++) {
				montoInvertir = montoInvertir + montoInvertir * interesAnual / 12;
			}
			System.out.println("El capital final es: ");
			System.out.println(Math.round(montoInvertir));
			
		}
		return montoInvertir;
	}
    
}
*/