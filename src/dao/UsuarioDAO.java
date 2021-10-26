package dao;

import java.util.LinkedList;

import model.Usuario;
import model.Vendible;

public interface UsuarioDAO{

	//public abstract Usuario findByNombre(String nombre);
	public LinkedList<Usuario> buscarTodos(LinkedList<Vendible> vendibles);
	
}
