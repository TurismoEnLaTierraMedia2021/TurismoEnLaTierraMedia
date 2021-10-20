package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import jdbc.ConnectionProvider;
import model.Atraccion;
import model.Tipo;

public class AtraccionDAOImpl implements AtraccionDAO {

	public LinkedList<Atraccion> buscarTodos() {
		try {
			String sql = "SELECT a.*, tda.tipo\n"
					+ "FROM atracciones a INNER JOIN tipo_de_atracciones tda ON a.tipo_id = tda.id";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();
			
			LinkedList<Atraccion> atracciones = new LinkedList<Atraccion>();
			while (resultados.next()) {
				atracciones.add(toAtraccion(resultados));
			}

			return atracciones;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	private Atraccion toAtraccion(ResultSet resultados) throws SQLException {
		return new Atraccion(resultados.getInt(1),resultados.getString(2), resultados.getDouble(3), resultados.getDouble(4), 
				Tipo.valueOf(resultados.getString(7)), resultados.getInt(5));
	}
	
}
