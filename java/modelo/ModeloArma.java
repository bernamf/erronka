package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import clases.Arma;
import conector.Conectar;

public class ModeloArma extends Conectar {
	public ArrayList<Arma> getArmas() {
		ArrayList<Arma> armas = new ArrayList<Arma>();
		String query = "SELECT * from arma";
		
		try (PreparedStatement st = getCn().prepareStatement(query)) {
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
				Arma arma = new Arma();
				arma.setId(rs.getInt("id"));
				arma.setAtaque(rs.getInt("ataque"));
				arma.setNombre(rs.getString("nombre"));

				armas.add(arma);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return armas;
	}

	public Arma getArmaById(int id) {
		String query = "SELECT * from arma WHERE id = ?";
		
		try (PreparedStatement st = getCn().prepareStatement(query)) {
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();

			if (rs.next()) {

				Arma arma = new Arma();
				arma.setId(rs.getInt("id"));
				arma.setAtaque(rs.getInt("ataque"));
				arma.setNombre(rs.getString("nombre"));

				return arma;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}
