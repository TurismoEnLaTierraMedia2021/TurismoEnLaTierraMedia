package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import jdbc.ConnectionProvider;
import model.Usuario;
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

	public LinkedList<Usuario> buscarTodos() {
		try {
			String sql = "SELECT * FROM usuarios";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();
			
			LinkedList<Usuario> usuarios = new LinkedList<Usuario>();
			while (resultados.next()) {
				usuarios.add(toUsuario(resultados));
			}

			return usuarios;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	private Usuario toUsuario(ResultSet resultados) throws SQLException {
		return new Usuario(resultados.getString(2), resultados.getDouble(4), resultados.getDouble(5), 
				Tipo.valueOf(getTipoById(resultados.getDouble(3))));
	}
	
	public String getTipoById(Double id_tipo_atraccion) {
		try {
			String sql = "SELECT tipo FROM tipo_de_atracciones WHERE id = ? ";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setDouble(1, id_tipo_atraccion);
			ResultSet resultado = statement.executeQuery();
			
			return resultado.getString(1);
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

}