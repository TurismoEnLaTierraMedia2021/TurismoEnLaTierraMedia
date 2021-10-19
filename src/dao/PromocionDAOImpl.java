package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import jdbc.ConnectionProvider;
import model.Atraccion;
import model.Promocion;
import model.Tipo;
import model.Usuario;

public class PromocionDAOImpl implements PromocionDAO {

	
	@Override
	@Override
	public LinkedList<Promocion> buscarTodos() {
		
			try {
				String sql = "SELECT tda.tipo, p.tipo_de_promocion, p.nombre_pack, p.referencia_costo, p.cantidad_atracciones, a.nombre\r\n"
						+ "FROM promociones p \r\n"
						+ "	INNER JOIN promociones_atracciones pa ON p.id = pa.promocion_id\r\n"
						+ "	INNER JOIN atracciones a ON pa.atraccion_id = a.id		\r\n"
						+ "	INNER JOIN tipo_de_atracciones tda ON p.tipo_id = tda.id";
				Connection conn = ConnectionProvider.getConnection();
				PreparedStatement statement = conn.prepareStatement(sql);
				ResultSet resultados = statement.executeQuery();
				
				LinkedList<Promocion> promociones = new LinkedList<Promocion>();
				while (resultados.next()) {
					promociones.add(toPromocion(resultados, LinkedList<Atraccion> atracciones));
				}

				return promociones;
			} catch (Exception e) {
				throw new MissingDataException(e);
			}
		}

		private Promocion toPromocion(ResultSet resultados, LinkedList<Atraccion> atracciones) throws SQLException {
			
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
		
		
		
		return null;
	}

}

/*
SELECT tda.tipo, p.tipo_de_promocion, p.nombre_pack, p.referencia_costo, p.cantidad_atracciones, a.nombre
FROM promociones p 
	INNER JOIN promociones_atracciones pa ON p.id = pa.promocion_id
	INNER JOIN atracciones a ON pa.atraccion_id = a.id		
	INNER JOIN tipo_de_atracciones tda ON p.tipo_id = tda.id

ver el tema de la referencia_costo para las promociones axb, porque ahora el "6" ya no hace referencia a la atraccion gratis.
Creo que iria en Null, porque ya no lo usabamos

