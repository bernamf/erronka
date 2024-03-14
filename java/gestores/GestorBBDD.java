package gestores;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import clases.Arma;
import clases.Caballero;
import clases.Escudo;
import conector.Conectar;

public class GestorBBDD extends Conectar {

	public ArrayList<Caballero> getCaballeros() {
		ArrayList<Caballero> caballeros = new ArrayList<Caballero>();
		String query = "SELECT * from caballero";
		
		try (PreparedStatement st = getCn().prepareStatement(query)) {
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
				Caballero caballero = new Caballero();
				caballero.setId(rs.getInt("id"));
				caballero.setFuerza(rs.getInt("fuerza"));
				caballero.setInteligencia(rs.getInt("inteligencia"));
				caballero.setAgilidad(rs.getInt("agilidad"));
				caballero.setExperiencia(rs.getInt("experiencia"));
				caballero.setArma(getArmaById(rs.getInt("arma_id")));
				caballero.setEscudo(getEscudoById(rs.getInt("escudo_id")));

				caballeros.add(caballero);
			}
			
			return caballeros;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

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

	public ArrayList<Escudo> getEscudos() {
		ArrayList<Escudo> escudos = new ArrayList<Escudo>();
		String query = "SELECT * from escudo";
		
		try (PreparedStatement st = getCn().prepareStatement(query)) {
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
				Escudo escudo = new Escudo();
				escudo.setId(rs.getInt("id"));
				escudo.setDefensa(rs.getInt("defensa"));
				escudo.setNombre(rs.getString("nombre"));

				escudos.add(escudo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return escudos;
	}

	public Escudo getEscudoById(int id) {
		String query = "SELECT * from escudo WHERE id = ?";
		
		try (PreparedStatement st = getCn().prepareStatement(query)) {
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();

			if (rs.next()) {

				Escudo escudo = new Escudo();
				escudo.setId(rs.getInt("id"));
				escudo.setDefensa(rs.getInt("defensa"));
				escudo.setNombre(rs.getString("nombre"));

				return escudo;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
