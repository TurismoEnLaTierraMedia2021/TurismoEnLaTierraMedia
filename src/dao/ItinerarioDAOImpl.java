package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.LinkedList;

import jdbc.ConnectionProvider;
import model.Usuario;
import model.Vendible;

public class ItinerarioDAOImpl implements ItinerarioDAO {


	public void llenarItinerario(LinkedList<Usuario> usuarios, LinkedList<Vendible> vendibles) {
		try {	
			Connection conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			try {				
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
