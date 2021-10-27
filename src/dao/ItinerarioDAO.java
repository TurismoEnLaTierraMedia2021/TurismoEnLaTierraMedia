package dao;

import java.util.LinkedList;

import model.Usuario;
import model.Vendible;

public interface ItinerarioDAO {
	
	public void llenarItinerario(LinkedList<Usuario> usuarios, LinkedList<Vendible> vendibles);
	
}


