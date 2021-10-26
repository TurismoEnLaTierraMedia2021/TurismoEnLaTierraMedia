package model;

import static org.junit.Assert.*;

import java.util.LinkedList;
import org.junit.Before;
import org.junit.Test;

import dao.AtraccionDAO;
import dao.DAOFactory;
import dao.PromocionDAO;
import dao.UsuarioDAO;

public class GuiaTuristicaTests {
	LinkedList<Usuario> usuarios;
	LinkedList<Atraccion> atracciones;
	LinkedList<Promocion> promociones;
	LinkedList<Vendible> vendibles;

	@Before
	public void setUp() {
		UsuarioDAO usuarioDAO = DAOFactory.getUsuarioDAO();
		usuarios = usuarioDAO.buscarTodos(vendibles);
		AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
		atracciones = atraccionDAO.buscarTodos();
		PromocionDAO promocionDAO = DAOFactory.getPromocionDAO();
		promociones = promocionDAO.buscarTodos(atracciones);
		vendibles = Vendible.getVendibles();
		
	}

	//Al final del archivo se encuentra la lista de vendibles comentada.
	
	@Test
	public void precioTest() {

		assertEquals(22.40, promociones.get(0).getCosto(), 0.01);
		assertEquals(36, promociones.get(1).getCosto(), 0.01);
		assertEquals(10, promociones.get(2).getCosto(), 0.01);
	}

	@Test
	public void duracionTest() {

		assertEquals(7, promociones.get(0).getDuracion(), 0.01);
		assertEquals(7.5, promociones.get(1).getDuracion(), 0.01);
		assertEquals(7.5, promociones.get(2).getDuracion(), 0.01);

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

		assertEquals(0, usuarios.get(0).getPresupuesto(), 0.01);
		assertEquals(5, atracciones.get(0).getCupo(), 0.01);
		assertEquals(6, usuarios.get(0).getTiempoDisponible(), 0.01);

	}

	@Test
	public void comprarPromocionTest() {

		usuarios.get(0).comprarVendible(promociones.get(2));

		assertEquals(0, usuarios.get(0).getPresupuesto(), 0.01);
		assertEquals(24, atracciones.get(1).getCupo(), 0.01);
		assertEquals(14, atracciones.get(4).getCupo(), 0.01);
		assertEquals(31, atracciones.get(6).getCupo(), 0.01);
		assertEquals(0.5, usuarios.get(0).getTiempoDisponible(), 0.01);
	}

	@Test
	public void thorinTest() {
		assertTrue(usuarios.get(4).puedeComprar(vendibles.get(0)));

		usuarios.get(4).comprarVendible(vendibles.get(2));

		assertEquals(97, usuarios.get(4).getPresupuesto(), 0.01);
		assertTrue(usuarios.get(4).yaLoCompro(vendibles.get(2)));
		assertFalse(usuarios.get(4).puedeComprar(vendibles.get(10)));
		usuarios.get(4).comprarVendible(vendibles.get(11));
		assertTrue(usuarios.get(4).yaLoCompro(vendibles.get(1)));
		assertFalse(usuarios.get(4).puedeComprar(vendibles.get(1)));
		assertEquals(87, usuarios.get(4).getPresupuesto(), 0.01);
		assertFalse(usuarios.get(4).puedeComprar(vendibles.get(6)));
	}

	@Test
	public void comparadorTiposTest() {
		assertEquals(Tipo.AVENTURA, promociones.get(0).getTipo());
		assertEquals(Tipo.AVENTURA, atracciones.get(0).getTipo());
		assertEquals(promociones.get(0).getTipo(), atracciones.get(0).getTipo());
		assertEquals(usuarios.get(0).getTipoDeAtraccion(), atracciones.get(0).getTipo());
	}
	
	@Test
	public void ignaTest() {
		assertTrue(usuarios.get(4).puedeComprar(vendibles.get(13)));

		usuarios.get(4).comprarVendible(vendibles.get(13));

		assertTrue(usuarios.get(4).yaLoCompro(vendibles.get(8)));
		assertFalse(usuarios.get(4).puedeComprar(vendibles.get(8)));
		
	}
	@Test
	public void igna2Test() {
		assertTrue(usuarios.get(4).puedeComprar(vendibles.get(11)));

		usuarios.get(4).comprarVendible(vendibles.get(11));

		assertTrue(usuarios.get(4).yaLoCompro(vendibles.get(6)));
		assertFalse(usuarios.get(4).puedeComprar(vendibles.get(14)));
		
	}

}

//Lista de vendibles

//0	 [Atraccion [nombre=Moria, costo=10.0, duracion=2.0, tipoDeAtraccion=AVENTURA, cupo=6]
//1 , Atraccion [nombre=Minas Tirith, costo=5.0, duracion=2.5, tipoDeAtraccion=PAISAJE, cupo=25]
//2 , Atraccion [nombre=La Comarca, costo=3.0, duracion=6.5, tipoDeAtraccion=DEGUSTACION, cupo=150]
//3 , Atraccion [nombre=Mordor, costo=25.0, duracion=3.0, tipoDeAtraccion=AVENTURA, cupo=4]
//4 , Atraccion [nombre=Abismo de Helm, costo=5.0, duracion=2.0, tipoDeAtraccion=PAISAJE, cupo=15]
//5 , Atraccion [nombre=Lothlorien, costo=35.0, duracion=1.0, tipoDeAtraccion=DEGUSTACION, cupo=30]
//6 , Atraccion [nombre=Erebor, costo=12.0, duracion=3.0, tipoDeAtraccion=PAISAJE, cupo=32]
//7 , Atraccion [nombre=Bosque Negro, costo=3.0, duracion=4.0, tipoDeAtraccion=AVENTURA, cupo=12]
//8 , Atraccion [nombre=Taberna Pony Pisador, costo=17.0, duracion=5.0, tipoDeAtraccion=DEGUSTACION, cupo=18]
//9 , Promocion AVENTURA [Valor: 22.4, Tiempo necesario: 7.0, Tipo de promocion:Descuento, Nombre del pack: Pack aventura,
//	 Atracciones:Bosque Negro, Mordor]
//10 , Promocion DEGUSTACION [Valor: 36.0, Tiempo necesario: 7.5, Tipo de promocion:Absoluta, Nombre del pack: Pack degustacion,
//	 Atracciones:Lothlorien, La Comarca]
//11 , Promocion PAISAJE [Valor: 10.0, Tiempo necesario: 7.5, Tipo de promocion:AxB, Nombre del pack: Pack paisajes,
//	 Atracciones:Minas Tirith, Abismo de Helm, Erebor]
//	 [Atraccion gratis: Erebor]
//12 , Promocion AVENTURA [Valor: 30.0, Tiempo necesario: 5.0, Tipo de promocion:Absoluta, Nombre del pack: Pack locuras,
//	 Atracciones:Moria, Mordor]
//13 , Promocion DEGUSTACION [Valor: 38.0, Tiempo necesario: 12.5, Tipo de promocion:AxB, Nombre del pack: Pack festin,
//	 Atracciones:La Comarca, Lothlorien, Taberna Pony Pisador]
//	 [Atraccion gratis: Taberna Pony Pisador]
//14 , Promocion PAISAJE [Valor: 9.35, Tiempo necesario: 5.0, Tipo de promocion:Descuento, Nombre del pack: Pack hotSale,
//	 Atracciones:Erebor, Abismo de Helm]
//]