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

		promociones = FileManager.getPromociones(atracciones);
	}

	@Test
	public void precioTest() {
		
		assertEquals(22.40, promociones.get(0).getCosto(),0.01);
		assertEquals(36, promociones.get(1).getCosto(),0.01);
		assertEquals(10, promociones.get(2).getCosto(),0.01);
	}
	
	@Test
	public void duracionTest() {
		
		assertEquals(7, promociones.get(0).getDuracion(),0.01);
		assertEquals(7.5, promociones.get(1).getDuracion(),0.01);
		assertEquals(7.5, promociones.get(2).getDuracion(),0.01);
		
	}
	
	@Test
	public void hayLugarPromocionTest() {
		
		assertTrue(promociones.get(0).hayCupo());
		assertTrue(promociones.get(1).hayCupo());
		assertTrue(promociones.get(2).hayCupo());
		
	}
	
	@Test
	public void hayLugarAtraccionTest() {
		
		assertTrue(atracciones.get(0).hayCupo());
		assertTrue(atracciones.get(1).hayCupo());
		assertTrue(atracciones.get(2).hayCupo());
		assertTrue(atracciones.get(3).hayCupo());
		
	}
	
	@Test
	public void comprarAtraccionTest() {
		
		usuarios.get(0).comprarVendible(atracciones.get(0));
		
		assertEquals(0, usuarios.get(0).getPresupuesto(),0.01);
		assertEquals(5, atracciones.get(0).getCupo(),0.01);
		assertEquals(6, usuarios.get(0).getTiempoDisponible(),0.01);
		
	}
	
	@Test
	public void comprarPromocionTest() {
		
		usuarios.get(0).comprarVendible(promociones.get(2));
		
		assertEquals(0, usuarios.get(0).getPresupuesto(),0.01);
		assertEquals(24, atracciones.get(1).getCupo(),0.01);
		assertEquals(14, atracciones.get(4).getCupo(),0.01);
		assertEquals(31, atracciones.get(6).getCupo(),0.01);
		assertEquals(0.5, usuarios.get(0).getTiempoDisponible(),0.01);
		
	}
	
	@Test
	public void comparadorTiposTest() {
		assertEquals(Tipo.AVENTURA, promociones.get(0).getTipo());
		assertEquals(Tipo.AVENTURA, atracciones.get(0).getTipo());
		assertEquals(promociones.get(0).getTipo(), atracciones.get(0).getTipo());
		assertEquals(usuarios.get(0).getTipoDeAtraccion(), atracciones.get(0).getTipo());
	}
	

}
