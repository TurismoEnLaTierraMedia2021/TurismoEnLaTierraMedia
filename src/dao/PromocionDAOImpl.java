package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import jdbc.ConnectionProvider;
import model.Atraccion;
import model.Promocion;
import model.PromocionAbsoluta;
import model.PromocionAxB;
import model.PromocionDescuento;
import model.Tipo;

public class PromocionDAOImpl implements PromocionDAO {

	public LinkedList<Promocion> buscarTodos(LinkedList<Atraccion> atracciones) {
		try {
			String sql = "SELECT p.id, tda.tipo, p.tipo_de_promocion, p.nombre_pack, p.referencia_costo, p.cantidad_atracciones, group_concat(a.nombre)\r\n"
					+ "FROM promociones p \r\n"
					+ "    INNER JOIN promociones_atracciones pa ON p.id = pa.promocion_id\r\n"
					+ "    INNER JOIN atracciones a ON pa.atraccion_id = a.id\r\n"
					+ "    INNER JOIN tipo_de_atracciones tda ON p.tipo_id = tda.id	\r\n" + "	GROUP BY p.id";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();

			LinkedList<Promocion> promociones = new LinkedList<Promocion>();
			while (resultados.next()) {
				promociones.add(toPromocion(resultados, atracciones));
			}
			return promociones;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	private Promocion toPromocion(ResultSet resultados, LinkedList<Atraccion> atracciones) throws SQLException {
		String tipoPromocion = resultados.getString(3);

		if (tipoPromocion.equals("Descuento")) {
			Integer id = resultados.getInt(1);
			Tipo tipo = Tipo.valueOf(resultados.getString(2));
			String nombrePack = resultados.getString(4);
			double porcentajeDescuento = resultados.getDouble(5);
			
			LinkedList<Atraccion> atraccionesDescuento = new LinkedList<Atraccion>();

			String datos[] = resultados.getString(7).split(",");
			for (int i = 0; i < datos.length; i++) {
				for (Atraccion atraccionActual : atracciones) {
					if (atraccionActual.getNombre().equals(datos[i])) {
						atraccionesDescuento.add(atraccionActual);
					}
				}
			}

			PromocionDescuento pd = new PromocionDescuento(id, tipo, tipoPromocion, nombrePack, atraccionesDescuento,
					porcentajeDescuento);

			return pd;

		} else if (tipoPromocion.equals("Absoluta")) {
			Integer id = resultados.getInt(1);
			Tipo tipo = Tipo.valueOf(resultados.getString(2));
			String nombrePack = resultados.getString(4);
			double precio = resultados.getDouble(5);
			
			LinkedList<Atraccion> atraccionesAbsolutas = new LinkedList<Atraccion>();

			String datos[] = resultados.getString(7).split(",");
			for (int i = 0; i < datos.length; i++) {
				for (Atraccion atraccionActual : atracciones) {
					if (atraccionActual.getNombre().equals(datos[i])) {
						atraccionesAbsolutas.add(atraccionActual);
					}
				}
			}

			PromocionAbsoluta pa = new PromocionAbsoluta(id, tipo, tipoPromocion, nombrePack, atraccionesAbsolutas,
					precio);

			return pa;

		} else {
			Integer id = resultados.getInt(1);
			Tipo tipo = Tipo.valueOf(resultados.getString(2));
			String nombrePack = resultados.getString(4);
			
			LinkedList<Atraccion> atraccionesAxB = new LinkedList<Atraccion>();

			String datos[] = resultados.getString(7).split(",");
			for (int i = 0; i < datos.length; i++) {
				for (Atraccion atraccionActual : atracciones) {
					if (atraccionActual.getNombre().equals(datos[i])) {
						atraccionesAxB.add(atraccionActual);
					}
				}
			}

			PromocionAxB pp = new PromocionAxB(id, tipo, tipoPromocion, nombrePack, atraccionesAxB);

			return pp;

		}

	}
}
