package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import clases.Caballo;
import conector.Conectar;

public class ModeloCaballo extends Conectar{
	public Caballo getCaballoById(int id) {
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
	public Caballo getCaballoByIdCaba(int id) {
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

	public boolean insertarCaballo(Caballo caballo) {
	    String query = "INSERT INTO Caballo (Nombre, VelocidadMaxima, Resistencia, idCaballero) VALUES (?, ?, ?, ?)";
	    try (PreparedStatement statement = getCn().prepareStatement(query)) {
	        statement.setString(1, caballo.getNombre());
	        statement.setInt(2, caballo.getVelocidadMaxima());
	        statement.setInt(3, caballo.getResistencia());
	        statement.setInt(4, caballo.getIdCaballero());
	        return statement.executeUpdate() > 0;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	}
	    public boolean eliminarCaballo(int id) {
	        String query = "DELETE FROM Caballo WHERE ID = ?";
	        try (PreparedStatement statement = getCn().prepareStatement(query)) {
	            statement.setInt(1, id);
	            return statement.executeUpdate() > 0;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return false;
	        }
	    }
	
}
