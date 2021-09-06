package turismo;

import java.io.IOException;
import java.util.List;

public class GuiaTuristica {

	public static void main(String[] args) throws IOException {
		
		List<Usuario> usuarios = FileManager.getUsuarios();
		System.out.println(usuarios);
		List<Atraccion> atracciones = FileManager.getAtracciones();
		System.out.println(atracciones);
		List<Promocion> promociones = FileManager.getPromociones(atracciones);
		System.out.println(promociones);
		
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