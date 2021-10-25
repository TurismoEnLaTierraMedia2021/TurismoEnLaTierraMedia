package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.LinkedList;

import jdbc.ConnectionProvider;
import model.Usuario;
import model.Vendible;

public class ItinerarioDAOImpl implements ItinerarioDAO {
	//String sql = "";

	public int insert(Usuario usuario, Vendible vendible) {
		try {
			String sql;
			if (vendible.esPromo()) {
				 sql = "INSERT INTO itinerarios (usuario_id, promocion_id) VALUES (?, ?);";
				//sql += sql1;
			} else {
				 sql = "INSERT INTO itinerarios (usuario_id, atraccion_id) VALUES (?, ?);";
				//sql += sql1;
			}

			// String sql = "INSERT INTO itinerario (usuario_id, promocion_id) VALUES (1,
			// 4);"
			// + "INSERT INTO itinerario (usuario_id, promocion_id) VALUES (1, 4);"

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
	
	public void llenarItinerario(LinkedList<Usuario> usuarios) {
		try {
			
			for(Usuario u : usuarios) {
				for(Vendible v : u.getVendiblesComprados()) {
					insert(u, v);
				}
			}

			// String sql = "INSERT INTO itinerario (usuario_id, promocion_id) VALUES (1,
			// 4);"
			// + "INSERT INTO itinerario (usuario_id, promocion_id) VALUES (1, 4);"

//			Connection conn = ConnectionProvider.getConnection();
//
//			PreparedStatement statement = conn.prepareStatement(sql);
//			statement.setInt(1, usuario.getId());
//			statement.setInt(2, vendible.getId());
//
//			int rows = statement.executeUpdate();
//
//			return rows;
		} catch (

		Exception e) {
			throw new MissingDataException(e);
		}
	}
}
