package dao;

import java.util.LinkedList;

import model.Usuario;

public interface UsuarioDAO{

	//public abstract Usuario findByNombre(String nombre);
	public LinkedList<Usuario> buscarTodos();
	
}
