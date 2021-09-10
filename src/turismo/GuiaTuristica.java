package turismo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

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

	public void ofertarSinParar(Usuario usuario) throws IOException{
		// ordenar la lista de vendibles segun su preferencia
		vendibles.sort(new Comparador(usuario.getTipoDeAtraccion()));
		// al usuario tengo que ofrecerle los vendibles
		// no ofertar vendible sin cupo
		// no ofertar algo ya comprado
		for (Vendible v : vendibles) {
			if (usuario.puedeComprar(v)) {
				System.out.println("Desea comprar? Y1/N2");
				System.out.println(v);

				InputStreamReader capturarTeclado = new InputStreamReader(System.in);
				BufferedReader buffer = new BufferedReader(capturarTeclado);
				String strNumero = buffer.readLine();
				Integer numero = Integer.parseInt(strNumero);
				
				if(numero == 1) {
					usuario.comprarVendible(v);
				}
				
			}
		}
	}

}





/*
 * import java.io.BufferedReader; import java.io.IOException; import
 * java.io.InputStreamReader;
 * 
 * public class Test {
 * 
 * public static void main(String[] args) throws IOException { // Con este
 * codigo pedimos un n�mero
 * System.out.println("Ingrese el monto del capital:"); Integer numero1 =
 * cargarNumero();
 * 
 * System.out.println("Ingrese la tasa de interes:"); Integer numero2 =
 * cargarNumero();
 * 
 * System.out.println("Ingrese la cantidad de meses:"); Integer numero3 =
 * cargarNumero();
 * 
 * System.out.
 * println("Desea invertir el monto todos los meses? 1 para si, 2 para no:");
 * Integer numero4 = cargarNumero();
 * 
 * calculoIntereses(numero1, numero2, numero3, numero4);
 * 
 * }
 * 
 * 
 * 
 * //@return //@throws IOException
 * 
 * private static Integer cargarNumero() throws IOException { InputStreamReader
 * capturarTeclado = new InputStreamReader(System.in); BufferedReader buffer =
 * new BufferedReader(capturarTeclado); String strNumero = buffer.readLine();
 * Integer numero = Integer.parseInt(strNumero); return numero; }
 * 
 * private static double calculoIntereses(double numero1 , double numero2 , int
 * numero3,int numero4) { double interesAnual = numero2/100; double
 * montoInvertir =numero1; if(numero4 == 1) { for (int i = 0; i < numero3; i++)
 * { if(i == 0) { montoInvertir = numero1 + numero1 * interesAnual / 12; } else
 * { montoInvertir = numero1 + montoInvertir + ((numero1 + montoInvertir) *
 * interesAnual / 12); } } System.out.println("El capital final es: ");
 * System.out.println(Math.round(montoInvertir)); return montoInvertir; }
 * 
 * if(numero4 == 2) { for (int i = 0; i < numero3; i++) { montoInvertir =
 * montoInvertir + montoInvertir * interesAnual / 12; }
 * System.out.println("El capital final es: ");
 * System.out.println(Math.round(montoInvertir));
 * 
 * } return montoInvertir; }
 * 
 * }
 */