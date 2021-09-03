package turismo;

import java.io.IOException;
import java.util.List;

public class GuiaTuristica {

	public static void main(String[] args) throws IOException {
		
		List<Usuario> usuarios = FileManager.getUsuarios();
		System.out.println(usuarios);
		List<Atraccion> atracciones = FileManager.getAtracciones();
		System.out.println(atracciones);
		List<Promocion> promociones = FileManager.getPromociones();
		System.out.println(promociones);
		System.out.println(promociones.get(0).calcularDescuento());
		System.out.println(promociones.get(1).calcularDescuento());
		System.out.println(promociones.get(2).calcularDescuento());
	}
}
