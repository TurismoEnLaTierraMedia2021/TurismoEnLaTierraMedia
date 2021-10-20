package dao;

import java.util.LinkedList;

import model.Atraccion;
import model.Promocion;

public interface PromocionDAO {

	public LinkedList<Promocion> buscarTodos(LinkedList<Atraccion> atracciones);
	
}
