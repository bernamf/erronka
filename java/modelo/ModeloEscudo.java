package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import clases.Escudo;
import conector.Conectar;

public class ModeloEscudo extends Conectar {
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
	
	public void insertarEscudo(Escudo escudo) {
        String query = "INSERT INTO escudo (nombre, defensa) VALUES (?, ?)";
        
        try (PreparedStatement st = getCn().prepareStatement(query)) {
            st.setString(1, escudo.getNombre());
            st.setInt(2, escudo.getDefensa());
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void eliminarEscudo(int id) {
        String query = "DELETE FROM escudo WHERE id = ?";
        
        try (PreparedStatement st = getCn().prepareStatement(query)) {
            st.setInt(1, id);
            
           
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
