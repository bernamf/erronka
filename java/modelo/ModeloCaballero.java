package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
}
