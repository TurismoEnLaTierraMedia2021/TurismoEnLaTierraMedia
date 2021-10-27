package app;

import java.io.IOException;
import java.util.LinkedList;

import dao.DAOFactory;
import dao.ItinerarioDAO;
import dao.UsuarioDAO;
import model.GuiaTuristica;
import model.Usuario;
import model.Vendible;

public class ParqueTuristico {

	public static void main(String[] args) throws IOException {
		
		LinkedList<Vendible> vendibles = Vendible.getVendibles();
		UsuarioDAO usuarioDAO = DAOFactory.getUsuarioDAO();
		LinkedList<Usuario> usuarios = usuarioDAO.buscarTodos(vendibles);
		GuiaTuristica guia = new GuiaTuristica(usuarios, vendibles);
		guia.ofertarVendibles();
		ItinerarioDAO itinerarioDAO = DAOFactory.getItinerarioDAO();
		itinerarioDAO.llenarItinerario2(usuarios, vendibles);
		
		//cerrar base de datos
	}
}
