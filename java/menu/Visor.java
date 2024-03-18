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

	    public static void mostrarEscudos(ArrayList<Escudo> escudos) {
	        System.out.println("Listado de Escudos:");
	        System.out.println("ID | Nombre              | Defensa");
	        System.out.println("------------------------------------");
	        for (Escudo escudo : escudos) {
	            System.out.printf("%-3d| %-20s| %-8d\n", escudo.getId(), escudo.getNombre(), escudo.getDefensa());
	        }
	        System.out.println();
	    }

}
