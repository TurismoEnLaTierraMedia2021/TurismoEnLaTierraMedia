package dao;

import java.util.LinkedList;

import model.Atraccion;
import model.Usuario;
import model.Vendible;

public interface ItinerarioDAO {
	public int insert(Usuario usuario, Vendible vendible);
	public void llenarItinerario(LinkedList<Usuario> usuarios, LinkedList<Vendible> vendibles);
	public int atraccionUpdate(Vendible v);
	public int usuarioUpdate(Usuario u);
}


