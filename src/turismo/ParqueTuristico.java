package turismo;

import java.io.IOException;
import java.util.LinkedList;

public class ParqueTuristico {

	public static void main(String[] args) throws IOException {
		LinkedList<Usuario> usuarios = FileManager.getUsuarios();
		LinkedList<Vendible> vendibles = FileManager.getVendibles();
		GuiaTuristica guia = new GuiaTuristica(usuarios, vendibles);
		//System.out.println(usuarios);
		//vendibles.sort(new Comparador(Tipo.PAISAJE));
		//System.out.println(vendibles);
		//guia.ofertarVendibles();
		guia.ofertarVendibles();	
		FileManager.generarItinerario(usuarios);
	}
}
