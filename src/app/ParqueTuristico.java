package app;

import java.io.IOException;
import java.util.LinkedList;

import dao.AtraccionDAO;
import dao.DAOFactory;
import dao.UsuarioDAO;
import model.Atraccion;
import model.GuiaTuristica;
import model.Usuario;
import model.Vendible;

public class ParqueTuristico {

	public static void main(String[] args) throws IOException {
		UsuarioDAO usuarioDAO = DAOFactory.getUsuarioDAO();
		AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
		LinkedList<Usuario> usuarios = usuarioDAO.buscarTodos();
		System.out.println(usuarios);
		LinkedList<Atraccion> atracciones = atraccionDAO.buscarTodos();
		System.out.println(atracciones);
		//LinkedList<Vendible> vendibles = FileManager.getVendibles();
		//GuiaTuristica guia = new GuiaTuristica(usuarios, vendibles);
		//guia.ofertarVendibles();
		//FileManager.generarItinerario(usuarios);
	}
}
