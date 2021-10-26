package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import jdbc.ConnectionProvider;
import model.Usuario;
import model.Vendible;
import model.Tipo;

public class UsuarioDAOImpl implements UsuarioDAO {

//	public int insert(Usuario usuario) {
//		try {
//			String sql = "INSERT INTO usuarios (nombre, tipo_id, monedas, tiempo_disponible) VALUES (?, ?, ?, ?)";
//			Connection conn = ConnectionProvider.getConnection();
//
//			PreparedStatement statement = conn.prepareStatement(sql);
//			statement.setString(1, usuario.getNombre());
//			statement.setString(2, usuario.getPassword());
//			statement.setString(2, usuario.getPassword());
//			statement.setString(2, usuario.getPassword());
//			int rows = statement.executeUpdate();
//
//			return rows;
//		} catch (Exception e) {
//			throw new MissingDataException(e);
//		}
//	}

//	public int update(Usuario usuario) {
//		try {
//			String sql = "UPDATE USERS SET PASSWORD = ? WHERE USERNAME = ?";
//			Connection conn = ConnectionProvider.getConnection();
//
//			PreparedStatement statement = conn.prepareStatement(sql);
//			//statement.setString(1, usuario.getPassword());
//			//statement.setString(2, usuario.getUsername());
//			int rows = statement.executeUpdate();
//
//			return rows;
//		} catch (Exception e) {
//			throw new MissingDataException(e);
//		}
//	}

//	public int delete(Usuario usuario) {
//		try {
//			String sql = "DELETE FROM USERS WHERE USERNAME = ?";
//			Connection conn = ConnectionProvider.getConnection();
//
//			PreparedStatement statement = conn.prepareStatement(sql);
//			//statement.setString(1, usuario.getUsername());
//			int rows = statement.executeUpdate();
//
//			return rows;
//		} catch (Exception e) {
//			throw new MissingDataException(e);
//		}
//	}

//	public Usuario findByNombre(String nombre) {
//		try {
//			String sql = "SELECT * FROM USERS WHERE USERNAME = ?";
//			Connection conn = ConnectionProvider.getConnection();
//			PreparedStatement statement = conn.prepareStatement(sql);
//			statement.setString(1, nombre);
//			ResultSet resultados = statement.executeQuery();
//
//			Usuario usuario = null;
//
//			if (resultados.next()) {
//				usuario = toUsuario(resultados);
//			}
//
//			return usuario;
//		} catch (Exception e) {
//			throw new MissingDataException(e);
//		}
//	}

//	public int countAll() {
//		try {
//			String sql = "SELECT COUNT(1) AS TOTAL FROM USERS";
//			Connection conn = ConnectionProvider.getConnection();
//			PreparedStatement statement = conn.prepareStatement(sql);
//			ResultSet resultados = statement.executeQuery();
//
//			resultados.next();
//			int total = resultados.getInt("TOTAL");
//
//			return total;
//		} catch (Exception e) {
//			throw new MissingDataException(e);
//		}
//	}

	public LinkedList<Usuario> buscarTodos(LinkedList<Vendible> vendibles) {
		try {
			String sql = "SELECT u.*, tda.tipo , group_concat(i.promocion_id),group_concat(i.atraccion_id) \r\n"
					+ "FROM usuarios u \r\n" + "    INNER JOIN tipo_de_atracciones tda ON u.tipo_id = tda.id\r\n"
					+ "    INNER JOIN itinerarios i ON u.id = i.usuario_id\r\n" + "    GROUP BY u.id";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();

			LinkedList<Usuario> usuarios = new LinkedList<Usuario>();
			while (resultados.next()) {
				usuarios.add(toUsuario(resultados, vendibles));
			}

			return usuarios;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	private Usuario toUsuario(ResultSet resultados, LinkedList<Vendible> vendibles) throws SQLException {
		LinkedList<Vendible> vendiblesComprados = new LinkedList<Vendible>();
		String idPromociones[] = resultados.getString(7).split(",");
		String idAtracciones[] = resultados.getString(8).split(",");
	
		for (Vendible v : vendibles) {
			if (v.esPromo()) {
				for (int i = 0; i < idPromociones.length; i++) {
					if (v.getId().equals(Integer.parseInt(idPromociones[i])))
						vendiblesComprados.add(v);
				}
			} else {
				for (int i = 0; i < idAtracciones.length; i++) {
					if (v.getId().equals(Integer.parseInt(idAtracciones[i])))
						vendiblesComprados.add(v);
				}
			}
		}

		return new Usuario(resultados.getInt(1), resultados.getString(2), resultados.getDouble(4),
				resultados.getDouble(5), Tipo.valueOf(resultados.getString(6)), vendiblesComprados);
	}

}
