package app;

import java.io.IOException;
import java.util.LinkedList;

import dao.DAOFactory;
import dao.UsuarioDAO;
import model.FileManager;
import model.GuiaTuristica;
import model.Usuario;
import model.Vendible;

public class ParqueTuristico {

	public static void main(String[] args) throws IOException {
		
		//AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
		//PromocionDAO promocionDAO = DAOFactory.getPromocionDAO();
		//System.out.println(usuarios);
		//LinkedList<Atraccion> atracciones = atraccionDAO.buscarTodos();
		//System.out.println(atracciones);
		//LinkedList<Promocion> promociones = promocionDAO.buscarTodos(atracciones);
		//System.out.println(promociones);
		
		UsuarioDAO usuarioDAO = DAOFactory.getUsuarioDAO();
		LinkedList<Usuario> usuarios = usuarioDAO.buscarTodos();
		LinkedList<Vendible> vendibles = Vendible.getVendibles();
		GuiaTuristica guia = new GuiaTuristica(usuarios, vendibles);
		guia.ofertarVendibles();
		FileManager.generarItinerario(usuarios);
		
		//cerrar base de datos
	}
}
