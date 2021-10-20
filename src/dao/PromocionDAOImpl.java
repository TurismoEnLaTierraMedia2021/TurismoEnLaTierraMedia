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
import model.Usuario;

public class PromocionDAOImpl implements PromocionDAO {

	
	public LinkedList<Promocion> buscarTodos(LinkedList<Atraccion> atracciones) {
			try {
				String sql = "SELECT p.id, tda.tipo, p.tipo_de_promocion, p.nombre_pack, p.referencia_costo, p.cantidad_atracciones, a.nombre\r\n"
						+ "FROM promociones p \r\n"
						+ "	INNER JOIN promociones_atracciones pa ON p.id = pa.promocion_id\r\n"
						+ "	INNER JOIN atracciones a ON pa.atraccion_id = a.id		\r\n"
						+ "	INNER JOIN tipo_de_atracciones tda ON p.tipo_id = tda.id";
				Connection conn = ConnectionProvider.getConnection();
				PreparedStatement statement = conn.prepareStatement(sql);
				ResultSet resultados = statement.executeQuery();
				
				LinkedList<Promocion> promociones = new LinkedList<Promocion>();
				while (resultados.next()) {
					if (!promociones.contains(pd))
						promociones.add(pd);
					promociones.add(toPromocion(resultados,atracciones));
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
				int cantAtracciones = resultados.getInt(6);

				LinkedList<Atraccion> atraccionesDescuento = new LinkedList<Atraccion>();
					String nombreAtraccion = resultados.getString(7);
					
					
					for (Atraccion atraccionActual : atracciones) {
						if (atraccionActual.getNombre().equals(nombreAtraccion)) {
							atraccionesDescuento.add(atraccionActual);
						}
					}
				

				PromocionDescuento pd = new PromocionDescuento(id, tipo, tipoPromocion, nombrePack,
						atraccionesDescuento, porcentajeDescuento);

				if (!promociones.contains(pd))
					promociones.add(pd);

			
			
			} else if (tipoPromocion.equals("Absoluta")) {
				Tipo tipo = Tipo.valueOf(datos[0]);
				String nombrePack = datos[2];
				double precio = Double.parseDouble(datos[3]);
				int cantAtracciones = Integer.parseInt(datos[4]);

				LinkedList<Atraccion> atraccionesAbsolutas = new LinkedList<Atraccion>();

				for (int i = 0; i < cantAtracciones; i++) {

					String nombreAtraccion = datos[5 + i];

					for (Atraccion atraccionActual : atracciones) {
						if (atraccionActual.getNombre().equals(nombreAtraccion)) {
							atraccionesAbsolutas.add(atraccionActual);
						}
					}
				}

				PromocionAbsoluta pa = new PromocionAbsoluta(tipo, tipoPromocion, nombrePack, atraccionesAbsolutas,
						precio);

				if (!promociones.contains(pa))
					promociones.add(pa);

			} else {
				Tipo tipo = Tipo.valueOf(datos[0]);
				String nombrePack = datos[2];
				int cantAtracciones = Integer.parseInt(datos[4]);

				LinkedList<Atraccion> atraccionesAxB = new LinkedList<Atraccion>();

				for (int i = 0; i < cantAtracciones; i++) {

					String nombreAtraccion = datos[5 + i];

					for (Atraccion atraccionActual : atracciones) {
						if (atraccionActual.getNombre().equals(nombreAtraccion)) {
							atraccionesAxB.add(atraccionActual);
						}

					}
				}

				PromocionAxB pp = new PromocionAxB(tipo, tipoPromocion, nombrePack, atraccionesAxB);

				if (!promociones.contains(pp))
					promociones.add(pp);
			
				
			}
		
		}
		


}



