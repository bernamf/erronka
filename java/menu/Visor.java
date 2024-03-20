package menu;

import java.util.ArrayList;

import clases.*;



public class Visor {
	public static void mostrarMensaje(String mensaje) {
		System.out.println(mensaje+"\n");
	}
	
	public static void mostrarCaballeros(ArrayList<Caballero> caballeros) {
		for (Caballero caballero : caballeros) {
			System.out.println(caballero.toString());
		}
	}
	
	 public static void mostrarArmas(ArrayList<Arma> armas) {
	        System.out.println("Listado de Armas:");
	        System.out.println("ID | Nombre              | Ataque");
	        System.out.println("---------------------------------");
	        for (Arma arma : armas) {
	            System.out.printf("%-3d| %-20s| %-6d\n", arma.getId(), arma.getNombre(), arma.getAtaque());
	        }
	        System.out.println();
	    }
	 public static void mostrarArmasTienda(ArrayList<Arma> armas) {
	        System.out.println("Listado de Armas para Comprar:");
	        System.out.println("ID | Nombre              | Ataque | Precio");
	        System.out.println("------------------------------------------");
	        for (Arma arma : armas) {
	            System.out.printf("%-3d| %-20s| %-6d | %-6d EXP\n", arma.getId(), arma.getNombre(), arma.getAtaque(),(int)(arma.getAtaque()*0.4));
	        }
	        System.out.println();
	    }

	    public static void mostrarEscudos(ArrayList<Escudo> escudos) {
	        System.out.println("Listado de Escudos:");
	        System.out.println("ID | Nombre                   | Defensa| Precio");
	        System.out.println("-----------------------------------------------");
	        for (Escudo escudo : escudos) {
	            System.out.printf("%-3d| %-25s| %-8d| %-6d EXP\n", escudo.getId(), escudo.getNombre(), escudo.getDefensa(),(int) (escudo.getDefensa()*0.4));
	        }
	        System.out.println();
	    }

	    public static void mostrarCaballos(ArrayList<Caballo> caballos) {
	        System.out.println("Listado de Caballos:");
	        System.out.println("ID | Nombre                 | Velocidad Máxima | Resistencia");
	        System.out.println("--------------------------------------------");
	        for (Caballo caballo : caballos) {
	            System.out.printf("%-3d| %-20s| %-17d| %-11d\n", caballo.getId(), caballo.getNombre(), caballo.getVelocidadMaxima(), caballo.getResistencia());
	        }
	        System.out.println();
	    }
	    
	    public static void mostrarEscuderos(ArrayList<Escudero> escuderos) {
	        System.out.println("Listado de Escuderos:");
	        System.out.println("ID | Nombre                 | Experiencia");
	        System.out.println("----------------------------------------");
	        for (Escudero escudero : escuderos) {
	            System.out.printf("%-3d| %-20s| %-11d\n", escudero.getId(), escudero.getNombre(), escudero.getExperiencia());
	        }
	        System.out.println();
	    }
}
