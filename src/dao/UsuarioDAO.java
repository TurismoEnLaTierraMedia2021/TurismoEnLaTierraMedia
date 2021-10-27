package dao;

import java.util.LinkedList;

import model.Usuario;
import model.Vendible;

public interface UsuarioDAO{

	public LinkedList<Usuario> buscarTodos(LinkedList<Vendible> vendibles);
	
}
