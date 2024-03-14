package main;

import java.util.ArrayList;
import java.util.Scanner;

import clases.Caballero;
import gertor.GestorCaballero;
import gertor.Modelo;
import menu.Menu;
import menu.Visor;

public class GestorPrincipal {
	
	public static void run() {
		Scanner scan = new Scanner(System.in);
		int opcion = 0;
		ArrayList<Caballero> caballeros = new ArrayList<Caballero>();
		caballeros = GestorCaballero.rellenarCaballeros();
		do {
			Menu.menuPrincipal();
			opcion= Integer.parseInt(scan.nextLine());
			switch (opcion) {
			case Menu.LUCHAR:
				Juego.run();
			case Menu.VER_ARMAS:
				GeestorArma.run();
				break;
			case Menu.HISTORIA:
				
				break;
			
			default:
				break;
			}
		} while (opcion!=0);
		Visor.mostrarMensaje("Adios");
		
	}
	
	
	
	
}
