package turismo;

import java.io.IOException;
import java.util.List;

public class GuiaTuristica {

	public static void main(String[] args) throws IOException {
		
		List<Usuario> usuarios = FileManager.getUsuarios("Usuarios");
		System.out.println(usuarios);
		List<Atraccion> atracciones = FileManager.getAtracciones("Atracciones");
		System.out.println(atracciones);
		List<Promocion> promociones = FileManager.getPromociones("Promociones");
		System.out.println(promociones);
	}
}
