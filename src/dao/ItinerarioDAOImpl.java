package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.LinkedList;

import jdbc.ConnectionProvider;
import model.Usuario;
import model.Vendible;

public class ItinerarioDAOImpl implements ItinerarioDAO {
	String sql = "";
	String sql1 = "";

	
	public int insert(Usuario usuario, LinkedList<Vendible> vendiblesComprados) {
		try {
			
			for(Vendible vendible : vendiblesComprados) {
				if(vendible.esPromo()) {
					String sql1 = "INSERT INTO itinerarios (usuario_id, promocion_id) VALUES (?, ?);";
					sql += sql1;
				} else {
					String sql1 = "INSERT INTO itinerarios (usuario_id, atraccion_id) VALUES (?, ?);";
					sql += sql1;
				}				
			}
			

			//sql += "COMMIT;"; 
			
			Connection conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement statement = conn.prepareStatement(sql);
            
			
			statement.setInt(1, usuario.getId());
			statement.setInt(2, vendiblesComprados.get(0).getId());
			statement.setInt(3, usuario.getId());
			statement.setInt(4, vendiblesComprados.get(1).getId());
	
			System.out.println(sql);
//			System.out.println( usuario.getId());
//			System.out.println( vendiblesComprados.get(0).getId());
//			System.out.println( usuario.getId());
//			System.out.println( vendiblesComprados.get(1).getId());
			
			
			int rows = statement.executeUpdate();

			return rows;
			//return 1;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
}
