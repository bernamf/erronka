package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import clases.Escudero;
import conector.Conectar;

public class ModeloEscudero extends Conectar{
	public Escudero getEscuderoById(int id) {
		String query = "SELECT * from escudero WHERE id = ?";
		
		try (PreparedStatement st = getCn().prepareStatement(query)) {
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();

			if (rs.next()) {

				Escudero escudero = new Escudero();
				escudero.setId(rs.getInt("id"));
				escudero.setExperiencia(rs.getInt("experiencia"));
				escudero.setNombre(rs.getString("nombre"));

				return escudero;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	public Escudero getEscuderoByIdCaba(int id) {
		String query = "SELECT * from escudero WHERE idCaballero = ?";
		
		try (PreparedStatement st = getCn().prepareStatement(query)) {
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();

			if (rs.next()) {

				Escudero escudero = new Escudero();
				escudero.setId(rs.getInt("id"));
				escudero.setExperiencia(rs.getInt("experiencia"));
				escudero.setNombre(rs.getString("nombre"));

				return escudero;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}
