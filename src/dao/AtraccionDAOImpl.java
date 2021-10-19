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
			String sql = "SELECT * FROM atracciones";
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
		return new Atraccion(resultados.getString(2), resultados.getDouble(3), resultados.getDouble(4), 
				Tipo.valueOf(getTipoById(resultados.getDouble(6))), resultados.getInt(5));
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
