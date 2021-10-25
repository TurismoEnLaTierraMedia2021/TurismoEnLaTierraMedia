package model;

import java.util.LinkedList;
import dao.AtraccionDAO;
import dao.DAOFactory;
import dao.PromocionDAO;

public abstract class Vendible {
	protected String nombre = "";
	protected double costo;
	protected double duracion;
	protected Tipo tipo;
	protected int cupo;
	protected LinkedList<Atraccion> atracciones;
	protected Integer id;

	public boolean hayCupo() {
		return false;
	}

	public void comprar() {
	}

	public double getDuracion() {
		return 0;
	}

	public double getCosto() {
		return 0;
	}

	public String getNombre() {
		return nombre;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public int getCupo() {
		return cupo;
	}
	
	public Integer getId() {
		if(this.esPromo()) {
			return this.getId();
		}else {
			return this.getId();
		}
	}

	public boolean esPromo() {
		return false;
	}
	
	public LinkedList<Atraccion> getAtracciones() {
		return atracciones;
	}
	
	public boolean esOContiene(Vendible v) {
		return false;
	}

	public static LinkedList<Vendible> getVendibles() {
		AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
		PromocionDAO promocionDAO = DAOFactory.getPromocionDAO();
		LinkedList<Atraccion> atracciones = atraccionDAO.buscarTodos();
		LinkedList<Promocion> promociones = promocionDAO.buscarTodos(atracciones);
		LinkedList<Vendible> vendibles = new LinkedList<Vendible>();
		vendibles.addAll(atracciones);
		vendibles.addAll(promociones);
		return vendibles;
	}
}
