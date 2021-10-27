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

	public LinkedList<Usuario> buscarTodos(LinkedList<Vendible> vendibles) {
		try {
			String sql = "SELECT u.*, tda.tipo , group_concat(i.promocion_id),group_concat(i.atraccion_id) \r\n"
					+ "FROM usuarios u \r\n" + "    INNER JOIN tipo_de_atracciones tda ON u.tipo_id = tda.id\r\n"
					+ "    LEFT JOIN itinerarios i ON u.id = i.usuario_id\r\n" + "  	GROUP BY u.id";
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

		for (Vendible v : vendibles) {
			if (v.esPromo()) {
				if (resultados.getString(7) != null) {
					String idPromociones[] = resultados.getString(7).split(",");
					for (int i = 0; i < idPromociones.length; i++) {
						Integer id = Integer.parseInt(idPromociones[i]);
						if (v.getId().equals(id))
							vendiblesComprados.add(v);
					}
				}
			} else {
				if (resultados.getString(8) != null) {
					String idAtracciones[] = resultados.getString(8).split(",");
					for (int i = 0; i < idAtracciones.length; i++) {
						Integer id = Integer.parseInt(idAtracciones[i]);
						if (v.getId().equals(id))
							vendiblesComprados.add(v);
					}
				}
			}

		}

		return new Usuario(resultados.getInt(1), resultados.getString(2), resultados.getDouble(4),
				resultados.getDouble(5), Tipo.valueOf(resultados.getString(6)), vendiblesComprados);
	}

}
