package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.LinkedList;

import jdbc.ConnectionProvider;
import model.Usuario;
import model.Vendible;

public class ItinerarioDAOImpl implements ItinerarioDAO {

	public int insert(Usuario usuario, Vendible vendible) {
		try {
			String sql;
			if (vendible.esPromo()) {
				 sql = "INSERT INTO itinerarios (usuario_id, promocion_id) VALUES (?, ?);";
			} else {
				 sql = "INSERT INTO itinerarios (usuario_id, atraccion_id) VALUES (?, ?);";
			}

			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, usuario.getId());
			statement.setInt(2, vendible.getId());

			int rows = statement.executeUpdate();

			return rows;
		} catch (

		Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	
	
	public void llenarItinerario(LinkedList<Usuario> usuarios, LinkedList<Vendible> vendibles) {
		try {	
			for(Usuario u : usuarios) {
				usuarioUpdate(u);
				for(Vendible v : u.getVendiblesComprados()) {
					insert(u, v);	
				}
			}
			for(Vendible v: vendibles) {
				if(!v.esPromo()) {
					atraccionUpdate(v);
				}	
			}
		} catch (
		Exception e) {
			throw new MissingDataException(e);
		}
	}



	public int atraccionUpdate(Vendible v) {
		try {
			String sql = "UPDATE atracciones SET cupo = ? WHERE id = ?;";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setDouble(1, v.getCupo());
			statement.setInt(2, v.getId());

			int rows = statement.executeUpdate();

			return rows;
		} catch (

		Exception e) {
			throw new MissingDataException(e);
		}
		
	}



	public int usuarioUpdate(Usuario u) {
		try {
			String sql = "UPDATE usuarios SET monedas = ?, tiempo_disponible = ? WHERE id = ?;";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setDouble(1, u.getPresupuesto());
			statement.setDouble(2, u.getTiempoDisponible());
			statement.setInt(3, u.getId());

			int rows = statement.executeUpdate();

			return rows;
		} catch (

		Exception e) {
			throw new MissingDataException(e);
		}
		
	}
	
	
}
