package gertor;

import java.util.ArrayList;
import java.util.Scanner;

import clases.Escudo;
import menu.Menu;
import menu.Visor;
import modelo.ModeloCaballo;


public class GestorCaballo {

public static void run() {
		
		Scanner scan = new Scanner(System.in);
		int opcion = 0;
		ModeloCaballo modeloCaballo = new ModeloCaballo();
		
		do {
			Menu.menuEscudo();
			opcion= Integer.parseInt(scan.nextLine());
			switch (opcion) {
			case Menu.ver_caballos:
				
				
				
				break;
			case Menu.insertar_caballo:
				
				
				break;
			case Menu.eliminar_caballo:
				
				
				break;
			
			default:
				break;
			}
		} while (opcion!=0);
		Visor.mostrarMensaje("Adios");
		
	}
}
