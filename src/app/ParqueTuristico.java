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
		UsuarioDAO usuarioDAO = DAOFactory.getUsuarioDAO();
		LinkedList<Usuario> usuarios = usuarioDAO.buscarTodos();
		System.out.println(usuarios);
		//LinkedList<Vendible> vendibles = FileManager.getVendibles();
		//GuiaTuristica guia = new GuiaTuristica(usuarios, vendibles);
		//guia.ofertarVendibles();
		//FileManager.generarItinerario(usuarios);
	}
}
