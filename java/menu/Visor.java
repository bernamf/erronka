package menu;

import java.util.ArrayList;

import clases.Caballero;


public class Visor {
	public static void mostrarMensaje(String mensaje) {
		System.out.println(mensaje+"\n");
	}
	
	public static void mostrarCaballeros(ArrayList<Caballero> caballeros) {
		for (Caballero caballero : caballeros) {
			System.out.println(caballero.toString());
		}
	}

}
