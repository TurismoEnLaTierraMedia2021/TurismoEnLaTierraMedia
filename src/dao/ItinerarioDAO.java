package dao;

import java.util.LinkedList;

import model.Usuario;
import model.Vendible;

public interface ItinerarioDAO {
	public int insert(Usuario usuario, Vendible vendible);
	public void llenarItinerario(LinkedList<Usuario> usuarios);
	
}


