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
				sql = "INSERT OR IGNORE INTO itinerarios (usuario_id, promocion_id) VALUES (?, ?);";
			} else {
				sql = "INSERT OR IGNORE INTO itinerarios (usuario_id, atraccion_id) VALUES (?, ?);";
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

			for (Usuario u : usuarios) {
				usuarioUpdate(u);
				for (Vendible v : u.getVendiblesComprados()) {
					insert(u, v);
				}
			}
			for (Vendible v : vendibles) {
				if (!v.esPromo()) {
					atraccionUpdate(v);
				}
			}
		} catch (Exception e) {
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

	public void llenarItinerario2(LinkedList<Usuario> usuarios, LinkedList<Vendible> vendibles) {
		try {
			
			Connection conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			try {
			//	String sql = "BEGIN TRANSACTION;";
			//	PreparedStatement statement = conn.prepareStatement(sql);
			//	statement.executeUpdate();
				
				for (Usuario u : usuarios) {

					String sql1 = "UPDATE usuarios SET monedas = ?, tiempo_disponible = ? WHERE id = ?;";
					PreparedStatement statement1 = conn.prepareStatement(sql1);
					statement1.setDouble(1, u.getPresupuesto());
					statement1.setDouble(2, u.getTiempoDisponible());
					statement1.setInt(3, u.getId());
					statement1.executeUpdate();

					for (Vendible v : u.getVendiblesComprados()) {
						String sql2;
						if (v.esPromo()) {
							sql2 = "INSERT OR IGNORE INTO itinerarios (usuario_id, promocion_id) VALUES (?, ?);";
						} else {
							sql2 = "INSERT OR IGNORE INTO itinerarios (usuario_id, atraccion_id) VALUES (?, ?);";
						}

						PreparedStatement statement2 = conn.prepareStatement(sql2);
						statement2.setInt(1, u.getId());
						statement2.setInt(2, v.getId());
						statement2.executeUpdate();
					}

				}
				for (Vendible v : vendibles) {
					if (!v.esPromo()) {
						String sql3 = "UPDATE atracciones SET cupo = ? WHERE id = ?;";

						PreparedStatement statement3 = conn.prepareStatement(sql3);
						statement3.setDouble(1, v.getCupo());
						statement3.setInt(2, v.getId());

						statement3.executeUpdate();

					}
				}		

			} catch (Exception e) {
				conn.rollback();
				throw new MissingDataException(e);
			} finally {
				conn.commit();
			}
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
}

//conn = ConnectionProvider.getConnection();
//conn.setAutoCommit(false);
//
//try {
//	  update user
//	  para cada vendible
//	     insert itinerario
//	     update atraccion
//	} catch (e) {
//	   conn.rollback();
//	} finally {
//	  conn.commit();
//	}
