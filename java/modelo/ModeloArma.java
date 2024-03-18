package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import clases.Arma;
import conector.Conectar;

public class ModeloArma extends Conectar {
    public ArrayList<Arma> getArmas() {
        ArrayList<Arma> armas = new ArrayList<Arma>();
        String query = "SELECT * FROM arma";

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
	
	
	 public void insertarArma(Arma arma) {
	        String query = "INSERT INTO arma (nombre, ataque) VALUES (?, ?)";
	        
	        try (PreparedStatement st = getCn().prepareStatement(query)) {
	            st.setString(1, arma.getNombre());
	            st.setInt(2, arma.getAtaque());
	            
	            int filasAfectadas = st.executeUpdate();
	            if (filasAfectadas == 1) {
	                System.out.println("Arma insertada correctamente.");
	            } else {
	                System.out.println("Error al insertar el arma.");
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    
	    public void eliminarArma(int id) {
	        String query = "DELETE FROM arma WHERE id = ?";
	        
	        try (PreparedStatement st = getCn().prepareStatement(query)) {
	            st.setInt(1, id);
	            
	            int filasAfectadas = st.executeUpdate();
	            if (filasAfectadas == 1) {
	                System.out.println("Arma eliminada correctamente.");
	            } else {
	                System.out.println("Error al eliminar el arma.");
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	
}
