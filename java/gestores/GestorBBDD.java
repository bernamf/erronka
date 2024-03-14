package gestores;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import clases.Caballero;
import conector.Conectar;

public class GestorBBDD extends Conectar {
	
	public ArrayList<Caballero> getCaballeros() {
		ArrayList<Caballero> caballeros = new ArrayList<Caballero>();
		String query = "SELECT * from caballero";
		try(PreparedStatement st = getCn().prepareStatement(query)) {
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return caballeros;
	}

}
