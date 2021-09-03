package turismo;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class GuiaTuristicaTests {
	List<Usuario> usuarios;
	List<Atraccion> atracciones;
	List<Promocion> promociones;

	@Before
	public void setUp() {
		usuarios = FileManager.getUsuarios();

		atracciones = FileManager.getAtracciones();

		promociones = FileManager.getPromociones();
	}

	@Test
	public void test() {
		
		assertEquals(22.40, promociones.get(0).calcularDescuento(),0.01);
		assertEquals(36, promociones.get(1).calcularDescuento(),0.01);
		assertEquals(10, promociones.get(2).calcularDescuento(),0.01);
	}

}
