package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import clases.Caballero;
import conector.Conectar;
import modelo.*;

public class ModeloCaballero extends Conectar {
	public ArrayList<Caballero> getCaballeros() {
		ArrayList<Caballero> caballeros = new ArrayList<Caballero>();
		String query = "SELECT * from caballero";
		ModeloArma modeloArma = new ModeloArma();
		ModeloEscudo modeloEscudo = new ModeloEscudo();
		
		try (PreparedStatement st = getCn().prepareStatement(query)) {
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
				Caballero caballero = new Caballero();
				caballero.setId(rs.getInt("id"));
				caballero.setNombre(rs.getString("nombre"));
				caballero.setFuerza(rs.getInt("fuerza"));
				caballero.setInteligencia(rs.getInt("inteligencia"));
				caballero.setAgilidad(rs.getInt("agilidad"));
				caballero.setExperiencia(rs.getInt("experiencia"));
				caballero.setArma(modeloArma.getArmaById(rs.getInt("arma_id")));
				caballero.setEscudo(modeloEscudo.getEscudoById(rs.getInt("escudo_id")));

				caballeros.add(caballero);
			}
			
			return caballeros;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	public void modificarCaballeros(ArrayList<Caballero> caballeros) {
		
			String query = "UPDATE caballero SET nombre = ?, fuerza = ? , inteligencia = ?, agilidad=?, experiencia = ?, arma_id=?, escudo_id=? where id = ?";
	        try (PreparedStatement st = getCn().prepareStatement(query)) {
	        	for (Caballero caballero : caballeros) {
	            st.setString(1, caballero.getNombre());
	            st.setInt(2, caballero.getFuerza());
	            st.setInt(3, caballero.getInteligencia());
	            st.setInt(4, caballero.getAgilidad());
	            st.setInt(5, caballero.getExperiencia());
	            st.setInt(6, caballero.getArma().getId());
	            st.setInt(7, caballero.getEscudo().getId());
	            st.setInt(8, caballero.getId());
	            st.executeUpdate();
	        	}
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
        
    }
}
