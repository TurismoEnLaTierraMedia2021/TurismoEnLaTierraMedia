package turismo;

import java.util.LinkedList;


public class ParqueTuristico {
	
	
	public static void main(String[] args) {
		LinkedList<Usuario> usuarios = FileManager.getUsuarios();
		LinkedList<Vendible> vendibles = FileManager.getVendibles();
		GuiaTuristica guia = new GuiaTuristica(usuarios, vendibles);
		System.out.println(usuarios);
		System.out.println(vendibles);
		guia.ofertarVendibles();
	}
}
