package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import clases.Caballo;
import conector.Conectar;

public class ModeloCaballo extends Conectar{
	public Caballo getEscuderoById(int id) {
		String query = "SELECT * from caballo WHERE id = ?";
		
		try (PreparedStatement st = getCn().prepareStatement(query)) {
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();

			if (rs.next()) {

				Caballo caballo = new Caballo();
				caballo.setId(rs.getInt("id"));
				caballo.setResistencia(rs.getInt("resistencia"));
				caballo.setNombre(rs.getString("nombre"));
				caballo.setVelocidadMaxima(rs.getInt("velocidadMaxima"));
				return caballo;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	public Caballo getEscuderoByIdCaba(int id) {
		String query = "SELECT * from caballo WHERE idCaballero = ?";
		
		try (PreparedStatement st = getCn().prepareStatement(query)) {
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();

			if (rs.next()) {

				Caballo caballo = new Caballo();
				caballo.setId(rs.getInt("id"));
				caballo.setResistencia(rs.getInt("resistencia"));
				caballo.setNombre(rs.getString("nombre"));
				caballo.setVelocidadMaxima(rs.getInt("velocidadMaxima"));
				return caballo;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	
	
}
